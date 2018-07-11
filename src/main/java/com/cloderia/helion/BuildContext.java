/**
 * 
 */
package com.cloderia.helion;

import java.util.Map;

import com.cloderia.ide.Artifact;
import com.cloderia.ide.config.ContextConfig;

/**
 * @author Edward Banfa
 *
 */
public interface BuildContext extends Artifact {
	
	/**
	 * @return
	 */
	public ContextConfig getContextConfig();
	
	/**
	 * @param contextConfig
	 */
	public void setContextConfig(ContextConfig contextConfig);
	
	/**
	 * @return
	 */
	public Map<String, Object> getContextData();
	
	/**
	 * @param contextData
	 */
	public void setContextData(Map<String, Object> contextData);
}
