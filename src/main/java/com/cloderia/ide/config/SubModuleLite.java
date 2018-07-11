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
@XmlRootElement(name="subModule")
public class SubModuleLite extends AbstractArtifactLite {
	
	private List<EntityLite> entities = new ArrayList<EntityLite>();

	/* (non-Javadoc)
	 * @see com.cloderia.helion.model.Artifact#getArtifactType()
	 */
	@Override
	public String getArtifactType() {
		return "subModuleLite";
	}

	/**
	 * @return the entities
	 */
	public List<EntityLite> getEntities() {
		return entities;
	}

	/**
	 * @param entities the entities to set
	 */
	@XmlElement(name="entity")
	@XmlElementWrapper(name="entities")
	public void setEntities(List<EntityLite> entities) {
		this.entities = entities;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SubModuleLite [entities=" + entities + "]";
	}

}
