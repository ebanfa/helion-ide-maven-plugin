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
public class ArtifactData  {
	
	private String configFile;
	private List<String> dependencies = new ArrayList<String>();
	private List<ArtifactDataParameter> configParameters = new ArrayList<ArtifactDataParameter>();
	
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
	public List<ArtifactDataParameter> getConfigParameters() {
		return configParameters;
	}

	/**
	 * @param configParameters the configParameters to set
	 */
	@XmlElement(name="param")
	@XmlElementWrapper(name="params")
	public void setConfigParameters(List<ArtifactDataParameter> configParameters) {
		this.configParameters = configParameters;
	}
}
