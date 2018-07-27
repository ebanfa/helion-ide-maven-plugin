/**
 * 
 */
package com.cloderia.helion;

import com.cloderia.helion.context.Context;
import com.cloderia.helion.context.PipelineContext;
import com.cloderia.helion.pipeline.Pipeline;
import com.cloderia.helion.pipeline.PipelineFactory;

/**
 * @author Edward Banfa
 *
 */
public abstract class AbstractPipelineMojo extends AbstractHelionMojo {

	/** 
	 * Use the context to create a pipeline and then execute the pipeline
	 */
	@Override
	protected void doExecute(Context context) throws HelionException {
		PipelineContext pipelineContext = (PipelineContext) context;
		Pipeline pipeline = PipelineFactory.getInstance(pipelineContext);
		pipeline.execute(pipelineContext);
	}
	
}
