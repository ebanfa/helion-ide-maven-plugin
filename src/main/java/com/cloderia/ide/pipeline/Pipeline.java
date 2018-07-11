/**
 * 
 */
package com.cloderia.ide.pipeline;

import java.util.List;

import com.cloderia.helion.exception.HelionException;

/**
 * @author adrian
 *
 */
public interface Pipeline {
	
	/**
	 * @param items
	 */
	public void setItems(List<PipelineItem> items);
	
	/**
	 * @param context
	 */
	public PipelineContext execute() throws HelionException;
	
}
