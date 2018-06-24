/**
 * 
 */
package com.cloderia.helion.ide.model.web;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Edward Banfa
 *
 */
public class UiModuleConfig {
	
	private String pagesConfigFile;
	private String widgetsConfigFile;
	private String containersConfigFile;

	/**
	 * @return the pagesConfigFile
	 */
	public String getPagesConfigFile() {
		return pagesConfigFile;
	}

	/**
	 * @param pagesConfigFile the pagesConfigFile to set
	 */
	@XmlElement
	public void setPagesConfigFile(String pagesConfigFile) {
		this.pagesConfigFile = pagesConfigFile;
	}

	/**
	 * @return the widgetsConfigFile
	 */
	public String getWidgetsConfigFile() {
		return widgetsConfigFile;
	}

	/**
	 * @param widgetsConfigFile the widgetsConfigFile to set
	 */
	@XmlElement
	public void setWidgetsConfigFile(String widgetsConfigFile) {
		this.widgetsConfigFile = widgetsConfigFile;
	}

	/**
	 * @return the containersConfigFile
	 */
	public String getContainersConfigFile() {
		return containersConfigFile;
	}

	/**
	 * @param containersConfigFile the containersConfigFile to set
	 */
	@XmlElement
	public void setContainersConfigFile(String containersConfigFile) {
		this.containersConfigFile = containersConfigFile;
	}
		
}
