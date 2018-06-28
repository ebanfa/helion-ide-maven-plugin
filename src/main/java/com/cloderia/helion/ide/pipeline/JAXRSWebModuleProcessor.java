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
public class JAXRSWebModuleProcessor extends ModulePipelineItem {

	
	@Override
	protected Module processModule(Module module, PipelineContext context) {
		return module;
	}

}
