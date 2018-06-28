/**
 * 
 */
package com.cloderia.helion.ide.model;

/**
 * @author adrian
 *
 */
public class Field extends AbstractArtifact {

	private String size;
	private String javaName;
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
	 * @return the javaName
	 */
	public String getJavaName() {
		return javaName;
	}

	/**
	 * @param javaName the javaName to set
	 */
	public void setJavaName(String javaName) {
		this.javaName = javaName;
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
