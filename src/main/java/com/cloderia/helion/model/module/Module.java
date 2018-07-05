/**
 * 
 */
package com.cloderia.helion.model.module;

import java.util.List;

import com.cloderia.helion.model.Artifact;
import com.cloderia.helion.model.entity.Entity;

/**
 * Represents an application module.
 * 
 * @author Edward Banfa
 */
public interface Module extends Artifact {
	
	/**
	 * For use by components outside the JVM (e.g template files)
	 * @return
	 */
	public String getType();
	
	/**
	 * @return the entities
	 */
	public <T extends Entity> List<T> getEntities();


}
