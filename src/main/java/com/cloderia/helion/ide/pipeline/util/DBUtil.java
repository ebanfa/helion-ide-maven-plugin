/**
 * 
 */
package com.cloderia.helion.ide.pipeline.util;

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

import com.cloderia.helion.HelionException;
import com.cloderia.helion.ide.model.DatabaseData;
import com.cloderia.helion.ide.model.Entity;
import com.cloderia.helion.ide.model.Field;
import com.cloderia.helion.ide.util.StringUtil;
import com.cloderia.helion.pipeline.PipelineContext;
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
	public static List<Entity> loadEntitiesFromDB(PipelineContext context) throws HelionException {
		List<Entity> entities = new ArrayList<Entity>();
		Table[] tables = readDatabase(getMySQLDataSource(context)).getTables();
		for (Table table : tables) {
			Entity entity = tableToEntity(table);
			entities.add(entity);
		}
		return entities;
	}
	
	/**
	 * @param entities
	 * @param table
	 */
	public static Entity tableToEntity(Table table) {
		Entity entity = new Entity();
		String entityName = StringUtil.tableNameToJavaClassName(table.getName());
		entity.setName(entityName);
		entity.setId(entityName);
		entity.setTableName(table.getName());
		if (StringUtil.isValidString(table.getDescription()))
			entity.setDescription(table.getDescription());
		else
			entity.setDescription(entity.getName());
		List<Field> fields = new ArrayList<Field>();
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
	private static void foreignKeyToField(ForeignKey foreignKey, List<Field> fields) {
		for (Field field : fields) {
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
	private static Field columnToField(Column column) {
		Field field = new Field();
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
	public static Field processColumnDataType(Field field, Column column) {
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

	public static Field processCharColumn(Field field, Column column) {
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
	private static Field processTextColumn(Field field, Column column) {
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
	private static Field processIntColumn(Field field, Column column) {
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
	private static Field processDateColumn(Field field, Column column) {
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
	private static Field processDecimalColumn(Field field, Column column) {
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
		DatabaseData dbConfig = context.getApplication().getDatabase();
		MysqlDataSource mysqlDS = new MysqlDataSource();
		mysqlDS.setURL(dbConfig.getUrl());
		mysqlDS.setUser(dbConfig.getUserName());
		mysqlDS.setPassword(dbConfig.getPassword());
		return mysqlDS;
	}
}
