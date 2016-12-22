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
public class UtilArtifactBuilder extends AbstractArtifactBuilder {

	public static final String SERVICE_MAP_PHP = "ServiceMap.php";
	public static final String COMMAND_MAP_PHP = "ActionMap.php";
	public static final String MENU_MAP_PHP = "MenuMap.php";
	public static final String VIEW_MAP_PHP = "ViewMap.php";
	public static final String ENQUEUE_UTIL_PHP = "EnqueueUtil.php";
	public static final String TEMPLATE_LOADER_PHP = "TemplateLoader.php";
	public static final String UI_COMPONENT_MAP_PHP = "UIComponentMap.php";
	public static final String RESOURCE_BUNDLE_PHP = "ResourceBundle.php";
	public static final String MENU_MAP_TEMPLATE_FILE = "includes/util/menu-map-php.ftl";
	public static final String SERVICE_MAP_TEMPLATE_FILE = "includes/util/service-map-php.ftl";
	public static final String ENQUEUE_UTIL_TEMPLATE_FILE = "includes/util/enqueue-util-php.ftl";
	public static final String COMMAND_MAP_TEMPLATE_FILE = "includes/util/action-map-php.ftl";
	public static final String VIEW_MAP_TEMPLATE_FILE = "includes/util/view-map-php.ftl";
	public static final String UICOMPONENT_MAP_PHP_FTL = "includes/util/uicomponent-map-php.ftl";
	public static final String RESOURCE_BUNDLE_PHP_FTL = "includes/util/resource-bundle-php.ftl";
	public static final String TEMPLATE_LOADER_TEMPLATE_FILE = "includes/util/template-loader-php.ftl";

	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.ArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public void build(BuildConfiguration buildConfiguration) throws IDEException {
		String targetDir = buildConfiguration.getTargetDir();
		Application application = buildConfiguration.getApplication();
		// Enqueue Util
		this.generateArtifact(buildConfiguration, application, 
				ENQUEUE_UTIL_TEMPLATE_FILE, ENQUEUE_UTIL_PHP, targetDir.concat(IDEConstants.WP_UTIL_DIR));
		// Service Map
		this.generateArtifact(buildConfiguration, application, 
				SERVICE_MAP_TEMPLATE_FILE, SERVICE_MAP_PHP, targetDir.concat(IDEConstants.WP_UTIL_DIR));
		// Command Map
		this.generateArtifact(buildConfiguration, application, 
				COMMAND_MAP_TEMPLATE_FILE, COMMAND_MAP_PHP, targetDir.concat(IDEConstants.WP_UTIL_DIR));
		// View Map
		this.generateArtifact(buildConfiguration, application, 
				VIEW_MAP_TEMPLATE_FILE, VIEW_MAP_PHP, targetDir.concat(IDEConstants.WP_UTIL_DIR));
		// Template Loader
		this.generateArtifact(buildConfiguration, application, 
				TEMPLATE_LOADER_TEMPLATE_FILE, TEMPLATE_LOADER_PHP, targetDir.concat(IDEConstants.WP_UTIL_DIR));
		// The component registry
		this.generateArtifact(buildConfiguration, application, 
				UICOMPONENT_MAP_PHP_FTL, UI_COMPONENT_MAP_PHP, targetDir.concat(IDEConstants.WP_UTIL_DIR));
		// The resource bundle
		this.generateArtifact(buildConfiguration, application, 
				RESOURCE_BUNDLE_PHP_FTL, RESOURCE_BUNDLE_PHP, targetDir.concat(IDEConstants.WP_UTIL_DIR));
		// The menu map
		this.generateArtifact(buildConfiguration, application, 
				MENU_MAP_TEMPLATE_FILE, MENU_MAP_PHP, targetDir.concat(IDEConstants.WP_UTIL_DIR));

	}

}
