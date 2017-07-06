/**
 * 
 */
package com.cloderia.helion.ide.builder;

import com.cloderia.helion.ide.artifact.Entity;
import com.cloderia.helion.ide.artifact.Module;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public abstract class AbstractEntityArtifactProcessor extends AbstractModuleArtifactProcessor {

	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.AbstractModuleArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration, com.cloderia.helion.ide.app.Module)
	 */
	public void execute(BuildConfiguration buildConfiguration, Module module) throws IDEException {
		for (Entity entity : module.getEntities()) {
			entity.setModule(module);
			execute(buildConfiguration, entity);
		}
	}
	
	public abstract void execute(BuildConfiguration buildConfiguration, Entity entity) throws IDEException;
}
