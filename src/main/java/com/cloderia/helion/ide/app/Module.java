/**
 * 
 */
package com.cloderia.helion.ide.app;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author adrian
 *
 */
public class Module implements ArtifactData {
	
	String name;
	private String description;
	private String uiClass;
		
	private Navigation navigation;
	List<Entity> entities = new ArrayList<Entity>();

	/**
	 * 
	 */
	public Module() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the navigation
	 */
	@XmlElement
	public Navigation getNavigation() {
		return navigation;
	}

	/**
	 * @param navigation the navigation to set
	 */
	public void setNavigation(Navigation navigation) {
		this.navigation = navigation;
	}

	/**
	 * @return the entities
	 */
	public List<Entity> getEntities() {
		return entities;
	}

	/**
	 * @param entities the entities to set
	 */
	@XmlElement(name="entity")
	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.app.ArtifactData#getArtifactDataType()
	 */
	public String getArtifactDataType() {
		return "module";
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the cssClass
	 */
	public String getUiClass() {
		return uiClass;
	}

	/**
	 * @param cssClass the cssClass to set
	 */
	@XmlElement
	public void setUiClass(String cssClass) {
		this.uiClass = cssClass;
	}

}
