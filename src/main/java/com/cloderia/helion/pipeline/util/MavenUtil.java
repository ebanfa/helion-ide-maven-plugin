/**
 * 
 */
package com.cloderia.helion.pipeline.util;

import com.cloderia.helion.exception.HelionException;
import com.cloderia.helion.util.ArtifactConfigUtil;
import com.cloderia.helion.util.FileUtil;
import com.cloderia.helion.util.IDEConstants;
import com.cloderia.helion.util.StringUtil;
import com.cloderia.ide.module.Module;
import com.cloderia.ide.pipeline.PipelineContext;

/**
 * This class contains utility methods for dealing with application modules.
 * 
 * @author adrian
 */
public class MavenUtil {

	/**
	 * Get the module project directory.
	 * @param module
	 * @param targetDir
	 * @return
	 */
	public static String getProjectDir(Module module, PipelineContext context) {
		String targetDir = ArtifactConfigUtil.getConfigParameterValue(
				IDEConstants.TARGET_DIR_PARAM, context.getContextConfig());
		
		return targetDir.concat(StringUtil.trailingSlashIt(module.getId()));
	}

	/**
	 * Override to the above defined method
	 * @param module
	 * @param moduleDir
	 * @return
	 */
	public static String getJavaPackageDir(Module module, PipelineContext context) {
		String moduleDir = MavenUtil.getProjectDir(module, context);
		String packageDir = StringUtil.packageNameToFilePath(module.getPackageName());
		return moduleDir.concat(IDEConstants.JAVA_DIR).concat(packageDir);
	}

	/**
	 * Returns the ${moduleDir}/src/ directory for the given module.
	 * @param module
	 * @param context
	 * @return
	 */
	public static String getProjectSourceDir(Module module, PipelineContext context) {
		String projectDir = getProjectDir(module, context);
		return projectDir.concat(IDEConstants.SRC_DIR);
	}
	
	/**
	 * Returns the ${moduleDir}/src/main directory for the given module.
	 * @param module
	 * @param context
	 * @return
	 */
	public static String getProjectSourceMainDir(Module module, PipelineContext context) {
		String projectDir = getProjectDir(module, context);
		return projectDir.concat(IDEConstants.SRC_MAIN_DIR);
	}
	

	/**
	 * Returns the webapp directory for the given module.
	 * @param moduleDir
	 * @return
	 */
	public static String getWebAppDir(Module module, PipelineContext context) {
		String moduleDir = getProjectDir(module, context);
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

	/**
	 * @param targetDir
	 * @param isParentModule
	 */
	public static void createMavenProjectFileSystem(String targetDir, boolean isParentModule, String packageDir) {
		FileUtil.createDirectoryIfNeeded(targetDir);
		if(!isParentModule) {
			FileUtil.createDirectoryIfNeeded(targetDir.concat(IDEConstants.SRC_DIR));
			FileUtil.createDirectoryIfNeeded(targetDir.concat(IDEConstants.SRC_MAIN_DIR));
			FileUtil.createDirectoryIfNeeded(targetDir.concat(IDEConstants.JAVA_DIR));
			FileUtil.createDirectoryIfNeeded(targetDir.concat(IDEConstants.RESOURCES_DIR));
			FileUtil.createDirectoryIfNeeded(packageDir);
		}
	}

	/**
	 * @param module
	 * @param context
	 * @throws HelionException
	 */
	public static void generateMavenProjectArtifacts(Module module, PipelineContext context) throws HelionException {
		String targetDir = MavenUtil.getProjectDir(module, context);
		//TemplateUtil.generateArtifact(context, module, TemplateUtil.getModulePomTemplateFile(module), IDEConstants.POM_XML_FILE_NAME, targetDir);
		//TemplateUtil.generateArtifact(context, module, IDEConstants.MODULE_README_TMPL_FTL, IDEConstants.README_MD_FILE_NAME, targetDir);
	
	}
	
}
