/**
 * 
 */
package com.cloderia.ide;

/**
 * An artifact is an abstract application building block.
 * Modules and entities are examples of application artifacts.
 * 
 * @author Edward Banfa
 */
public interface Artifact {
	
	/**
	 * @return the id
	 */
	public String getId();
	
	/**
	 * @return
	 */
	public String getName();
	
	/**
	 * @return the className
	 */
	public String getClassName();

	/**
	 * @return the packageName
	 */
	public String getPackageName();
	
	/**
	 * @return the title
	 */
	public String getTitle();
	
	/**
	 * @return the description
	 */
	public String getDescription();
	
	/**
	 * @return
	 */
	public String getVersion();
	
	/**
	 * @return
	 */
	public String getArtifactType();
}
