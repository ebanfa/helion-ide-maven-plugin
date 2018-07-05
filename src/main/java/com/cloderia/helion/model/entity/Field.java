/**
 * 
 */
package com.cloderia.helion.model.entity;

import com.cloderia.helion.model.Artifact;

/**
 * @author Edward Banfa
 *
 */
public interface Field extends Artifact {

	/**
	 * @return the size
	 */
	public String getSize();
	
	/**
	 * @return the dataType
	 */
	public String getDataType();
	
	/**
	 * @return the required
	 */
	public boolean isRequired();
	
	/**
	 * @return the relationshipField
	 */
	public boolean isRelationshipField();
}
