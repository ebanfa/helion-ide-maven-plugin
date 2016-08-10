/**
 * 
 */
package com.cloderia.helion.ide.builder;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ddlutils.DatabaseOperationException;
import org.apache.ddlutils.Platform;
import org.apache.ddlutils.PlatformFactory;
import org.apache.ddlutils.model.Column;
import org.apache.ddlutils.model.Database;
import org.apache.ddlutils.model.ForeignKey;
import org.apache.ddlutils.model.Table;

import com.cloderia.helion.ide.app.Application;
import com.cloderia.helion.ide.app.Entity;
import com.cloderia.helion.ide.app.Field;
import com.cloderia.helion.ide.app.Module;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEException;
import com.cloderia.helion.ide.util.IDEUtils;
import com.cloderia.helion.ide.util.StringUtils;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * @author adrian
 *
 */
public class DBToApplicationXMLBuilder implements ArtifactBuilder {
	
	public static final String DATE = "DATE";
	public static final String CHAR = "CHAR";
    public static final String VARCHAR = "VARCHAR";
    public static final String DECIMAL = "DECIMAL";
	public static final String INTEGER = "INTEGER";
	public static final String DATETIME = "DATETIME";
	public static final String TIMESTAMP = "TIMESTAMP";

	public static final String DATA_TYPE_FG = "flag";
	public static final String DATA_TYPE_ID = "id";
	public static final String DATA_TYPE_DATE = "date";
	public static final String DATA_TYPE_INT = "number";
	public static final String DATA_TYPE_NAME = "name";
	public static final String DATA_TYPE_MONEY = "money";
	public static final String DATA_TYPE_LG_TEXT = "text-lg";
	public static final String DATA_TYPE_CODE = "alphanumeric";
	public static final String DATA_TYPE_DATETIME = "datetime";
	public static final String DATA_TYPE_TIMESTAMP = "timestamp";
	private static final String DATA_TYPE_BIGINT = "bignumber";
	List<String> defaultCreateFields = Arrays.asList("name", "description", "effective_dt");
	List<String> defaultEditFields = Arrays.asList("entity_code", "name", "description", "effective_dt");
	List<String> defaultViewFields = Arrays.asList("entity_code", "name", "description", "effective_dt");
	List<String> defaultListFields = Arrays.asList("entity_code", "name", "description", "effective_dt");


	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.ArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public void build(BuildConfiguration buildConfiguration) throws IDEException {
		Application application = buildConfiguration.getApplication();
		application.setEntitiesInDB(loadEntitiesFromDB(buildConfiguration));
		List<Module> modulesForApplication = new ArrayList<Module>();
		
		for(Module module: application.getModules()) {
			List<Entity> entitiesForModule = new ArrayList<Entity>();
			for(Entity entityInModule: module.getEntities()) {
				for(Entity entityInDB: application.getEntitiesInDB()){
					if(entityInModule.getName().equals(entityInDB.getName())) {
						entityInDB.setModule(module);
						entitiesForModule.add(entityInDB);
					}
				}
			}
			module.setEntities(entitiesForModule);
			modulesForApplication.add(module);
		}
		processApplicationOverrides(buildConfiguration);
		generateApplicationXML(buildConfiguration);
	}
	
	/**
	 * @param buildConfiguration
	 * @throws IDEException
	 */
	private void generateApplicationXML(BuildConfiguration buildConfiguration) throws IDEException {
		IDEUtils.writeApplicationXML(buildConfiguration.getProjectDir().concat("config/logix/application.xml"), buildConfiguration.getApplication());
	}

	/**
	 * @param buildConfiguration
	 * @param module 
	 * @return
	 * @throws IDEException
	 */
	public List<Entity> loadEntitiesFromDB(BuildConfiguration buildConfiguration) throws IDEException {
		List<Entity> entities = new ArrayList<Entity>();
		Table[] tables = readDatabase(getMySQLDataSource(buildConfiguration)).getTables();
		for(Table table: tables){
			Entity entity = tableToEntity(table);
			entities.add(entity);
		}
		return entities;
	}

	/**
	 * @param buildConfiguration
	 * @return
	 * @throws IDEException
	 */
	private Application processApplicationOverrides(BuildConfiguration buildConfiguration) throws IDEException {
		Application application = buildConfiguration.getApplication();
		Application applicationOverrides = IDEUtils.loadApplicationXMLData(
				buildConfiguration.getProjectDir().concat("config/logix/entity-config.xml"));
		for(Module module: application.getModules()) {
			for(Module moduleOverride: applicationOverrides.getModules()) {
				processEntityOverrides(module, moduleOverride);
			}
		}
		return application;
	}

	/**
	 * @param module
	 * @param moduleOverride
	 */
	private void processEntityOverrides(Module module, Module moduleOverride) {
		for(Entity entity: module.getEntities()) {
			for(Entity entityOverride: moduleOverride.getEntities()) {
				if(entity.getName().equals(entityOverride.getName())) {
					entity.setHasOverride(true);
					// Services overrides
					if(entityOverride.getApiTemplate() != null) entity.setApiTemplate(entityOverride.getApiTemplate());
					if(entityOverride.getApiImplTemplate() != null)	entity.setApiImplTemplate(entityOverride.getApiImplTemplate());
					// End point overrides
					if(entityOverride.getEndPointTemplate() != null) entity.setEndPointTemplate(entityOverride.getEndPointTemplate());
					if(entityOverride.getEndPointImplTemplate() != null) entity.setEndPointImplTemplate(entityOverride.getEndPointImplTemplate());
					// View overrides
					if(entityOverride.getCreateViewTemplate() != null) entity.setCreateViewTemplate(entityOverride.getCreateViewTemplate());
					if(entityOverride.getEditViewTemplate() != null) entity.setEditViewTemplate(entityOverride.getEditViewTemplate());
					if(entityOverride.getSingleViewTemplate() != null) entity.setSingleViewTemplate(entityOverride.getSingleViewTemplate());
					if(entityOverride.getListViewTemplate() != null) entity.setListViewTemplate(entityOverride.getListViewTemplate());
					// View overrides
					if(entityOverride.getCreatePageTemplate() != null) {
						entity.setCreatePageTemplate(entityOverride.getCreatePageTemplate());
					}
					if(entityOverride.getEditPageTemplate() != null) entity.setEditPageTemplate(entityOverride.getEditPageTemplate());
					if(entityOverride.getViewPageTemplate() != null) entity.setViewPageTemplate(entityOverride.getViewPageTemplate());
					if(entityOverride.getListPageTemplate() != null) entity.setListPageTemplate(entityOverride.getListPageTemplate());
				}
			}
		}
	}

	/**
	 * @param entities
	 * @param table
	 */
	private Entity tableToEntity(Table table) {
		Entity entity = new Entity();
		entity.setGlobal(false);
		entity.setIsVirtual(false);
		entity.setName(StringUtils.tableNameToJavaClassName(table.getName()));
		entity.setPostName(table.getName());
		if(StringUtils.isValidString(table.getDescription()))
			entity.setDescription(table.getDescription());
		else
			entity.setDescription(entity.getName());
		List<Field> fields = new ArrayList<Field>();
		// Process columns
		for(Column column : table.getColumns()) {
			if(!column.getName().equals("id")) fields.add(columnToField(column));
		}
		// Process foreign keys
		for(ForeignKey foreignKey : table.getForeignKeys()) foreignKeyToField(foreignKey, fields);
		entity.setFields(fields);
		return entity;
	}
	
	/**
	 * @param foreignKey
	 * @param fields
	 */
	private void foreignKeyToField(ForeignKey foreignKey, List<Field> fields) {
		for(Field field : fields) {
			if(foreignKey.getFirstReference().getLocalColumnName().equals(field.getName())) {
				field.setRelationshipField(true);
				field.setDataType(StringUtils.tableNameToJavaClassName(foreignKey.getForeignTableName()));
			}
		}
	}

	/**
	 * @param column
	 * @return
	 */
	private Field columnToField(Column column) {
		Field field = new Field();
		field.setName(column.getName());
		field.setJavaName(StringUtils.columnNameToJavaFieldName(column.getName()));
		if(StringUtils.isValidString(column.getDescription()))
			field.setDescription(column.getDescription());
		else
			field.setDescription(field.getJavaName());
		field.setRequired(column.isRequired()); 
		field.setSize(String.valueOf(column.getSizeAsInt()));
		field.setIsFormField(true);
		field.setIsVisible(false);
		
		if(defaultCreateFields.contains(field.getName())) {
			field.setIsVisible(true);
			field.setCreateField(true);
		}
		else field.setCreateField(false);
		
		if(defaultEditFields.contains(field.getName()))	{
			field.setIsVisible(true);
			field.setEditField(true);
		}
		else field.setEditField(false);
		
		if(defaultViewFields.contains(field.getName()))	{
			field.setIsVisible(true);
			field.setViewField(true);
		}
		else field.setViewField(false);
		
		if(defaultListFields.contains(field.getName())){
			field.setIsVisible(true);
			field.setListField(true);
		}
		else field.setListField(false);
		
		field.setRelationshipField(false);
		return processColumnDataType(field, column);
	}
	
	/**
	 * @param field
	 * @param column
	 * @return
	 */
	public Field processColumnDataType(Field field, Column column){
		if(column.getType().equals(INTEGER))
			return processIntColumn(field, column);
		else if(column.getType().equals(DECIMAL))
			return processDecimalColumn(field, column);
		else if(column.getType().equals(DATE))
			return processDateColumn(field, column);
		else if(column.getType().equals(DATETIME))
			return processDateColumn(field, column);
		else if(column.getType().equals(TIMESTAMP))
			return processDateColumn(field, column);
		else if(column.getType().equals(VARCHAR))
			return processTextColumn(field, column);
		else if(column.getType().equals(CHAR))
			return processCharColumn(field, column);
		else 
			return processIntColumn(field, column);
	}

	public Field processCharColumn(Field field, Column column) {
		if(column.getName().equalsIgnoreCase("rec_st")) {
			field.setDataType(DATA_TYPE_CODE);
		}
		else {
			field.setDataType(DATA_TYPE_FG);
		}
		return field;
	}

	/**
	 * @param field
	 * @param column
	 */
	private Field processTextColumn(Field field, Column column) {
		if(column.getName().equalsIgnoreCase("name")) {
			field.setDataType(DATA_TYPE_NAME);
		}
		else if(column.getName().equalsIgnoreCase("entity_code")) {
			field.setDataType(DATA_TYPE_CODE);
		}
		else if(column.getName().equalsIgnoreCase("description")) {
			field.setDataType(DATA_TYPE_LG_TEXT);
		}
		else {
			if(column.getSizeAsInt() == 1)
				field.setDataType(DATA_TYPE_FG);
			if(column.getSizeAsInt() == 35)
				field.setDataType(DATA_TYPE_CODE);
			else if (column.getSizeAsInt() == 75)
				field.setDataType(DATA_TYPE_NAME);
			else if (column.getSizeAsInt() == 255)
				field.setDataType(DATA_TYPE_LG_TEXT);
			else {
				field.setDataType(DATA_TYPE_NAME);
			}
		}
		return field;
	}

	/**
	 * @param field
	 * @param column
	 */
	private Field processIntColumn(Field field, Column column) {
		if(column.isPrimaryKey())
			field.setDataType(DATA_TYPE_ID);
		else if(column.getSizeAsInt() < 12)
			field.setDataType(DATA_TYPE_INT);
		else
			field.setDataType(DATA_TYPE_BIGINT);
		return field;
	}

	/**
	 * @param field
	 * @param column
	 */
	private Field processDateColumn(Field field, Column column) {
		if(column.getType().equals(DATE))
			field.setDataType(DATA_TYPE_DATE);
		else if(column.getType().equals(DATETIME))
			field.setDataType(DATA_TYPE_DATE);
		else if(column.getType().equals(TIMESTAMP))
			field.setDataType(DATA_TYPE_DATE);
		return field;
	}

	/**
	 * @param field
	 * @param column
	 */
	private Field processDecimalColumn(Field field, Column column) {
		field.setDataType(DATA_TYPE_MONEY);
		return field;
	}
	
	
	/**
	 * @param dataSource
	 * @return
	 */
	public Database readDatabase(DataSource dataSource) throws IDEException
	{
	    Platform platform = PlatformFactory.createNewPlatformInstance(dataSource);
	    try {
			Connection connection = dataSource.getConnection();
			return platform.readModelFromDatabase(connection, null, null, null, null);
		} catch (DatabaseOperationException e) {
			e.printStackTrace();
			throw new IDEException(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IDEException(e.getMessage());
		}
	}
	
	/**
	 * @param buildConfiguration
	 * @return
	 */
	public DataSource getMySQLDataSource(BuildConfiguration buildConfiguration) {
		MysqlDataSource mysqlDS = new MysqlDataSource();
		mysqlDS.setURL(buildConfiguration.getDatabase().getUrl());
		mysqlDS.setUser(buildConfiguration.getDatabase().getUser());
		mysqlDS.setPassword(buildConfiguration.getDatabase().getPassword());
		return mysqlDS;
	}

}
