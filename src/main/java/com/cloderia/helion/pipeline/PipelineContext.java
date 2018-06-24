/**
 * 
 */
package com.cloderia.helion.pipeline;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.cloderia.helion.ide.model.AbstractArtifact;
import com.cloderia.helion.ide.model.Application;

/**
 * @author adrian
 *
 */
@SuppressWarnings("restriction")
@XmlRootElement(name="configuration")
public class PipelineContext extends AbstractArtifact {
	
	/** Application data */
	private Application application;
	
	/** Directories */
	private String projectDir;
	private String targetDir;
	private List<String> templateDir;
	private String modulesConfigFile;
	
	/** Build pipeline */
	private List<String> processor;

	/** Generic data context */
	private Map<String, Object> contextData = new HashMap<String, Object>();

	/**
	 * 
	 */
	public PipelineContext() {
	}
	
	/**
	 * @return the projectDir
	 */
	public String getProjectDir() {
		return projectDir;
	}

	/**
	 * @param projectDir the projectDir to set
	 */
	@XmlElement
	public void setProjectDir(String projectDir) {
		this.projectDir = projectDir;
	}

	/**
	 * @return the targetDir
	 */
	public String getTargetDir() {
		return targetDir;
	}

	/**
	 * @param targetDir the targetDir to set
	 */
	@XmlElement
	public void setTargetDir(String targetDir) {
		this.targetDir = targetDir;
	}

	/**
	 * @return
	 */
	public String getModulesConfigFile() {
		return modulesConfigFile;
	}

	/**
	 * @param modulesConfigFile
	 */
	@XmlElement
	public void setModulesConfigFile(String modulesConfigFile) {
		this.modulesConfigFile = modulesConfigFile;
	}

	/**
	 * @return the templateDir
	 */
	public List<String> getTemplateDir() {
		return templateDir;
	}

	/**
	 * @param templateDir the templateDir to set
	 */
	@XmlElement
	public void setTemplateDir(List<String> templateDir) {
		this.templateDir = templateDir;
	}
	
	/**
	 * @return the builders
	 */
	public List<String> getProcessor() {
		return processor;
	}

	/**
	 * @param builders the builders to set
	 */
	@XmlElement
	@XmlElementWrapper(name="pipeline")
	public void setProcessor(List<String> processor) {
		this.processor = processor;
	}

	/**
	 * @return the application
	 */
	public Application getApplication() {
		return application;
	}

	/**
	 * @param application the application to set
	 */
	@XmlElement
	public void setApplication(Application application) {
		this.application = application;
	}

	/**
	 * @return the contextData
	 */
	public Object get(String key) {
		return contextData.get(key);
	}

	/**
	 * @param contextData the contextData to set
	 */
	public void put(String key, Object value) {
		this.contextData.put(key, value);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BuildContext [application=" + application + ", projectDir=" + projectDir 
				+ ", targetDir=" + targetDir + ", templateDir=" + templateDir + ", processor=" + processor
				+ ", contextData=" + contextData + "]";
	}

	@Override
	public String getArtifactType() {
		return "pipelineContext";
	}

}
