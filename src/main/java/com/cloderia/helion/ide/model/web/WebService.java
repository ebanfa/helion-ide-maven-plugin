/**
 * 
 */
package com.cloderia.helion.ide.model.web;

import com.cloderia.helion.ide.model.AbstractArtifact;

/**
 * @author Edward Banfa
 *
 */
public class WebService extends AbstractArtifact {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.model.Artifact#getArtifactType()
	 */
	@Override
	public String getArtifactType() {
		return "webService";
	}

}
