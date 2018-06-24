/**
 * 
 */
package com.cloderia.helion.ide.pipeline.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.ide.model.Module;
import com.cloderia.helion.ide.util.FileUtil;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.pipeline.PipelineContext;

/**
 * This class creates a Maven project file system for an application module.
 * 
 * @author adrian
 */
public class ModuleProjectDirectoryUtil {
	
	private static Logger logger = LoggerFactory.getLogger(ModuleProjectDirectoryUtil.class);
	/**
	 * @param directoryName
	 * @param context
	 */
	public static void createProjectDirectories(Module module, PipelineContext context) throws HelionException {
		String moduleDir = ModuleUtil.getProjectDir(module, context);
		String packageDir = ModuleUtil.getPackageDir(module, moduleDir);
		logger.debug("Create project directory for module {} ", module.getId());
		
		FileUtil.deleteDir(moduleDir);
		FileUtil.createDirectoryIfNeeded(moduleDir);
		FileUtil.createDirectoryIfNeeded(moduleDir.concat(IDEConstants.SRC_DIR));
		FileUtil.createDirectoryIfNeeded(moduleDir.concat(IDEConstants.SRC_MAIN_DIR));
		FileUtil.createDirectoryIfNeeded(moduleDir.concat(IDEConstants.JAVA_DIR));
		FileUtil.createDirectoryIfNeeded(moduleDir.concat(IDEConstants.RESOURCES_DIR));
		FileUtil.createDirectoryIfNeeded(packageDir);
	}
}
