/**
 * 
 */
package com.cloderia.helion.model.web;

import javax.xml.bind.annotation.XmlElement;

import com.cloderia.helion.model.ArtifactConfig;

/**
 * @author Edward Banfa
 */
public class WebServiceConfig extends ArtifactConfig {

	private String servicePath;
	private String templateFile;

	/**
	 * @return the servicePath
	 */
	public String getServicePath() {
		return servicePath;
	}

	/**
	 * @param servicePath the servicePath to set
	 */
	@XmlElement
	public void setServicePath(String servicePath) {
		this.servicePath = servicePath;
	}
	
	/**
	 * @return the templateFile
	 */
	public String getTemplateFile() {
		return templateFile;
	}

	/**
	 * @param templateFile the templateFile to set
	 */
	@XmlElement
	public void setTemplateFile(String templateFile) {
		this.templateFile = templateFile;
	}
}
