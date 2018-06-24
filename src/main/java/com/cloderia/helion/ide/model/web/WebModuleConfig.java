/**
 * 
 */
package com.cloderia.helion.ide.model.web;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.cloderia.helion.ide.model.CopyDirectory;

/**
 * @author Edward Banfa
 *
 */
public class WebModuleConfig {

	private String servicesConfigFile;
	private List<CopyDirectory> copyDirectories = new ArrayList<CopyDirectory>();
	

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
	 * @return the copyDirectories
	 */
	public List<CopyDirectory> getCopyDirectories() {
		return copyDirectories;
	}

	/**
	 * @param copyResources the copyDirectories to set
	 */
	@XmlElement(name="copyDirectory")
	@XmlElementWrapper(name="copyResources")
	public void setCopyDirectories(List<CopyDirectory> copyDirectories) {
		this.copyDirectories = copyDirectories;
	}
}
