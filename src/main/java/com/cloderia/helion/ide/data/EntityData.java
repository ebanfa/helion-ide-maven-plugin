/**
 * 
 */
package com.cloderia.helion.ide.data;

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
public class EntityData implements ArtifactData {

	private String name;
	private boolean hasUI;
	private boolean hasEndpoint;
	private boolean hasServices;
	private String parentName;
	private String displayName;
	private String description;
	private ModuleData moduleData;
	private List<FieldData> fieldDatas = new ArrayList<FieldData>();
	private Map<String, EntityData> relatedChildEntities = new HashMap<String, EntityData>();

	/**
	 * 
	 */
	public EntityData() {
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
	 * @return the moduleData
	 */
	public ModuleData getModule() {
		return moduleData;
	}

	/**
	 * @param moduleData the moduleData to set
	 */
	public void setModule(ModuleData moduleData) {
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

	public String getArtifactDataType() {
		return "entity";
	}

	/**
	 * @return the relatedChildEntities
	 */
	public Map<String, EntityData> getRelatedChildEntities() {
		return relatedChildEntities;
	}

	/**
	 * @param relatedChildEntities the relatedChildEntities to set
	 */
	public void setRelatedChildEntities(Map<String, EntityData> relatedChildEntities) {
		this.relatedChildEntities = relatedChildEntities;
	}
}
