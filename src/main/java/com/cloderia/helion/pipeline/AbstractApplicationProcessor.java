/**
 * 
 */
package com.cloderia.helion.pipeline;

import com.cloderia.helion.exception.HelionException;
import com.cloderia.helion.exception.PipelineException;
import com.cloderia.helion.model.application.Application;
import com.cloderia.helion.model.database.AbstractDataBase;
import com.cloderia.helion.model.database.DataBase;
import com.cloderia.helion.model.pipeline.AbstractPipelineItem;
import com.cloderia.helion.model.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.util.ConfigurationUtil;
import com.cloderia.helion.util.ArtifactConfigUtil;
import com.cloderia.helion.util.IDEConstants;

/**
 * @author Edward Banfa
 *
 */
public abstract class AbstractApplicationProcessor extends AbstractPipelineItem {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.AbstractPipelineItem#doExecute(com.cloderia.helion.pipeline.PipelineContext)
	 */
	@Override
	protected PipelineContext doExecute(PipelineContext context) {
		try {
			Application application = ConfigurationUtil.loadApplication(
					context.getApplicationConfigFile(), this.getApplicationClass(context));
			application.setDataBase(initDatabaseData(application, context));
			
			context.setApplication(application);
		} catch (HelionException e) {
			throw new PipelineException(e);
		}
		return context;
	}

	/**
	 * @param application
	 */
	private DataBase initDatabaseData(Application application, PipelineContext context) {
		AbstractDataBase database = this.getDatabaseInstance(application, context);
		database.setId(ArtifactConfigUtil.getConfigParameterValue(IDEConstants.DB_ID_CONFIG_PARAM, application));
		database.setUrl(ArtifactConfigUtil.getConfigParameterValue(IDEConstants.DB_URL_CONFIG_PARAM, application));
		database.setUserName(ArtifactConfigUtil.getConfigParameterValue(IDEConstants.DB_USER_CONFIG_PARAM, application));
		database.setPassword(ArtifactConfigUtil.getConfigParameterValue(IDEConstants.DB_PASSWORD_CONFIG_PARAM, application));
		return database;
	}
	
	/**
	 * @return
	 */
	public abstract <T extends Application> Class<T> getApplicationClass(PipelineContext context); 
	
	/**
	 * @return
	 */
	public abstract <T extends DataBase> T getDatabaseInstance(Application application, PipelineContext context); 

}
