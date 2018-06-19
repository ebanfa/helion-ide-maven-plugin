/**
 * 
 */
package com.cloderia.helion.ide.pipeline;

import java.util.stream.Collectors;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.ide.model.Application;
import com.cloderia.helion.ide.model.Module;
import com.cloderia.helion.ide.pipeline.util.ModuleProjectDirectoryUtil;
import com.cloderia.helion.pipeline.AbstractPipelineItem;
import com.cloderia.helion.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.PipelineException;

/**
 * This pipeline item creates the basic Maven directory structure for modules.
 * 
 * @author adrian
 */
public class ModuleDirectoryCreator extends AbstractPipelineItem {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cloderia.helion.pipeline.AbstractPipelineItem#doExecute(com.cloderia.
	 * helion.pipeline.PipelineContext)
	 */
	@Override
	protected PipelineContext doExecute(PipelineContext context) {
		Application application = context.getApplication();
		// For each module create its directory structure
		application.getModules()
			.stream()
			.map(module -> {
				return process(context, module);
		}).collect(Collectors.toList());
		return context;
	}

	/**
	 * Creates the project file system for a given module.
	 * @param context
	 * @param module
	 * @return
	 */
	private Module process(PipelineContext context, Module module) {
		try {
			return ModuleProjectDirectoryUtil.createProjectDirectories(module, context);
		} catch (HelionException e) {
			throw new PipelineException(e);
		}
	}

}
