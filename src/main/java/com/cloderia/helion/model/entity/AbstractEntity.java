/**
 * 
 */
package com.cloderia.helion.model.entity;

import javax.xml.bind.annotation.XmlTransient;

import com.cloderia.helion.model.AbstractArtifact;
import com.cloderia.helion.model.module.Module;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Edward Banfa
 *
 */
public abstract class AbstractEntity extends AbstractArtifact implements Entity {
	@JsonIgnore
	private Module module;

	/**
	 * @return the module
	 */
	public Module getModule() {
		return module;
	}

	/**
	 * @param module the module to set
	 */
	@XmlTransient
	public void setModule(Module module) {
		this.module = module;
	}

	@Override
	public String getArtifactType() {
		return "entity";
	}

}
