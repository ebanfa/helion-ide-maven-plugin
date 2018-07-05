/**
 * 
 */
package com.cloderia.helion.model.module;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.cloderia.helion.model.entity.JPAEntity;

/**
 * @author Edward Banfa
 *
 */
@XmlRootElement(name="module")
public class EjbSharedModule extends AbstractSharedModule {
	
	private List<JPAEntity> entities = new ArrayList<JPAEntity>();

	/**
	 * @return the entities
	 */
	public List<JPAEntity> getEntities() {
		return entities;
	}

	/**
	 * @param entities the entities to set
	 */
	@XmlElement(name="entity")
	@XmlElementWrapper(name="entities")
	public void setEntities(List<JPAEntity> entities) {
		this.entities = entities;
	}
	
}
