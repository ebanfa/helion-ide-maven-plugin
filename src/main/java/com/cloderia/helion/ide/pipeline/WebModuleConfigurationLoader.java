/**
 * 
 */
package com.cloderia.helion.ide.pipeline;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.ide.model.Module;
import com.cloderia.helion.ide.pipeline.util.ConfigurationUtil;
import com.cloderia.helion.ide.pipeline.util.ModuleUtil;
import com.cloderia.helion.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.PipelineException;

/**
 * @author Edward Banfa
 *
 */
public class WebModuleConfigurationLoader extends ModulePipelineItem {

	@Override
	protected Module processModule(Module module, PipelineContext context) {
		if(!ModuleUtil.isWebModule(module)) return module;
		try {
			module.setWebModule(ConfigurationUtil.loadWebModule(module, context));
			return module;
		} catch (HelionException e) {
			throw new PipelineException(e);
		} 
	}

}
