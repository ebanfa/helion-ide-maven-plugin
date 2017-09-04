/**
 * 
 */
package com.cloderia.helion.ide.build;

/**
 * @author adrian
 *
 */
public interface BuildPipeline<T extends BuildContext> {
	
	/**
	 * @param context
	 */
	public T build(T context);
	
}
