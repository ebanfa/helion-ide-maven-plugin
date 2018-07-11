/**
 * 
 */
package com.cloderia.ide.pipeline;

import com.cloderia.helion.BuildContext;
import com.cloderia.helion.exception.HelionException;
import com.cloderia.helion.pipeline.util.PipelineItemsFactory;
import com.cloderia.helion.util.ArtifactConfigUtil;
import com.cloderia.helion.util.IDEConstants;
import com.cloderia.ide.config.PipelineContextConfig;

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
	public static Pipeline getInstance(BuildContext context) throws HelionException {
		try {
			PipelineContextConfig contextConfig = (PipelineContextConfig) context.getContextConfig();
			String pipelineClassName = ArtifactConfigUtil.getConfigParameterValue(IDEConstants.PIPELINE_CLASS_PARAM, contextConfig);
			
			Pipeline pipeline = (Pipeline) Class.forName(pipelineClassName).newInstance();
			pipeline.setItems(PipelineItemsFactory.getPipelineItems(contextConfig));
			
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
