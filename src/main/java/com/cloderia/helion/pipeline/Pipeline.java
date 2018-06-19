/**
 * 
 */
package com.cloderia.helion.pipeline;

import com.cloderia.helion.HelionException;

/**
 * @author adrian
 *
 */
public interface Pipeline {
	
	/**
	 * @param context
	 */
	public PipelineContext execute(PipelineContext context) throws HelionException;
	
}
