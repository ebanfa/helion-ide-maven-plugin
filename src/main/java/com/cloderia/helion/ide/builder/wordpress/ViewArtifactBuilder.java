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
public class ViewArtifactBuilder extends AbstractEntityArtifactBuilder {
	

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.AbstractEntityArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration, com.cloderia.helion.ide.app.Entity)
	 */
	@Override
	public void build(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		String entityDir = entity.getName().toLowerCase().concat(IDEConstants.T_SLASH);
		String targetDir = buildConfiguration.getTargetDir().concat(IDEConstants.WP_VIEW_DIR);
		// List View
		if(entity.getListViewTemplate() != null)
			this.generateArtifact(buildConfiguration, entity, entity.getListViewTemplate(), 
					"List".concat(entity.getName().concat("View").concat(IDEConstants.PHP_EXT)), targetDir.concat(entityDir));
		// Create View
		if(entity.getCreateViewTemplate() != null)
			this.generateArtifact(buildConfiguration, entity, entity.getCreateViewTemplate(), 
					"Create".concat(entity.getName().concat("View").concat(IDEConstants.PHP_EXT)), targetDir.concat(entityDir));
		// Create View model
		if(entity.getCreateViewModelTemplate() != null)
			this.generateArtifact(buildConfiguration, entity, entity.getCreateViewModelTemplate(), 
					"Create".concat(entity.getName().concat("ViewModel").concat(IDEConstants.PHP_EXT)), targetDir.concat(entityDir));
		// Single View
		if(entity.getSingleViewTemplate() != null)
			this.generateArtifact(buildConfiguration, entity, entity.getSingleViewTemplate(), 
					"Single".concat(entity.getName().concat("View").concat(IDEConstants.PHP_EXT)), targetDir.concat(entityDir));
		// Single View model
		if(entity.getSingleViewModelTemplate() != null)
			this.generateArtifact(buildConfiguration, entity, entity.getSingleViewModelTemplate(), 
					"Single".concat(entity.getName().concat("ViewModel").concat(IDEConstants.PHP_EXT)), targetDir.concat(entityDir));
	}

}
