/**
 * 
 */
package com.cloderia.helion.pipeline;

import java.util.stream.Collectors;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.model.Module;

/**
 * @author adrian
 *
 */
public class JPAModuleArtifactsCreator extends AbstractPipelineItem {


	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator#decorate(com.cloderia.helion.ide.build.BuildContext)
	 */
	@Override
	protected PipelineContext doExecute(PipelineContext context) throws HelionException {
		// For each module
		context.getApplication().getModules().stream().map(module -> { 
			return this.processEntitiesInModule(module, context);
		}).collect(Collectors.toList());
		return context;
	}

	private Object processEntitiesInModule(Module module, PipelineContext context) {
		return null;
	}

}
