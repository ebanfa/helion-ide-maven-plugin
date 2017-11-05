/**
 * 
 */
package com.cloderia.helion.ide.data;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author adrian
 *
 */
@XmlRootElement(name="application")
public class ApplicationData implements ArtifactData {
	
	String name;
	String groupId;
	String artifactId;
	String description;
	String templatesDir;
	UiConfig uiConfig;
	List<ModuleData> moduleDatas = new ArrayList<ModuleData>();

	/**
	 * 
	 */
	public ApplicationData() {
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
	 * @return the templatesDir
	 */
	public String getTemplatesDir() {
		return templatesDir;
	}

	/**
	 * @param templatesDir the templatesDir to set
	 */
	@XmlElement
	public void setTemplatesDir(String templates) {
		this.templatesDir = templates;
	}

	/**
	 * @return the uiConfig
	 */
	public UiConfig getUiConfig() {
		return uiConfig;
	}

	/**
	 * @param uiConfig the uiConfig to set
	 */
	@XmlElement
	public void setUiConfig(UiConfig uiConfig) {
		this.uiConfig = uiConfig;
	}

	/**
	 * @return the modules
	 */
	public List<ModuleData> getModules() {
		return moduleDatas;
	}

	/**
	 * @param moduleDatas the modules to set
	 */
	@XmlElement(name="module")
	public void setModules(List<ModuleData> moduleDatas) {
		this.moduleDatas = moduleDatas;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.app.ArtifactData#getArtifactDataType()
	 */
	public String getArtifactDataType() {
		return "application";
	}

	/**
	 * @return the groupId
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the artifactId
	 */
	public String getArtifactId() {
		return artifactId;
	}

	/**
	 * @param artifactId the artifactId to set
	 */
	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

}
