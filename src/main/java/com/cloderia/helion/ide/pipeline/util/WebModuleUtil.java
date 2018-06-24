/**
 * 
 */
package com.cloderia.helion.ide.pipeline.util;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.ide.model.Module;
import com.cloderia.helion.ide.util.FileUtil;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.pipeline.PipelineContext;

/**
 * @author Edward Banfa
 *
 */
public class WebModuleUtil {
	
	/**
	 * @param module
	 * @param context
	 */
	public static void createWebProjectDirectory(Module module, PipelineContext context) {
		String webAppDir = getWebAppDir(module, context);
		FileUtil.createDirectoryIfNeeded(webAppDir);
		FileUtil.createDirectoryIfNeeded(webAppDir.concat(IDEConstants.WEB_INF_DIR));
	}
	
	/**
	 * @param context
	 * @param module
	 * @return
	 * @throws HelionException
	 */
	public static Module generateModuleArtifacts(PipelineContext context, Module module) throws HelionException {
		// Generate WEB.XML and JBOSSWEB.XML
		String webInfDir = getModuleWebInfDir(module, context);
		TemplateUtil.generateArtifact(context, module, IDEConstants.WEB_XML_TMPL_FTL, IDEConstants.WEB_XML,	webInfDir);
		TemplateUtil.generateArtifact(context, module, IDEConstants.JBOSS_WEB_XML_TMPL_FTL, IDEConstants.JBOSS_WEB_XML,	webInfDir);
		return module;
	}
	
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
