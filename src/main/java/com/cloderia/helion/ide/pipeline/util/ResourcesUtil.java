/**
 * 
 */
package com.cloderia.helion.ide.pipeline.util;

import java.util.List;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.ide.model.CopyDirectory;
import com.cloderia.helion.ide.util.FileUtil;

/**
 * This class is used to generate static files from the build project to a specified module project.
 * 
 * @author adrian
 */
public class ResourcesUtil {
	
	/**
	 * @param copyDirectories
	 * @param targetDir
	 * @throws HelionException
	 */
	public static void copyDirectories(List<CopyDirectory> copyDirectories, String targetDir) throws HelionException {
		copyDirectories.forEach(resource -> {
			FileUtil.copyDirectory(resource.getSource(), targetDir.concat(resource.getTarget()));
		});
	}

}
