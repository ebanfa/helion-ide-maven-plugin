/**
 * 
 */
package com.cloderia.helion.pipeline;

import java.util.List;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.context.PipelineContext;

/**
 * A pipeline of PipelineItem objects.
 * 
 * @author adrian
 */
public interface Pipeline {
	
	/**
	 * @param items
	 */
	public void setItems(List<PipelineItem> items);
	
	/**
	 * @return
	 */
	public List<PipelineItem> getItems();
	
	/**
	 * @param context
	 */
	public PipelineContext execute(PipelineContext context) throws HelionException;
	
}
