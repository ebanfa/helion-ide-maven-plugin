/**
 * 
 */
package com.cloderia.helion.ide.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author adrian
 *
 */
public class Entity extends AbstractArtifact {

	private String tableName;
	private Module parentModule;
	private EntityConfig artifactConfig;
	private List<Field> fields = new ArrayList<Field>();
	
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
	 * @return the fields
	 */
	public List<Field> getFields() {
		return fields;
	}

	/**
	 * @param fields the fields to set
	 */
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.model.Artifact#getArtifactType()
	 */
	public String getArtifactType() {
		return "entity";
	}

	/**
	 * @return the artifactConfig
	 */
	public EntityConfig getArtifactConfig() {
		return artifactConfig;
	}

	/**
	 * @param artifactConfig the artifactConfig to set
	 */
	@XmlElement
	public void setArtifactConfig(EntityConfig artifactConfig) {
		this.artifactConfig = artifactConfig;
	}

	/**
	 * @return the parentModule
	 */
	public Module getParentModule() {
		return parentModule;
	}

	/**
	 * @param parentModule the parentModule to set
	 */
	public void setParentModule(Module parentModule) {
		this.parentModule = parentModule;
	}

}
