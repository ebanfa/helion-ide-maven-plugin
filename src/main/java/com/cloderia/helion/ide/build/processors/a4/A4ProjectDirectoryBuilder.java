/**
 * 
 */
package com.cloderia.helion.ide.build.processors.a4;

import com.cloderia.helion.ide.IDEException;
import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator;
import com.cloderia.helion.ide.build.processors.BuildProcessor;
import com.cloderia.helion.ide.data.EntityData;
import com.cloderia.helion.ide.data.ModuleData;
import com.cloderia.helion.ide.util.FileUtil;
import com.cloderia.helion.ide.util.IDEUtil;
import com.cloderia.helion.ide.util.StringUtil;

/**
 * @author adrian
 *
 */
public class A4ProjectDirectoryBuilder extends AbstractBuildProcessorDecorator {
	
	/* Target directories */
	public static final String A4_SRC_DIR = StringUtil.trailingSlashIt("src");
	public static final String A4_APP_DIR = A4_SRC_DIR + StringUtil.trailingSlashIt("app");
	public static final String A4_API_DIR = A4_APP_DIR + StringUtil.trailingSlashIt("api");
	public static final String A4_DATA_DIR = StringUtil.trailingSlashIt("data");
	public static final String A4_SERVICES_DIR = StringUtil.trailingSlashIt("services");
	public static final String A4_COMPONENTS_DIR = StringUtil.trailingSlashIt("components");
	public static final String A4_PAGES_DIR = A4_COMPONENTS_DIR + StringUtil.trailingSlashIt("page");
	public static final String A4_UICOMPONENTS_DIR = A4_COMPONENTS_DIR + StringUtil.trailingSlashIt("ui-component");
	public static final String A4_COMPONENTS_COMMON_DIR = A4_COMPONENTS_DIR + StringUtil.trailingSlashIt("common");
	public static final String A4_COMPONENTS_FRONTEND_DIR = A4_COMPONENTS_DIR + StringUtil.trailingSlashIt("frontend");
	public static final String A4_COMPONENTS_PORTAL_DIR = A4_COMPONENTS_DIR + StringUtil.trailingSlashIt("portal");
	
	/**
	 * @param processor
	 */
	public A4ProjectDirectoryBuilder(BuildProcessor<BuildContext> processor){
		super(processor);
	}
	
	@Override
	protected BuildContext decorate(BuildContext context) {
		System.out.println("############################## A4ProjectDirectoryBuilder");
		for(ModuleData moduleData: context.getApplicationData().getModules()){
			this.buildModuleDir(context, moduleData);
		}
		//FileUtil.deleteDir(context.getTargetDir());
		FileUtil.createDirectoryIfNeeded(context.getTargetDir());
		FileUtil.createDirectoryIfNeeded(context.getTargetDir().concat(A4_SRC_DIR));
		FileUtil.createDirectoryIfNeeded(context.getTargetDir().concat(A4_APP_DIR));
/*		FileUtil.createDirectoryIfNeeded(context.getTargetDir().concat(A4_COMPONENTS_DIR));
		FileUtil.createDirectoryIfNeeded(context.getTargetDir().concat(A4_SERVICES_DIR));
		FileUtil.createDirectoryIfNeeded(context.getTargetDir().concat(A4_DATA_DIR));
		FileUtil.createDirectoryIfNeeded(context.getTargetDir().concat(A4_API_DIR));*/
		return context;
	}
	
	private void buildModuleDir(BuildContext context, ModuleData module){
		String appDir = context.getTargetDir().concat(A4_APP_DIR);
		String moduleDir = appDir.concat(StringUtil.trailingSlashIt(module.getName().toLowerCase()));
		FileUtil.createDirectoryIfNeeded(moduleDir);
		FileUtil.createDirectoryIfNeeded(moduleDir.concat(A4_PAGES_DIR));
		FileUtil.createDirectoryIfNeeded(moduleDir.concat(A4_UICOMPONENTS_DIR));
		FileUtil.createDirectoryIfNeeded(moduleDir.concat(A4_SERVICES_DIR));
		FileUtil.createDirectoryIfNeeded(moduleDir.concat(A4_DATA_DIR));
		//System.out.println(moduleDir);
	}

	
}
