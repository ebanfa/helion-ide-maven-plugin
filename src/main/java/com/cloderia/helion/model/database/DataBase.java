/**
 * 
 */
package com.cloderia.helion.model.database;

import com.cloderia.helion.model.Artifact;

/**
 * @author Edward Banfa
 */
public interface DataBase extends Artifact  {

	/**
	 * @return the url
	 */
	public String getUrl();

	/**
	 * @return the userName
	 */
	public String getUserName();
	
	/**
	 * @return the password
	 */
	public String getPassword();
}
