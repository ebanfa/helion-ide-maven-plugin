/**
 * 
 */
package com.cloderia.helion.model.application;

import com.cloderia.helion.model.AbstractArtifact;

/**
 * @author Edward Banfa
 *
 */
public abstract class AbstractApplication extends AbstractArtifact implements Application {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.model.Artifact#getArtifactType()
	 */
	@Override
	public String getArtifactType() {
		return "application";
	}

}
