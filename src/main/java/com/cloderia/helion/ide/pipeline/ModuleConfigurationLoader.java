/**
 * 
 */
package com.cloderia.helion.ide.pipeline;

import java.util.List;
import java.util.stream.Collectors;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.ide.model.Application;
import com.cloderia.helion.ide.model.Module;
import com.cloderia.helion.ide.pipeline.util.ConfigurationUtil;
import com.cloderia.helion.ide.pipeline.util.ModuleUtil;
import com.cloderia.helion.pipeline.AbstractPipelineItem;
import com.cloderia.helion.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.PipelineException;

/**
 * This pipeline item loads the modules configured for this application.
 * 
 * @author adrian
 */
public class ModuleConfigurationLoader extends AbstractPipelineItem {
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.AbstractPipelineItem#doExecute(com.cloderia.helion.pipeline.PipelineContext)
	 */
	@Override
	protected PipelineContext doExecute(PipelineContext context) {
		try {
			List<Module> modules = ConfigurationUtil.loadModules(context);
			// Update the package name for each module
			modules.stream()
				.map(module -> {
					return ModuleUtil.setModulePackage(module, context);
			}).collect(Collectors.toList());
			// Update the application with the loaded modules
			Application application = context.getApplication();
			application.setModules(modules);
		} catch (HelionException e) {
			throw new PipelineException(e);
		}
		return context;
	}

}
