/**
 * 
 */
package com.cloderia.helion.ide.generator;

import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public interface ArtifactGenerator {
	
	public void generateArtifact(BuildConfiguration buildConfiguration, ArtifactGeneratorData artifactData) throws IDEException;

}
