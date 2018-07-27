/**
 * 
 */
package com.cloderia.helion.context;

import java.util.HashMap;
import java.util.Map;

import com.cloderia.helion.config.Artifact;

/**
 * @author Edward Banfa
 *
 */
public class AbstractContext implements Context {


	private Artifact contextConfig;

	/** Generic data context */
	private Map<String, Object> contextData = new HashMap<String, Object>();
	

	/**
	 * @param config
	 */
	public AbstractContext() {
		super();
	}
	
	/**
	 * @param config
	 */
	public AbstractContext(Artifact config) {
		this.contextConfig = config;
				
	}

	/**
	 * @return the contextConfig
	 */
	public Artifact getContextConfig() {
		return contextConfig;
	}

	/**
	 * @param contextConfig the contextConfig to set
	 */
	public void setContextConfig(Artifact contextConfig) {
		this.contextConfig = contextConfig;
	}

	/**
	 * @return the contextData
	 */
	public Object getContextDataItem(String key) {
		return contextData.get(key);
	}

	/**
	 * @param contextData the contextData to set
	 */
	public void setContextDataItem(String key, Object contextData) {
		this.contextData.put(key, contextData);
	}

	/**
	 * @return the contextData
	 */
	public Map<String, Object> getContextData() {
		return contextData;
	}
}
