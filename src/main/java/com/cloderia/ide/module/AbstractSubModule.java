/**
 * 
 */
package com.cloderia.ide.module;

import com.cloderia.ide.AbstractArtifact;

/**
 * @author Edward Banfa
 */
public abstract class AbstractSubModule extends AbstractArtifact implements SubModule {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.model.Artifact#getArtifactType()
	 */
	@Override
	public String getArtifactType() {
		return "subModule";
	}

}
