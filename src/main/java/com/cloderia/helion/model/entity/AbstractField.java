/**
 * 
 */
package com.cloderia.helion.model.entity;

import com.cloderia.helion.model.AbstractArtifact;

/**
 * @author Edward Banfa
 *
 */
public abstract class AbstractField extends AbstractArtifact implements Field {
	
	private String size;
	private String dataType;
	private boolean required;
	private boolean relationshipField = false;

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the dataType
	 */
	public String getDataType() {
		return dataType;
	}

	/**
	 * @param dataType the dataType to set
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	/**
	 * @return the required
	 */
	public boolean isRequired() {
		return required;
	}

	/**
	 * @param required the required to set
	 */
	public void setRequired(boolean required) {
		this.required = required;
	}

	/**
	 * @return the relationshipField
	 */
	public boolean isRelationshipField() {
		return relationshipField;
	}

	/**
	 * @param relationshipField the relationshipField to set
	 */
	public void setRelationshipField(boolean relationshipField) {
		this.relationshipField = relationshipField;
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.app.ArtifactData#getArtifactDataType()
	 */
	public String getArtifactType() {
		return "field";
	}
	
}
