/**
 * 
 */
package com.cloderia.helion.pipeline;

import com.cloderia.helion.config.Artifact;
import com.cloderia.helion.context.PipelineContext;

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
	public Artifact getConfig();
	
	/**
	 * @return
	 */
	public void setConfig(Artifact config);
	
	
}
