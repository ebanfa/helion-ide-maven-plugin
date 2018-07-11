/**
 * 
 */
package com.cloderia.ide.pipeline;

import java.util.ArrayList;
import java.util.List;

import com.cloderia.helion.exception.HelionException;
import com.cloderia.helion.exception.HelionRuntimeException;
import com.cloderia.helion.exception.PipelineException;

/**
 * @author adrian
 *
 */
public class HelionPipeline implements Pipeline {

	private PipelineContext context;
	private List<PipelineItem> items = new ArrayList<PipelineItem>();
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.build.BuildPipeline#build(com.cloderia.helion.ide.build.BuildContext)
	 */
	public PipelineContext execute() throws HelionException {
		try {
			for(PipelineItem item: items) {
				context = item.execute(context);
			}
			return context;
		} catch (PipelineException e) {
			throw new HelionException("PipelineItem execution error", e);
		}
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
