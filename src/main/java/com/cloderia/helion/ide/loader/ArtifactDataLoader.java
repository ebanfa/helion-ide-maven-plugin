/**
 * 
 */
package com.cloderia.helion.ide.loader;

import com.cloderia.helion.ide.app.Application;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public interface ArtifactDataLoader {
	
	/**
	 * @param buildConfiguration
	 * @return
	 * @throws IDEException
	 */
	public Application loadArtifactsData(BuildConfiguration buildConfiguration) throws IDEException;
}
