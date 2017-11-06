/**
 * 
 */
package com.cloderia.helion.ide.build.processors.a42;

import java.io.File;

import com.cloderia.helion.ide.IDEException;
import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator;
import com.cloderia.helion.ide.build.processors.BuildProcessor;
import com.cloderia.helion.ide.data.EntityData;
import com.cloderia.helion.ide.data.ModuleData;
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
		for(ModuleData moduleData: context.getApplicationData().getModules()) {
			String moduleId = StringUtil.lowerCase(moduleData.getName());
			String moduleDir = this.getModuleOutputDirectory(context, moduleData);
			String pageDir = StringUtil.trailingSlashIt("components").concat(StringUtil.trailingSlashIt("page"));
			String uiComponentDir = StringUtil.trailingSlashIt("components").concat(StringUtil.trailingSlashIt("ui-component"));
			String dataDir = moduleDir.concat(A4ProjectDirectoryBuilder.A4_DATA_DIR);
			
			this.generateModuleArtifact(context, moduleData, A4_MODULE_INDEX_TMPL_FTL, "index.ts", moduleDir);
			this.generateModuleArtifact(context, moduleData, A4_MODULE_CONFIG_TMPL_FTL, moduleId.concat(".module.ts"), moduleDir);
			this.generateModuleArtifact(context, moduleData, A4_MODULE_ROUTES_TMPL_FTL, moduleId.concat(".routes.ts"), moduleDir);
			this.generateModuleArtifact(context, moduleData, A4_MODULE_ROUTES_MODULE_TMPL_FTL, moduleId.concat(".routing.module.ts"), moduleDir);
			this.generateModuleArtifact(context, moduleData, A4_MODULE_ENTRY_PAGE_TMPL_FTL, moduleId.concat("-entry-page.component.ts"), moduleDir.concat(pageDir));
			this.generateModuleArtifact(context, moduleData, A4_MODULE_ENTRY_PAGE_MODEL_TMPL_FTL, moduleId.concat("-entry-page-component-model.ts"), moduleDir.concat(pageDir));
			this.generateModuleArtifact(context, moduleData, A4_MODULE_ENTRY_COMPONENT_TMPL_FTL, moduleId.concat("-entry.component.ts"), moduleDir.concat(uiComponentDir));
			this.generateModuleArtifact(context, moduleData, A4_MODULE_ENTRY_COMPONENT_MODEL_TMPL_FTL, moduleId.concat("-entry-model-component.ts"), moduleDir.concat(uiComponentDir));
			this.generateModelObjects(context, moduleData, dataDir);
		}
		return context;
	}

	/**
	 * @param context
	 * @param moduleData
	 */
	protected String getModuleOutputDirectory(BuildContext context, ModuleData moduleData) {
		String moduleId = moduleData.getName().toLowerCase();
		String moduleDir = StringUtil.trailingSlashIt(moduleId);
		moduleDir = context.getTargetDir().concat(A4ProjectDirectoryBuilder.A4_APP_DIR);
		moduleDir = moduleDir.concat(StringUtil.trailingSlashIt(moduleId));
		System.out.println("Got module output directory" +  moduleDir);
		return moduleDir;
	}

	
	private void generateModuleArtifact(BuildContext context, ModuleData moduleData, String template, String outputFileName, String outputDir){
		try {
			String baseTemplateDir = resolveBaseTemplateDir(context, moduleData, template);
			System.out.println("Generating module artifact " +  outputFileName + " suing tmpl " + template + " base dir "+ baseTemplateDir);
			IDEUtil.generateArtifact(context, moduleData, baseTemplateDir.concat(template), outputFileName, outputDir);
		} catch (IDEException e) {
			e.printStackTrace();
		}
	}

	private void generateEntityArtifact(BuildContext context, EntityData entityData, String template, String outputFileName, String outputDir){
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
	protected String resolveBaseTemplateDir(BuildContext context, ModuleData moduleData, String template) {
		String baseTemplateDir = StringUtil.trailingSlashIt("module");
		if(this.hasOverrides(context, moduleData, template)) {
			String moduleId = StringUtil.lowerCase(moduleData.getName());
			baseTemplateDir =  "modules/".concat(StringUtil.trailingSlashIt(moduleId));
		}
		return baseTemplateDir;
	}
	
	private boolean hasOverrides(BuildContext context, ModuleData moduleData, String template){
		String moduleId = StringUtil.lowerCase(moduleData.getName());
		String projectPath = StringUtil.trailingSlashIt(context.getArtifactId());
		String uaTemplateDirectory = context.getProjectDir().concat("templates/a4-portal/a4-ua/");
		uaTemplateDirectory = uaTemplateDirectory.concat(projectPath).concat("modules/").concat(StringUtil.trailingSlashIt(moduleId));
		String templateFilePath = uaTemplateDirectory.concat(template);
		File templateFile = new File(templateFilePath);
		if(templateFile.exists()) {
			System.out.println("Found override " +  templateFile);
			return true;
		}
		System.out.println("Override not found " +  templateFile);
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
	private void generateModelObjects(BuildContext context, ModuleData moduleData, String dataDir) 
	{
		for(EntityData entityData: moduleData.getEntities()) {
			String overrideTmpl = "data/".concat(StringUtil.lowerCase(entityData.getName())).concat("-data-ts.ftl");
			if(this.hasOverrides(context, moduleData, overrideTmpl))
				this.generateEntityArtifact(context, entityData, overrideTmpl, StringUtil.lowerCase(entityData.getName()).concat(".ts"), dataDir);
			else 
				this.generateEntityArtifact(context, entityData, A4_MODULE_DATA_OBJECT_TMPL_FTL, StringUtil.lowerCase(entityData.getName()).concat(".ts"), dataDir);
		}
	}

}
