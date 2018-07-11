/**
 * 
 */
package com.cloderia.ide.application;

import com.cloderia.ide.config.ApplicationLite;
import com.cloderia.ide.module.ejb.EjbModule;

/**
 * @author Edward Banfa
 */
public class EjbApplication extends AbstractApplication<EjbModule> {

	public EjbApplication(ApplicationLite configuration) {
		super(configuration);
	}

}
