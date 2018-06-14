/**
 * 
 */
package com.cloderia.helion.util;

import com.cloderia.helion.model.Module;
import com.cloderia.helion.pipeline.PipelineContext;

/**
 * @author adrian
 *
 */
public class ProjectArtifactsUtil {

	/**
	 * @param module
	 * @param context
	 */
	public static void copyJavaSources(Module module, PipelineContext context) {
		// 1. Get the source directory
		if(module.getExtraConfig() != null) {
			String javaSourceDir = module.getExtraConfig().getJavaSourceDir();
			if(StringUtil.isValidString(javaSourceDir)) {
				//2.  Copy the directory
				FileUtil.copyDirectory(javaSourceDir, ModuleDirectoryUtil.getModuleTopLevelPackageDir(module, context));
			}
		}
	}

	public static void copyResources(Module module, PipelineContext context) {
		
	}

}
