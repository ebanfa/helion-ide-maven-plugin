/**
 * 
 */
package com.cloderia.helion.ide.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * Extra configuration information that 
 * can be attached to a module.
 * 
 * @author adrian
 */
public class ModuleConfig extends AbstractArtifactConfig {
	
	private String pomTemplate;
	private String readMeTemplate;
	private String entitiesConfigFile;
	private String servicesConfigFile;
	private String webConfigFile;

	/**
	 * @return the pomTemplate
	 */
	public String getPomTemplate() {
		return pomTemplate;
	}

	/**
	 * @param pomTemplate the pomTemplate to set
	 */
	@XmlElement
	public void setPomTemplate(String pomTemplate) {
		this.pomTemplate = pomTemplate;
	}

	/**
	 * @return the readMeTemplate
	 */
	public String getReadMeTemplate() {
		return readMeTemplate;
	}

	/**
	 * @param readMeTemplate the readMeTemplate to set
	 */
	@XmlElement
	public void setReadMeTemplate(String readMeTemplate) {
		this.readMeTemplate = readMeTemplate;
	}

	/**
	 * @return the entitiesConfigFile
	 */
	public String getEntitiesConfigFile() {
		return entitiesConfigFile;
	}

	/**
	 * @param entitiesConfigFile the entitiesConfigFile to set
	 */
	@XmlElement
	public void setEntitiesConfigFile(String entitiesConfigFile) {
		this.entitiesConfigFile = entitiesConfigFile;
	}

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
	 * @return the webConfigFile
	 */
	public String getWebConfigFile() {
		return webConfigFile;
	}

	/**
	 * @param webConfigFile the webConfigFile to set
	 */
	@XmlElement
	public void setWebConfigFile(String webConfigFile) {
		this.webConfigFile = webConfigFile;
	}
}
