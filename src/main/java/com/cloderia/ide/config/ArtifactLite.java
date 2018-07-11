/**
 * 
 */
package com.cloderia.ide.config;

import com.cloderia.ide.Artifact;

/**
 * @author Edward Banfa
 */
public interface ArtifactLite extends Artifact {
	
	/**
	 * @return
	 */
	public String getType();
	
	/**
	 * @return
	 */
	public ArtifactConfigLite getArtifactConfig();

}
