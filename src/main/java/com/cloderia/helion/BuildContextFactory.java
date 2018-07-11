/**
 * 
 */
package com.cloderia.helion;

import java.lang.reflect.InvocationTargetException;

import com.cloderia.helion.exception.HelionException;
import com.cloderia.ide.config.ContextConfig;
import com.cloderia.ide.config.PipelineContextConfig;

/**
 * @author Edward Banfa
 *
 */
public class BuildContextFactory {
	
	/**
	 * @param contextConfig
	 * @return
	 * @throws HelionException 
	 */
	public static BuildContext getInstance(ContextConfig contextConfig) throws HelionException {
		try {
			BuildContext context = (BuildContext) Class.forName(contextConfig.getClassName())
					.getDeclaredConstructor(PipelineContextConfig.class)
					.newInstance(contextConfig);

			context.setContextConfig(contextConfig);
			return  context;
			
		} catch (InstantiationException e) {
			throw new HelionException(e);
		} catch (IllegalAccessException e) {
			throw new HelionException(e);
		} catch (ClassNotFoundException e) {
			throw new HelionException(e);
		} catch (IllegalArgumentException e) {
			throw new HelionException(e);
		} catch (InvocationTargetException e) {
			throw new HelionException(e);
		} catch (NoSuchMethodException e) {
			throw new HelionException(e);
		} catch (SecurityException e) {
			throw new HelionException(e);
		}
	}

}
