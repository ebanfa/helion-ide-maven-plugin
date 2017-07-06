/**
 * 
 */
package com.cloderia.helion.ide.builder;

import com.cloderia.helion.ide.artifact.Entity;
import com.cloderia.helion.ide.artifact.Field;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.BuilderUtils;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 * 
 */
public abstract class AbstractEntityFieldArtifactProcessor extends AbstractEntityArtifactProcessor {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.AbstractEntityArtifactProcessor#execute(com.cloderia.helion.ide.configuration.BuildConfiguration, com.cloderia.helion.ide.artifact.Entity)
	 */
	@Override
	public void execute(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		for(Field field : entity.getFields()) {
			execute(buildConfiguration, field);
		}
	}
	
	/**
	 * @param buildConfiguration
	 * @param field
	 * @throws IDEException
	 */
	public abstract void execute(BuildConfiguration buildConfiguration, Field field) throws IDEException;

}
