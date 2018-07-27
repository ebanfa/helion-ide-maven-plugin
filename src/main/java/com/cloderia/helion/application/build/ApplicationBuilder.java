/**
 * 
 */
package com.cloderia.helion.application.build;

import com.cloderia.helion.application.model.Container;
import com.cloderia.helion.config.Artifact;
import com.cloderia.helion.context.Context;

/**
 * @author Edward Banfa
 */
public interface ApplicationBuilder {
		
	/**
	 * @param config
	 * @param context 
	 * @return
	 */
	public Container build(Artifact applicationConfig, Context context);
}
