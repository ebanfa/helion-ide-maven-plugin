/**
 * 
 */
package com.cloderia.helion.ide.generator;

import com.cloderia.helion.ide.IDEException;

/**
 * @author adrian
 *
 */
public class ArtifactGeneratorFactory {
	
	
	public static ArtifactGenerator getArtifactGenerator(String artifactGeneratorName) throws IDEException {
		try {
			return (ArtifactGenerator) Class.forName(artifactGeneratorName).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new IDEException(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new IDEException(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new IDEException(e.getMessage());
		}
	}
	

}
