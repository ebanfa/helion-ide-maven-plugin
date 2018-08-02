/**
 * 
 */
package com.cloderia.helion.util;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.HelionRuntimeException;
import com.cloderia.helion.config.Artifact;

/**
 * Contains utility methods for read data from helion configuration files.
 * 
 * @author Edward Banfa
 */
public class ConfigurationUtil {

	/**
	 * @param artifactConfigFileOpt
	 * @return
	 * @throws HelionException
	 */
	public static Artifact readArtifact(String artifactConfigFile) throws HelionException {
		Artifact artifact = JAXBUtil.loadArtifact(artifactConfigFile, Artifact.class);
		
		artifact.getArtifacts()
		.stream()
		.map(childArtifact -> {
			return readArtifactConfig(childArtifact);
		});		
		
		return artifact;
	}
	
	/**
	 * @param moduleLite
	 * @return
	 * @throws HelionException
	 */
	public static Artifact readArtifactConfig(Artifact artifact) {
		if(!ArtifactConfigUtil.hasArtifactConfigFile(artifact))
			return artifact;
		
		String artifactConfigFile = ArtifactConfigUtil.getArtifactConfigFile(artifact);
		
		try {
			return readArtifact(artifactConfigFile);
		} catch (HelionException e) {
			throw new HelionRuntimeException();
		}
	}
	
}
