/**
 * 
 */
package com.cloderia.helion.pipeline;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.config.Artifact;
import com.cloderia.helion.context.PipelineContext;


/**
 * @author adrian
 *
 */
public abstract class AbstractPipelineItem implements PipelineItem {

	private Artifact config;
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.PipelineItem#execute(com.cloderia.helion.pipeline.PipelineContext)
	 */
	@Override
	public PipelineContext execute(PipelineContext context) {
		return doExecute(context);
	}
	
	/**
	 * @return the config
	 */
	public Artifact getConfig() {
		return config;
	}
	
	/**
	 * @param config the config to set
	 */
	public void setConfig(Artifact config) {
		this.config = config;
	}
	
	/**
	 * @param context
	 * @return
	 * @throws HelionException
	 */
	protected abstract PipelineContext doExecute(PipelineContext context);
}
