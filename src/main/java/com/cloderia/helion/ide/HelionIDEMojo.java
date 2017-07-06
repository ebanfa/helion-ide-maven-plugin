/**
 * 
 */
package com.cloderia.helion.ide;

import java.util.List;

import org.apache.maven.plugins.annotations.Mojo;

import com.cloderia.helion.ide.builder.ArtifactProcessor;
import com.cloderia.helion.ide.builder.ArtifactBuilderFactory;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
@Mojo(name="helion")
public class HelionIDEMojo extends AbstractIDEMojo {
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.IDEMojo#execute(com.cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public void execute(BuildConfiguration buildConfiguration) throws IDEException {
		List<ArtifactProcessor> artifactProcessors = ArtifactBuilderFactory.getArtifactBuilders(buildConfiguration);
		for(ArtifactProcessor artifactProcessor : artifactProcessors) {
			artifactProcessor.execute(buildConfiguration);
		}
	}
}
