/**
 * 
 */
package com.cloderia.helion.ide.data;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author adrian
 *
 */
public class PageData implements ArtifactData {
	
	private String name;
	private String site;
	private String module;
	private String description;
	private boolean hasDataModel;
	private String dataModelName;
	private String dataModelAction;
	private String dataModelService;
	
	/**
	 * 
	 */
	public PageData() {
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
	 * @return the site
	 */
	public String getSite() {
		return site;
	}


	/**
	 * @param site the site to set
	 */
	@XmlElement
	public void setSite(String site) {
		this.site = site;
	}


	/**
	 * @return the module
	 */
	public String getModule() {
		return module;
	}

	/**
	 * @param module the module to set
	 */
	@XmlElement
	public void setModule(String module) {
		this.module = module;
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
	 * @return the hasDataModel
	 */
	public boolean isHasDataModel() {
		return hasDataModel;
	}


	/**
	 * @param hasDataModel the hasDataModel to set
	 */
	@XmlElement
	public void setHasDataModel(boolean hasDataModel) {
		this.hasDataModel = hasDataModel;
	}


	/**
	 * @return the dataModelName
	 */
	public String getDataModelName() {
		return dataModelName;
	}


	/**
	 * @param dataModelName the dataModelName to set
	 */
	@XmlElement
	public void setDataModelName(String dataModelName) {
		this.dataModelName = dataModelName;
	}


	/**
	 * @return the dataModelAction
	 */
	public String getDataModelAction() {
		return dataModelAction;
	}


	/**
	 * @param dataModelAction the dataModelAction to set
	 */
	@XmlElement
	public void setDataModelAction(String dataModelAction) {
		this.dataModelAction = dataModelAction;
	}


	/**
	 * @return the dataModelService
	 */
	public String getDataModelService() {
		return dataModelService;
	}


	/**
	 * @param dataModelService the dataModelService to set
	 */
	@XmlElement
	public void setDataModelService(String dataModelService) {
		this.dataModelService = dataModelService;
	}


	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.data.ArtifactData#getArtifactDataType()
	 */
	public String getArtifactDataType() {
		return "page";
	}

}
