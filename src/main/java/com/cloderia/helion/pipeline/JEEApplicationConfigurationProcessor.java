/**
 * 
 */
package com.cloderia.helion.pipeline;

import com.cloderia.helion.model.application.Application;
import com.cloderia.helion.model.application.JEEApplication;
import com.cloderia.helion.model.database.JEEDataBase;
import com.cloderia.helion.model.pipeline.PipelineContext;
import com.cloderia.helion.util.ArtifactConfigUtil;
import com.cloderia.helion.util.IDEConstants;

/**
 * This pipeline item loads the modules configured for this application.
 * 
 * @author Edward Banfa
 */
public class JEEApplicationConfigurationProcessor extends AbstractApplicationProcessor {



	@Override
	public Class<JEEApplication> getApplicationClass(PipelineContext context) {
		return JEEApplication.class;
	}

	@Override
	public JEEDataBase getDatabaseInstance(Application application, PipelineContext context) {
		JEEDataBase database = new JEEDataBase();
		database.setDataSource(ArtifactConfigUtil.getConfigParameterValue(IDEConstants.DB_JNDI_URL_CONFIG_PARAM, application));
		return database;
	}

}
