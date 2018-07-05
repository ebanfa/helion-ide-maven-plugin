/**
 * 
 */
package com.cloderia.helion.pipeline;

import java.util.List;
import java.util.stream.Collectors;

import com.cloderia.helion.exception.HelionException;
import com.cloderia.helion.exception.PipelineException;
import com.cloderia.helion.model.application.Application;
import com.cloderia.helion.model.module.AbstractModule;
import com.cloderia.helion.model.module.Module;
import com.cloderia.helion.model.pipeline.AbstractPipelineItem;
import com.cloderia.helion.model.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.util.ConfigurationUtil;
import com.cloderia.helion.pipeline.util.MavenUtil;
import com.cloderia.helion.util.ArtifactConfigUtil;
import com.cloderia.helion.util.IDEConstants;
import com.cloderia.helion.util.ResourcesUtil;
import com.cloderia.helion.util.TemplateUtil;

/**
 * @author Edward Banfa
 *
 */
public abstract class AbstractModuleProcessor extends AbstractPipelineItem {
	
	@Override
	protected PipelineContext doExecute(PipelineContext context) {
		Application application = context.getApplication();
		this.getModules(application, context)
			.stream()
			.map(module -> {
				return processModule(module, context);
		}).collect(Collectors.toList());
		return context;
	}

	/**
	 * @param dataModule
	 * @param context
	 * @return
	 */
	public Module processModule(Module module, PipelineContext context) {
		try {
			module = loadModuleConfiguration(module, context);
			module = processDataModule(module, context);
			processModuleArtifacts(module, context);
		} catch (HelionException e) {
			throw new PipelineException("Error processing module " + module.getId(), e);
		}
		return module;
	}

	/**
	 * @param module
	 * @param context
	 * @throws HelionException
	 */
	private void processModuleArtifacts(Module module, PipelineContext context) throws HelionException {
		ResourcesUtil.copyDirectories(module, MavenUtil.getProjectDir(module, context));
		String targetDir = MavenUtil.getProjectDir(module, context);
		String pomTemplateFile = TemplateUtil.getModulePomTemplateFile(module);
		TemplateUtil.generateArtifact(context, module, pomTemplateFile, IDEConstants.POM_XML_FILE_NAME, targetDir);
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.AbstractModuleProcessor#loadModuleConfiguration(com.cloderia.helion.model.module.Module, com.cloderia.helion.model.pipeline.PipelineContext)
	 */
	public <T extends AbstractModule> T loadModuleConfiguration(Module module, PipelineContext context) throws HelionException {
		String moduleConfigFile = ArtifactConfigUtil.getArtifactConfigFile(module);
		T loadedModule = ConfigurationUtil.loadModule(moduleConfigFile, this.getModuleClass());
		loadedModule.setPackageName(module.getPackageName());
		loadedModule.getArtifactConfig().setConfigFile(moduleConfigFile);
		return loadedModule;
	}
	
	/**
	 * @return
	 */
	protected abstract <T extends AbstractModule> Class<T> getModuleClass();
	
	/**
	 * @param application
	 * @param context
	 * @return
	 */
	protected abstract <T extends Module> List<T> getModules(Application application, PipelineContext context);

	/**
	 * @param dataModule
	 * @param context
	 * @return
	 */
	public abstract <T extends Module> T processDataModule(T module, PipelineContext context) throws HelionException;

}
