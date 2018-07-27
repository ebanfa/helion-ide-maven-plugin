/**
 * 
 */
package com.cloderia.helion.application.pipeline;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.HelionRuntimeException;
import com.cloderia.helion.application.build.ApplicationBuilder;
import com.cloderia.helion.application.build.ApplicationBuilderFactory;
import com.cloderia.helion.application.model.Container;
import com.cloderia.helion.config.Artifact;
import com.cloderia.helion.context.PipelineContext;
import com.cloderia.helion.pipeline.AbstractPipelineItem;
import com.cloderia.helion.util.IDEConstants;

/**
 * @author Edward Banfa
 *
 */
public class ModelProcessor extends AbstractPipelineItem {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.AbstractPipelineItem#doExecute(com.cloderia.helion.context.PipelineContext)
	 */
	@Override
	protected PipelineContext doExecute(PipelineContext context) {
		try {
			Artifact applicationConfig = (Artifact) context.getContextDataItem(IDEConstants.APPLICATION_CONFIG_KEY);
			
			ApplicationBuilder builder = ApplicationBuilderFactory.getBuilderInstance(getConfig());
			Container application = builder.build(applicationConfig, context);
			
			context.setContextDataItem(IDEConstants.APPLICATION_OBJ_KEY, application);
		} catch (HelionException e) {
			throw new HelionRuntimeException(e);
		}
		return context;
	}

}
