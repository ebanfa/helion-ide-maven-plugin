/**
 * 
 */
package com.cloderia.helion.ide.pipeline;

import java.util.stream.Collectors;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.ide.model.Application;
import com.cloderia.helion.ide.model.Module;
import com.cloderia.helion.ide.pipeline.util.ModuleUtil;
import com.cloderia.helion.ide.pipeline.util.WebModuleUtil;
import com.cloderia.helion.pipeline.AbstractPipelineItem;
import com.cloderia.helion.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.PipelineException;

/**
 * This class generates the web.xml and jboss.xml files for a web module.
 * 
 * @author adrian
 */
public class WebModuleConfigurationProcessor extends AbstractPipelineItem {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.AbstractPipelineItem#doExecute(com.cloderia.helion.pipeline.PipelineContext)
	 */
	@Override
	protected PipelineContext doExecute(PipelineContext context) {
		Application application = context.getApplication();
		// For each module generates its mandatory artifacts
		application.getModules()
			.stream()
			.map(module -> {
				return generateModuleArtifacts(context, module);
		}).collect(Collectors.toList());
		return context;
	}

	/**
	 * @param context
	 * @param module
	 * @return
	 */
	private Module generateModuleArtifacts(PipelineContext context, Module module) {
		if(!ModuleUtil.isWebModule(module)) return module;
		try {
			// copy resources
			return WebModuleUtil.generateModuleArtifacts(context, module);
		} catch (HelionException e) {
			throw new PipelineException(e);
		}
	}

}
