/**
 * 
 */
package com.cloderia.helion.ide.model.web;

import javax.xml.bind.annotation.XmlElement;

import com.cloderia.helion.ide.model.AbstractArtifactConfig;

/**
 * @author Edward Banfa
 *
 */
public class WebModuleConfig extends AbstractArtifactConfig {
	
	private String wsPath;
	private String servicesConfigFile;
	private String rsApplicationTemplateFile;

	/**
	 * @return the servicesConfigFile
	 */
	public String getServicesConfigFile() {
		return servicesConfigFile;
	}

	/**
	 * @param servicesConfigFile the servicesConfigFile to set
	 */
	@XmlElement
	public void setServicesConfigFile(String servicesConfigFile) {
		this.servicesConfigFile = servicesConfigFile;
	}

	/**
	 * @return the wsPath
	 */
	public String getWsPath() {
		return wsPath;
	}

	/**
	 * @param wsPath the wsPath to set
	 */
	@XmlElement
	public void setWsPath(String wsPath) {
		this.wsPath = wsPath;
	}

	/**
	 * @return the rsApplicationTemplateFile
	 */
	public String getRsApplicationTemplateFile() {
		return rsApplicationTemplateFile;
	}

	/**
	 * @param rsApplicationTemplateFile the rsApplicationTemplateFile to set
	 */
	@XmlElement
	public void setRsApplicationTemplateFile(String rsApplicationTemplateFile) {
		this.rsApplicationTemplateFile = rsApplicationTemplateFile;
	}
}
