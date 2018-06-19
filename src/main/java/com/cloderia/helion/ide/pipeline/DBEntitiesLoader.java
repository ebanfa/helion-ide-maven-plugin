/**
 * 
 */
package com.cloderia.helion.ide.pipeline;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.ide.pipeline.util.DBUtil;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.pipeline.AbstractPipelineItem;
import com.cloderia.helion.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.PipelineException;

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
			context.put(IDEConstants.ENTITIES_IN_DB_CONTEXT_KEY, DBUtil.loadEntitiesFromDB(context));
		} catch (HelionException e) {
			throw new PipelineException(e);
		}
		return context;
	}
}
