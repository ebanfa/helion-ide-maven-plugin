/**
 * 
 */
package com.cloderia.helion.ide.build.processors.a42;

import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator;
import com.cloderia.helion.ide.build.processors.BuildProcessor;
import com.cloderia.helion.ide.data.ModuleData;
import com.cloderia.helion.ide.util.FileUtil;
import com.cloderia.helion.ide.util.StringUtil;

/**
 * @author adrian
 *
 */
public class A4ProjectDirectoryBuilder extends AbstractBuildProcessorDecorator {
	
	/* Target directories */
	public static final String A4_SRC_DIR = StringUtil.trailingSlashIt("src");
	public static final String A4_APP_DIR = A4_SRC_DIR + StringUtil.trailingSlashIt("app");
	public static final String A4_DATA_DIR = StringUtil.trailingSlashIt("data");
	public static final String A4_SERVICES_DIR = StringUtil.trailingSlashIt("services");
	public static final String A4_COMPONENTS_DIR = StringUtil.trailingSlashIt("components");
	public static final String A4_PAGES_DIR = A4_COMPONENTS_DIR + StringUtil.trailingSlashIt("page");
	public static final String A4_UICOMPONENTS_DIR = A4_COMPONENTS_DIR + StringUtil.trailingSlashIt("ui-component");

	public static final String A4_E2E_DIR = StringUtil.trailingSlashIt("e2e");
	public static final String A4_DIST_DIR = StringUtil.trailingSlashIt("dist");
	public static final String A4_ASSETS_DIR = StringUtil.trailingSlashIt("assets");
	public static final String A4_ENV_DIR = StringUtil.trailingSlashIt("environments");
	public static final String A4_NODE_MODULES_DIR = StringUtil.trailingSlashIt("node_modules");
	
	/**
	 * @param processor
	 */
	public A4ProjectDirectoryBuilder(BuildProcessor<BuildContext> processor){
		super(processor);
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator#decorate(com.cloderia.helion.ide.build.BuildContext)
	 */
	@Override
	protected BuildContext decorate(BuildContext context) {
		// Build the angular4 directory structure
		//FileUtil.deleteDir(context.getTargetDir());
		FileUtil.createDirectoryIfNeeded(context.getTargetDir());
		FileUtil.createDirectoryIfNeeded(context.getTargetDir().concat(A4_SRC_DIR));
		FileUtil.createDirectoryIfNeeded(context.getTargetDir().concat(A4_APP_DIR));
		// Process the application modules;
		this.processModules(context);
		return context;
	}
	
	/**
	 * @param context
	 */
	private void processModules(BuildContext context){
		String appDir = context.getTargetDir().concat(A4_APP_DIR);
		for(ModuleData moduleData: context.getApplicationData().getModules()){
			String moduleDirName = moduleData.getName().toLowerCase();
			String moduleDir = appDir.concat(StringUtil.trailingSlashIt(moduleDirName));
			FileUtil.createDirectoryIfNeeded(moduleDir);
			FileUtil.createDirectoryIfNeeded(moduleDir.concat(A4_PAGES_DIR));
			FileUtil.createDirectoryIfNeeded(moduleDir.concat(A4_UICOMPONENTS_DIR));
			FileUtil.createDirectoryIfNeeded(moduleDir.concat(A4_SERVICES_DIR));
			FileUtil.createDirectoryIfNeeded(moduleDir.concat(A4_DATA_DIR));
		}
	}
	
}
