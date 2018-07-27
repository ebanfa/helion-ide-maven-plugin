/**
 * 
 */
package com.cloderia.helion.application.config;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.config.Artifact;

/**
 * @author Edward Banfa
 *
 */
public interface ConfigurationReader {
	
	public Artifact readConfiguration(Artifact artifactConfig) throws HelionException;
}
