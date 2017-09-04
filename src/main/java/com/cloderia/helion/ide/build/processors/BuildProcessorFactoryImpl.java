/**
 * 
 */
package com.cloderia.helion.ide.build.processors;

import com.cloderia.helion.ide.ObjectFactory;
import com.cloderia.helion.ide.build.BuildContext;

/**
 * @author adrian
 *
 */
public class BuildProcessorFactoryImpl<T extends BuildProcessor<BuildContext>> implements ObjectFactory<T> {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.build.ObjectFactory#getInstance(java.lang.String)
	 */
	public T getInstance(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
