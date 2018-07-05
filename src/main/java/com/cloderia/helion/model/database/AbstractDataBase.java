/**
 * 
 */
package com.cloderia.helion.model.database;

import javax.xml.bind.annotation.XmlElement;

import com.cloderia.helion.model.AbstractArtifact;

/**
 * @author Edward Banfa
 *
 */
public abstract class AbstractDataBase extends AbstractArtifact implements DataBase {

	private String url;
	private String userName;
	private String password;
	
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

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.model.Artifact#getArtifactType()
	 */
	@Override
	public String getArtifactType() {
		return "database";
	}

}
