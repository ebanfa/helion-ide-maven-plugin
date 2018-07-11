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
@XmlRootElement(name="module")
public class ModuleLite extends AbstractArtifactLite {
	
	private List<SubModuleLite> subModules = new ArrayList<SubModuleLite>();
	
	/**
	 * @return the subModules
	 */
	public List<SubModuleLite> getSubModules() {
		return subModules;
	}

	/**
	 * @param subModules the subModules to set
	 */
	@XmlElement(name="subModule")
	@XmlElementWrapper(name="subModules")
	public void setSubModules(List<SubModuleLite> subModules) {
		this.subModules = subModules;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.model.Artifact#getArtifactType()
	 */
	@Override
	public String getArtifactType() {
		return "moduleLite";
	}
}
