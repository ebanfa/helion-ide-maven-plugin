/**
 * 
 */
package com.cloderia.helion.ide.builder;

import com.cloderia.helion.ide.app.Application;
import com.cloderia.helion.ide.app.Entity;
import com.cloderia.helion.ide.app.Field;
import com.cloderia.helion.ide.app.Module;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEException;
import com.cloderia.helion.ide.util.IDEUtils;
import com.cloderia.helion.ide.util.StringUtils;

/**
 * @author adrian
 *
 */
public class EntityFieldBuilder extends AbstractArtifactBuilder{

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.ArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public void build(BuildConfiguration buildConfiguration) throws IDEException {
		Application application = buildConfiguration.getApplication();
		Application applicationOverrides = IDEUtils.loadApplicationXMLData(
				buildConfiguration.getProjectDir().concat("config/logix/entity-config.xml"));
		for(Module module: application.getModules()) {
			for(Module moduleOverride: applicationOverrides.getModules()) {
				processEntityOverrides(module, moduleOverride);
			}
		}
		
	}
	/**
	 * @param module
	 * @param moduleOverride
	 */
	private void processEntityOverrides(Module module, Module moduleOverride) {
		for(Entity entity: module.getEntities()) {
			for(Entity entityOverride: moduleOverride.getEntities()) {
				if(entity.getName().equals(entityOverride.getName())) {
					if(StringUtils.isValidString(entityOverride.getDescription())) {
						entity.setDescription(entityOverride.getDescription());
					}
					entity.setHasOverride(true);
					processEntityFieldOverrides(entity, entityOverride);
				}
			}
		}
	}
	
	private void processEntityFieldOverrides(Entity entity, Entity entityOverride) {
		for(Field overrideField: entityOverride.getFields()){
			for(Field entityField: entity.getFields()){
				if(overrideField.getName().equals(entityField.getName())){
					entityField.setDescription(overrideField.getDescription());
					entityField.setIsVisible(overrideField.getIsVisible());
					entityField.setCreateField(overrideField.getCreateField());
					entityField.setEditField(overrideField.getEditField());
					entityField.setViewField(overrideField.getViewField());
					entityField.setListField(overrideField.getListField());
				}
			}
		}
	}
}
