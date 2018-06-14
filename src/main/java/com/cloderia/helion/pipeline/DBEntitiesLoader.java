/**
 * 
 */
package com.cloderia.helion.pipeline;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.util.DBUtil;
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
	protected PipelineContext doExecute(PipelineContext context) throws HelionException {
		context.put(IDEConstants.ENTITIES_IN_DB_CONTEXT_KEY, DBUtil.loadEntitiesFromDB(context));
		return context;
	}
}
