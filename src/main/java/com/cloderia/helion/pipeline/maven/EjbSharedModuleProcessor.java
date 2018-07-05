/**
 * 
 */
package com.cloderia.helion.pipeline.maven;

import com.cloderia.helion.model.module.EjbSharedModule;
import com.cloderia.helion.pipeline.AbstractSharedModuleProcessor;

/**
 * @author Edward Banfa
 */
public class EjbSharedModuleProcessor extends AbstractSharedModuleProcessor<EjbSharedModule> {

	public EjbSharedModuleProcessor() {
		super(EjbSharedModule.class);
	}

}
