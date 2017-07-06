/**
 * 
 */
package com.cloderia.helion.ide.builder;

import com.cloderia.helion.ide.artifact.Module;
import com.cloderia.helion.ide.artifact.ServiceDefinition;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public abstract class AbstractServiceArtifactProcessor extends AbstractModuleArtifactProcessor {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.AbstractModuleArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration, com.cloderia.helion.ide.app.Module)
	 */
	public void execute(BuildConfiguration buildConfiguration, Module module) throws IDEException {
		for (ServiceDefinition serviceDefinition : module.getServiceDefinition()) {
			serviceDefinition.setModule(module);
			execute(buildConfiguration, serviceDefinition);
		}
	}
	
	public abstract void execute(BuildConfiguration buildConfiguration, ServiceDefinition serviceDefinition) throws IDEException;

}
