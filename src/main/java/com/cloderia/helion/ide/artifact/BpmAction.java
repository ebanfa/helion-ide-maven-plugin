/**
 * 
 */
package com.cloderia.helion.ide.artifact;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author adrian
 *
 */
public class BpmAction implements ArtifactData {
	

	private String name;
	private String description;
	private String uiGroup;
	private String actionTemplate;

	/**
	 * 
	 */
	public BpmAction() {
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
	 * @return the actionTemplate
	 */
	public String getActionTemplate() {
		return actionTemplate;
	}

	/**
	 * @param actionTemplate the actionTemplate to set
	 */
	@XmlElement
	public void setActionTemplate(String actionTemplate) {
		this.actionTemplate = actionTemplate;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.app.ArtifactData#getArtifactDataType()
	 */
	public String getArtifactDataType() {
		return "bpmaction";
	}

}
