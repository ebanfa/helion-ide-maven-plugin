/**
 * 
 */
package com.cloderia.helion.ide.pipeline;

import com.cloderia.helion.ide.model.Module;
import com.cloderia.helion.pipeline.PipelineContext;

/**
 * @author Edward Banfa
 *
 */
public class NGWebModuleProcessor extends ModulePipelineItem {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.pipeline.ModulePipelineItem#processModule(com.cloderia.helion.ide.model.Module, com.cloderia.helion.pipeline.PipelineContext)
	 */
	@Override
	protected Module processModule(Module module, PipelineContext context) {
		return module;
	}

}
