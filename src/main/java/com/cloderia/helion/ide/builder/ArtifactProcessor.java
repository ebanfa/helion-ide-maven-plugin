/**
 * 
 */
package com.cloderia.helion.ide.builder;

import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public interface ArtifactProcessor {

	/**
	 * @param entity
	 */
	public void execute(BuildConfiguration buildConfiguration) throws IDEException;
}
