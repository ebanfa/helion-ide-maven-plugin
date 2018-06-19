/**
 * 
 */
package com.cloderia.helion.pipeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloderia.helion.HelionException;


/**
 * @author adrian
 *
 */
public abstract class AbstractPipelineItem implements PipelineItem {

	private PipelineItem nextItem;
	private static Logger logger = LoggerFactory.getLogger(AbstractPipelineItem.class);
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.PipelineItem#execute(com.cloderia.helion.pipeline.PipelineContext)
	 */
	@Override
	public PipelineContext execute(PipelineContext context) {
		logger.debug("Executing pipeline item " + this);
		return doExecute(context);
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.PipelineItem#setNext(com.cloderia.helion.pipeline.PipelineItem)
	 */
	@Override
	public void setNextItem(PipelineItem nextItem) {
		this.nextItem = nextItem;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.PipelineItem#getNext()
	 */
	@Override
	public PipelineItem getNextItem() {
		return nextItem;
	}
	
	/**
	 * @param context
	 * @return
	 * @throws HelionException
	 */
	protected abstract PipelineContext doExecute(PipelineContext context);
}
