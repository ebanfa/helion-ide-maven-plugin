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
public class EntityServiceArtifactBuilder extends AbstractEntityArtifactBuilder {
	
	public static final String SERVICE_TEMPLATE_FTL = IDEConstants.WP_SERVICE_DIR.concat("entity-service-php.ftl");

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.AbstractEntityArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration, com.cloderia.helion.ide.app.Entity)
	 */
	@Override
	public void build(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		String serviceTemplate = SERVICE_TEMPLATE_FTL;
		String targetDir = buildConfiguration.getTargetDir();
		if(entity.getServiceTemplate() != null) 
			serviceTemplate = entity.getServiceTemplate();
		this.generateArtifact(buildConfiguration, entity, serviceTemplate, 
				entity.getName().concat("Service").concat(IDEConstants.PHP_EXT), targetDir.concat(IDEConstants.WP_SERVICE_DIR));
	}

}
