/**
 * 
 */
package com.cloderia.helion.pipeline.util;

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

import com.cloderia.helion.exception.HelionException;
import com.cloderia.helion.model.application.Application;
import com.cloderia.helion.model.database.DataBase;
import com.cloderia.helion.model.entity.JPAEntity;
import com.cloderia.helion.model.entity.JPAEntityField;
import com.cloderia.helion.model.pipeline.PipelineContext;
import com.cloderia.helion.util.ArtifactConfigUtil;
import com.cloderia.helion.util.IDEConstants;
import com.cloderia.helion.util.StringUtil;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * @author adrian
 *
 */
public class DBUtil {

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
	public static final String DATA_TYPE_BIGINT = "bignumber";
	
	public static List<String> defaultCreateFields = Arrays.asList("name", "description", "effective_dt");
	public static List<String> defaultEditFields = Arrays.asList("entity_code", "name", "description", "effective_dt");
	public static List<String> defaultViewFields = Arrays.asList("entity_code", "name", "description", "effective_dt");
	public static List<String> defaultListFields = Arrays.asList("entity_code", "name", "description", "effective_dt");

	/**
	 * @param buildConfiguration
	 * @param module
	 * @return
	 * @throws HelionException
	 */
	public static List<JPAEntity> loadEntitiesFromDB(PipelineContext context) throws HelionException {
		List<JPAEntity> entities = new ArrayList<JPAEntity>();
		Table[] tables = readDatabase(getMySQLDataSource(context)).getTables();
		for (Table table : tables) {
			JPAEntity entity = tableToEntity(table);
			entities.add(entity);
		}
		return entities;
	}
	
	/**
	 * @param entities
	 * @param table
	 */
	public static JPAEntity tableToEntity(Table table) {
		JPAEntity entity = new JPAEntity();
		String entityName = StringUtil.tableNameToJavaClassName(table.getName());
		entity.setName(entityName);
		entity.setId(entityName);
		entity.setTableName(table.getName());
		if (StringUtil.isValidString(table.getDescription()))
			entity.setDescription(table.getDescription());
		else
			entity.setDescription(entity.getName());
		List<JPAEntityField> fields = new ArrayList<JPAEntityField>();
		// Process columns
		for (Column column : table.getColumns()) {
			if (!column.getName().equalsIgnoreCase("id"))
				fields.add(columnToField(column));
		}
		// Process foreign keys
		for (ForeignKey foreignKey : table.getForeignKeys())
			foreignKeyToField(foreignKey, fields);
		entity.setFields(fields);
		return entity;
	}

	/**
	 * @param foreignKey
	 * @param fields
	 */
	private static void foreignKeyToField(ForeignKey foreignKey, List<JPAEntityField> fields) {
		for (JPAEntityField field : fields) {
			if (foreignKey.getFirstReference().getLocalColumnName().equals(field.getName())) {
				field.setRelationshipField(true);
				field.setDataType(StringUtil.tableNameToJavaClassName(foreignKey.getForeignTableName()));
			}
		}
	}

	/**
	 * @param column
	 * @return
	 */
	private static JPAEntityField columnToField(Column column) {
		JPAEntityField field = new JPAEntityField();
		field.setName(StringUtil.columnNameToJavaFieldName(column.getName()));
		field.setJavaName(field.getName());
		if (StringUtil.isValidString(column.getDescription()))
			field.setDescription(column.getDescription());
		else
			field.setDescription(field.getJavaName());
		field.setRequired(column.isRequired());
		field.setSize(String.valueOf(column.getSizeAsInt()));

		field.setRelationshipField(false);
		return processColumnDataType(field, column);
	}

	/**
	 * @param field
	 * @param column
	 * @return
	 */
	public static JPAEntityField processColumnDataType(JPAEntityField field, Column column) {
		if (column.getType().equals(DBUtil.INTEGER))
			return processIntColumn(field, column);
		else if (column.getType().equals(DBUtil.DECIMAL))
			return processDecimalColumn(field, column);
		else if (column.getType().equals(DBUtil.DATE))
			return processDateColumn(field, column);
		else if (column.getType().equals(DBUtil.DATETIME))
			return processDateColumn(field, column);
		else if (column.getType().equals(DBUtil.TIMESTAMP))
			return processDateColumn(field, column);
		else if (column.getType().equals(DBUtil.VARCHAR))
			return processTextColumn(field, column);
		else if (column.getType().equals(DBUtil.CHAR))
			return processCharColumn(field, column);
		else
			return processIntColumn(field, column);
	}

	public static JPAEntityField processCharColumn(JPAEntityField field, Column column) {
		if (column.getName().equalsIgnoreCase("status")) {
			field.setDataType(DBUtil.DATA_TYPE_CODE);
		} else {
			field.setDataType(DBUtil.DATA_TYPE_FG);
		}
		return field;
	}

	/**
	 * @param field
	 * @param column
	 */
	private static JPAEntityField processTextColumn(JPAEntityField field, Column column) {
		if (column.getName().equalsIgnoreCase("name")) {
			field.setDataType(DBUtil.DATA_TYPE_NAME);
		} else if (column.getName().equalsIgnoreCase("entity_code")) {
			field.setDataType(DBUtil.DATA_TYPE_CODE);
		} else if (column.getName().equalsIgnoreCase("description")) {
			field.setDataType(DBUtil.DATA_TYPE_LG_TEXT);
		} else {
			if (column.getSizeAsInt() == 1)
				field.setDataType(DBUtil.DATA_TYPE_FG);
			if (column.getSizeAsInt() == 35)
				field.setDataType(DBUtil.DATA_TYPE_CODE);
			else if (column.getSizeAsInt() == 75)
				field.setDataType(DBUtil.DATA_TYPE_NAME);
			else if (column.getSizeAsInt() == 255)
				field.setDataType(DBUtil.DATA_TYPE_LG_TEXT);
			else {
				field.setDataType(DBUtil.DATA_TYPE_NAME);
			}
		}
		return field;
	}

	/**
	 * @param field
	 * @param column
	 */
	private static JPAEntityField processIntColumn(JPAEntityField field, Column column) {
		if (column.isPrimaryKey())
			field.setDataType(DBUtil.DATA_TYPE_ID);
		else if (column.getSizeAsInt() < 12)
			field.setDataType(DBUtil.DATA_TYPE_INT);
		else
			field.setDataType(DBUtil.DATA_TYPE_BIGINT);
		return field;
	}

	/**
	 * @param field
	 * @param column
	 */
	private static JPAEntityField processDateColumn(JPAEntityField field, Column column) {
		if (column.getType().equals(DBUtil.DATE))
			field.setDataType(DBUtil.DATA_TYPE_DATE);
		else if (column.getType().equals(DBUtil.DATETIME))
			field.setDataType(DBUtil.DATA_TYPE_DATE);
		else if (column.getType().equals(DBUtil.TIMESTAMP))
			field.setDataType(DBUtil.DATA_TYPE_DATE);
		return field;
	}

	/**
	 * @param field
	 * @param column
	 */
	private static JPAEntityField processDecimalColumn(JPAEntityField field, Column column) {
		field.setDataType(DBUtil.DATA_TYPE_MONEY);
		return field;
	}

	/**
	 * @param dataSource
	 * @return
	 */
	public static Database readDatabase(DataSource dataSource) throws HelionException {
		Platform platform = PlatformFactory.createNewPlatformInstance(dataSource);
		try {
			Connection connection = dataSource.getConnection();
			return platform.readModelFromDatabase(connection, null, null, null, null);
		} catch (DatabaseOperationException e) {
			e.printStackTrace();
			throw new HelionException(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new HelionException(e.getMessage());
		}
	}

	/**
	 * @param buildConfiguration
	 * @return
	 */
	public static DataSource getMySQLDataSource(PipelineContext context) {
		Application application = context.getApplication();
		DataBase dataBase = application.getDataBase();
		
		MysqlDataSource mysqlDS = new MysqlDataSource();
		mysqlDS.setURL(dataBase.getUrl());
		mysqlDS.setUser(dataBase.getUserName());
		mysqlDS.setPassword(dataBase.getPassword());
		return mysqlDS;
	}
}
