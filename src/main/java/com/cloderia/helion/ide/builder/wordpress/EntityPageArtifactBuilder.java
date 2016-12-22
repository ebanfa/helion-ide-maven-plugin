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
public class EntityPageArtifactBuilder extends AbstractEntityArtifactBuilder {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.AbstractEntityArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration, com.cloderia.helion.ide.app.Entity)
	 */
	@Override
	public void build(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		String entityDir = entity.getName().toLowerCase().concat(IDEConstants.T_SLASH);
		String targetDir = buildConfiguration.getTargetDir().concat(IDEConstants.WP_ENTITY_HTML_TEMPLATES_DIR);
		
		if(entity.getCreatePageTemplate() != null)
			this.generateArtifact(buildConfiguration, entity, entity.getCreatePageTemplate(), "create-entity-page.php", targetDir.concat(entityDir));
		if(entity.getSinglePageTemplate() != null)
			this.generateArtifact(buildConfiguration, entity, entity.getSinglePageTemplate(), "single-entity-page.php", targetDir.concat(entityDir));

	}

}
