/**
 * 
 */
package com.cloderia.helion.ide.pipeline;

import java.util.List;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.ide.model.Entity;
import com.cloderia.helion.ide.model.Module;
import com.cloderia.helion.ide.pipeline.util.DBUtil;
import com.cloderia.helion.ide.pipeline.util.EJBDataModuleUtil;
import com.cloderia.helion.ide.pipeline.util.ModuleUtil;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.PipelineException;

/**
 * @author Edward Banfa
 *
 */
public class EJBDataModuleProcessor extends ModulePipelineItem {
	private List<Entity> entitiesInDB = null;
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.pipeline.ModulePipelineItem#doExecute(com.cloderia.helion.pipeline.PipelineContext)
	 */
	@Override
	protected PipelineContext doExecute(PipelineContext context) {
		try {
			// List of entities reversed engineered from the database
			entitiesInDB = DBUtil.loadEntitiesFromDB(context);
			context.put(IDEConstants.ENTITIES_IN_DB_CONTEXT_KEY, entitiesInDB);
			return super.doExecute(context);
		} catch (HelionException e) {
			throw new PipelineException(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.pipeline.ModulePipelineItem#processModule(com.cloderia.helion.ide.model.Module, com.cloderia.helion.pipeline.PipelineContext)
	 */
	@Override
	protected Module processModule(Module module, PipelineContext context) {
		// If the module is not a data module then return
		if(!ModuleUtil.isDataModule(module)) return module;
		try {
			// Sort the entities loaded from the db into their parent module
			module = EJBDataModuleUtil.loadEntitiesIntoModule(module, entitiesInDB, context); 
			// Generate the required EJB entity artifacts
			EJBDataModuleUtil.generateEJBDataArtifacts(module, context);
			return module;
		} catch (HelionException e) {
			throw new PipelineException(e);
		}
	}


}
