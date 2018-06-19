/**
 * 
 */
package com.cloderia.helion.pipeline;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloderia.helion.HelionException;

/**
 * @author adrian
 *
 */
public class SimplePipeline implements Pipeline {

	protected List<PipelineItem> pipeline = new ArrayList<PipelineItem>();
	private static Logger logger = LoggerFactory.getLogger(SimplePipeline.class);

	/**
	 * @param items
	 */
	public SimplePipeline(List<PipelineItem> items) throws HelionException {
		this.pipeline = items;
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.build.BuildPipeline#build(com.cloderia.helion.ide.build.BuildContext)
	 */
	public PipelineContext execute(PipelineContext context) throws HelionException {
		if(pipeline.isEmpty()) 
			throw new HelionException("Cannot execute empty pipeline");
		logger.debug("Starting pipeline execution");
		context = executePipeline(context);
		logger.debug("Finished pipeline execution");
		return context;
	}

	/**
	 * Loops through the pipeline executing each item 
	 * until it reaches the end of the pipeline.
	 * @param context
	 * @return
	 */
	private PipelineContext executePipeline(PipelineContext context) throws HelionException  {
		try {
			// Get the first item in the pipeline and execute it
			PipelineItem item = pipeline.get(0);
			context = item.execute(context);
			// While we have more items we continue the execution chain
			while(item.getNextItem() != null) {
				item = item.getNextItem();
				context = item.execute(context);
			}
			return context;
		} catch (PipelineException e) {
			throw new HelionException("PipelineItem execution error", e);
		}
	}

}
