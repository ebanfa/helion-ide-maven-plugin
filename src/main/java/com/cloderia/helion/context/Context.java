/**
 * 
 */
package com.cloderia.helion.context;

import com.cloderia.helion.config.Artifact;

/**
 * @author Edward Banfa
 *
 */
public interface Context {
	
	/**
	 * @return
	 */
	public Artifact getContextConfig();
	
	/**
	 * @param config
	 */
	public void setContextConfig(Artifact config);

}
