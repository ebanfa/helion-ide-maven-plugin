/**
 * 
 */
package com.cloderia.helion.ide.pipeline.util;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.ide.model.Module;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.StringUtil;
import com.cloderia.helion.pipeline.PipelineContext;

/**
 * This class generates artifacts required by a Maven project module.
 * 
 * @author adrian
 */
public class ModuleArtifactsUtil {

	/**
	 * @param context
	 * @param module
	 * @return
	 * @throws HelionException
	 */
	public static void generateModuleArtifacts(PipelineContext context, Module module) throws HelionException {
		// Generate POM and README files
		String projectDir = ModuleUtil.getProjectDir(module, context);
		TemplateUtil.generateArtifact(context, module, getPomTemplate(module), IDEConstants.MODULE_POM_XML, projectDir);
		TemplateUtil.generateArtifact(context, module, getReadMeTemplate(module), IDEConstants.MODULE_README_MD,	projectDir);
	}

	/**
	 * Resolves the template to be used to generate module pom.xml
	 * @param module
	 * @return
	 */
	private static String getPomTemplate(Module module) {
		if(module.getExtraConfig() != null) {
			if(StringUtil.isValidString(module.getExtraConfig().getPomTemplate()))
				return module.getExtraConfig().getPomTemplate();
		}
		return IDEConstants.MODULE_POM_TMPL_FTL;
	}
	
	/**
	 * Resolves the template to be used to generate module README.md
	 * @param module
	 * @return
	 */
	private static String getReadMeTemplate(Module module) {
		if(module.getExtraConfig() != null) {
			if(StringUtil.isValidString(module.getExtraConfig().getReadMeTemplate()))
				return module.getExtraConfig().getReadMeTemplate();
		}
		return IDEConstants.MODULE_README_TMPL_FTL;
	}

}
