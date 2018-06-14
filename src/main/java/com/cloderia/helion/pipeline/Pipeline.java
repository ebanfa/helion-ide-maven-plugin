/**
 * 
 */
package com.cloderia.helion.pipeline;

/**
 * @author adrian
 *
 */
public interface Pipeline {
	
	/**
	 * @param context
	 */
	public PipelineContext execute(PipelineContext context);
	
}
