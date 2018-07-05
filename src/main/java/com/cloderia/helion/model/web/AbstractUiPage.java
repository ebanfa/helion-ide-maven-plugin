/**
 * 
 */
package com.cloderia.helion.model.web;

import com.cloderia.helion.model.AbstractArtifact;

/**
 * @author Edward Banfa
 *
 */
public abstract class AbstractUiPage extends AbstractArtifact implements UiPage {
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.model.Artifact#getArtifactType()
	 */
	@Override
	public String getArtifactType() {
		return "uiPage";
	}
}
