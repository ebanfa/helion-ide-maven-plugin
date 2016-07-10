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
public interface ArtifactBuilder {

	/**
	 * @param entity
	 */
	public void build(BuildConfiguration buildConfiguration) throws IDEException;
}
