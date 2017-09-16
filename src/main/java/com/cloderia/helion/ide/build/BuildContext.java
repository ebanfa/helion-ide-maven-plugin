/**
 * 
 */
package com.cloderia.helion.ide.build;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.cloderia.helion.ide.data.ApplicationData;

/**
 * @author adrian
 *
 */
@SuppressWarnings("restriction")
@XmlRootElement(name="configuration")
public class BuildContext {
	
	private String name;
	private String groupId;
	private String artifactId;
	private String version;
	private String description;
	private String projectDir;
	private String config;
	private String targetDir;
	private String wpTargetDir;
	private String resourcesDir;
	private String uaResourcesDir;
	private String wpResourcesDir;
	private String wpUaResourcesDir;
	private List<String> processor;
	private List<String> templateDir;
	private ApplicationData applicationData;
	private Map<String, Object> contextData = new HashMap<String, Object>();

	/**
	 * 
	 */
	public BuildContext() {
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
	 * @return the groupId
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	@XmlElement
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
	@XmlElement
	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	@XmlElement
	public void setVersion(String version) {
		this.version = version;
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
	 * @return the configFile
	 */
	public String getConfig() {
		return config;
	}

	/**
	 * @param configFile the configFile to set
	 */
	@XmlElement
	public void setConfig(String config) {
		this.config = config;
	}
	
	/**
	 * @return the projectDir
	 */
	public String getProjectDir() {
		return projectDir;
	}

	/**
	 * @param projectDir the projectDir to set
	 */
	@XmlElement
	public void setProjectDir(String projectDir) {
		this.projectDir = projectDir;
	}

	/**
	 * @return the targetDir
	 */
	public String getTargetDir() {
		return targetDir;
	}

	/**
	 * @param targetDir the targetDir to set
	 */
	@XmlElement
	public void setTargetDir(String targetDir) {
		this.targetDir = targetDir;
	}

	/**
	 * @return the wpTargetDir
	 */
	public String getWpTargetDir() {
		return wpTargetDir;
	}

	/**
	 * @param wpTargetDir the wpTargetDir to set
	 */
	@XmlElement
	public void setWpTargetDir(String wpTargetDir) {
		this.wpTargetDir = wpTargetDir;
	}

	/**
	 * @return the resourcesDir
	 */
	public String getResourcesDir() {
		return resourcesDir;
	}

	/**
	 * @param resourcesDir the resourcesDir to set
	 */
	@XmlElement
	public void setResourcesDir(String resourcesDir) {
		this.resourcesDir = resourcesDir;
	}

	/**
	 * @return the uaResourcesDir
	 */
	public String getUaResourcesDir() {
		return uaResourcesDir;
	}

	/**
	 * @param uaResourcesDir the uaResourcesDir to set
	 */
	@XmlElement
	public void setUaResourcesDir(String uaResourcesDir) {
		this.uaResourcesDir = uaResourcesDir;
	}

	/**
	 * @return the wpResourcesDir
	 */
	public String getWpResourcesDir() {
		return wpResourcesDir;
	}

	/**
	 * @param wpResourcesDir the wpResourcesDir to set
	 */
	@XmlElement
	public void setWpResourcesDir(String wpResourcesDir) {
		this.wpResourcesDir = wpResourcesDir;
	}

	/**
	 * @return the templateDir
	 */
	public List<String> getTemplateDir() {
		return templateDir;
	}

	/**
	 * @param templateDir the templateDir to set
	 */
	@XmlElement
	public void setTemplateDir(List<String> templateDir) {
		this.templateDir = templateDir;
	}

	/**
	 * @return the builders
	 */
	public List<String> getProcessor() {
		return processor;
	}

	/**
	 * @param builders the builders to set
	 */
	@XmlElement
	@XmlElementWrapper(name="pipeline")
	public void setProcessor(List<String> processor) {
		this.processor = processor;
	}

	/**
	 * @return the application
	 */
	public ApplicationData getApplicationData() {
		return applicationData;
	}

	/**
	 * @param application the application to set
	 */
	public void setApplicationData(ApplicationData applicationData) {
		this.applicationData = applicationData;
	}

	/**
	 * @return the contextData
	 */
	public Object get(String key) {
		return contextData.get(key);
	}

	/**
	 * @param contextData the contextData to set
	 */
	public void put(String key, Object value) {
		this.contextData.put(key, value);
	}

	/**
	 * @return the wpUaResourcesDir
	 */
	public String getWpUaResourcesDir() {
		return wpUaResourcesDir;
	}

	/**
	 * @param wpUaResourcesDir the wpUaResourcesDir to set
	 */
	@XmlElement
	public void setWpUaResourcesDir(String wpUaResourcesDir) {
		this.wpUaResourcesDir = wpUaResourcesDir;
	}

	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BuildContext [name=" + name + ", groupId=" + groupId + ", artifactId=" + artifactId + ", version="
				+ version + ", description=" + description + ", projectDir=" + projectDir + ", config=" + config
				+ ", targetDir=" + targetDir + ", processor=" + processor + ", templateDir=" + templateDir
				+ ", applicationData=" + applicationData + "]";
	}
}
