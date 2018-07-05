/**
 * 
 */
package com.cloderia.helion.pipeline.maven;

import java.util.List;

import com.cloderia.helion.exception.HelionException;
import com.cloderia.helion.exception.PipelineException;
import com.cloderia.helion.model.entity.Entity;
import com.cloderia.helion.model.module.EjbDataModule;
import com.cloderia.helion.model.module.Module;
import com.cloderia.helion.model.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.AbstractDataModuleProcessor;
import com.cloderia.helion.pipeline.util.EjbDataModuleUtil;
import com.cloderia.helion.util.IDEConstants;

/**
 * @author Edward Banfa
 */
public class EjbDataModuleProcessor extends AbstractDataModuleProcessor<EjbDataModule> {
	
	public EjbDataModuleProcessor() {
		super(EjbDataModule.class);
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.AbstractModuleProcessor#processDataModule(com.cloderia.helion.model.module.Module, com.cloderia.helion.model.pipeline.PipelineContext)
	 */
	@Override
	public Module doProcessModule(Module module, PipelineContext context) throws HelionException {
		try {
			// Sort the entities loaded from the db into their parent module
			List<Entity> entitiesInDB = (List<Entity>) context.getContextDataItem(IDEConstants.ENTITIES_IN_DB_CONTEXT_KEY);
			// Load the entities into the module and generate the entity related java source files
			module = EjbDataModuleUtil.loadEntitiesIntoModule(module, entitiesInDB, context);
			EjbDataModuleUtil.generateEJBDataArtifacts(module, context);
			return module;
		} catch (HelionException e) {
			throw new PipelineException(e);
		}
	}
}
