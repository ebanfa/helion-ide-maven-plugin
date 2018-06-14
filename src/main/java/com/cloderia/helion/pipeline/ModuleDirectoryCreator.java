/**
 * 
 */
package com.cloderia.helion.pipeline;

import java.util.stream.Collectors;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.util.ModuleDirectoryUtil;

/**
 * This class creates the basic module directory structure
 * 
 * @author Edward Banfa
 */
public class ModuleDirectoryCreator extends AbstractPipelineItem {

	
	@Override
	protected PipelineContext doExecute(PipelineContext context) throws HelionException {
		// 1. Create project directories for each module
		context.getApplication().getModules().stream().map(module -> { 
			return ModuleDirectoryUtil.createProjectDirectory(module, context);
		}).collect(Collectors.toList());
		return context;
	}

}
