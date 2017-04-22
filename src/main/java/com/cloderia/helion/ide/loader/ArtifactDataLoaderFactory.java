/**
 * 
 */
package com.cloderia.helion.ide.loader;

import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public class ArtifactDataLoaderFactory {
	
	public static ArtifactDataLoader getArtifactLoader(String artifactLoaderName) throws IDEException {
		try {
			return (ArtifactDataLoader) Class.forName(artifactLoaderName).newInstance();
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
