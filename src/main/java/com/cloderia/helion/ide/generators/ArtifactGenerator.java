/**
 * 
 */
package com.cloderia.helion.ide.generators;

import com.cloderia.helion.ide.IDEException;
import com.cloderia.helion.ide.build.BuildContext;

/**
 * @author adrian
 *
 */
public interface ArtifactGenerator {
	
	public void generateArtifact(BuildContext context, ArtifactGeneratorData artifactData) throws IDEException;

}
