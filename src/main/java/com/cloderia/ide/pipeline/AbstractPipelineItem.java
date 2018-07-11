/**
 * 
 */
package com.cloderia.ide.pipeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloderia.helion.exception.HelionException;
import com.cloderia.ide.config.PipelineItemConfig;


/**
 * @author adrian
 *
 */
public abstract class AbstractPipelineItem implements PipelineItem {

	private PipelineItemConfig config;
	private static Logger logger = LoggerFactory.getLogger(AbstractPipelineItem.class);
	
	public AbstractPipelineItem(PipelineItemConfig config) {
		this.config = config;
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.PipelineItem#execute(com.cloderia.helion.pipeline.PipelineContext)
	 */
	@Override
	public PipelineContext execute(PipelineContext context) {
		logger.debug("Executing pipeline item " + this);
		return doExecute(context);
	}
	
	/**
	 * @return the config
	 */
	public PipelineItemConfig getConfig() {
		return config;
	}
	
	/**
	 * @param config the config to set
	 */
	public void setConfig(PipelineItemConfig config) {
		this.config = config;
	}
	
	/**
	 * @param context
	 * @return
	 * @throws HelionException
	 */
	protected abstract PipelineContext doExecute(PipelineContext context);
}
