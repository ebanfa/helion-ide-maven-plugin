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
public class GenericUIResourcesBuilder extends AbstractArtifactBuilder {
	
	public static final String LIST_ENTITY_PAGE_PHP = "list-entity-page.php";
	public static final String CREATE_ENTITY_PAGE_PHP = "create-entity-page.php";
	public static final String MULTI_CREATE_ENTITY_PAGE_PHP = "multi-create-entity-page.php";
	public static final String EDIT_ENTITY_PAGE_PHP = "edit-entity-page.php";
	public static final String VIEW_ENTITY_PAGE_PHP = "single-entity-page.php";
	public static final String LIST_PAGE_TEMPLATE_FILE = "html/entity/list-entity-page-php.ftl";
	public static final String CREATE_PAGE_TEMPLATE_FILE = "html/entity/create-entity-page-php.ftl";
	public static final String MULTI_CREATE_PAGE_TEMPLATE_FILE = "html/entity/multi-create-entity-page-php.ftl";
	public static final String EDIT_PAGE_TEMPLATE_FILE = "html/entity/edit-entity-page-php.ftl";
	public static final String VIEW_PAGE_TEMPLATE_FILE = "html/entity/single-entity-page-php.ftl";

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.ArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public void build(BuildConfiguration buildConfiguration) throws IDEException {
		String targetDir = buildConfiguration.getTargetDir();
		Application application = buildConfiguration.getApplication();
		this.generateArtifact(buildConfiguration, application, LIST_PAGE_TEMPLATE_FILE, LIST_ENTITY_PAGE_PHP, targetDir.concat(IDEConstants.WP_ENTITY_HTML_TEMPLATES_DIR));
		this.generateArtifact(buildConfiguration, application, CREATE_PAGE_TEMPLATE_FILE, CREATE_ENTITY_PAGE_PHP, targetDir.concat(IDEConstants.WP_ENTITY_HTML_TEMPLATES_DIR));
		this.generateArtifact(buildConfiguration, application, MULTI_CREATE_PAGE_TEMPLATE_FILE, MULTI_CREATE_ENTITY_PAGE_PHP, targetDir.concat(IDEConstants.WP_ENTITY_HTML_TEMPLATES_DIR));
		this.generateArtifact(buildConfiguration, application, EDIT_PAGE_TEMPLATE_FILE, EDIT_ENTITY_PAGE_PHP, targetDir.concat(IDEConstants.WP_ENTITY_HTML_TEMPLATES_DIR));
		this.generateArtifact(buildConfiguration, application, VIEW_PAGE_TEMPLATE_FILE, VIEW_ENTITY_PAGE_PHP, targetDir.concat(IDEConstants.WP_ENTITY_HTML_TEMPLATES_DIR));
		

	}

}
