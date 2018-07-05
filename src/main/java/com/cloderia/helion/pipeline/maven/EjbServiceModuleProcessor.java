/**
 * 
 */
package com.cloderia.helion.pipeline.maven;

import com.cloderia.helion.model.module.EjbServiceModule;
import com.cloderia.helion.pipeline.AbstractServiceModuleProcessor;

/**
 * @author Edward Banfa
 */
public class EjbServiceModuleProcessor extends AbstractServiceModuleProcessor<EjbServiceModule> {

	public EjbServiceModuleProcessor() {
		super(EjbServiceModule.class);
	}

}
