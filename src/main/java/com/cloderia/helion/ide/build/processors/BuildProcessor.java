/**
 * 
 */
package com.cloderia.helion.ide.build.processors;

import com.cloderia.helion.ide.build.BuildContext;

/**
 * @author adrian
 *
 */
public interface BuildProcessor<T extends BuildContext> {

	/**
	 * @param context
	 */
	public T build(T context);
}
