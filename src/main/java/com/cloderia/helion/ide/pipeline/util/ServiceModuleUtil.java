/**
 * 
 */
package com.cloderia.helion.ide.pipeline.util;

import com.cloderia.helion.ide.model.Module;

/**
 * @author Edward Banfa
 *
 */
public class ServiceModuleUtil {

	public static final String SERVICE_MODULE = "service";

	/**
	 * Returns true if this is a service module
	 * 
	 * @param module
	 * @return
	 */
	public static Boolean isServiceModule(Module module) {
		return module.getType().equals(SERVICE_MODULE) ? true: false;
	}

}
