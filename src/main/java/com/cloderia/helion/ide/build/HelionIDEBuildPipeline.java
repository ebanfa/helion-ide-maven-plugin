/**
 * 
 */
package com.cloderia.helion.ide.build;

import java.util.List;

import com.cloderia.helion.ide.build.processors.BuildProcessor;

/**
 * @author adrian
 *
 */
public class HelionIDEBuildPipeline extends AbstractBuildPipeline<BuildContext> {

	public HelionIDEBuildPipeline(List<BuildProcessor<BuildContext>> processors) {
		this.pipeline = processors;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HelionIDEBuildPipeline [pipeline=" + pipeline + "]";
	}

}
