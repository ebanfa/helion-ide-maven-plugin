/**
 * 
 */
package com.cloderia.ide.module;

import java.util.List;

import com.cloderia.ide.Artifact;

/**
 * Represents an application module.
 * 
 * @author Edward Banfa
 */
public interface Module extends Artifact {
	
	/**
	 * @return
	 */
	public <T extends SubModule> List<T> getSubModules();	
}
