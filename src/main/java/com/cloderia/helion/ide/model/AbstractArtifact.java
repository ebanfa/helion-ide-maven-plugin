/**
 * 
 */
package com.cloderia.helion.ide.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Edward Banfa
 *
 */
public abstract class AbstractArtifact implements Artifact {
	
	private String id;
	private String name;
	private String title;
	private String description;
	private	AbstractArtifactConfig artifactConfig;

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
	@Override
	@XmlElement
	public String getName() {
		return name;
	}

	/**
	 * @return the artifactConfig
	 */
	public AbstractArtifactConfig getArtifactConfig() {
		return artifactConfig;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AbstractArtifact [id=" + id + ", name=" + name + ", title=" + title + ", description=" + description
				+ "]";
	}

}
