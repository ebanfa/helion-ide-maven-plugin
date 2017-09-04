/**
 * 
 */
package com.cloderia.helion.ide.build.processors;

import com.cloderia.helion.ide.build.BuildContext;

/**
 * @author adrian
 *
 */
public abstract class AbstractBuildProcessor<T extends BuildContext> implements BuildProcessor<T> {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.build.BuildProcessor#build(com.cloderia.helion.ide.build.BuildContext)
	 */
	public T build(T context) {
		return doBuild(context);
	}
	
	protected abstract T doBuild(T context);
}
