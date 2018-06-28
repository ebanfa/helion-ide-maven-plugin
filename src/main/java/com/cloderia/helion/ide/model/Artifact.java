/**
 * 
 */
package com.cloderia.helion.ide.model;

/**
 * @author adrian
 *
 */
public interface Artifact {
	
	/**
	 * @return
	 */
	public String getArtifactType();
	
	/**
	 * @return
	 */
	public String getName();
	
	/**
	 * @return
	 */
	public ArtifactConfig getArtifactConfig();
}
