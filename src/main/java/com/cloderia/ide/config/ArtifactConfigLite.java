/**
 * 
 */
package com.cloderia.ide.config;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * @author Edward Banfa
 */
public class ArtifactConfigLite  {
	
	private String configFile;
	private List<String> dependencies = new ArrayList<String>();
	private List<CopyDirectory> copyDirectories = new ArrayList<CopyDirectory>();
	private List<ArtifactConfigParameter> configParameters = new ArrayList<ArtifactConfigParameter>();
	
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
	 * @return the copyDirectories
	 */
	public List<CopyDirectory> getCopyDirectories() {
		return copyDirectories;
	}

	/**
	 * @param copyDirectories the copyDirectories to set
	 */
	@XmlElement(name="copyDirectory")
	@XmlElementWrapper(name="copyResources")
	public void setCopyDirectories(List<CopyDirectory> copyDirectories) {
		this.copyDirectories = copyDirectories;
	}
	
	/**
	 * @return the configParameters
	 */
	public List<ArtifactConfigParameter> getConfigParameters() {
		return configParameters;
	}

	/**
	 * @param configParameters the configParameters to set
	 */
	@XmlElement(name="param")
	@XmlElementWrapper(name="params")
	public void setConfigParameters(List<ArtifactConfigParameter> configParameters) {
		this.configParameters = configParameters;
	}
}
