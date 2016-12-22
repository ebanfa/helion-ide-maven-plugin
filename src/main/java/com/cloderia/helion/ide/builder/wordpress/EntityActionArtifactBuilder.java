/**
 * 
 */
package com.cloderia.helion.ide.builder.wordpress;

import com.cloderia.helion.ide.app.Entity;
import com.cloderia.helion.ide.builder.AbstractEntityArtifactBuilder;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public class EntityActionArtifactBuilder extends AbstractEntityArtifactBuilder {

	public static final String LIST_COMMAND_TEMPLATE_FTL = IDEConstants.WP_COMMAND_DIR.concat("list-command-php.ftl");
	public static final String CREATE_COMMAND_TEMPLATE_FTL = IDEConstants.WP_COMMAND_DIR.concat("create-command-php.ftl");
	public static final String EDIT_COMMAND_TEMPLATE_FTL = IDEConstants.WP_COMMAND_DIR.concat("edit-command-php.ftl");
	public static final String VIEW_COMMAND_TEMPLATE_FTL = IDEConstants.WP_COMMAND_DIR.concat("view-command-php.ftl");
	public static final String DELETE_COMMAND_TEMPLATE_FTL = IDEConstants.WP_COMMAND_DIR.concat("delete-command-php.ftl");


	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.AbstractEntityArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration, com.cloderia.helion.ide.app.Entity)
	 */
	@Override
	public void build(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		String targetDir = buildConfiguration.getTargetDir();
		String actionName = entity.getName().concat("Action");
		// Create command
		if(entity.getCreateViewActionTemplate() != null)
			this.buildAction(buildConfiguration, entity,  actionName, entity.getCreateViewActionTemplate(), targetDir);
		else
			this.buildAction(buildConfiguration, entity, actionName, CREATE_COMMAND_TEMPLATE_FTL, targetDir);
		
		// List command
		this.generateArtifact(buildConfiguration, entity, LIST_COMMAND_TEMPLATE_FTL, 
				"List".concat(actionName).concat(IDEConstants.PHP_EXT), targetDir.concat(IDEConstants.WP_COMMAND_DIR));
		// Edit command
		this.generateArtifact(buildConfiguration, entity, EDIT_COMMAND_TEMPLATE_FTL, 
				"Edit".concat(actionName).concat(IDEConstants.PHP_EXT), targetDir.concat(IDEConstants.WP_COMMAND_DIR));
		// View command
		this.generateArtifact(buildConfiguration, entity, VIEW_COMMAND_TEMPLATE_FTL, 
				"View".concat(actionName).concat(IDEConstants.PHP_EXT), targetDir.concat(IDEConstants.WP_COMMAND_DIR));
		// Delete command
		this.generateArtifact(buildConfiguration, entity, DELETE_COMMAND_TEMPLATE_FTL, 
				"Delete".concat(actionName).concat(IDEConstants.PHP_EXT), targetDir.concat(IDEConstants.WP_COMMAND_DIR));

	}
	
	private void buildAction(BuildConfiguration buildConfiguration, 
			Entity entity, String actionName, String templateFile, String targetDir) throws IDEException
	{
		this.generateArtifact(buildConfiguration, entity, templateFile, 
				"Create".concat(actionName).concat(IDEConstants.PHP_EXT), targetDir.concat(IDEConstants.WP_COMMAND_DIR));
	}

}
