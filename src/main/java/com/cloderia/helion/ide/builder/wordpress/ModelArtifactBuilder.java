/**
 * 
 */
package com.cloderia.helion.ide.builder.wordpress;

import com.cloderia.helion.ide.app.Entity;
import com.cloderia.helion.ide.builder.AbstractEntityArtifactBuilder;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public class ModelArtifactBuilder extends AbstractEntityArtifactBuilder {

	public static final String MODEL_TEMPLATE_FTL = IDEConstants.WP_MODEL_DIR.concat("model.ftl");

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.AbstractEntityArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration, com.cloderia.helion.ide.app.Entity)
	 */
	@Override
	public void build(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		String targetDir = buildConfiguration.getTargetDir();
		this.generateArtifact(buildConfiguration, entity, 	
				MODEL_TEMPLATE_FTL, entity.getName() + IDEConstants.PHP_EXT, targetDir.concat(IDEConstants.WP_MODEL_DIR));
	}

}
