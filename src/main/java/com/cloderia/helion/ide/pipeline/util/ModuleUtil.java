/**
 * 
 */
package com.cloderia.helion.ide.pipeline.util;

import com.cloderia.helion.ide.model.Module;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.StringUtil;
import com.cloderia.helion.pipeline.PipelineContext;

/**
 * This class contains utility methods for dealing with application modules.
 * 
 * @author adrian
 */
public class ModuleUtil {

	/**
	 * Get the module project directory.
	 * 
	 * @param module
	 * @param targetDir
	 * @return
	 */
	public static String getProjectDir(Module module, PipelineContext context) {
		return context.getTargetDir().concat(StringUtil.trailingSlashIt(module.getId()));
	}

	/**
	 * Resolves and sets the module package name.
	 * This is equivalent to ${moduleDir}/src/main/java/${groupId}/${moduleId}.
	 * 
	 * @param application
	 * @param module
	 * @return
	 */
	public static Module setModulePackage(Module module, PipelineContext context) {
		String groupId = context.getApplication().getGroupId();
		// Append the group id to the configured package name
		module.setPackageName(groupId.concat("." . concat(module.getPackageName())));
		return module;
	}

	/**
	 * Override to the above defined method
	 * 
	 * @param module
	 * @param moduleDir
	 * @return
	 */
	public static String getPackageDir(Module module, String moduleDir) {
		String packageName = module.getPackageName();
		String packageDir = StringUtil.packageNameToFilePath(packageName);
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
}
