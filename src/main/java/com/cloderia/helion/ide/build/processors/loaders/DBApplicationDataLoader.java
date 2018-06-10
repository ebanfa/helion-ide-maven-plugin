/**
 * 
 */
package com.cloderia.helion.ide.build.processors.loaders;

import com.cloderia.helion.ide.IDEException;
import com.cloderia.helion.ide.artifacts.Application;
import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator;
import com.cloderia.helion.ide.build.processors.BuildProcessor;
import com.cloderia.helion.ide.util.DBUtil;
import com.cloderia.helion.ide.util.IDEConstants;

/**
 * @author adrian
 *
 */
public class DBApplicationDataLoader extends AbstractBuildProcessorDecorator {


	public DBApplicationDataLoader(BuildProcessor<BuildContext> processor) {
		super(processor);
	}

	/*
	 * @see
	 * com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator#
	 * decorate(com.cloderia.helion.ide.build.BuildContext)
	 */
	@Override
	public BuildContext decorate(BuildContext context) throws IDEException{
		context.put(IDEConstants.ENTITIES_IN_DB_CONTEXT_KEY, DBUtil.loadEntitiesFromDB(context));
		return context;
	}

}
