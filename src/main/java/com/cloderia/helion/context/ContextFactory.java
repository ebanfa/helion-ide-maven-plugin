/**
 * 
 */
package com.cloderia.helion.context;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.config.Artifact;

/**
 * @author Edward Banfa
 *
 */
public class ContextFactory {
	
	/**
	 * @param contextConfig
	 * @return
	 * @throws HelionException 
	 */
	public static Context getInstance(Artifact contextConfig) throws HelionException {
		try {
			Context context = 
					(Context) Class.forName(contextConfig.getClassName()).newInstance();
			context.setContextConfig(contextConfig);
			return context;
			
		} catch (InstantiationException e) {
			throw new HelionException(e);
		} catch (IllegalAccessException e) {
			throw new HelionException(e);
		} catch (ClassNotFoundException e) {
			throw new HelionException(e);
		} catch (IllegalArgumentException e) {
			throw new HelionException(e);
		} catch (SecurityException e) {
			throw new HelionException(e);
		}
	}

}
