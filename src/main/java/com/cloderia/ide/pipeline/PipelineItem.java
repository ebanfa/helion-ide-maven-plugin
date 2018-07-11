/**
 * 
 */
package com.cloderia.ide.pipeline;

import com.cloderia.ide.config.PipelineItemConfig;

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
	 * @return
	 */
	public PipelineItemConfig getConfig();
	
	
}
