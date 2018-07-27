/**
 * 
 */
package com.cloderia.helion.pipeline;

import java.util.ArrayList;
import java.util.List;

import com.cloderia.helion.HelionRuntimeException;

/**
 * @author Edward Banfa
 *
 */
public abstract class AbstractPipeline implements Pipeline {

	protected List<PipelineItem> items = new ArrayList<PipelineItem>();
	
	/**
	 * @return the items
	 */
	public List<PipelineItem> getItems() {
		return items;
	}
	
	/**
	 * @param items the items to set
	 */
	public void setItems(List<PipelineItem> items) {
		if(items.size() < 1) 
			throw new HelionRuntimeException("Pipeline items cannot be empty");
		this.items = items;
	}

}
