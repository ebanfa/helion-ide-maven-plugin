/**
 * 
 */
package com.cloderia.ide.application;

import java.util.ArrayList;
import java.util.List;

import com.cloderia.ide.AbstractArtifact;
import com.cloderia.ide.config.ApplicationLite;
import com.cloderia.ide.module.Module;

/**
 * @author Edward Banfa
 *
 */
public abstract class AbstractApplication<T extends Module> extends AbstractArtifact implements Application {
	
	private List<T> modules = new ArrayList<>();
	private ApplicationLite configuration;
	
	public AbstractApplication(ApplicationLite configuration) {
		this.setId(configuration.getId());
		this.setName(configuration.getName());
		this.setTitle(configuration.getTitle());
		this.setClassName(configuration.getClassName());
		this.setDescription(configuration.getDescription());
		this.setPackageName(configuration.getPackageName());
		this.setVersion(configuration.getVersion());
	}

	/**
	 * @return the modules
	 */
	public List<T> getModules() {
		return modules;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.model.Artifact#getArtifactType()
	 */
	@Override
	public String getArtifactType() {
		return "application";
	}

	/**
	 * @return the configuration
	 */
	public ApplicationLite getConfiguration() {
		return configuration;
	}

	/**
	 * @param configuration the configuration to set
	 */
	public void setConfiguration(ApplicationLite configuration) {
		this.configuration = configuration;
	}

	/**
	 * @param modules the modules to set
	 */
	public void setModules(List<T> modules) {
		this.modules = modules;
	}

}
