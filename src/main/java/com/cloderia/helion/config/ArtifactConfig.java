/**
 * 
 */
package com.cloderia.helion.config;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * @author Edward Banfa
 */
public class ArtifactConfig  {
	
	private String configFile;
	private List<String> dependencies = new ArrayList<String>();
	private List<Action> actions = new ArrayList<Action>();
	private List<ArtifactConfigParameter> params = new ArrayList<ArtifactConfigParameter>();
	
	/**
	 * @return the configFile
	 */
	public String getConfigFile() {
		return configFile;
	}

	/**
	 * @param configFile the configFile to set
	 */
	@XmlElement
	public void setConfigFile(String configFile) {
		this.configFile = configFile;
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
	
	/**
	 * @return the configParameters
	 */
	public List<ArtifactConfigParameter> getParams() {
		return params;
	}

	/**
	 * @param configParameters the configParameters to set
	 */
	@XmlElement(name="param")
	@XmlElementWrapper(name="params")
	public void setParams(List<ArtifactConfigParameter> configParameters) {
		this.params = configParameters;
	}

	/**
	 * @return the actions
	 */
	public List<Action> getActions() {
		return actions;
	}

	/**
	 * @param actions the actions to set
	 */
	@XmlElement(name="action")
	@XmlElementWrapper(name="actions")
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
}
