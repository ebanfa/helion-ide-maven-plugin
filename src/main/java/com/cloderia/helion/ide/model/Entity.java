/**
 * 
 */
package com.cloderia.helion.ide.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author adrian
 *
 */
public class Entity implements Artifact {

	private String name;
	private String tableName;
	private boolean hasUI;
	private boolean hasEndpoint;
	private boolean hasServices;
	private String parentName;
	private String displayName;
	private String description;
	private Module moduleData;
	private List<FieldData> fieldDatas = new ArrayList<FieldData>();
	private Map<String, Entity> relatedChildEntities = new HashMap<String, Entity>();

	/**
	 * 
	 */
	public Entity() {
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the name
	 */
	public String getLCName() {
		return name.toLowerCase();
	}

	/**
	 * @param name the name to set
	 */
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the hasUI
	 */
	public boolean isHasUI() {
		return hasUI;
	}

	/**
	 * @param hasUI the hasUI to set
	 */
	@XmlElement
	public void setHasUI(boolean hasUI) {
		this.hasUI = hasUI;
	}

	/**
	 * @return the hasEndpoint
	 */
	public boolean isHasEndpoint() {
		return hasEndpoint;
	}

	/**
	 * @param hasEndpoint the hasEndpoint to set
	 */
	@XmlElement
	public void setHasEndpoint(boolean hasEndpoint) {
		this.hasEndpoint = hasEndpoint;
	}

	/**
	 * @return the hasServices
	 */
	public boolean isHasServices() {
		return hasServices;
	}

	/**
	 * @param hasServices the hasServices to set
	 */
	@XmlElement
	public void setHasServices(boolean hasServices) {
		this.hasServices = hasServices;
	}

	/**
	 * @return the parentName
	 */
	public String getParentName() {
		return parentName;
	}

	/**
	 * @param parentName the parentName to set
	 */
	@XmlElement
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName the displayName to set
	 */
	@XmlElement
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	@XmlElement
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the moduleData
	 */
	public Module getModule() {
		return moduleData;
	}

	/**
	 * @param moduleData the moduleData to set
	 */
	@XmlTransient   
	public void setModule(Module moduleData) {
		this.moduleData = moduleData;
	}

	/**
	 * @return the fieldDatas
	 */
	public List<FieldData> getFields() {
		return fieldDatas;
	}

	/**
	 * @param fieldDatas the fieldDatas to set
	 */
	@XmlElement(name="field")
	public void setFields(List<FieldData> fieldDatas) {
		this.fieldDatas = fieldDatas;
	}

	public String getArtifactType() {
		return "entity";
	}

	/**
	 * @return the relatedChildEntities
	 */
	public Map<String, Entity> getRelatedChildEntities() {
		return relatedChildEntities;
	}

	/**
	 * @param relatedChildEntities the relatedChildEntities to set
	 */
	public void setRelatedChildEntities(Map<String, Entity> relatedChildEntities) {
		this.relatedChildEntities = relatedChildEntities;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EntityData [name=" + name + "]";
	}
}
