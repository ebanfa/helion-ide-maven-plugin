/**
 * 
 */
package com.cloderia.helion.ide.artifact;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author adrian
 *
 */
public class Page implements ArtifactData {
	private String name;
	private String displayName;
	private String description;
	private String uiGroup;
	private String pageTemplate;
	private String viewTemplate;
	private String viewModelTemplate;
	private String viewActionTemplate;
	private Boolean generateTemplate;

	/**
	 * 
	 */
	public Page() {
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
	 * @return the uiGroup
	 */
	public String getUiGroup() {
		return uiGroup;
	}

	/**
	 * @param uiGroup the uiGroup to set
	 */
	@XmlElement
	public void setUiGroup(String uiGroup) {
		this.uiGroup = uiGroup;
	}

	/**
	 * @return the pageTemplate
	 */
	public String getPageTemplate() {
		return pageTemplate;
	}

	/**
	 * @param pageTemplate the pageTemplate to set
	 */
	@XmlElement
	public void setPageTemplate(String pageTemplate) {
		this.pageTemplate = pageTemplate;
	}

	/**
	 * @return the viewTemplate
	 */
	public String getViewTemplate() {
		return viewTemplate;
	}

	/**
	 * @param viewTemplate the viewTemplate to set
	 */
	@XmlElement
	public void setViewTemplate(String viewTemplate) {
		this.viewTemplate = viewTemplate;
	}

	/**
	 * @return the viewModelTemplate
	 */
	public String getViewModelTemplate() {
		return viewModelTemplate;
	}

	/**
	 * @param viewModelTemplate the viewModelTemplate to set
	 */
	@XmlElement
	public void setViewModelTemplate(String viewModelTemplate) {
		this.viewModelTemplate = viewModelTemplate;
	}

	/**
	 * @return the viewActionTemplate
	 */
	public String getViewActionTemplate() {
		return viewActionTemplate;
	}

	/**
	 * @param viewActionTemplate the viewActionTemplate to set
	 */
	@XmlElement
	public void setViewActionTemplate(String viewActionTemplate) {
		this.viewActionTemplate = viewActionTemplate;
	}

	/**
	 * @return the generateTemplate
	 */
	public Boolean getGenerateTemplate() {
		return generateTemplate;
	}

	/**
	 * @param generateTemplate the generateTemplate to set
	 */
	@XmlElement
	public void setGenerateTemplate(Boolean generateTemplate) {
		this.generateTemplate = generateTemplate;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.app.ArtifactData#getArtifactDataType()
	 */
	public String getArtifactDataType() {
		return "page";
	}

}
