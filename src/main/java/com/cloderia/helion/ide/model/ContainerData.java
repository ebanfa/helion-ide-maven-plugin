/**
 * 
 */
package com.cloderia.helion.ide.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author adrian
 *
 */
public class ContainerData implements Artifact {
	
	private String id;
	private String name;
	private String description;
	private boolean hasWidget;
	
	/**
	 * 
	 */
	public ContainerData() {
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
	 * @return the hasWidget
	 */
	public boolean isHasWidget() {
		return hasWidget;
	}

	/**
	 * @param hasWidget the hasWidget to set
	 */
	@XmlElement
	public void setHasWidget(boolean hasWidget) {
		this.hasWidget = hasWidget;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.data.ArtifactData#getArtifactDataType()
	 */
	public String getArtifactType() {
		return "container";
	}

}
