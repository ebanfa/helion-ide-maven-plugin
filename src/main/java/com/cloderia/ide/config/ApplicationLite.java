/**
 * 
 */
package com.cloderia.ide.config;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Edward Banfa
 */
@XmlRootElement(name="application")
public class ApplicationLite extends AbstractArtifactLite {
	
	private List<ModuleLite> modules = new ArrayList<ModuleLite>();

	/**
	 * @return the modules
	 */
	public List<ModuleLite> getModules() {
		return modules;
	}

	/**
	 * @param modules the modules to set
	 */
	@XmlElement(name="module")
	@XmlElementWrapper(name="modules")
	public void setModules(List<ModuleLite> modules) {
		this.modules = modules;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.model.Artifact#getArtifactType()
	 */
	@Override
	public String getArtifactType() {
		return "applicationLite";
	}

}
