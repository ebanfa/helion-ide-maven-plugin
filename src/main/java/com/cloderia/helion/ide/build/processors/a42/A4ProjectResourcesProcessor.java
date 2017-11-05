/**
 * 
 */
package com.cloderia.helion.ide.build.processors.a42;

import com.cloderia.helion.ide.IDEException;
import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator;
import com.cloderia.helion.ide.build.processors.BuildProcessor;
import com.cloderia.helion.ide.util.FileUtil;
import com.cloderia.helion.ide.util.IDEUtil;

/**
 * @author adrian
 *
 */
public class A4ProjectResourcesProcessor extends AbstractBuildProcessorDecorator {
	
	/* Build resources directories */
	public static final String A4_APP_MODULE_TMPL_FTL = "app-module-ts.ftl";
	public static final String A4_APP_ROUTES_TMPL_FTL = "app-routes-ts.ftl";
	public static final String A4_APP_ROUTES_MODULE_TMPL_FTL = "app-routes-module-ts.ftl";

	
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
		this.copyLocalProjectResources(context);
		return context;
	}

	/**
	 * @param context
	 */
	protected void copyLocalProjectResources(BuildContext context) {
		try {
			String targetDir = context.getTargetDir().concat(A4ProjectDirectoryBuilder.A4_APP_DIR);
			IDEUtil.generateArtifact(context, context.getApplicationData(), A4_APP_MODULE_TMPL_FTL, "app.module.ts", targetDir);
			IDEUtil.generateArtifact(context, context.getApplicationData(), A4_APP_ROUTES_TMPL_FTL, "app.routes.ts", targetDir);
			IDEUtil.generateArtifact(context, context.getApplicationData(), A4_APP_ROUTES_MODULE_TMPL_FTL, "app.routes.module.ts", targetDir);

			String sourceDir = context.getResourcesDir().concat(A4ProjectDirectoryBuilder.A4_SRC_DIR);
			FileUtil.copyDirectory(context.getResourcesDir().concat(A4ProjectDirectoryBuilder.A4_E2E_DIR), context.getTargetDir().concat(A4ProjectDirectoryBuilder.A4_E2E_DIR));
			//FileUtil.copyDirectory(context.getResourcesDir().concat(A4ProjectDirectoryBuilder.A4_NODE_MODULES_DIR), context.getTargetDir().concat(A4ProjectDirectoryBuilder.A4_NODE_MODULES_DIR));
			
			FileUtil.copyFileToDirectory(context.getResourcesDir().concat("deploy.sh"), context.getTargetDir());
			FileUtil.copyFileToDirectory(context.getResourcesDir().concat("README.md"), context.getTargetDir());
			FileUtil.copyFileToDirectory(context.getResourcesDir().concat("tslint.json"), context.getTargetDir());
			FileUtil.copyFileToDirectory(context.getResourcesDir().concat("package.json"), context.getTargetDir());
			FileUtil.copyFileToDirectory(context.getResourcesDir().concat("tsconfig.json"), context.getTargetDir());
			FileUtil.copyFileToDirectory(context.getResourcesDir().concat("karma.conf.js"), context.getTargetDir());
			FileUtil.copyFileToDirectory(context.getResourcesDir().concat("protractor.conf.js"), context.getTargetDir());
			FileUtil.copyFileToDirectory(context.getResourcesDir().concat(".angular-cli.json"), context.getTargetDir());
			FileUtil.copyFileToDirectory(context.getResourcesDir().concat(".editorconfig"), context.getTargetDir());
			FileUtil.copyFileToDirectory(context.getResourcesDir().concat(".gitignore"), context.getTargetDir());
			
			// Resources under source folder
			FileUtil.copyFileToDirectory(sourceDir.concat("favicon.ico"), context.getTargetDir().concat(A4ProjectDirectoryBuilder.A4_SRC_DIR));
			FileUtil.copyFileToDirectory(sourceDir.concat("index.html"), context.getTargetDir().concat(A4ProjectDirectoryBuilder.A4_SRC_DIR));
			FileUtil.copyFileToDirectory(sourceDir.concat("main.ts"), context.getTargetDir().concat(A4ProjectDirectoryBuilder.A4_SRC_DIR));
			FileUtil.copyFileToDirectory(sourceDir.concat("polyfills.ts"), context.getTargetDir().concat(A4ProjectDirectoryBuilder.A4_SRC_DIR));
			FileUtil.copyFileToDirectory(sourceDir.concat("styles.css"), context.getTargetDir().concat(A4ProjectDirectoryBuilder.A4_SRC_DIR));
			FileUtil.copyFileToDirectory(sourceDir.concat("test.ts"), context.getTargetDir().concat(A4ProjectDirectoryBuilder.A4_SRC_DIR));
			FileUtil.copyFileToDirectory(sourceDir.concat("tsconfig.app.json"), context.getTargetDir().concat(A4ProjectDirectoryBuilder.A4_SRC_DIR));
			FileUtil.copyFileToDirectory(sourceDir.concat("tsconfig.spec.json"), context.getTargetDir().concat(A4ProjectDirectoryBuilder.A4_SRC_DIR));
			FileUtil.copyFileToDirectory(sourceDir.concat("typings.d.ts"), context.getTargetDir().concat(A4ProjectDirectoryBuilder.A4_SRC_DIR));

			
			targetDir = context.getTargetDir().concat(A4ProjectDirectoryBuilder.A4_SRC_DIR);
			FileUtil.copyDirectory(sourceDir.concat(A4ProjectDirectoryBuilder.A4_ASSETS_DIR), targetDir.concat(A4ProjectDirectoryBuilder.A4_ASSETS_DIR));
			FileUtil.copyDirectory(sourceDir.concat(A4ProjectDirectoryBuilder.A4_ENV_DIR), targetDir.concat(A4ProjectDirectoryBuilder.A4_ENV_DIR));
			
		} catch (IDEException e) {
			e.printStackTrace();
		}
		
	}

}


/*/home/adrian/Projects/helion-ide/src/main/resources/a4/src/app
/home/adrian/Projects/helion-ide/src/main/resources/a4/src/assets
/home/adrian/Projects/helion-ide/src/main/resources/a4/src/environments
/home/adrian/Projects/helion-ide/src/main/resources/a4/src/favicon.ico
/home/adrian/Projects/helion-ide/src/main/resources/a4/src/index.html
/home/adrian/Projects/helion-ide/src/main/resources/a4/src/main.ts
/home/adrian/Projects/helion-ide/src/main/resources/a4/src/polyfills.ts
/home/adrian/Projects/helion-ide/src/main/resources/a4/src/styles.css
/home/adrian/Projects/helion-ide/src/main/resources/a4/src/test.ts
/home/adrian/Projects/helion-ide/src/main/resources/a4/src/tsconfig.app.json
/home/adrian/Projects/helion-ide/src/main/resources/a4/src/tsconfig.spec.json
/home/adrian/Projects/helion-ide/src/main/resources/a4/src/typings.d.ts



*/



