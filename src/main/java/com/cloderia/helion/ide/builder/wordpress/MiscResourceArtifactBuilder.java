/**
 * 
 */
package com.cloderia.helion.ide.builder.wordpress;

import com.cloderia.helion.ide.app.Application;
import com.cloderia.helion.ide.builder.AbstractArtifactBuilder;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public class MiscResourceArtifactBuilder extends AbstractArtifactBuilder {
	
	public static final String DDL_SQL = "ddl.sql";
	public static final String DDL_SQL_FTL = "sql/ddl-sql.ftl";

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.ArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public void build(BuildConfiguration buildConfiguration) throws IDEException {
		String targetDir = buildConfiguration.getTargetDir();
		Application application = buildConfiguration.getApplication();
		// DDL SQL file
		this.generateArtifact(buildConfiguration, application, DDL_SQL_FTL, DDL_SQL, targetDir.concat(IDEConstants.WP_SQL_DIR));

	}

}