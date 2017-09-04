/**
 * 
 */
package com.cloderia.helion.ide.data;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author adrian
 *
 */
public class ModuleData implements ArtifactData {
	
	private String name;
	private String description;
	List<EntityData> entityDatas = new ArrayList<EntityData>();

	/**
	 * 
	 */
	public ModuleData() {
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the entities
	 */
	public List<EntityData> getEntities() {
		return entityDatas;
	}

	/**
	 * @param entityDatas the entities to set
	 */
	@XmlElement(name="entity")
	public void setEntities(List<EntityData> entityDatas) {
		this.entityDatas = entityDatas;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.app.ArtifactData#getArtifactDataType()
	 */
	public String getArtifactDataType() {
		return "module";
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
}
