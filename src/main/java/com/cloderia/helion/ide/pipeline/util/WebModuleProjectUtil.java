/**
 * 
 */
package com.cloderia.helion.ide.pipeline.util;

import com.cloderia.helion.ide.model.Module;
import com.cloderia.helion.ide.util.FileUtil;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.pipeline.PipelineContext;

/**
 * @author Edward Banfa
 *
 */
public class WebModuleProjectUtil {

	/**
	 * @param module
	 * @param context
	 */
	public static void createWebProjectDirectory(Module module, PipelineContext context) {
		String webAppDir = WebModuleUtil.getWebAppDir(module, context);
		FileUtil.createDirectoryIfNeeded(webAppDir);
		FileUtil.createDirectoryIfNeeded(webAppDir.concat(IDEConstants.WEB_INF_DIR));
	}
}
