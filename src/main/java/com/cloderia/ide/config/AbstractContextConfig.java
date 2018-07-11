/**
 * 
 */
package com.cloderia.ide.config;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Edward Banfa
 *
 */
public class AbstractContextConfig extends AbstractArtifactLite implements ContextConfig {
	
	/** Directories */
	private String projectDir;
	private String targetDir;
	private List<String> templateDir;
	
	/* (non-Javadoc)
	 * @see com.cloderia.ide.Artifact#getArtifactType()
	 */
	@Override
	public String getArtifactType() {
		return "context";
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

}
