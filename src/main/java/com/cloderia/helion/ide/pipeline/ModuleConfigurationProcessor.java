/**
 * 
 */
package com.cloderia.helion.ide.pipeline;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.ide.model.Module;
import com.cloderia.helion.ide.pipeline.util.ModuleArtifactsUtil;
import com.cloderia.helion.ide.pipeline.util.ModuleProjectUtil;
import com.cloderia.helion.ide.pipeline.util.ModuleUtil;
import com.cloderia.helion.ide.pipeline.util.ResourcesUtil;
import com.cloderia.helion.ide.util.StringUtil;
import com.cloderia.helion.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.PipelineException;

/**
 * This class is used to generate static files from the build project to a specified module project.
 * 
 * @author Edward Banfa
 */
public class ModuleConfigurationProcessor extends ModulePipelineItem {
	
	@Override
	protected Module processModule(Module module, PipelineContext context) {
		try {
			module.setClassName(StringUtil.moduleIdToJavaClassName(module.getId()));
			ModuleProjectUtil.createProjectDirectories(module, context);
			ResourcesUtil.copyDirectories(module, ModuleUtil.getProjectDir(module, context));
			ModuleArtifactsUtil.generateModuleArtifacts(context, module);
			return module;
		} catch (HelionException e) {
			throw new PipelineException(e);
		}
	}

}
