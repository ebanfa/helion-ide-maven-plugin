/**
 * 
 */
package com.cloderia.helion.ide.pipeline;

import java.util.stream.Collectors;

import com.cloderia.helion.ide.model.Application;
import com.cloderia.helion.ide.model.Module;
import com.cloderia.helion.pipeline.AbstractPipelineItem;
import com.cloderia.helion.pipeline.PipelineContext;

/**
 * @author Edward Banfa
 *
 */
public abstract class ModulePipelineItem extends AbstractPipelineItem {

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
				return processModule(module, context);
		}).collect(Collectors.toList());
		return context;
	}

	/**
	 * @param module
	 * @param context
	 * @return
	 */
	protected abstract Module processModule(Module module, PipelineContext context);

}
