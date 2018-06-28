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
public class WebServiceConfig extends AbstractArtifactConfig {
	
	private String templateFile;

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
