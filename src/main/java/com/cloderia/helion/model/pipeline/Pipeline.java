/**
 * 
 */
package com.cloderia.helion.model.pipeline;

import com.cloderia.helion.exception.HelionException;

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
