/**
 * 
 */
package com.cloderia.helion.ide.builder;

import com.cloderia.helion.ide.app.ArtifactData;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.generator.ArtifactGenerator;
import com.cloderia.helion.ide.generator.ArtifactGeneratorData;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public abstract class AbstractArtifactBuilder implements ArtifactBuilder {
	/**
	 * @param buildConfiguration
	 * @throws IDEException
	 */
	protected void generateArtifact(BuildConfiguration buildConfiguration, ArtifactData artifactData,
			String inputFile, String outputFile, String outputDirectory) throws IDEException {
		ArtifactGeneratorData generatorData = 
				new ArtifactGeneratorData(artifactData, inputFile, outputFile, outputDirectory);
		ArtifactGenerator artifactGenerator = buildConfiguration.getArtifactGenerator();
		artifactGenerator.generateArtifact(buildConfiguration, generatorData);
	}
}
