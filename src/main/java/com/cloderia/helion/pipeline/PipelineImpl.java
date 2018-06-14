/**
 * 
 */
package com.cloderia.helion.pipeline;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author adrian
 *
 */
public class PipelineImpl implements Pipeline {

	protected List<PipelineItem> pipeline = new ArrayList<PipelineItem>();
	private static Logger logger = LoggerFactory.getLogger(PipelineImpl.class);

	/**
	 * @param items
	 */
	public PipelineImpl(List<PipelineItem> items) {
		this.pipeline = initPipeline(items);
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.build.BuildPipeline#build(com.cloderia.helion.ide.build.BuildContext)
	 */
	public PipelineContext execute(PipelineContext context) {
        for (PipelineItem item : pipeline) 
        	context = item.execute(context);
        return context;
	}

	/**
	 * 
	 */
	public List<PipelineItem> initPipeline(List<PipelineItem> items) {
		PipelineItem precedingItem = null;
        for (PipelineItem item : this.pipeline) {
        	if(precedingItem != null)
        		precedingItem.setNextItem(item);
        	precedingItem = item;
        }
        return items;
	}

}
