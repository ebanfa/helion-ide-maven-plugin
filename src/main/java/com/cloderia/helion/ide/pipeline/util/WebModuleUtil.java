/**
 * 
 */
package com.cloderia.helion.ide.pipeline.util;

import com.cloderia.helion.ide.model.Module;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.pipeline.PipelineContext;

/**
 * @author Edward Banfa
 *
 */
public class WebModuleUtil {
	

	/**
	 * Returns the webapp directory for the given module.
	 * @param moduleDir
	 * @return
	 */
	public static String getWebAppDir(Module module, PipelineContext context) {
		String moduleDir = ModuleUtil.getProjectDir(module, context);
		String srcMainDir = moduleDir.concat(IDEConstants.SRC_MAIN_DIR);
		return srcMainDir.concat(IDEConstants.WEBAPP_DIR);
	}

	/**
	 * Returns the WEB-INF directory location for the given module.
	 * @param moduleDir
	 * @return
	 */
	public static String getModuleWebInfDir(Module module, PipelineContext context) {
		return getWebAppDir(module, context).concat(IDEConstants.WEB_INF_DIR);
	}
}
