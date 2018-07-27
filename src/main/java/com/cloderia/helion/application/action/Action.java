/**
 * 
 */
package com.cloderia.helion.application.action;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.application.model.Component;
import com.cloderia.helion.context.Context;

/**
 * @author Edward Banfa
 *
 */
public interface Action {
	
	/**
	 * @param artifact
	 * @param context
	 * @throws HelionException
	 */
	public void execute(Component artifact, Context context) throws HelionException;

}
