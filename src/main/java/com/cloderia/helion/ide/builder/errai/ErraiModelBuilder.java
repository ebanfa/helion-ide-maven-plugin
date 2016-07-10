/**
 * 
 */
package com.cloderia.helion.ide.builder.errai;

import com.cloderia.helion.ide.app.Entity;
import com.cloderia.helion.ide.app.Module;
import com.cloderia.helion.ide.builder.AbstractArtifactBuilder;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public class ErraiModelBuilder extends AbstractArtifactBuilder {

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
	
	public void build(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		doBuildEntities(buildConfiguration, entity);
		doBuildEntityOps(buildConfiguration, entity);
	}

	/**
	 * @param config
	 * @param entity
	 * @throws IDEException 
	 */
	private void doBuildEntities(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		this.generateArtifact(buildConfiguration, entity, 
			"entities/errai/entity.ftl", entity.getName() + ".java", IDEConstants.MODEL_DIR);
	}

	/**
	 * @param config
	 * @param entity
	 * @throws IDEException 
	 */
	private void doBuildEntityOps(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		this.generateArtifact(buildConfiguration, entity, 
			"entities/errai/entity-ops.ftl", entity.getName() + "Operation.java", IDEConstants.OPS_DIR);
	}


}
