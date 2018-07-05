/**
 * 
 */
package com.cloderia.helion.pipeline;

import java.util.List;

import com.cloderia.helion.model.application.Application;
import com.cloderia.helion.model.module.DataModule;
import com.cloderia.helion.model.pipeline.PipelineContext;

/**
 * @author Edward Banfa
 *
 */
public abstract class AbstractDataModuleProcessor<T extends DataModule> extends AbstractModuleProcessor<T> {
	
	protected AbstractDataModuleProcessor(Class<T> moduleImplClass) {
		super(moduleImplClass);
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.AbstractModuleProcessor#getModules(com.cloderia.helion.model.application.Application, com.cloderia.helion.model.pipeline.PipelineContext)
	 */
	@Override
	protected List<T> getModules(Application application, PipelineContext context) {
		return application.getDataModules();
	}

}
