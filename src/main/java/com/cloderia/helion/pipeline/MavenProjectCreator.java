/**
 * 
 */
package com.cloderia.helion.pipeline;

import com.cloderia.ide.config.PipelineItemConfig;
import com.cloderia.ide.pipeline.AbstractPipelineItem;
import com.cloderia.ide.pipeline.PipelineContext;

/**
 * @author Edward Banfa
 *
 */
public class MavenProjectCreator extends AbstractPipelineItem {

	public MavenProjectCreator(PipelineItemConfig config) {
		super(config);
	}

	/* (non-Javadoc)
	 * @see com.cloderia.ide.pipeline.AbstractPipelineItem#doExecute(com.cloderia.ide.pipeline.PipelineContext)
	 */
	@Override
	protected PipelineContext doExecute(PipelineContext context) {
		return context;
	}

}
