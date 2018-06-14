/**
 * 
 */
package com.cloderia.helion.util;

import com.cloderia.helion.model.Module;
import com.cloderia.helion.pipeline.PipelineContext;

/**
 * @author adrian
 *
 */
public class ModuleUtil {

	public static final String WEB_MODULE = "web";
	public static final String SERVICE_MODULE = "service";
	public static final String STANDARD_MODULE = "standard";
	public static final String PERSISTENCE_MODULE = "persistence";
	
	/**
	 * Returns true if this is a standard module
	 * @param module
	 * @return
	 */
	public static Boolean isStandardModule(Module module) {
		if(module.getType().equals(STANDARD_MODULE)) 
			return true;
		return false;
	}
	
	/**
	 * Returns true if this is a persistence module
	 * @param module
	 * @return
	 */
	public static Boolean isPersistenceModule(Module module) {
		if(module.getType().equals(PERSISTENCE_MODULE)) 
			return true;
		return false;
	}
	
	/**
	 * Returns true if this is a service module
	 * @param module
	 * @return
	 */
	public static Boolean isServiceModule(Module module) {
		if(module.getType().equals(SERVICE_MODULE)) 
			return true;
		return false;
	}
	
	/**
	 * Returns true if this is a web module
	 * @param module
	 * @return
	 */
	public static Boolean isWebModule(Module module) {
		if(module.getType().equals(WEB_MODULE)) 
			return true;
		return false;
	}

}
