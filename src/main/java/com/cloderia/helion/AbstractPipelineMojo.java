/**
 * 
 */
package com.cloderia.helion;

import com.cloderia.helion.exception.HelionException;
import com.cloderia.ide.pipeline.PipelineFactory;

/**
 * @author Edward Banfa
 *
 */
public abstract class AbstractPipelineMojo extends AbstractHelionMojo {
	
	@Override
	protected void doExecute(BuildContext context) throws HelionException {
		PipelineFactory.getInstance(context).execute();
	}
	
}
