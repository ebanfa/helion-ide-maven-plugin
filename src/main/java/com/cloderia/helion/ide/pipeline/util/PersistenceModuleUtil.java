/**
 * 
 */
package com.cloderia.helion.ide.pipeline.util;

import com.cloderia.helion.ide.model.Module;

/**
 * @author Edward Banfa
 *
 */
public class PersistenceModuleUtil {
	
	public static final String PERSISTENCE_MODULE = "persistence";

	/**
	 * Returns true if this is a persistence module
	 * 
	 * @param module
	 * @return
	 */
	public static Boolean isPersistenceModule(Module module) {
		return module.getType().equals(PERSISTENCE_MODULE) ? true: false;
	}

}
