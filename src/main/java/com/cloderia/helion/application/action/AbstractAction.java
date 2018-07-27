/**
 * 
 */
package com.cloderia.helion.application.action;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.application.model.Component;
import com.cloderia.helion.config.Artifact;
import com.cloderia.helion.context.Context;

/**
 * @author Edward Banfa
 *
 */
public abstract class AbstractAction implements Action {

	private Artifact config;
	
	/**
	 * @return the config
	 */
	public Artifact getConfig() {
		return config;
	}

	/**
	 * @param config the config to set
	 */
	public void setConfig(Artifact config) {
		this.config = config;
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.application.action.Action#execute(com.cloderia.helion.context.Context, com.cloderia.helion.application.model.Component, java.util.List)
	 */
	@Override
	public void execute(Component artifact, Context context) throws HelionException {
		this.doExecute(artifact, context);
	}
	
	public abstract void doExecute(Component artifact, Context context) throws HelionException;
}
