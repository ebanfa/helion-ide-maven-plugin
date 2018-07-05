/**
 * 
 */
package com.cloderia.helion.model.module;

import javax.xml.bind.annotation.XmlElement;

/**
 * Represents a abstract web module. A web module is an application
 * module that deals with web related (web services and web ui) functionality.
 * 
 * @author Edward Banfa
 */
public abstract class AbstractWebModule extends AbstractModule implements WebModule {

	private Boolean hasUi;
	private Boolean hasWebServices;
	
	/**
	 * @return the hasUi
	 */
	public Boolean getHasUi() {
		return hasUi;
	}

	/**
	 * @param hasUi the hasUi to set
	 */
	@XmlElement
	public void setHasUi(Boolean hasUi) {
		this.hasUi = hasUi;
	}

	/**
	 * @return the hasWebServices
	 */
	public Boolean getHasWebServices() {
		return hasWebServices;
	}

	/**
	 * @param hasWebServices the hasWebServices to set
	 */
	@XmlElement
	public void setHasWebServices(Boolean hasWebServices) {
		this.hasWebServices = hasWebServices;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.model.module.Module#getType()
	 */
	@Override
	public String getType() {
		return "web";
	}
	
}
