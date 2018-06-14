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
public class ModuleDirectoryUtil {
	
	
		
	/**
	 * @param directoryName
	 * @param context
	 */
	public static Module createProjectDirectory(Module module, PipelineContext context) {
		String moduleDir = getModuleDir(module, context);
		String topLevelpackageDir = getModuleTopLevelPackageDir(module, moduleDir);
		
		FileUtil.deleteDir(moduleDir);
		FileUtil.createDirectoryIfNeeded(moduleDir);
		FileUtil.createDirectoryIfNeeded(moduleDir.concat(IDEConstants.SRC_DIR));
		FileUtil.createDirectoryIfNeeded(moduleDir.concat(IDEConstants.SRC_MAIN_DIR));
		FileUtil.createDirectoryIfNeeded(moduleDir.concat(IDEConstants.JAVA_DIR));
		FileUtil.createDirectoryIfNeeded(moduleDir.concat(IDEConstants.RESOURCES_DIR));
		FileUtil.createDirectoryIfNeeded(topLevelpackageDir);

		if(ModuleUtil.isWebModule(module)) createWebProjectDirectory(module, context);
		if(ModuleUtil.isServiceModule(module)) createServiceProjectDirectory(topLevelpackageDir);
		if(ModuleUtil.isPersistenceModule(module)) createPersistenceProjectDirectory(topLevelpackageDir);
		return module;
	}

	/**
	 * Returns the webapp directory for the given module.
	 * 
	 * @param moduleDir
	 * @return
	 */
	public static String getModuleWebAppDir(Module module, PipelineContext context) {
		String moduleDir = getModuleDir(module, context);
		String srcMainDir = moduleDir.concat(IDEConstants.SRC_MAIN_DIR);
		return srcMainDir.concat(IDEConstants.WEBAPP_DIR);
	}

	/**
	 * Returns the WEB-INF directory location for
	 * the given module.
	 * 
	 * @param moduleDir
	 * @return
	 */
	public static String getModuleWebInfDir(Module module, PipelineContext context) {
		return getModuleWebAppDir(module, context).concat(IDEConstants.WEB_INF_DIR);
	}

	/**
	 * @param module
	 * @param context
	 */
	public static void createWebProjectDirectory(Module module, PipelineContext context) {
		String webAppDir = getModuleWebAppDir(module, context);
		FileUtil.createDirectoryIfNeeded(webAppDir);
		FileUtil.createDirectoryIfNeeded(webAppDir.concat(IDEConstants.WEB_INF_DIR));
	}
	
	/**
	 * @param module
	 * @param context
	 */
	public static void createPersistenceProjectDirectory(String targetDir) {
		String persistenceDir = targetDir.concat(IDEConstants.JAVA_PERSISTENCE_DIR);
		
		FileUtil.createDirectoryIfNeeded(persistenceDir);
		FileUtil.createDirectoryIfNeeded(persistenceDir.concat(IDEConstants.JAVA_ENTITY_PERSISTENCE_DIR));
		FileUtil.createDirectoryIfNeeded(persistenceDir.concat(IDEConstants.JAVA_ENTITY_OP_PERSISTENCE_DIR));
		FileUtil.createDirectoryIfNeeded(persistenceDir.concat(IDEConstants.JAVA_SERVICE_PERSISTENCE_DIR));
		FileUtil.createDirectoryIfNeeded(persistenceDir.concat(
				IDEConstants.JAVA_SERVICE_PERSISTENCE_DIR).concat(IDEConstants.JAVA_SERVICE_IMPL_PERSISTENCE_DIR));
	}

	/**
	 * @param module
	 * @param context
	 */
	public static void createServiceProjectDirectory(String targetDir) {
		String serviceDir = targetDir.concat(IDEConstants.JAVA_SERVICE_PERSISTENCE_DIR);
		FileUtil.createDirectoryIfNeeded(serviceDir);
		FileUtil.createDirectoryIfNeeded(serviceDir.concat(IDEConstants.JAVA_SERVICE_IMPL_PERSISTENCE_DIR));
	}
	
	/**
	 * Get the module project directory.
	 * 
	 * @param module
	 * @param targetDir
	 * @return
	 */
	public static String getModuleDir(Module module, PipelineContext context) {
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
		module.setPackageName(context.getApplication().getGroupId().concat("." . concat(module.getId())));
		return module;
	}

	/**
	 * Get the top level package directory for this module. 
	 * This is equivalent to ${moduleDir}/src/main/java/${groupId}/${moduleId}.
	 * 
	 * @param module
	 * @param moduleDir
	 * @return
	 */
	public static String getModuleTopLevelPackageDir(Module module, PipelineContext context) {	
		String moduleDir = getModuleDir(module, context);
		String topLevelpackageDir = StringUtil.packageNameToFilePath(module.getPackageName());
		return moduleDir.concat(IDEConstants.JAVA_DIR).concat(topLevelpackageDir);
	}

	/**
	 * Override to the above defined method
	 * @param module
	 * @param moduleDir
	 * @return
	 */
	public static String getModuleTopLevelPackageDir(Module module, String moduleDir) {	
		String topLevelpackageDir = StringUtil.packageNameToFilePath(module.getPackageName());
		return moduleDir.concat(IDEConstants.JAVA_DIR).concat(topLevelpackageDir);
	}
	

}
