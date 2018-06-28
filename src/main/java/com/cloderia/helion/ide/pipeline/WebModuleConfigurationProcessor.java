/**
 * 
 */
package com.cloderia.helion.ide.pipeline;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.ide.model.Module;
import com.cloderia.helion.ide.pipeline.util.ModuleUtil;
import com.cloderia.helion.ide.pipeline.util.ResourcesUtil;
import com.cloderia.helion.ide.pipeline.util.WebModuleArtifactsUtil;
import com.cloderia.helion.ide.pipeline.util.WebModuleProjectUtil;
import com.cloderia.helion.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.PipelineException;

/**
 * This class generates the web.xml and jboss.xml files for a web module.
 * 
 * @author adrian
 */
public class WebModuleConfigurationProcessor extends ModulePipelineItem {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.pipeline.ModulePipelineItem#processModule(com.cloderia.helion.ide.model.Module, com.cloderia.helion.pipeline.PipelineContext)
	 */
	@Override
	protected Module processModule(Module module, PipelineContext context) {
		if(!ModuleUtil.isWebModule(module)) return module;
		try {
			// copy resources
			WebModuleProjectUtil.createWebProjectDirectory(module, context);
			ResourcesUtil.copyDirectories(module.getWebModule(), ModuleUtil.getProjectDir(module, context));
			WebModuleArtifactsUtil.generateWebModuleArtifacts(module, context);
			return module;
		} catch (HelionException e) {
			throw new PipelineException(e);
		}
	}

}
