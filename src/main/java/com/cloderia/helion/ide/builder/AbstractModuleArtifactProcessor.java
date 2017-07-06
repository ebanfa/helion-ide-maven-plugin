/**
 * 
 */
package com.cloderia.helion.ide.builder;

import java.util.List;

import com.cloderia.helion.ide.artifact.Module;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public abstract class AbstractModuleArtifactProcessor extends AbstractArtifactProcessor {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.ArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public void execute(BuildConfiguration buildConfiguration) throws IDEException {
		List<Module> modules = buildConfiguration.getApplication().getModules();
		for(Module module : modules) execute(buildConfiguration, module);
		
	}
	
	/**
	 * @param buildConfiguration
	 * @param module
	 * @throws IDEException
	 */
	public abstract void execute(BuildConfiguration buildConfiguration, Module module) throws IDEException;

}
