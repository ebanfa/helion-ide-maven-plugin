/**
 * 
 */
package com.cloderia.helion.pipeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.context.PipelineContext;

/**
 * @author adrian
 *
 */
public class SimplePipeline extends AbstractPipeline {
	
	private static Logger logger = LoggerFactory.getLogger(SimplePipeline.class);

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.build.BuildPipeline#build(com.cloderia.helion.ide.build.BuildContext)
	 */
	public PipelineContext execute(PipelineContext context) throws HelionException {
		logger.debug("Executing pipeline item {}");
		try {
			for(PipelineItem item: items) {
				System.out.printf("Executing pipeline item {%s} \n", item);
				context = item.execute(context);
			}
			return context;
		} catch (PipelineException e) {
			throw new HelionException("PipelineItem execution error", e);
		}
	}
}
