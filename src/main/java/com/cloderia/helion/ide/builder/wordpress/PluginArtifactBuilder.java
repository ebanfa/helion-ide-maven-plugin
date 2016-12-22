/**
 * 
 */
package com.cloderia.helion.ide.builder.wordpress;

import com.cloderia.helion.ide.app.Application;
import com.cloderia.helion.ide.builder.AbstractArtifactBuilder;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public class PluginArtifactBuilder extends AbstractArtifactBuilder {

	public static final String README_MD = "readme.md";
	public static final String INDEX_PHP = "index.php";
	public static final String INCLUDES_PHP = "includes.php";
	public static final String INDEX_TEMPLATE_FILE = "plugin/index-php.ftl";
	public static final String README_TEMPLATE_FILE = "plugin/readme-md.ftl";
	public static final String PLUGIN_TEMPLATE_FILE = "plugin/plugin-php.ftl";
	public static final String PLUGIN_INCLUDES_TEMPLATE_FILE = "plugin/plugin-includes-php.ftl";

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.ArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public void build(BuildConfiguration buildConfiguration) throws IDEException {
		String targetDir = buildConfiguration.getTargetDir();
		Application application = buildConfiguration.getApplication();
		this.generateArtifact(buildConfiguration, application, INDEX_TEMPLATE_FILE, INDEX_PHP, targetDir);
		this.generateArtifact(buildConfiguration, application, README_TEMPLATE_FILE, README_MD, targetDir);
		this.generateArtifact(buildConfiguration, application, PLUGIN_INCLUDES_TEMPLATE_FILE, INCLUDES_PHP, targetDir);
		this.generateArtifact(buildConfiguration, application, PLUGIN_TEMPLATE_FILE, application.getName().concat(".php"), targetDir);
	}
	

}
