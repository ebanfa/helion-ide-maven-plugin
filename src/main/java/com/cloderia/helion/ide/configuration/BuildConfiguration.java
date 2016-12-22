/**
 * 
 */
package com.cloderia.helion.ide.configuration;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.cloderia.helion.ide.app.Application;
import com.cloderia.helion.ide.generator.ArtifactGenerator;

/**
 * @author adrian
 *
 */
@SuppressWarnings("restriction")
@XmlRootElement(name="configuration")
public class BuildConfiguration {
	
	private String name;
	private String groupId;
	private String artifactId;
	private String version;
	private String description;
	private String projectDir;
	private String configFile;
	private String targetDir;
	private String templatesDir;
	private String generatorName;
	private Database database;
	private List<String> builder;
	private Application application;
	private ArtifactGenerator artifactGenerator;

	/**
	 * 
	 */
	public BuildConfiguration() {
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
	public String getConfigFile() {
		return configFile;
	}

	/**
	 * @param configFile the configFile to set
	 */
	@XmlElement
	public void setConfigFile(String configFile) {
		this.configFile = configFile;
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
	 * @return the templatesDir
	 */
	public String getTemplatesDir() {
		return templatesDir;
	}

	/**
	 * @param templatesDir the templatesDir to set
	 */
	@XmlElement
	public void setTemplatesDir(String templatesDir) {
		this.templatesDir = templatesDir;
	}

	/**
	 * @return the generatorName
	 */
	public String getGeneratorName() {
		return generatorName;
	}

	/**
	 * @param generatorName the generatorName to set
	 */
	@XmlElement
	public void setGeneratorName(String generatorName) {
		this.generatorName = generatorName;
	}

	/**
	 * @return the database
	 */
	public Database getDatabase() {
		return database;
	}

	/**
	 * @param database the database to set
	 */
	@XmlElement
	public void setDatabase(Database database) {
		this.database = database;
	}

	/**
	 * @return the builders
	 */
	public List<String> getBuilder() {
		return builder;
	}

	/**
	 * @param builders the builders to set
	 */
	@XmlElement
	@XmlElementWrapper(name="builders")
	public void setBuilder(List<String> builder) {
		this.builder = builder;
	}

	/**
	 * @return the application
	 */
	public Application getApplication() {
		return application;
	}

	/**
	 * @param application the application to set
	 */
	public void setApplication(Application application) {
		this.application = application;
	}

	/**
	 * @return the artifactGenerator
	 */
	public ArtifactGenerator getArtifactGenerator() {
		return artifactGenerator;
	}

	/**
	 * @param artifactGenerator the artifactGenerator to set
	 */
	@XmlTransient
	public void setArtifactGenerator(ArtifactGenerator artifactGenerator) {
		this.artifactGenerator = artifactGenerator;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BuildConfiguration [name=" + name + ", groupId=" + groupId + ", artifactId=" + artifactId + ", version="
				+ version + ", description=" + description + ", projectDir=" + projectDir + ", targetDir=" + targetDir
				+ ", templatesDir=" + templatesDir + ", database=" + database + ", builders=" + builder + "]";
	}
}
