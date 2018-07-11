/**
 * 
 */
package com.cloderia.helion.pipeline;

import com.cloderia.helion.exception.HelionException;
import com.cloderia.helion.exception.PipelineException;
import com.cloderia.helion.pipeline.util.ConfigurationUtil;
import com.cloderia.helion.util.ArtifactConfigUtil;
import com.cloderia.ide.config.ApplicationLite;
import com.cloderia.ide.config.PipelineItemConfig;
import com.cloderia.ide.pipeline.AbstractPipelineItem;
import com.cloderia.ide.pipeline.PipelineContext;

/**
 * @author Edward Banfa
 *
 */
public class XMLApplicationReader extends AbstractPipelineItem {

	public XMLApplicationReader(PipelineItemConfig config) {
		super(config);
	}

	/* (non-Javadoc)
	 * @see com.cloderia.ide.pipeline.AbstractPipelineItem#doExecute(com.cloderia.ide.pipeline.PipelineContext)
	 */
	@Override
	protected PipelineContext doExecute(PipelineContext context) {
		String applicationConfigFile = ArtifactConfigUtil.getConfigParameterValue("applicationConfigFile", this.getConfig());
		try {
			ApplicationLite applicationConfiguration = ConfigurationUtil.readApplicationLite(applicationConfigFile);
			//context.setApplicationLite(applicationConfiguration);
		} catch (HelionException e) {
			throw new PipelineException(e);
		}
		return context;
	}

}
