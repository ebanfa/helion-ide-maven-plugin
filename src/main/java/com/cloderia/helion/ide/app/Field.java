/**
 * 
 */
package com.cloderia.helion.ide.app;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author adrian
 *
 */
public class Field implements ArtifactData {

	private String name;
	private String javaName;
	private String dataType;
	private String size;
	private boolean isVisible;
	private boolean isFormField;
	private boolean required;
	private boolean createField;
	private boolean editField;
	private boolean viewField;
	private boolean listField;
	private String dataColumn;
	private String description;
	private String displayName;
	private String optionsProvider;
	private boolean relationshipField;
	
	/**
	 * 
	 */
	public Field() {
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
	 * @return the isVisible
	 */
	public boolean getIsVisible() {
		return isVisible;
	}

	/**
	 * @param isVisible the isVisible to set
	 */
	@XmlElement
	public void setIsVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	/**
	 * @return the isFormField
	 */
	public boolean getIsFormField() {
		return isFormField;
	}

	/**
	 * @param isFormField the isFormField to set
	 */
	@XmlElement
	public void setIsFormField(boolean isFormField) {
		this.isFormField = isFormField;
	}


	/**
	 * @return the createField
	 */
	public boolean getCreateField() {
		return createField;
	}

	/**
	 * @param createField the dataType to set
	 */
	@XmlElement
	public void setCreateField(boolean createField) {
		this.createField = createField;
	}

	/**
	 * @return the editField
	 */
	public boolean getEditField() {
		return editField;
	}

	/**
	 * @param editField the dataType to set
	 */
	@XmlElement
	public void setEditField(boolean editField) {
		this.editField = editField;
	}

	/**
	 * @return the viewField
	 */
	public boolean getViewField() {
		return viewField;
	}

	/**
	 * @param viewField the dataType to set
	 */
	@XmlElement
	public void setViewField(boolean viewField) {
		this.viewField = viewField;
	}


	/**
	 * @return the listField
	 */
	public boolean getListField() {
		return listField;
	}

	/**
	 * @param listField the dataType to set
	 */
	@XmlElement
	public void setListField(boolean listField) {
		this.listField = listField;
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
	@XmlElement
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	@XmlElement
	public void setSize(String size) {
		this.size = size;
	}

    /**
	 * @return the dataType
	 */
	public boolean getRequired() {
		return required;
	}

	/**
	 * @param dataType the dataType to set
	 */
	@XmlElement
	public void setRequired(boolean required) {
		this.required = required;
	}

	/**
	 * @return the dataColumn
	 */
	public String getDataColumn() {
		return dataColumn;
	}

	/**
	 * @param dataColumn the dataColumn to set
	 */
	@XmlElement
	public void setDataColumn(String dataColumn) {
		this.dataColumn = dataColumn;
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
	 * @return the relationshipField
	 */
	public boolean isRelationshipField() {
		return relationshipField;
	}

	/**
	 * @param relationshipField the relationshipField to set
	 */
	@XmlElement
	public void setRelationshipField(boolean relationshipField) {
		this.relationshipField = relationshipField;
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
	@XmlElement
	public void setJavaName(String javaName) {
		this.javaName = javaName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Field [name=" + name + ", javaName=" + javaName + ", dataType=" + dataType + ", size=" + size
				+ ", isVisible=" + isVisible + ", isFormField=" + isFormField + ", required=" + required
				+ ", createField=" + createField + ", editField=" + editField + ", viewField=" + viewField
				+ ", listField=" + listField + ", dataColumn=" + dataColumn + ", description=" + description
				+ ", displayName=" + displayName + ", optionsProvider=" + optionsProvider + ", relationshipField="
				+ relationshipField + "]";
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.app.ArtifactData#getArtifactDataType()
	 */
	public String getArtifactDataType() {
		return "field";
	}

}
