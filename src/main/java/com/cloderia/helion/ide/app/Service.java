/**
 * 
 */
package com.cloderia.helion.ide.app;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author adrian
 *
 */
public class Service implements ArtifactData {
	

	private String name;
	private String description;
	private String uiGroup;
	private String serviceTemplate;
	List<String> listens = new ArrayList<String>();

	/**
	 * 
	 */
	public Service() {
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
	 * @return the listens
	 */
	public List<String> getListens() {
		return listens;
	}

	/**
	 * @param listens the listens to set
	 */
	@XmlElement
	public void setListens(List<String> listens) {
		this.listens = listens;
	}

	/**
	 * @return the serviceTemplate
	 */
	public String getServiceTemplate() {
		return serviceTemplate;
	}

	/**
	 * @param serviceTemplate the serviceTemplate to set
	 */
	@XmlElement
	public void setServiceTemplate(String serviceTemplate) {
		this.serviceTemplate = serviceTemplate;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.app.ArtifactData#getArtifactDataType()
	 */
	public String getArtifactDataType() {
		return "service";
	}

}
