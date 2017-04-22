/**
 * 
 */
package com.cloderia.helion.ide.builder.wordpress;

import com.cloderia.helion.ide.app.Application;

import com.cloderia.helion.ide.builder.AbstractArtifactBuilder;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEException;
import com.cloderia.helion.ide.util.IDEUtils;

/**
 * @author adrian
 *
 */
public class PluginDirectoryBuilder extends AbstractArtifactBuilder {
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.ArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public void build(BuildConfiguration buildConfiguration) throws IDEException {
		String baseDir = buildConfiguration.getProjectDir();
		String targetDir = buildConfiguration.getTargetDir();
		Application application = buildConfiguration.getApplication();
		String destinationDir = baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR.concat(IDEConstants.WP_APP_RESOURCE_DIR));
		
		IDEUtils.deleteDir(targetDir);
		IDEUtils.createDirectoryIfNeeded(targetDir);
		IDEUtils.createDirectoryIfNeeded(targetDir.concat(IDEConstants.WP_MODEL_DIR));
		IDEUtils.createDirectoryIfNeeded(targetDir.concat(IDEConstants.WP_PERSISTENCE_DIR));
		IDEUtils.createDirectoryIfNeeded(targetDir.concat(IDEConstants.WP_PROCESS_DIR));
		IDEUtils.createDirectoryIfNeeded(targetDir.concat(IDEConstants.WP_SERVICE_DIR));
		IDEUtils.createDirectoryIfNeeded(targetDir.concat(IDEConstants.WP_COMMAND_DIR));
		IDEUtils.createDirectoryIfNeeded(targetDir.concat(IDEConstants.WP_CONTROLLER_DIR));
		IDEUtils.createDirectoryIfNeeded(targetDir.concat(IDEConstants.WP_UI_DIR));
		IDEUtils.createDirectoryIfNeeded(targetDir.concat(IDEConstants.WP_SQL_DIR));
		IDEUtils.createDirectoryIfNeeded(targetDir.concat(IDEConstants.WP_UTIL_DIR));
		IDEUtils.createDirectoryIfNeeded(targetDir.concat(IDEConstants.WP_FONT_DIR));
		IDEUtils.createDirectoryIfNeeded(targetDir.concat(IDEConstants.WP_HTML_TEMPLATES_DIR));
		IDEUtils.createDirectoryIfNeeded(targetDir.concat(IDEConstants.WP_PAGE_HTML_TEMPLATES_DIR));
		IDEUtils.createDirectoryIfNeeded(targetDir.concat(IDEConstants.WP_ENTITY_HTML_TEMPLATES_DIR));
		IDEUtils.createDirectoryIfNeeded(targetDir.concat(IDEConstants.WP_UICOMPONENT_TEMPLATES_DIR));
		IDEUtils.createDirectoryIfNeeded(targetDir.concat(IDEConstants.WP_UICOMPONENT_HTML_TEMPLATES_DIR));
		IDEUtils.createDirectoryIfNeeded(targetDir.concat(IDEConstants.WP_EMAIL_TEMPLATES_DIR));
		
		IDEUtils.copyDirectory(destinationDir.concat(IDEConstants.WP_EVENT_DIR), targetDir.concat(IDEConstants.WP_EVENT_DIR));
		IDEUtils.copyDirectory(destinationDir.concat(IDEConstants.WP_MODEL_DIR), targetDir.concat(IDEConstants.WP_MODEL_DIR));
		IDEUtils.copyDirectory(destinationDir.concat(IDEConstants.WP_PERSISTENCE_DIR), targetDir.concat(IDEConstants.WP_PERSISTENCE_DIR));
		IDEUtils.copyDirectory(destinationDir.concat(IDEConstants.WP_PROCESS_DIR), targetDir.concat(IDEConstants.WP_PROCESS_DIR));
		IDEUtils.copyDirectory(destinationDir.concat(IDEConstants.WP_SERVICE_DIR), targetDir.concat(IDEConstants.WP_SERVICE_DIR));
		IDEUtils.copyDirectory(destinationDir.concat(IDEConstants.WP_COMMAND_DIR), targetDir.concat(IDEConstants.WP_COMMAND_DIR));
		IDEUtils.copyDirectory(destinationDir.concat(IDEConstants.WP_CONTROLLER_DIR), targetDir.concat(IDEConstants.WP_CONTROLLER_DIR));
		IDEUtils.copyDirectory(destinationDir.concat(IDEConstants.WP_UI_DIR), targetDir.concat(IDEConstants.WP_UI_DIR));
		IDEUtils.copyDirectory(destinationDir.concat(IDEConstants.WP_UTIL_DIR), targetDir.concat(IDEConstants.WP_UTIL_DIR));
		IDEUtils.copyDirectory(destinationDir.concat(IDEConstants.WP_EXCEPTION_DIR), targetDir.concat(IDEConstants.WP_EXCEPTION_DIR));
		/* Resources */
		IDEUtils.copyDirectory(destinationDir.concat(IDEConstants.WP_CSS_DIR), targetDir.concat(IDEConstants.WP_CSS_DIR));
		IDEUtils.copyDirectory(destinationDir.concat(IDEConstants.WP_FONT_DIR), targetDir.concat(IDEConstants.WP_FONT_DIR));
		IDEUtils.copyDirectory(destinationDir.concat(IDEConstants.WP_IMAGES_DIR), targetDir.concat(IDEConstants.WP_IMAGES_DIR));
		IDEUtils.copyDirectory(destinationDir.concat(IDEConstants.WP_JS_DIR), targetDir.concat(IDEConstants.WP_JS_DIR));
		IDEUtils.copyDirectory(destinationDir.concat(IDEConstants.WP_SQL_DIR), targetDir.concat(IDEConstants.WP_SQL_DIR));
		IDEUtils.copyDirectory(destinationDir.concat(IDEConstants.WP_VENDOR_DIR), targetDir.concat(IDEConstants.WP_VENDOR_DIR));

		String artifactDir = application.getArtifactId().concat("/");
		String templatesDir = application.getTemplatesDir().concat("/wp-ee-ua/");
		String emailsDir = templatesDir.concat(artifactDir);
		IDEUtils.copyDirectory(emailsDir.concat("emails/"), targetDir.concat(IDEConstants.WP_EMAIL_TEMPLATES_DIR));

	}

}
