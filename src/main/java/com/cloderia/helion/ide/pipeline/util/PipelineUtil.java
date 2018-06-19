/**
 * 
 */
package com.cloderia.helion.ide.pipeline.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.PipelineItem;

/**
 * @author Edward Banfa
 *
 */
public class PipelineUtil {
	
	private static Logger logger = LoggerFactory.getLogger(PipelineUtil.class);

	/**
	 * @param buildContext
	 * @return
	 */
	public static List<PipelineItem> getPipelineItems(PipelineContext buildContext) throws HelionException {
		List<PipelineItem> processors = new ArrayList<PipelineItem>();
		
		for (String processor : buildContext.getProcessor()) {
			try {
				logger.debug("Instantiating pipeline item {} ", processor);
				processors.add((PipelineItem) Class.forName(processor).newInstance());
			} catch (InstantiationException e) {
				throw new HelionException(e);
			} catch (IllegalAccessException e) {
				throw new HelionException(e);
			} catch (ClassNotFoundException e) {
				throw new HelionException(e);
			}
		}
		return buildPipeline(processors);
	}

	/**
	 * 
	 */
	public static List<PipelineItem> buildPipeline(List<PipelineItem> items) throws HelionException {
		
		if(items.size() < 1) 
			throw new HelionException("Cannot instantiate an empty pipeline");
		
		PipelineItem precedingItem = null;
        for (PipelineItem item : items) {
        	if(precedingItem != null)
        		precedingItem.setNextItem(item);
        	precedingItem = item;
        }
        return items;
	}
}
