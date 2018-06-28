/**
 * 
 */
package com.cloderia.helion.ide.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author adrian
 *
 */
public class DatabaseData extends AbstractArtifact {
	
	private String url;
	private String userName;
	private String password;
	private String persistenceUnitName;
	private String dataSource;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	@XmlElement
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	@XmlElement
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	@XmlElement
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * @return the persistenceUnitName
	 */
	public String getPersistenceUnitName() {
		return persistenceUnitName;
	}

	/**
	 * @param persistenceUnitName the persistenceUnitName to set
	 */
	@XmlElement
	public void setPersistenceUnitName(String persistenceUnitName) {
		this.persistenceUnitName = persistenceUnitName;
	}

	/**
	 * @return the dataSource
	 */
	public String getDataSource() {
		return dataSource;
	}

	/**
	 * @param dataSource the dataSource to set
	 */
	@XmlElement
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.model.Artifact#getArtifactType()
	 */
	public String getArtifactType() {
		return "database";
	}

}
