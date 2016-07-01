/**
 * 
 */
package com.cloderia.helion.ide;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ddlutils.DatabaseOperationException;
import org.apache.ddlutils.Platform;
import org.apache.ddlutils.PlatformFactory;
import org.apache.ddlutils.model.Column;
import org.apache.ddlutils.model.Database;
import org.apache.ddlutils.model.Table;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import com.cloderia.helion.ide.app.Application;
import com.cloderia.helion.ide.app.Entity;
import com.cloderia.helion.ide.app.Field;
import com.cloderia.helion.ide.app.Module;
import com.cloderia.helion.ide.util.IDEUtils;
import com.cloderia.helion.ide.util.StringUtils;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * @author adrian
 *
 */
@Mojo(name="generate-model")
public class DBToXMLEntityDataMojo  extends AbstractHelionMojo {
    
    /**
     */
    @Parameter(property = "helion.dbURL")
    protected String dbURL;
	
    /**
     */
    @Parameter(property = "helion.dbUser")
    private String dbUser;  
    
    /**
     */
    @Parameter(property = "helion.dbPassword")
    protected String dbPassword;


	public void execute() throws MojoExecutionException, MojoFailureException {
		Application application = new Application();
		application.setName(name);
		application.setPackageName(packageName);
		application.setDescription(description);
		application.setTemplatesDir(templateDir);
		application.setGenerateSourcesDir(targetDir);
		execute(application);
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.AbstractHelionMojo#execute(com.cloderia.helion.ide.app.Application)
	 */
	@Override
	public void execute(Application application) {
		Database database = readDatabase(getMySQLDataSource());
		Module module = new Module();
		List<Entity> entities = new ArrayList<Entity>();
		for(Table table: database.getTables()) entities.add(tableToEntity(table));
		module.setEntities(entities);
		application.getModules().add(module);
		IDEUtils.writeApplicationXML(config, application);
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
		entity.setDescription(table.getDescription());
		List<Field> fields = new ArrayList<Field>();
		for(Column column : table.getColumns()) fields.add(columnToField(column));
		entity.setFields(fields);
		return entity;
	}
	
	/**
	 * @param column
	 * @return
	 */
	private Field columnToField(Column column) {
		Field field = new Field();
		field.setName(column.getName());
		field.setDescription(column.getDescription());
		field.setJavaName(column.getJavaName());
		field.setRequired(column.isRequired()); 
		field.setSize(column.getSize());
		field.setDataType(column.getType());
		field.setIsFormField(true);
		field.setIsVisible(true);
		field.setListField(true);
		field.setCreateField(true);
		field.setEditField(true);
		field.setViewField(true);
		return field;
	}
	
	public Database readDatabase(DataSource dataSource)
	{
	    Platform platform = PlatformFactory.createNewPlatformInstance(dataSource);
	    try {
			Connection connection = dataSource.getConnection();
			return platform.readModelFromDatabase(connection, null, null, null, null);
		} catch (DatabaseOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  null;
	}
	
	public DataSource getMySQLDataSource() {
		MysqlDataSource mysqlDS = new MysqlDataSource();
		mysqlDS.setURL(dbURL);
		mysqlDS.setUser(dbUser);
		mysqlDS.setPassword(dbPassword);
		return mysqlDS;
	}
}
