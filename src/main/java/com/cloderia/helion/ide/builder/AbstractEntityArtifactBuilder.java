/**
 * 
 */
package com.cloderia.helion.ide.builder;

import com.cloderia.helion.ide.app.Entity;
import com.cloderia.helion.ide.app.Module;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public abstract class AbstractEntityArtifactBuilder extends AbstractArtifactBuilder {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.ArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public void build(BuildConfiguration buildConfiguration) throws IDEException {
		for(Module module : buildConfiguration.getApplication().getModules()){
			build(buildConfiguration, module);
		}
	}
	
	public void build(BuildConfiguration buildConfiguration, Module module) throws IDEException {
		for (Entity entity : module.getEntities()) {
			build(buildConfiguration, entity);
		}
	}
	
	public abstract void build(BuildConfiguration buildConfiguration, Entity entity) throws IDEException;
}
