/**
 * 
 */
package com.cloderia.helion.pipeline.maven;

import com.cloderia.helion.model.module.JavaWebModule;
import com.cloderia.helion.pipeline.AbstractWebModuleProcessor;

/**
 * @author Edward Banfa
 */
public class JavaWebModuleProcessor extends AbstractWebModuleProcessor<JavaWebModule> {

	public JavaWebModuleProcessor() {
		super(JavaWebModule.class);
	}
}
