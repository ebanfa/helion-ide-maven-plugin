/**
 * 
 */
package com.cloderia.helion.pipeline.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.cloderia.helion.exception.HelionException;
import com.cloderia.helion.exception.HelionRuntimeException;
import com.cloderia.ide.config.PipelineContextConfig;
import com.cloderia.ide.config.PipelineItemConfig;
import com.cloderia.ide.pipeline.PipelineItem;

/**
 * @author Edward Banfa
 *
 */
public class PipelineItemsFactory {
	
	/**
	 * @param buildContext
	 * @return
	 */
	public static List<PipelineItem> getPipelineItems(PipelineContextConfig contextConfig) {
		List<PipelineItem> processors = new ArrayList<PipelineItem>();
		List<PipelineItemConfig> itemConfigs = contextConfig.getPipelineItems();
		
		if(itemConfigs.isEmpty()) return processors;
		
		for (PipelineItemConfig itemConfig : itemConfigs) {
			processors.add(getInstance(processors, itemConfig));
		}
		return processors;		
	}

	/**
	 * @param processors
	 * @param itemConfig
	 * @throws HelionException
	 */
	private static PipelineItem getInstance(List<PipelineItem> processors, PipelineItemConfig itemConfig) {
		try {
			return (PipelineItem) Class.forName(itemConfig.getClassName())
					.getDeclaredConstructor(PipelineItemConfig.class).newInstance(itemConfig);
			
		} catch (InstantiationException e) {
			throw new HelionRuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new HelionRuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new HelionRuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new HelionRuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new HelionRuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new HelionRuntimeException(e);
		} catch (SecurityException e) {
			throw new HelionRuntimeException(e);
		}
	}
}
