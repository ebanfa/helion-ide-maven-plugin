/**
 * 
 */
package com.cloderia.helion.model.module;

import javax.xml.bind.annotation.XmlElement;

import com.cloderia.helion.model.AbstractArtifact;

/**
 * An abstract implementation of an application module artifact.
 * 
 * @author Edward Banfa
 */
public abstract class AbstractModule extends AbstractArtifact implements Module {

	private String className;
	private String packageName;

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	@XmlElement
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
	 * @see com.cloderia.helion.model.Artifact#getArtifactType()
	 */
	@Override
	public String getArtifactType() {
		return "module";
	}
	
}
