/**
 * 
 */
package com.cloderia.helion.pipeline;

import java.util.List;
import java.util.stream.Collectors;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.model.Module;
import com.cloderia.helion.util.ModuleDirectoryUtil;

/**
 * This item does processes/normalizes basic module information
 * 
 * @author Edward Banfa
 */
 public class ModuleDataProcessor extends AbstractPipelineItem {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.AbstractPipelineItem#doExecute(com.cloderia.helion.pipeline.PipelineContext)
	 */
	@Override
	protected PipelineContext doExecute(PipelineContext context) throws HelionException {
		List<Module> modules = context.getApplication().getModules();
		modules = modules.stream().map(module -> {
			// For now, this just sets the module package name
			return ModuleDirectoryUtil.setModulePackage(module, context);
		}).collect(Collectors.toList());
		context.getApplication().setModules(modules);
		return context;
	}

}
