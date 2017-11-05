/**
 * 
 */
package com.cloderia.helion.ide.build.processors.a4;

import com.cloderia.helion.ide.IDEException;
import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator;
import com.cloderia.helion.ide.build.processors.BuildProcessor;
import com.cloderia.helion.ide.data.ModuleData;
import com.cloderia.helion.ide.util.FileUtil;
import com.cloderia.helion.ide.util.IDEUtil;
import com.cloderia.helion.ide.util.StringUtil;

/**
 * @author adrian
 *
 */
public class A4ProjectResourcesProcessor extends AbstractBuildProcessorDecorator {
	
	/* Build resources directories */
	public static final String A4_APP_RESOURCE_SRC_DIR = StringUtil.trailingSlashIt("src");
	public static final String A4_APP_RESOURCE_SRC_APP_DIR = StringUtil.trailingSlashIt("app");
	public static final String A4_APP_RESOURCE_E2E_DIR = StringUtil.trailingSlashIt("e2e");
	public static final String A4_APP_RESOURCE_DIST_DIR = StringUtil.trailingSlashIt("dist");
	public static final String A4_APP_RESOURCE_NODE_MODULES_DIR = StringUtil.trailingSlashIt("node_modules");
	
	public static final String A4_APP_MODULE_TMPL_FTL = "misc/app-module-ts.ftl";
	public static final String A4_APP_ROUTES_TMPL_FTL = "misc/app-routes-ts.ftl";

	public static final String A4_MODULE_TMPL_FTL = "misc/module/module-ts.ftl";
	public static final String A4_ROUTES_TMPL_FTL = "misc/module/routes-ts.ftl";
	public static final String A4_MODULE_ROUTES_TMPL_FTL = "misc/module/module-routes-ts.ftl";
	

	public static final String A4_APP_COMPONENTS_DIR = A4_APP_RESOURCE_SRC_DIR + A4_APP_RESOURCE_SRC_APP_DIR + StringUtil.trailingSlashIt("components");
	public static final String A4_APP_SERVICES_DIR = A4_APP_RESOURCE_SRC_DIR + A4_APP_RESOURCE_SRC_APP_DIR + StringUtil.trailingSlashIt("services");
	public static final String A4_APP_DATA_OBJECCT_DIR = A4_APP_RESOURCE_SRC_DIR + A4_APP_RESOURCE_SRC_APP_DIR + StringUtil.trailingSlashIt("data");
	
	/**
	 * @param processor
	 */
	public A4ProjectResourcesProcessor(BuildProcessor<BuildContext> processor){
		super(processor);
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.build.processors.AbstractProcessorDecorator#decorate(com.cloderia.helion.ide.build.BuildContext)
	 */
	@Override
	protected BuildContext decorate(BuildContext context) {
		copyResources(context);
		generateProjectArtefacts(context);
		for(ModuleData moduleData: context.getApplicationData().getModules()){
			this.generateModuleArtefacts(context, moduleData);
		}
		return context;
	}
	
	protected void generateProjectArtefacts(BuildContext context){
		try {
			String targetDir = context.getTargetDir().concat(A4_APP_RESOURCE_SRC_DIR + A4_APP_RESOURCE_SRC_APP_DIR);
			IDEUtil.generateArtifact(context, context.getApplicationData(), A4_APP_MODULE_TMPL_FTL, "app.module.ts", targetDir);
			IDEUtil.generateArtifact(context, context.getApplicationData(), A4_APP_ROUTES_TMPL_FTL, "app.routes.ts", targetDir);
		} catch (IDEException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param context
	 */
	protected void copyResources(BuildContext context) {
		
		String targetDir = context.getTargetDir();
		String resourcesDir = context.getResourcesDir();
		String sourceResourceDir = context.getUaResourcesDir().concat(StringUtil.trailingSlashIt(context.getArtifactId()));

		copyProjectConfigurationResources(resourcesDir, targetDir);

		FileUtil.copyDirectory(resourcesDir.concat(A4_APP_RESOURCE_SRC_DIR), targetDir.concat(A4_APP_RESOURCE_SRC_DIR));
		FileUtil.copyDirectory(sourceResourceDir.concat(A4_APP_RESOURCE_SRC_DIR), targetDir.concat(A4_APP_RESOURCE_SRC_DIR));
		FileUtil.copyDirectory(resourcesDir.concat(A4_APP_RESOURCE_E2E_DIR), targetDir.concat(A4_APP_RESOURCE_E2E_DIR));
		FileUtil.copyDirectory(resourcesDir.concat(A4_APP_RESOURCE_DIST_DIR), targetDir.concat(A4_APP_RESOURCE_DIST_DIR));
	}
	private void copyProjectConfigurationResources(String resourcesDir, String targetDir){
		FileUtil.copyFileToDirectory(resourcesDir.concat("deploy.sh"), targetDir);
		FileUtil.copyFileToDirectory(resourcesDir.concat("README.md"), targetDir);
		FileUtil.copyFileToDirectory(resourcesDir.concat("tslint.json"), targetDir);
		FileUtil.copyFileToDirectory(resourcesDir.concat("package.json"), targetDir);
		FileUtil.copyFileToDirectory(resourcesDir.concat("tsconfig.json"), targetDir);
		FileUtil.copyFileToDirectory(resourcesDir.concat("karma.conf.js"), targetDir);
		FileUtil.copyFileToDirectory(resourcesDir.concat("protractor.conf.js"), targetDir);
		FileUtil.copyFileToDirectory(resourcesDir.concat(".angular-cli.json"), targetDir);
		FileUtil.copyFileToDirectory(resourcesDir.concat(".editorconfig"), targetDir);
		FileUtil.copyFileToDirectory(resourcesDir.concat(".gitignore"), targetDir);
	}
	private void generateModuleArtefacts(BuildContext context, ModuleData moduleData){
		try {
			String moduleName = moduleData.getName().toLowerCase();
			String appDir = context.getTargetDir().concat(A4ProjectDirectoryBuilder.A4_APP_DIR);
			String moduleDir = appDir.concat(StringUtil.trailingSlashIt(moduleData.getName().toLowerCase()));
			
			IDEUtil.generateArtifact(context, moduleData, A4_MODULE_TMPL_FTL, moduleName.concat(".module.ts"), moduleDir);
			IDEUtil.generateArtifact(context, moduleData, A4_ROUTES_TMPL_FTL, moduleName.concat(".routes.ts"), moduleDir);
			IDEUtil.generateArtifact(context, moduleData, A4_MODULE_ROUTES_TMPL_FTL, moduleName.concat(".routing.module.ts"), moduleDir);
		} catch (IDEException e) {
			e.printStackTrace();
		}
	}
	private void copySourceResources(String sourceDir){
		//FileUtil.copyDirectory(resourcesDir.concat(A4_APP_RESOURCE_NODE_MODULES_DIR), targetDir.concat(A4_APP_RESOURCE_NODE_MODULES_DIR));
		
		/* 
		sourceResourceDir = sourceResourceDir.concat(A4_APP_RESOURCE_SRC_DIR);
		FileUtil.copyFileToDirectory(sourceResourceDir.concat("test.ts"), targetDir.concat(A4_APP_RESOURCE_SRC_DIR));
		FileUtil.copyFileToDirectory(sourceResourceDir.concat("main.ts"), targetDir.concat(A4_APP_RESOURCE_SRC_DIR));
		FileUtil.copyFileToDirectory(sourceResourceDir.concat("styles.css"), targetDir.concat(A4_APP_RESOURCE_SRC_DIR));
		FileUtil.copyFileToDirectory(sourceResourceDir.concat("index.html"), targetDir.concat(A4_APP_RESOURCE_SRC_DIR));
		FileUtil.copyFileToDirectory(sourceResourceDir.concat("favicon.ico"), targetDir.concat(A4_APP_RESOURCE_SRC_DIR));
		FileUtil.copyFileToDirectory(sourceResourceDir.concat("typings.d.ts"), targetDir.concat(A4_APP_RESOURCE_SRC_DIR));
		FileUtil.copyFileToDirectory(sourceResourceDir.concat("polyfills.ts"), targetDir.concat(A4_APP_RESOURCE_SRC_DIR));
		FileUtil.copyFileToDirectory(sourceResourceDir.concat("tsconfig.app.json"), targetDir.concat(A4_APP_RESOURCE_SRC_DIR));
		FileUtil.copyFileToDirectory(sourceResourceDir.concat("tsconfig.spec.json"), targetDir.concat(A4_APP_RESOURCE_SRC_DIR)); 


		FileUtil.copyDirectory(sourceResourceDir.concat("app"), targetDir.concat(A4_APP_RESOURCE_SRC_DIR + StringUtil.trailingSlashIt("app")));
		FileUtil.copyDirectory(sourceResourceDir.concat("assets"), targetDir.concat(A4_APP_RESOURCE_SRC_DIR + StringUtil.trailingSlashIt("assets")));
		FileUtil.copyDirectory(sourceResourceDir.concat("environments"), targetDir.concat(A4_APP_RESOURCE_SRC_DIR + StringUtil.trailingSlashIt("environments")));
		*/

	}

}
