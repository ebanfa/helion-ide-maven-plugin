/**
 * 
 */
package com.cloderia.helion.pipeline;

import com.cloderia.helion.pipeline.util.EjbApplicationBuilderUtil;
import com.cloderia.ide.application.Application;
import com.cloderia.ide.config.PipelineItemConfig;
import com.cloderia.ide.pipeline.AbstractPipelineItem;
import com.cloderia.ide.pipeline.PipelineContext;

/**
 * @author Edward Banfa
 *
 */
public class EjbApplicationBuilder extends AbstractPipelineItem {

	public EjbApplicationBuilder(PipelineItemConfig config) {
		super(config);
	}

	/* (non-Javadoc)
	 * @see com.cloderia.ide.pipeline.AbstractPipelineItem#doExecute(com.cloderia.ide.pipeline.PipelineContext)
	 */
	@Override
	protected PipelineContext doExecute(PipelineContext context) {
		Application ejbApplication = EjbApplicationBuilderUtil.build(context);
		context.setApplication(ejbApplication);
		return context;
	}

}
