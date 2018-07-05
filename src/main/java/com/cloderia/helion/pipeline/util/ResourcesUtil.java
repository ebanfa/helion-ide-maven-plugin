/**
 * 
 */
package com.cloderia.helion.pipeline.util;

import java.util.List;

import com.cloderia.helion.exception.HelionException;
import com.cloderia.helion.model.Artifact;
import com.cloderia.helion.model.CopyDirectory;
import com.cloderia.helion.util.FileUtil;

/**
 * This class is used to generate static files from the build project to a specified module project.
 * 
 * @author adrian
 */
public class ResourcesUtil {
	
	/**
	 * @param artifact
	 * @param targetDir
	 * @throws HelionException
	 */
	public static void copyDirectories(Artifact artifact, String targetDir) throws HelionException {
		if(artifact.getArtifactConfig() == null) return;
		List<CopyDirectory> copyDirectories = artifact.getArtifactConfig().getCopyDirectories();
		copyDirectories.forEach(resource -> {
			FileUtil.copyDirectory(resource.getSource(), targetDir.concat(resource.getTarget()));
		});
	}

}
