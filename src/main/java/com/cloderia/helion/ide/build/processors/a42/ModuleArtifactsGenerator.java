/**
 * 
 */
package com.cloderia.helion.ide.build.processors.a42;

import java.io.File;

import com.cloderia.helion.ide.IDEException;
import com.cloderia.helion.ide.artifacts.Entity;
import com.cloderia.helion.ide.artifacts.Module;
import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator;
import com.cloderia.helion.ide.build.processors.BuildProcessor;
import com.cloderia.helion.ide.util.IDEUtil;
import com.cloderia.helion.ide.util.StringUtil;

/**
 * @author adrian
 *
 */
public class ModuleArtifactsGenerator extends AbstractBuildProcessorDecorator {
	
	public static final String A4_MODULE_INDEX_TMPL_FTL = "index-ts.ftl";
	public static final String A4_MODULE_CONFIG_TMPL_FTL = "module-ts.ftl";
	public static final String A4_MODULE_ROUTES_TMPL_FTL = "module-routes-ts.ftl";
	public static final String A4_MODULE_ROUTES_MODULE_TMPL_FTL = "module-routes-module-ts.ftl";
	public static final String A4_MODULE_DATA_OBJECT_TMPL_FTL = "data/entity-data-ts.ftl";
	public static final String A4_MODULE_ENTRY_PAGE_TMPL_FTL = "components/page/entry-page-component-ts.ftl";
	public static final String A4_MODULE_ENTRY_PAGE_MODEL_TMPL_FTL = "components/page/entry-page-model-ts.ftl";
	public static final String A4_MODULE_ENTRY_COMPONENT_TMPL_FTL = "components/ui-component/entry-component-ts.ftl";
	public static final String A4_MODULE_ENTRY_COMPONENT_MODEL_TMPL_FTL = "components/ui-component/entry-component-model-ts.ftl";

	protected ModuleArtifactsGenerator(BuildProcessor<BuildContext> processor) {
		super(processor);
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator#decorate(com.cloderia.helion.ide.build.BuildContext)
	 */
	@Override
	protected BuildContext decorate(BuildContext context) {
		for(Module moduleData: context.getApplication().getModules()) {
			String moduleDir = this.getModuleOutputDirectory(context, moduleData);
			String frontPageDir = StringUtil.trailingSlashIt("components").concat(StringUtil.trailingSlashIt("page/front-page"));
			String frontPagePanelDir = StringUtil.trailingSlashIt("components").concat(StringUtil.trailingSlashIt("ui-component/front-page"));
			String dataDir = moduleDir.concat(A4ProjectDirectoryBuilder.A4_DATA_DIR);
			
			this.generateModuleArtifact(context, moduleData, A4_MODULE_INDEX_TMPL_FTL, "index.ts", moduleDir);
			this.generateModuleArtifact(context, moduleData, A4_MODULE_CONFIG_TMPL_FTL, moduleData.getId().concat(".module.ts"), moduleDir);
			this.generateModuleArtifact(context, moduleData, A4_MODULE_ROUTES_TMPL_FTL, moduleData.getId().concat(".routes.ts"), moduleDir);
			this.generateModuleArtifact(context, moduleData, A4_MODULE_ROUTES_MODULE_TMPL_FTL, moduleData.getId().concat(".routing.module.ts"), moduleDir);
			this.generateModuleArtifact(context, moduleData, A4_MODULE_ENTRY_PAGE_TMPL_FTL, "front-page.component.ts", moduleDir.concat(frontPageDir));
			this.generateModuleArtifact(context, moduleData, A4_MODULE_ENTRY_PAGE_MODEL_TMPL_FTL, "front-page-component-model.ts", moduleDir.concat(frontPageDir));
			this.generateModuleArtifact(context, moduleData, A4_MODULE_ENTRY_COMPONENT_TMPL_FTL, "front-page-panel.component.ts", moduleDir.concat(frontPagePanelDir));
			this.generateModuleArtifact(context, moduleData, A4_MODULE_ENTRY_COMPONENT_MODEL_TMPL_FTL, "front-page-panel-model.ts", moduleDir.concat(frontPagePanelDir));
			this.generateModelObjects(context, moduleData, dataDir);
		}
		return context;
	}

	/**
	 * @param context
	 * @param moduleData
	 */
	protected String getModuleOutputDirectory(BuildContext context, Module moduleData) {
		String moduleDir = StringUtil.trailingSlashIt(moduleData.getId());
		moduleDir = context.getTargetDir().concat(A4ProjectDirectoryBuilder.A4_APP_DIR);
		moduleDir = moduleDir.concat(StringUtil.trailingSlashIt(moduleData.getId()));
		System.out.println("Got module output directory" +  moduleDir);
		return moduleDir;
	}

	
	private void generateModuleArtifact(BuildContext context, Module moduleData, String template, String outputFileName, String outputDir){
		try {
			String baseTemplateDir = resolveBaseTemplateDir(context, moduleData, template);
			System.out.println("Generating module artifact " +  outputFileName + " suing tmpl " + template + " base dir "+ baseTemplateDir);
			IDEUtil.generateArtifact(context, moduleData, baseTemplateDir.concat(template), outputFileName, outputDir);
		} catch (IDEException e) {
			e.printStackTrace();
		}
	}

	private void generateEntityArtifact(BuildContext context, Entity entityData, String template, String outputFileName, String outputDir){
		try {
			String baseTemplateDir = resolveBaseTemplateDir(context, entityData.getModule(), template);
			System.out.println("Generating module artifact " +  outputFileName + " suing tmpl " + template + " base dir "+ baseTemplateDir);
			IDEUtil.generateArtifact(context, entityData, baseTemplateDir.concat(template), outputFileName, outputDir);
		} catch (IDEException e) {
			e.printStackTrace();
		}
	}


	/**
	 * @param context
	 * @param moduleData
	 * @param template
	 */
	protected String resolveBaseTemplateDir(BuildContext context, Module moduleData, String template) {
		String baseTemplateDir = StringUtil.trailingSlashIt("module");
		if(this.hasOverrides(context, moduleData, template)) {
			baseTemplateDir =  "modules/".concat(StringUtil.trailingSlashIt(moduleData.getId()));
		}
		return baseTemplateDir;
	}
	
	private boolean hasOverrides(BuildContext context, Module moduleData, String template){
		/*String projectPath = StringUtil.trailingSlashIt(context.getArtifactId());
		String uaTemplateDirectory = context.getProjectDir().concat("templates/a4-portal/a4-ua/");
		uaTemplateDirectory = uaTemplateDirectory.concat(projectPath).concat("modules/").concat(StringUtil.trailingSlashIt(moduleData.getId()));
		String templateFilePath = uaTemplateDirectory.concat(template);
		File templateFile = new File(templateFilePath);
		if(templateFile.exists()) {
			System.out.println("Found override " +  templateFile);
			return true;
		}
		System.out.println("Override not found " +  templateFile);*/
		return false;
	}
	
	/**
	 * @param context
	 * @param moduleData
	 * @param moduleId
	 * @param moduleDir
	 * @param dataDir
	 * @throws IDEException
	 */
	private void generateModelObjects(BuildContext context, Module moduleData, String dataDir) 
	{
		for(Entity entityData: moduleData.getEntities()) {
			String overrideTmpl = "data/".concat(StringUtil.lowerCase(entityData.getName())).concat("-data-ts.ftl");
			if(this.hasOverrides(context, moduleData, overrideTmpl))
				this.generateEntityArtifact(context, entityData, overrideTmpl, StringUtil.lowerCase(entityData.getName()).concat(".ts"), dataDir);
			else 
				this.generateEntityArtifact(context, entityData, A4_MODULE_DATA_OBJECT_TMPL_FTL, StringUtil.lowerCase(entityData.getName()).concat(".ts"), dataDir);
		}
	}

}
