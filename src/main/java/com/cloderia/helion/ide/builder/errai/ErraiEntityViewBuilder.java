/**
 * 
 */
package com.cloderia.helion.ide.builder.errai;

import com.cloderia.helion.ide.app.Entity;
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
		
		if (entity.getHasOverride()) {
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
		
		if(createViewTempate == null) createViewTempate = "components/errai/create-entity.ftl";
		if(editViewTempate == null) editViewTempate = "components/errai/edit-entity.ftl";
		if(singleViewTempate == null) singleViewTempate = "components/errai/view-entity.ftl";
		if(listViewTempate == null) listViewTempate = "components/errai/list-entity.ftl";
		
		String entityNameLC = entity.getName().toLowerCase();
		String viewUIDir = buildConfiguration.getTargetDir().concat(IDEConstants.UI_DIR).concat(entityNameLC).concat("/");
		
		String createOutputFile = "Create" + entity.getName() + "Page.java";
		String editOutputFile = "Edit" + entity.getName() + "Page.java";
		String viewOutputFile = "View" + entity.getName() + "Page.java";
		String listOutputFile = "List" + entity.getName() + "Page.java";
		
		this.generateArtifact(buildConfiguration, entity, createViewTempate, createOutputFile, viewUIDir);
		this.generateArtifact(buildConfiguration, entity, editViewTempate, editOutputFile, viewUIDir);
		this.generateArtifact(buildConfiguration, entity, singleViewTempate, viewOutputFile, viewUIDir);
		this.generateArtifact(buildConfiguration, entity, listViewTempate, listOutputFile, viewUIDir);
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
				"components/errai/entity-editor.ftl", entity.getName() + "Editor.java", viewUIDir);
		
		this.generateArtifact(buildConfiguration, entity, 
				"components/errai/entity-presenter.ftl", entity.getName() + "Presenter.java", viewUIDir);
		
		this.generateArtifact(buildConfiguration, entity, 
				"components/errai/entity-display.ftl", entity.getName() + "Display.java", viewUIDir);
		
		this.generateArtifact(buildConfiguration, entity, 
				"components/errai/base-entity-edit-page.ftl", "Base" + entity.getName() + "Page.java", viewUIDir);
	}

}
