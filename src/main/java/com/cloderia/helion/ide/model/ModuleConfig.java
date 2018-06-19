/**
 * 
 */
package com.cloderia.helion.ide.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * Extra configuration information that 
 * can be attached to a module.
 * 
 * @author adrian
 */
public class ModuleConfig {
	
	private String pomTemplate;
	private String readMeTemplate;
	private List<CopyDirectory> copyDirectories = new ArrayList<CopyDirectory>();
	
	/**
	 * 
	 */
	public ModuleConfig() {
		// TODO Auto-generated constructor stub
	}

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
