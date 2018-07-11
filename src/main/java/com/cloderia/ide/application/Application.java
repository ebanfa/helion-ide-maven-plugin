/**
 * 
 */
package com.cloderia.ide.application;

import java.util.List;

import com.cloderia.ide.Artifact;
import com.cloderia.ide.module.Module;

/**
 * Represents an abstract definition of an application.
 * 
 * @author Edward Banfa
 */
public interface Application extends Artifact {
	
	/**
	 * @return List of shared modules
	 */
	public <T extends Module> List<T> getModules();
}
