/**
 * 
 */
package com.cloderia.helion.ide.builder.errai;

import com.cloderia.helion.ide.artifact.Entity;
import com.cloderia.helion.ide.artifact.Field;
import com.cloderia.helion.ide.builder.AbstractEntityFieldArtifactProcessor;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.BuilderUtils;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public class EntityRelationshipFieldProcessor extends AbstractEntityFieldArtifactProcessor {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.AbstractEntityFieldArtifactProcessor#execute(com.cloderia.helion.ide.configuration.BuildConfiguration, com.cloderia.helion.ide.artifact.Field)
	 */
	@Override
	public void execute(BuildConfiguration buildConfiguration, Field field) throws IDEException {
		Entity entityOfField = BuilderUtils.findEntityInApplication(field.getDataType(), buildConfiguration.getApplication());
		field.setParentEntity(entityOfField);
	}

}
