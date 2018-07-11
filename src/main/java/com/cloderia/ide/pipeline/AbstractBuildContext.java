/**
 * 
 */
package com.cloderia.ide.pipeline;

import java.util.HashMap;
import java.util.Map;

import com.cloderia.ide.AbstractArtifact;
import com.cloderia.ide.config.ContextConfig;
import com.cloderia.ide.config.PipelineContextConfig;

/**
 * @author Edward Banfa
 *
 */
public class AbstractBuildContext extends AbstractArtifact {
	
	private ContextConfig contextConfig;

	/** Generic data context */
	private Map<String, Object> contextData = new HashMap<String, Object>();

	/**
	 * 
	 */
	public AbstractBuildContext(ContextConfig contextConfig) {
		this.contextConfig = contextConfig;
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.ide.Artifact#getArtifactType()
	 */
	@Override
	public String getArtifactType() {
		return "buildContext";
	}

	/**
	 * @return the contextConfig
	 */
	public ContextConfig getContextConfig() {
		return contextConfig;
	}

	/**
	 * @param contextConfig the contextConfig to set
	 */
	public void setContextConfig(ContextConfig contextConfig) {
		this.contextConfig = contextConfig;
	}

	/**
	 * @return the contextData
	 */
	public Map<String, Object> getContextData() {
		return contextData;
	}

	/**
	 * @param contextData the contextData to set
	 */
	public void setContextData(Map<String, Object> contextData) {
		this.contextData = contextData;
	}

}
