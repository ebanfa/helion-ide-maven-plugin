/**
 * 
 */
package com.cloderia.helion.model;

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
	
	String pomTemplate;
	String readMeTemplate;
	String javaSourceDir;
	List<String> resourceDirs;
	
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
	 * @return the javaSourceDir
	 */
	public String getJavaSourceDir() {
		return javaSourceDir;
	}

	/**
	 * @param javaSourceDir the javaSourceDir to set
	 */
	@XmlElement
	public void setJavaSourceDir(String javaSourceDir) {
		this.javaSourceDir = javaSourceDir;
	}

	/**
	 * @return the resourceDirs
	 */
	public List<String> getResourceDirs() {
		return resourceDirs;
	}

	/**
	 * @param resourceDirs the resourceDirs to set
	 */
	@XmlElement(name="resourceDir")
	@XmlElementWrapper(name="resources")
	public void setResourceDirs(List<String> resourceDirs) {
		this.resourceDirs = resourceDirs;
	}

}
