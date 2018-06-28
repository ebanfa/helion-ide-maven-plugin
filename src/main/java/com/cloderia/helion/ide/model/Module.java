/**
 * 
 */
package com.cloderia.helion.ide.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.cloderia.helion.ide.model.web.WebModule;

/**
 * @author adrian
 *
 */
@SuppressWarnings("restriction")
@XmlRootElement(name="module")
public class Module extends AbstractArtifact {
	
	private String type;
	private String packageName;
	private String className;
	private WebModule webModule;
	private ModuleConfig artifactConfig;
	private List<String> dependencies = new ArrayList<String>();
	
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
	public ModuleConfig getArtifactConfig() {
		return artifactConfig;
	}

	/**
	 * @param extraConfig the extraConfig to set
	 */
	@XmlElement
	public void setArtifactConfig(ModuleConfig artifactConfig) {
		this.artifactConfig = artifactConfig;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
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

	/**
	 * @return the dependencies
	 */
	public List<String> getDependencies() {
		return dependencies;
	}

	/**
	 * @param dependencies the dependencies to set
	 */
	@XmlElement(name="dependency")
	@XmlElementWrapper(name="dependencies")
	public void setDependencies(List<String> dependencies) {
		this.dependencies = dependencies;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Module [type=" + type + ", packageName=" + packageName + ", webModule=" + webModule + ", artifactConfig="
				+ artifactConfig + ", entities=" + entities + "]";
	}


	
}
