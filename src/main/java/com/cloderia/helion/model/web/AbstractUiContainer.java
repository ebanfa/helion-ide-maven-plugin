/**
 * 
 */
package com.cloderia.helion.model.web;

import com.cloderia.helion.model.AbstractArtifact;

/**
 * @author Edward Banfa
 *
 */
public abstract class AbstractUiContainer extends AbstractArtifact implements UiContainer {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.model.Artifact#getArtifactType()
	 */
	@Override
	public String getArtifactType() {
		return "uiContainer";
	}
}
