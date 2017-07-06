/**
 * 
 */
package com.cloderia.helion.ide.builder.errai;

import java.util.Collections;

import com.cloderia.helion.ide.artifact.Application;
import com.cloderia.helion.ide.builder.AbstractArtifactProcessor;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.BuilderUtils;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public class MiscResourceArtifactBuilder extends AbstractArtifactProcessor {
	
	public static final String DDL_SQL = "ddl.sql";
	public static final String DDL_SQL_FTL = "sql/ddl-sql.ftl";

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.ArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public void execute(BuildConfiguration buildConfiguration) throws IDEException {
		String targetDir = buildConfiguration.getTargetDir();
		Application application = buildConfiguration.getApplication();

		//Collections.reverse(application.getModules());
		BuilderUtils.generateArtifact(buildConfiguration, application, DDL_SQL_FTL, DDL_SQL, targetDir.concat(IDEConstants.WP_SQL_DIR));
	}

}
