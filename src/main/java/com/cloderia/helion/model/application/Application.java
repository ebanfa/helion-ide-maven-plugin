/**
 * 
 */
package com.cloderia.helion.model.application;

import java.util.List;

import com.cloderia.helion.model.Artifact;
import com.cloderia.helion.model.database.DataBase;
import com.cloderia.helion.model.module.DataModule;
import com.cloderia.helion.model.module.ServiceModule;
import com.cloderia.helion.model.module.SharedModule;
import com.cloderia.helion.model.module.WebModule;

/**
 * Represents an abstract definition of an application.
 * 
 * @author Edward Banfa
 */
public interface Application extends Artifact {

	/**
	 * @return the id
	 */
	public String getId();

	/**
	 * @return the name
	 */
	public String getName();

	/**
	 * @return the packageName
	 */
	public String getPackageName();

	/**
	 * @return the version
	 */
	public String getVersion();

	/**
	 * @return the dataBase
	 */
	public DataBase getDataBase();
	
	/**
	 * @param dataBase
	 */
	public void setDataBase(DataBase dataBase);
	
	/**
	 * @return List of shared modules
	 */
	public <T extends SharedModule> List<T> getSharedModules();
	
	/**
	 * @return List of data modules
	 */
	public <T extends DataModule> List<T> getDataModules();
	
	/**
	 * @return List of web modules
	 */
	public <T extends WebModule> List<T> getWebModules();
	
	/**
	 * @return List of web modules
	 */
	public <T extends ServiceModule> List<T> getServiceModules();
}
