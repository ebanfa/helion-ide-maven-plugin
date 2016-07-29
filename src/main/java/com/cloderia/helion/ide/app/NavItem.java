/**
 * 
 */
package com.cloderia.helion.ide.app;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author adrian
 *
 */
public class NavItem implements ArtifactData {

	private String type;
	private String name;
	private String displayName;
	private String description;
	private String uiClass;
	private String target;

	/**
	 * 
	 */
	public NavItem() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	@XmlElement
	public void setType(String type) {
		this.type = type;
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
	 * @return the uiClass
	 */
	public String getUiClass() {
		return uiClass;
	}

	/**
	 * @param uiClass the uiClass to set
	 */
	@XmlElement
	public void setUiClass(String uiClass) {
		this.uiClass = uiClass;
	}

	/**
	 * @return the target
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	@XmlElement
	public void setTarget(String target) {
		this.target = target;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.app.ArtifactData#getArtifactDataType()
	 */
	public String getArtifactDataType() {
		return "menugroup";
	}
}