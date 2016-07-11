/**
 * 
 */
package com.cloderia.helion.ide.builder.errai;

import com.cloderia.helion.ide.app.Entity;
import com.cloderia.helion.ide.builder.AbstractEntityArtifactBuilder;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public class ErraiModelBuilder extends AbstractEntityArtifactBuilder {
	
	private static final String ENTITIES_ERRAI_ENTITY_FTL = "entities/errai/entity.ftl";
	private static final String ENTITIES_ERRAI_ENTITY_OPS_FTL = "entities/errai/entity-ops.ftl";

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.AbstractEntityArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration, com.cloderia.helion.ide.app.Entity)
	 */
	public void build(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		this.generateArtifact(buildConfiguration, entity, ENTITIES_ERRAI_ENTITY_FTL, 
				entity.getName() + ".java", buildConfiguration.getTargetDir().concat(IDEConstants.MODEL_DIR));
		
		this.generateArtifact(buildConfiguration, entity, ENTITIES_ERRAI_ENTITY_OPS_FTL, 
				entity.getName() + "Operation.java", buildConfiguration.getTargetDir().concat(IDEConstants.OPS_DIR));
	}
}
