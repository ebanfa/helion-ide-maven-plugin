/**
 * 
 */
package com.cloderia.helion.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * Abstract implementation of the Artifact interface.
 * 
 * @author Edward Banfa
 */
public abstract class AbstractArtifact implements Artifact {
	
	private String id;
	private String name;
	private String title;
	private String className;
	private String packageName;
	private String description;
	private String version;
	private ArtifactConfig artifactConfig  = new ArtifactConfig();

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	@XmlElement
	public void setId(String id) {
		this.id = id;
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
	@XmlElement
	public void setTitle(String title) {
		this.title = title;
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
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.model.Artifact#getName()
	 */
	@XmlElement
	public String getName() {
		return name;
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
	 * @return the packageName
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * @param packageName the packageName to set
	 */
	@XmlElement
	public void setPackageName(String packageName) {
		this.packageName = packageName;
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
	 * @return the artifactConfig
	 */
	public ArtifactConfig getArtifactConfig() {
		return artifactConfig;
	}

	/**
	 * @param artifactConfig the artifactConfig to set
	 */
	@XmlElement
	public void setArtifactConfig(ArtifactConfig artifactConfig) {
		this.artifactConfig = artifactConfig;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Artifact [id=" + id + ", name=" + name + ", title=" + title + ", className=" + className
				+ ", packageName=" + packageName + ", description=" + description + ", version=" + version + "]";
	}

}
