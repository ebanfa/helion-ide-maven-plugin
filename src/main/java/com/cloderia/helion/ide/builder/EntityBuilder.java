/**
 * 
 */
package com.cloderia.helion.ide.builder;

import com.cloderia.helion.ide.app.Entity;
import com.cloderia.helion.ide.app.Module;

/**
 * @author adrian
 *
 */
public interface EntityBuilder {

	/**
	 * @param entity
	 */
	public void build(BuilderConfig config, Module module);
	
	/**
	 * @param entity
	 */
	public void build(BuilderConfig config, Entity entity);
}
