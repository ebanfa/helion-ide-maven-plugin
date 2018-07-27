/**
 * 
 */
package com.cloderia.helion.pipeline;

import java.util.List;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.config.Artifact;
import com.cloderia.helion.context.PipelineContext;
import com.cloderia.helion.util.ArtifactConfigUtil;
import com.cloderia.helion.util.IDEConstants;
import com.cloderia.helion.util.JAXBUtil;

/**
 * @author Edward Banfa
 *
 */
public class PipelineFactory {
	
	/**
	 * @param context
	 * @return
	 * @throws HelionException 
	 */
	public static Pipeline getInstance(PipelineContext context) throws HelionException {
		try {
			String pipelineConfigFile = ArtifactConfigUtil.getConfigParameterValue("pipelineConfigFile", context.getContextConfig());
			Artifact pipelineConfig = JAXBUtil.loadArtifact(pipelineConfigFile, Artifact.class);
			
			String pipelineClassName = ArtifactConfigUtil.getConfigParameterValue(IDEConstants.PIPELINE_CLASS_PARAM, context.getContextConfig());
			Pipeline pipeline = (Pipeline) Class.forName(pipelineClassName).newInstance();
			
			List<PipelineItem> items = PipelineItemsFactory.getPipelineItems(pipelineConfig);
			pipeline.setItems(items);
			
			return pipeline;
			
		} catch (InstantiationException e) {
			throw new HelionException(e);
		} catch (IllegalAccessException e) {
			throw new HelionException(e);
		} catch (ClassNotFoundException e) {
			throw new HelionException(e);
		} catch (ClassCastException e) {
			throw new HelionException("Invalid context config was expecting instance of PipelineContextConfig ", e);
		}
	}
}
