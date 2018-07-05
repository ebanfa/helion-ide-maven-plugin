/**
 * 
 */
package com.cloderia.helion.pipeline;

import com.cloderia.helion.exception.HelionException;
import com.cloderia.helion.exception.PipelineException;
import com.cloderia.helion.model.pipeline.AbstractPipelineItem;
import com.cloderia.helion.model.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.util.DBUtil;
import com.cloderia.helion.util.IDEConstants;

/**
 * This class loads entity definitions from a database.
 * More specifically for an entity artifact is generated 
 * for each database table found in database we are reverse engineering
 * 
 * @author adrian
 */
public class DBEntitiesLoader extends AbstractPipelineItem {

	@Override
	protected PipelineContext doExecute(PipelineContext context) {
		try {
			context.setContextDataItem(IDEConstants.ENTITIES_IN_DB_CONTEXT_KEY, DBUtil.loadEntitiesFromDB(context));
		} catch (HelionException e) {
			throw new PipelineException(e);
		}
		return context;
	}
}
