/**
 * 
 */
package com.cloderia.helion.ide.builder.errai;

import com.cloderia.helion.ide.app.Application;
import com.cloderia.helion.ide.app.Entity;
import com.cloderia.helion.ide.app.Module;
import com.cloderia.helion.ide.app.RelatedEntity;
import com.cloderia.helion.ide.builder.AbstractEntityArtifactBuilder;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public class ErraiEntityViewBuilder extends AbstractEntityArtifactBuilder {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.AbstractEntityArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration, com.cloderia.helion.ide.app.Entity)
	 */
	@Override
	public void build(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		
		if (entity.isHasOverride()) {
			this.doBuildViews(buildConfiguration, entity);
			this.doBuildViewComponents(buildConfiguration, entity);
		}
	}

	/**
	 * @param buildConfiguration
	 * @param entity
	 * @throws IDEException
	 */
	private void doBuildViews(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		String createViewTempate = entity.getCreateViewTemplate();
		String editViewTempate = entity.getEditViewTemplate();
		String singleViewTempate = entity.getSingleViewTemplate();
		String listViewTempate = entity.getListViewTemplate();
		String baseViewTempate = entity.getBasePageTemplate();
		
		if(createViewTempate == null) createViewTempate = "components/errai/create-entity.ftl";
		if(editViewTempate == null) editViewTempate = "components/errai/edit-entity.ftl";
		if(singleViewTempate == null) singleViewTempate = "components/errai/view-entity.ftl";
		if(listViewTempate == null) listViewTempate = "components/errai/list-entity.ftl";
		if(baseViewTempate == null) baseViewTempate = "components/errai/base-entity-edit-page.ftl";
		String dialogTemplateFile = "components/errai/entity-editor-dialog.ftl";
		
		String entityNameLC = entity.getName().toLowerCase();
		String viewUIDir = buildConfiguration.getTargetDir().concat(IDEConstants.UI_DIR).concat(entityNameLC).concat("/");
		
		String createOutputFile = "Create" + entity.getName() + "Page.java";
		String editOutputFile = "Edit" + entity.getName() + "Page.java";
		String viewOutputFile = "View" + entity.getName() + "Page.java";
		String listOutputFile = "List" + entity.getName() + "Page.java";
		String dialogOutputFile = entity.getName() + "EditorDialog.java";
		String basePageOutFile = "Base" + entity.getName() + "Page.java";
		
		this.generateArtifact(buildConfiguration, entity, createViewTempate, createOutputFile, viewUIDir);
		this.generateArtifact(buildConfiguration, entity, editViewTempate, editOutputFile, viewUIDir);
		this.generateArtifact(buildConfiguration, entity, singleViewTempate, viewOutputFile, viewUIDir);
		this.generateArtifact(buildConfiguration, entity, listViewTempate, listOutputFile, viewUIDir);
		this.generateArtifact(buildConfiguration, entity, dialogTemplateFile, dialogOutputFile, viewUIDir);
		this.generateArtifact(buildConfiguration, entity,baseViewTempate, basePageOutFile, viewUIDir);
		
		//this.processRelatedUIEntityRelationship(buildConfiguration, entity);
		
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
			if(relatedEntityObject!=null){
				String dialogTemplateFile = "components/errai/entity-editor-dialog.ftl";
				String dialogOutputFile = relatedEntityObject.getName() + "EditorDialog.java";
				String relatedEntityNameLC = relatedEntityObject.getName().toLowerCase();
				String relatedEntityViewUIDir = buildConfiguration.getTargetDir().concat(IDEConstants.UI_DIR).concat(relatedEntityNameLC).concat("/");
				this.generateArtifact(buildConfiguration, relatedEntityObject, dialogTemplateFile, dialogOutputFile, relatedEntityViewUIDir);
			}
		}
	}
	
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
	private void doBuildViewComponents(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		String entityNameLC = entity.getName().toLowerCase();
		String viewUIDir = buildConfiguration.getTargetDir().concat(IDEConstants.UI_DIR).concat(entityNameLC).concat("/");
		
		this.generateArtifact(buildConfiguration, entity, 
				"components/errai/entity-list-display.ftl", entity.getName() + "ListItemDisplay.java", viewUIDir);
		
		this.generateArtifact(buildConfiguration, entity, 
				"components/errai/entity-list-widget.ftl", entity.getName() + "ListWidget.java", viewUIDir);
		
		this.generateArtifact(buildConfiguration, entity, 
				"components/errai/entity-editor.ftl", entity.getName() + "Editor.java", viewUIDir);
		
		this.generateArtifact(buildConfiguration, entity, 
				"components/errai/entity-presenter.ftl", entity.getName() + "Presenter.java", viewUIDir);
		
		this.generateArtifact(buildConfiguration, entity, 
				"components/errai/entity-display.ftl", entity.getName() + "Display.java", viewUIDir);
		
		this.generateArtifact(buildConfiguration, entity, 
				"components/errai/entity-list.ftl", entity.getName() + "List.java", viewUIDir);
	}

}
