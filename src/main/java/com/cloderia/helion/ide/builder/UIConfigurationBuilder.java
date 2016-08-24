/**
 * 
 */
package com.cloderia.helion.ide.builder;

import java.util.List;

import com.cloderia.helion.ide.app.Application;
import com.cloderia.helion.ide.app.Entity;
import com.cloderia.helion.ide.app.Module;
import com.cloderia.helion.ide.app.RelatedEntity;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEException;
import com.cloderia.helion.ide.util.IDEUtils;

/**
 * @author adrian
 *
 */
public class UIConfigurationBuilder extends AbstractArtifactBuilder {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.ArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public void build(BuildConfiguration buildConfiguration) throws IDEException {
		
		Application application = IDEUtils.loadApplicationXMLData(
				buildConfiguration.getConfigDir().concat("ui-config.xml"));

		List<Module> modulesInUIConfig = application.getModules();
		buildConfiguration.getApplication().setNavigation(application.getNavigation());
		
		for(Module module : modulesInUIConfig) {
			List<Entity> entitiesInUIConfig = module.getEntities();
			for(Entity entity: entitiesInUIConfig) {
				this.processEntityRelatedActivities(entity, buildConfiguration);
			}
		}
	}

	/**
	 * @param entity
	 * @param buildConfiguration
	 */
	private void processEntityRelatedActivities(Entity entity, BuildConfiguration buildConfiguration) {
		List<Module> modulesInApplication = buildConfiguration.getApplication().getModules();
		for(Module module : modulesInApplication) {
			List<Entity> entitiesInApplication = module.getEntities();
			for(Entity appEntity: entitiesInApplication) {
				if(appEntity.getName().equals(entity.getName())) {
					appEntity.setRelatedEntity(entity.getRelatedEntity());
				}
			}
		}
	}

}
