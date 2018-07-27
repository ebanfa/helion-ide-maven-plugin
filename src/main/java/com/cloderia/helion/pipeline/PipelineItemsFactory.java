/**
 * 
 */
package com.cloderia.helion.pipeline;

import java.util.ArrayList;
import java.util.List;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.HelionRuntimeException;
import com.cloderia.helion.config.Artifact;

/**
 * @author Edward Banfa
 *
 */
public class PipelineItemsFactory {
	
	/**
	 * @param buildContext
	 * @return
	 */
	public static List<PipelineItem> getPipelineItems(Artifact pipelineConfig) {
		List<PipelineItem> processors = new ArrayList<PipelineItem>();
		List<Artifact> itemConfigs = pipelineConfig.getArtifacts();
		
		for (Artifact itemConfig : itemConfigs) {
			processors.add(getInstance(itemConfig));
		}
		return processors;		
	}

	/**
	 * @param processors
	 * @param itemConfig
	 * @throws HelionException
	 */
	private static PipelineItem getInstance(Artifact itemConfig) {
		try {
			PipelineItem item = (PipelineItem) Class.forName(itemConfig.getClassName()).newInstance();
			item.setConfig(itemConfig);
			return item;
			
		} catch (InstantiationException e) {
			throw new HelionRuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new HelionRuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new HelionRuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new HelionRuntimeException(e);
		} catch (SecurityException e) {
			throw new HelionRuntimeException(e);
		}
	}
}
