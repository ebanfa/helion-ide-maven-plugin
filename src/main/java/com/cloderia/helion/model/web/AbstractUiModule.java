/**
 * 
 */
package com.cloderia.helion.model.web;

import com.cloderia.helion.model.module.AbstractModule;

/**
 * @author Edward Banfa
 *
 */
public abstract class AbstractUiModule extends AbstractModule implements UiModule {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.model.Artifact#getArtifactType()
	 */
	@Override
	public String getArtifactType() {
		return "uiModule";
	}
}
