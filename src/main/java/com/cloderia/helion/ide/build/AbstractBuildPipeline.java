/**
 * 
 */
package com.cloderia.helion.ide.build;

import java.util.ArrayList;
import java.util.List;

import com.cloderia.helion.ide.build.processors.BuildProcessor;

/**
 * @author adrian
 *
 */
public abstract class AbstractBuildPipeline<T extends BuildContext> implements BuildPipeline<T> {

	protected List<BuildProcessor<T>> pipeline = new ArrayList<BuildProcessor<T>>();

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.build.BuildPipeline#build(com.cloderia.helion.ide.build.BuildContext)
	 */
	public T build(T context) {
		T processed = context;
        for (BuildProcessor<T> processor : pipeline) {
        	processed = processor.build(context);
        }
        return processed;
	}
}
