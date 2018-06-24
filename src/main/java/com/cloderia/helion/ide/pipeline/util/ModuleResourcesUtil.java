/**
 * 
 */
package com.cloderia.helion.ide.pipeline.util;

import java.util.List;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.ide.model.CopyDirectory;
import com.cloderia.helion.ide.model.Module;
import com.cloderia.helion.pipeline.PipelineContext;

/**
 * @author Edward Banfa
 *
 */
public class ModuleResourcesUtil {


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
		ResourcesUtil.copyDirectories(copyDirectories, targetDir);
	}
}
