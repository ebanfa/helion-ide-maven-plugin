/**
 * 
 */
package com.cloderia.helion.model.pipeline;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.cloderia.helion.model.AbstractArtifact;
import com.cloderia.helion.model.ArtifactConfig;
import com.cloderia.helion.model.application.Application;

/**
 * @author Edward Banfa
 */
@SuppressWarnings("restriction")
@XmlRootElement(name="configuration")
public class PipelineContext extends AbstractArtifact {
	
	/** Directories */
	private String projectDir;
	private String targetDir;
	private List<String> templateDir;
	private String applicationConfigFile;
	
	/** Build pipeline */
	private List<String> processors;
	
	/** Application data */
	private Application application;

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
	@XmlElement()
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
	@XmlElement()
	public void setTargetDir(String targetDir) {
		this.targetDir = targetDir;
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
	@XmlElement()
	public void setTemplateDir(List<String> templateDir) {
		this.templateDir = templateDir;
	}

	/**
	 * @return the applicationConfigFile
	 */
	public String getApplicationConfigFile() {
		return applicationConfigFile;
	}

	/**
	 * @param applicationConfigFile the applicationConfigFile to set
	 */
	@XmlElement()
	public void setApplicationConfigFile(String applicationConfigFile) {
		this.applicationConfigFile = applicationConfigFile;
	}

	/**
	 * @return the processors
	 */
	public List<String> getProcessors() {
		return processors;
	}

	/**
	 * @param processors the processors to set
	 */
	@XmlElement(name="processor")
	@XmlElementWrapper(name="pipeline")
	public void setProcessors(List<String> processors) {
		this.processors = processors;
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
	@XmlTransient
	public void setApplication(Application application) {
		this.application = application;
	}

	/**
	 * @return the contextData
	 */
	public Object getContextDataItem(String key) {
		return contextData.get(key);
	}

	/**
	 * @param contextData the contextData to set
	 */
	public void setContextDataItem(String key, Object value) {
		this.contextData.put(key, value);
	}

	/**
	 * @return the contextData
	 
	public Map<String, Object> getContextData() {
		return contextData;
	}*/

	/**
	 * @param contextData the contextData to set
	 
	public void setContextData(Map<String, Object> contextData) {
		this.contextData = contextData;
	}*/

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.model.Artifact#getArtifactType()
	 */
	@Override
	public String getArtifactType() {
		return "pipelineContext";
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.model.Artifact#getArtifactConfig()
	 */
	@Override
	public ArtifactConfig getArtifactConfig() {
		return null;
	}


}
