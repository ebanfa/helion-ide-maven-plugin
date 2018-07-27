/**
 * 
 */
package com.cloderia.helion.application.pipeline;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.HelionRuntimeException;
import com.cloderia.helion.application.config.ConfigurationReaderFactory;
import com.cloderia.helion.application.config.ConfigurationReader;
import com.cloderia.helion.config.Artifact;
import com.cloderia.helion.context.PipelineContext;
import com.cloderia.helion.pipeline.AbstractPipelineItem;
import com.cloderia.helion.util.IDEConstants;

/**
 * @author Edward Banfa
 */
public class ConfigurationProcessor extends AbstractPipelineItem {

	/* (non-Javadoc)
	 * @see com.cloderia.ide.pipeline.AbstractPipelineItem#doExecute(com.cloderia.ide.pipeline.PipelineContext)
	 */
	@Override
	protected PipelineContext doExecute(PipelineContext context) {
		try {
			ConfigurationReader reader = ConfigurationReaderFactory.getReader(getConfig());
			Artifact appConfigObject = reader.readConfiguration(getConfig());
			context.setContextDataItem(IDEConstants.APPLICATION_CONFIG_KEY, appConfigObject);
			
		} catch (HelionException e) {
			throw new HelionRuntimeException(e);
		}
		return context;
	}

}
