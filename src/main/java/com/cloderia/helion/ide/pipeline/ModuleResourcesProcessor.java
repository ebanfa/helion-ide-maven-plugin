/**
 * 
 */
package com.cloderia.helion.ide.pipeline;

import java.util.stream.Collectors;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.ide.model.Application;
import com.cloderia.helion.ide.model.Module;
import com.cloderia.helion.ide.pipeline.util.ModuleResourcesUtil;
import com.cloderia.helion.pipeline.AbstractPipelineItem;
import com.cloderia.helion.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.PipelineException;

/**
 * This class is used to generate static files from the build project to a specified module project.
 * 
 * @author Edward Banfa
 */
public class ModuleResourcesProcessor extends AbstractPipelineItem {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.AbstractPipelineItem#doExecute(com.cloderia.helion.pipeline.PipelineContext)
	 */
	@Override
	protected PipelineContext doExecute(PipelineContext context) {
		Application application = context.getApplication();
		// For each module create its directory structure
		application.getModules()
			.stream()
			.map(module -> {
				return copyResources(context, module);
		}).collect(Collectors.toList());
		return context;
	}

	/**
	 * Do the actual copying.
	 * 
	 * @param context
	 * @param module
	 * @return
	 */
	private Module copyResources(PipelineContext context, Module module) {
		try {
			ModuleResourcesUtil.copyResources(module, context);
			return module;
		} catch (HelionException e) {
			throw new PipelineException(e);
		}
	}

}
