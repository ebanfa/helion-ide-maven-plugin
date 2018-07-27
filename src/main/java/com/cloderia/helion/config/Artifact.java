/**
 * 
 */
package com.cloderia.helion.config;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Edward Banfa
 */
@XmlRootElement(name="artifact")
public class Artifact {
	
	private String id;
	private String name;
	private String title;
	private String className;
	private String packageName;
	private String description;
	private String version;
	private String type;
	private ArtifactData artifactConfig  = new ArtifactData();
	private List<Artifact> artifacts = new ArrayList<Artifact>();

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the packageName
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * @param packageName the packageName to set
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
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
	public void setVersion(String version) {
		this.version = version;
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
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the artifactConfig
	 */
	public ArtifactData getArtifactConfig() {
		return artifactConfig;
	}

	/**
	 * @param artifactConfig the artifactConfig to set
	 */
	public void setArtifactConfig(ArtifactData artifactConfig) {
		this.artifactConfig = artifactConfig;
	}

	/**
	 * @return the artifacts
	 */
	public List<Artifact> getArtifacts() {
		return artifacts;
	}

	/**
	 * @param artifacts the artifacts to set
	 */
	@XmlElement(name="artifact")
	@XmlElementWrapper(name="artifacts")
	public void setArtifacts(List<Artifact> artifacts) {
		this.artifacts = artifacts;
	}
}
