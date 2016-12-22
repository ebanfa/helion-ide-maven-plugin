/**
 * 
 */
package com.cloderia.helion.ide.builder;

import com.cloderia.helion.ide.app.Application;
import com.cloderia.helion.ide.app.Entity;
import com.cloderia.helion.ide.app.Module;
import com.cloderia.helion.ide.app.RelatedEntity;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public abstract class AbstractEntityArtifactBuilder extends AbstractArtifactBuilder {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.ArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public void build(BuildConfiguration buildConfiguration) throws IDEException {
		for(Module module : buildConfiguration.getApplication().getModules()){
			build(buildConfiguration, module);
		}
	}
	
	public void build(BuildConfiguration buildConfiguration, Module module) throws IDEException {
		for (Entity entity : module.getEntities()) {
			build(buildConfiguration, entity);
		}
	}
	
	public abstract void build(BuildConfiguration buildConfiguration, Entity entity) throws IDEException;

	/**
	 * @param name
	 * @param application
	 * @return
	 */
	public Entity findEntityInApplication(String name, Application application){
		for(Module module: application.getModules()){
			for(Entity entity: module.getEntities()){
				if(entity.getName().equals(name)){
					return entity;
				}
			}
		}
		return null;
	}

	/**
	 * @param buildConfiguration
	 * @param entity
	 * @throws IDEException
	 */
	protected void processRelatedUIEntityRelationship(BuildConfiguration buildConfiguration, Entity entity)
			throws IDEException {
		Application application = buildConfiguration.getApplication();
		for(RelatedEntity relatedEntity: entity.getRelatedEntity()){
			Entity relatedEntityObject = this.findEntityInApplication(relatedEntity.getName(), application);
			relatedEntity.setEntity(relatedEntityObject);
			
			/*if(relatedEntityObject!=null){
				String dialogTemplateFile = "components/errai/entity-editor-dialog.ftl";
				String dialogOutputFile = relatedEntityObject.getName() + "EditorDialog.java";
				String relatedEntityNameLC = relatedEntityObject.getName().toLowerCase();
				String relatedEntityViewUIDir = buildConfiguration.getTargetDir().concat(IDEConstants.UI_DIR).concat(relatedEntityNameLC).concat("/");
				this.generateArtifact(buildConfiguration, relatedEntityObject, dialogTemplateFile, dialogOutputFile, relatedEntityViewUIDir);
			}*/
		}
	}
}
