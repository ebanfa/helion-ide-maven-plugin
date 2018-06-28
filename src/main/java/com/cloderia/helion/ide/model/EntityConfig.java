/**
 * 
 */
package com.cloderia.helion.ide.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Edward Banfa
 *
 */
public class EntityConfig extends AbstractArtifactConfig {
	private String entityTemplateFile;
	private String entityOpsTemplateFile;
	private String entityServiceTemplateFile;
	private String entityServiceImplTemplateFile;

	/**
	 * @return the entityTemplateFile
	 */
	public String getEntityTemplateFile() {
		return entityTemplateFile;
	}

	/**
	 * @param entityTemplateFile the entityTemplateFile to set
	 */
	@XmlElement
	public void setEntityTemplateFile(String entityTemplateFile) {
		this.entityTemplateFile = entityTemplateFile;
	}

	/**
	 * @return the entityOpsTemplateFile
	 */
	public String getEntityOpsTemplateFile() {
		return entityOpsTemplateFile;
	}

	/**
	 * @param entityOpsTemplateFile the entityOpsTemplateFile to set
	 */
	@XmlElement
	public void setEntityOpsTemplateFile(String entityOpsTemplateFile) {
		this.entityOpsTemplateFile = entityOpsTemplateFile;
	}

	/**
	 * @return the entityServiceTemplateFile
	 */
	public String getEntityServiceTemplateFile() {
		return entityServiceTemplateFile;
	}

	/**
	 * @param entityServiceTemplateFile the entityServiceTemplateFile to set
	 */
	@XmlElement
	public void setEntityServiceTemplateFile(String entityServiceTemplateFile) {
		this.entityServiceTemplateFile = entityServiceTemplateFile;
	}

	/**
	 * @return the entityServiceImplTemplateFile
	 */
	public String getEntityServiceImplTemplateFile() {
		return entityServiceImplTemplateFile;
	}

	/**
	 * @param entityServiceImplTemplateFile the entityServiceImplTemplateFile to set
	 */
	@XmlElement
	public void setEntityServiceImplTemplateFile(String entityServiceImplTemplateFile) {
		this.entityServiceImplTemplateFile = entityServiceImplTemplateFile;
	}

}
