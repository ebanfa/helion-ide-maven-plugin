/**
 * 
 */
package com.cloderia.helion.ide.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.cloderia.helion.ide.model.web.WebModule;

/**
 * @author adrian
 *
 */
public class Module extends AbstractArtifact {
	
	private String type;
	private String packageName;
	private WebModule webModule;
	private ModuleConfig extraConfig;
	
	/** UI configuration*/
	List<Entity> entities = new ArrayList<Entity>();
	
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
	 * @return the webModule
	 */
	public WebModule getWebModule() {
		return webModule;
	}

	/**
	 * @param webModule the webModule to set
	 */
	public void setWebModule(WebModule webModule) {
		this.webModule = webModule;
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
	@XmlElement
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
		return "Module [type=" + type + ", packageName=" + packageName + ", webModule=" + webModule + ", extraConfig="
				+ extraConfig + ", entities=" + entities + "]";
	}


	
}
