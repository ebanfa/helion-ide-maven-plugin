/**
 * 
 */
package com.cloderia.helion.pipeline;

import java.util.List;
import java.util.stream.Collectors;

import com.cloderia.helion.exception.HelionException;
import com.cloderia.helion.exception.PipelineException;
import com.cloderia.helion.model.application.Application;
import com.cloderia.helion.model.module.Module;
import com.cloderia.helion.model.pipeline.AbstractPipelineItem;
import com.cloderia.helion.model.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.util.ConfigurationUtil;
import com.cloderia.helion.pipeline.util.MavenUtil;
import com.cloderia.helion.util.ResourcesUtil;

/**
 * @author Edward Banfa
 */
public abstract class AbstractModuleProcessor<T extends Module> extends AbstractPipelineItem {

	protected Class<T> moduleImplClass;
	
	/**
	 * 
	 */
	public AbstractModuleProcessor(Class<T> clazz) {
		this.moduleImplClass = clazz;
	}

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
			module = loadAndProcessModule(module, context);
			ResourcesUtil.copyDirectories(module, MavenUtil.getProjectDir(module, context));
			MavenUtil.generateMavenProjectArtifacts(module, context);
		} catch (HelionException e) {
			throw new PipelineException("Error processing module " + module.getId(), e);
		}
		return module;
	}

	/**
	 * @param module
	 * @param context
	 * @return
	 * @throws HelionException
	 */
	private Module loadAndProcessModule(Module module, PipelineContext context) throws HelionException {
		module = ConfigurationUtil.fromModule(module, moduleImplClass);
		// Call the subclass functionality
		return doProcessModule(module, context);
	}
	

	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.AbstractModuleProcessor#getModuleClass()
	 */
	protected Class<T> getModuleClass() {
		return moduleImplClass;
	}
	
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
	protected <T extends Module> T doProcessModule(T module, PipelineContext context) throws HelionException {
		return module;
	}

}
