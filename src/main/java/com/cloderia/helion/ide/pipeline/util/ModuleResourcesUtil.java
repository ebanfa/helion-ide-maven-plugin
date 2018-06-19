/**
 * 
 */
package com.cloderia.helion.ide.pipeline.util;

import java.util.List;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.ide.model.CopyDirectory;
import com.cloderia.helion.ide.model.Module;
import com.cloderia.helion.ide.util.FileUtil;
import com.cloderia.helion.ide.util.StringUtil;
import com.cloderia.helion.pipeline.PipelineContext;

/**
 * This class is used to generate static files from the build project to a specified module project.
 * 
 * @author adrian
 */
public class ModuleResourcesUtil {
	
	/**
	 * Copies non generated files from the build project to the specified module project.
	 * 
	 * @param module
	 * @param context
	 * @throws HelionException
	 */
	public static void copyResources(Module module, PipelineContext context) throws HelionException {
		copyDirectories(module, context);
	}

	/**
	 * Copies all folders under ${buildProject}/src/main/resource  -> ${moduleDir}/src/main/resource.
	 * 
	 * @param module
	 * @param context
	 * @throws HelionException
	 */
	public static void copyNonJavaResources(Module module, PipelineContext context) throws HelionException {
		
	}

	/**
	 * Copies all SPECIFIED folders under ${buildProject}/src/main/  -> ${moduleDir}/src/main.
	 * @param module
	 * @param context
	 * @throws HelionException
	 */
	public static void copyDirectories(Module module, PipelineContext context) throws HelionException {
		if(module.getExtraConfig() == null) return;
		
		String targetDir = ModuleUtil.getProjectDir(module, context);
		List<CopyDirectory> copyDirectories = module.getExtraConfig().getCopyDirectories();
		copyDirectories.forEach(resource -> {
			FileUtil.copyDirectory(resource.getSource(), targetDir.concat(resource.getTarget()));
		});
	}

}
