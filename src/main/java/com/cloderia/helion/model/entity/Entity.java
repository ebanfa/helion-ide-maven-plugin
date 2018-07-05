/**
 * 
 */
package com.cloderia.helion.model.entity;

import java.util.List;

import com.cloderia.helion.model.Artifact;
import com.cloderia.helion.model.module.Module;

/**
 * @author Edward Banfa
 */
public interface Entity extends Artifact {
	
	/**
	 * @return the fields
	 */
	public <T extends Field> List<T> getFields(); 
	
	/**
	 * @return the module
	 */
	public Module getModule();
	
	/**
	 * @param module the module to set
	 */
	public void setModule(Module module); 
}
