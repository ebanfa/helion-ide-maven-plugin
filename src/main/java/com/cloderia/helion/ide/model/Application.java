/**
 * 
 */
package com.cloderia.helion.ide.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author adrian
 *
 */
@SuppressWarnings("restriction")
@XmlRootElement(name="application")
public class Application implements Artifact {
	
	private String name;
	private String groupId;
	private String artifactId;
	private String description;
	private String version;
	
	/** Database configuration */
	private DBConfigData database;
	
	/** Modules in the application */
	List<Module> modules = new ArrayList<Module>();

	/**
	 * 
	 */
	public Application() {
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
	 * @return the database
	 */
	public DBConfigData getDatabase() {
		return database;
	}

	/**
	 * @param database the database to set
	 */
	@XmlElement
	public void setDatabase(DBConfigData database) {
		this.database = database;
	}

	/**
	 * @return the modules
	 */
	public List<Module> getModules() {
		return modules;
	}

	/**
	 * @param modules the modules to set
	 */
	@XmlElement(name="module")
	@XmlElementWrapper(name="modules")
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.artifacts.ArtifactData#getArtifactDataType()
	 */
	public String getArtifactType() {
		return "application";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Application [name=" + name + ", groupId=" + groupId + ", artifactId=" + artifactId + ", description="
				+ description + ", version=" + version + ", database=" + database + ", modules=" + modules + "]";
	}

}
