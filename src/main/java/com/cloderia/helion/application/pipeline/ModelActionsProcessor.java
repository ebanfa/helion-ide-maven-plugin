/**
 * 
 */
package com.cloderia.helion.application.pipeline;

import com.cloderia.helion.HelionRuntimeException;
import com.cloderia.helion.application.model.Component;
import com.cloderia.helion.context.PipelineContext;
import com.cloderia.helion.pipeline.AbstractPipelineItem;
import com.cloderia.helion.util.IDEConstants;
import com.google.common.base.Optional;

/**
 * @author Edward Banfa
 */
public class ModelActionsProcessor extends AbstractPipelineItem {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.AbstractPipelineItem#doExecute(com.cloderia.helion.context.PipelineContext)
	 */
	@Override
	protected PipelineContext doExecute(PipelineContext context) {
		Optional<Object> applicationOpt = Optional.of(
				context.getContextDataItem(IDEConstants.APPLICATION_OBJ_KEY));
		
		if(!applicationOpt.isPresent()) 
			throw new HelionRuntimeException("Application model not found in context");
		
		this.executeActions((Component) applicationOpt.get(), context);
		return context;
	}

	private void executeActions(Component component, PipelineContext context) {
		/*Artifact componentConfig = component.get
		for(Action action : component.getActions()) {
			action.execute(artifact, params, context);
		}*/
	}

}
