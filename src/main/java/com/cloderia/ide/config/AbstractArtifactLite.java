/**
 * 
 */
package com.cloderia.ide.config;

import javax.xml.bind.annotation.XmlElement;

/**
 * This abstract
 * @author Edward Banfa
 */
public abstract class AbstractArtifactLite implements ArtifactLite {
	
	private String id;
	private String name;
	private String title;
	private String className;
	private String packageName;
	private String description;
	private String version;
	private String type;
	private ArtifactConfigLite artifactConfig  = new ArtifactConfigLite();

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	@XmlElement()
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
	@XmlElement()
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
	@XmlElement()
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
	@XmlElement()
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
	@XmlElement()
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
	@XmlElement()
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
	@XmlElement()
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the artifactConfig
	 */
	public ArtifactConfigLite getArtifactConfig() {
		return artifactConfig;
	}

	/**
	 * @param artifactConfig the artifactConfig to set
	 */
	@XmlElement()
	public void setArtifactConfig(ArtifactConfigLite artifactConfig) {
		this.artifactConfig = artifactConfig;
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
	@XmlElement()
	public void setType(String type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AbstractArtifactLite [id=" + id + ", name=" + name + ", title=" + title + ", className=" + className
				+ ", packageName=" + packageName + "]";
	}

}
