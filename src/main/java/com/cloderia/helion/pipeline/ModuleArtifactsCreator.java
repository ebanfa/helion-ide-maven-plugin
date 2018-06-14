/**
 * 
 */
package com.cloderia.helion.pipeline;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.model.Application;
import com.cloderia.helion.model.Module;
import com.cloderia.helion.util.IDEConstants;
import com.cloderia.helion.util.ModuleDirectoryUtil;
import com.cloderia.helion.util.ProjectArtifactsUtil;
import com.cloderia.helion.util.StringUtil;
import com.cloderia.helion.util.TemplateUtil;

/**
 * This class does the following:
 * 1. Copies non auto generated java source files
 * 2. Copies other static non auto generated files (eg webapp files)
 * 3. Generates project pom.xml
 * 4. Generates project readme.md
 * @author adrian
 *
 */
public class ModuleArtifactsCreator extends AbstractPipelineItem {
	
	private static Logger logger = LoggerFactory.getLogger(ModuleArtifactsCreator.class);

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator#decorate(com.cloderia.helion.ide.build.BuildContext)
	 */
	@Override
	protected PipelineContext doExecute(PipelineContext context) throws HelionException {
		Application application = context.getApplication();
		// Generate the parent POM and README
		logger.debug("Generating parent pom and readme file");
		TemplateUtil.generateArtifact(context, application, 
				IDEConstants.APPLICATION_POM_TMPL_FTL, IDEConstants.MODULE_POM_XML, context.getTargetDir());
		
		TemplateUtil.generateArtifact(context, application, 
				IDEConstants.APPLICATION_README_TMPL_FTL, IDEConstants.MODULE_README_MD, context.getTargetDir());
		
		// Process each module
		application.getModules().stream().map(module -> {
			return this.process(module, context);
		}).collect(Collectors.toList());
		return context;
	}

	/**
	 * Copy and generate the required files.
	 * 
	 * @param module
	 * @param context
	 * @return
	 */
	private Module process(Module module, PipelineContext context) {
		logger.debug("Generating module pom and readme file for module " + module.getId());
		try {
			// Copy required files
			ProjectArtifactsUtil.copyJavaSources(module, context);
			ProjectArtifactsUtil.copyResources(module, context);
			// Generate POM
			TemplateUtil.generateArtifact(context, module, getModulePOMTemplate(module), 
					IDEConstants.MODULE_POM_XML, ModuleDirectoryUtil.getModuleDir(module, context));
			// Generate README
			TemplateUtil.generateArtifact(context, module, getModuleREADMETemplate(module), 
					IDEConstants.MODULE_README_MD, ModuleDirectoryUtil.getModuleDir(module, context));
		} catch (HelionException e) {
			logger.error(e.getMessage(),  e);
		}
		return module;
	}
	
	/**
	 * Returns the POM.XML template for a module by first
	 * checking if we have custom template configured for the module
	 * if not we just return the default template.
	 * 
	 * @param module
	 * @return
	 */
	private String getModulePOMTemplate(Module module) {
		if(module.getExtraConfig() != null) {
			if(StringUtil.isValidString(module.getExtraConfig().getPomTemplate()))
				return module.getExtraConfig().getPomTemplate();
		}
		return IDEConstants.MODULE_POM_TMPL_FTL;
	}
	
	/**
	 * Returns the README.MD template for a module by first
	 * checking if we have custom template configured for the module
	 * if not we just return the default template.
	 * 
	 * @param module
	 * @return
	 */
	private String getModuleREADMETemplate(Module module) {
		if(module.getExtraConfig() != null) {
			if(StringUtil.isValidString(module.getExtraConfig().getReadMeTemplate()))
				return module.getExtraConfig().getReadMeTemplate();
		}
		return IDEConstants.MODULE_README_TMPL_FTL;
	}

}
