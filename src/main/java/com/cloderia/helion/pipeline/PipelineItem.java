/**
 * 
 */
package com.cloderia.helion.pipeline;

/**
 * The represents a pipeline item. A build pipeline is
 * composed of one or more pipeline items.
 * 
 * @author adrian
 */
public interface PipelineItem {
	
	/**
	 * @param context
	 */
	public PipelineContext execute(PipelineContext context);
	
	/**
	 * Set the next previous build processor
	 * @param item
	 */
	public void setNextItem(PipelineItem nextItem);
	
	/**
	 * Returns the next build processor
	 * @return
	 */
	public PipelineItem getNextItem();
}
