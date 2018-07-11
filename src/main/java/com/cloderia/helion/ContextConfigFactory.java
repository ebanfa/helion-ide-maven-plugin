/**
 * 
 */
package com.cloderia.helion;

import com.cloderia.helion.exception.HelionException;
import com.cloderia.helion.pipeline.util.ConfigurationUtil;
import com.cloderia.ide.config.ContextConfig;

/**
 * @author Edward Banfa
 *
 */
public class ContextConfigFactory {

	/**
	 * @param contextConfigClass
	 * @return
	 * @throws HelionException
	 */
	public static <T extends ContextConfig>  T getInstance(String configurationFile, String configurationClass) throws HelionException {
		try {
			Class<T> clazz = (Class<T>) Class.forName(configurationClass);
			return ConfigurationUtil.loadContextConfiguration(configurationFile, clazz);
		} catch (ClassNotFoundException e) {
			throw new HelionException(e);
		}
	}

}
