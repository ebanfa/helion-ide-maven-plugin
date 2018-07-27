/**
 * 
 */
package com.cloderia.helion.context;

import com.cloderia.helion.config.Artifact;

/**
 * @author Edward Banfa
 */
public class PipelineContext extends AbstractContext  {

	/**
	 * @param config
	 */
	public PipelineContext() {
		super();
	}
	
	/**
	 * @param config
	 */
	public PipelineContext(Artifact config) {
		super(config);
	}
}
