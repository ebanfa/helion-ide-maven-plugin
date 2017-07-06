/**
 * 
 */
package com.cloderia.helion.ide.artifact;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author adrian
 *
 */
public class UiComponent implements ArtifactData {
	
	private String name;
	private String uiGroup;
	private String className;
	private String htmlTemplate;
	private String classTemplate;
	private String uiComponentModel;

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.app.ArtifactData#getArtifactDataType()
	 */
	public String getArtifactDataType() {
		return "uiComponent";
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
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	@XmlElement
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the htmlTemplate
	 */
	public String getHtmlTemplate() {
		return htmlTemplate;
	}

	/**
	 * @param htmlTemplate the htmlTemplate to set
	 */
	@XmlElement
	public void setHtmlTemplate(String htmlTemplate) {
		this.htmlTemplate = htmlTemplate;
	}

	/**
	 * @return the classTemplate
	 */
	public String getClassTemplate() {
		return classTemplate;
	}

	/**
	 * @param classTemplate the classTemplate to set
	 */
	@XmlElement
	public void setClassTemplate(String classTemplate) {
		this.classTemplate = classTemplate;
	}

	/**
	 * @return the uiComponentModel
	 */
	public String getUiComponentModel() {
		return uiComponentModel;
	}

	/**
	 * @param uiComponentModel the uiComponentModel to set
	 */
	@XmlElement
	public void setUiComponentModel(String uiComponentModel) {
		this.uiComponentModel = uiComponentModel;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UiComponent [name=" + name + ", uiGroup=" + uiGroup + ", className=" + className + ", htmlTemplate="
				+ htmlTemplate + ", classTemplate=" + classTemplate + ", uiComponentModel=" + uiComponentModel + "]";
	}

}
