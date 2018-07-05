/**
 * 
 */
package com.cloderia.helion.pipeline;

import java.util.List;

import com.cloderia.helion.model.application.Application;
import com.cloderia.helion.model.module.SharedModule;
import com.cloderia.helion.model.pipeline.PipelineContext;

/**
 * @author Edward Banfa
 *
 */
public abstract class AbstractSharedModuleProcessor<T extends SharedModule> extends AbstractModuleProcessor<T> {

	protected AbstractSharedModuleProcessor(Class<T> moduleImplClass) {
		super(moduleImplClass);
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.AbstractModuleProcessor#getModules(com.cloderia.helion.model.application.Application, com.cloderia.helion.model.pipeline.PipelineContext)
	 */
	@Override
	protected List<T> getModules(Application application, PipelineContext context) {
		return application.getSharedModules();
	}

}
