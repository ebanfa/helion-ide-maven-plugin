/**
 * 
 */
package com.cloderia.helion.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * @author adrian
 *
 */
public class Module implements Artifact {
	
	private String id;
	private String type;
	private String name;
	private String title;
	private String description;
	private String packageName;
	private ModuleConfig extraConfig;
	
	/** UI configuration*/
	List<Entity> entities = new ArrayList<Entity>();
	
	/** UI configuration*/
	private UiConfig uiConfiguration;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	@XmlElement
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	@XmlElement
	public void setType(String type) {
		this.type = type;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @param title the title to set
	 */
	@XmlElement
	public void setTitle(String title) {
		this.title = title;
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
	
	/**
	 * @return the entities
	 */
	public List<Entity> getEntities() {
		return entities;
	}
	
	/**
	 * @param entities the entities to set
	 */
	@XmlElement(name="entity")
	@XmlElementWrapper(name="entities")
	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}

	/**
	 * @return the uiConfiguration
	 */
	public UiConfig getUiConfiguration() {
		return uiConfiguration;
	}

	/**
	 * @param uiConfiguration the uiConfiguration to set
	 */
	@XmlElement
	public void setUiConfiguration(UiConfig uiConfiguration) {
		this.uiConfiguration = uiConfiguration;
	}

	/**
	 * @return the extraConfig
	 */
	public ModuleConfig getExtraConfig() {
		return extraConfig;
	}

	/**
	 * @param extraConfig the extraConfig to set
	 */
	@XmlElement
	public void setExtraConfig(ModuleConfig extraConfig) {
		this.extraConfig = extraConfig;
	}

	/**
	 * @return the packageName
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * @param packageName the packageName to set
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.artifacts.Artifact#getArtifactType()
	 */
	public String getArtifactType() {
		return "module";
	}

	public Boolean containsEntity(Module module, Entity entity) {
		List<Entity> entityInModule = module.entities.stream()
				.filter(e -> e.getName().equals(entity.getName())).collect(Collectors.toList());
		if(entityInModule.isEmpty()) return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Module [id=" + id + ", entities=" + entities + "]";
	}


	
}
