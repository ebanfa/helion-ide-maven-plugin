/**
 * 
 */
package com.cloderia.helion.model.entity;

/**
 * @author Edward Banfa
 */
public class JPAEntityField extends AbstractField {

	private String javaName;
	
	/**
	 * @return the javaName
	 */
	public String getJavaName() {
		return javaName;
	}

	/**
	 * @param javaName the javaName to set
	 */
	public void setJavaName(String javaName) {
		this.javaName = javaName;
	}
}
