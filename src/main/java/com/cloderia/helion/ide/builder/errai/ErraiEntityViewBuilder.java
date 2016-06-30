/**
 * 
 */
package com.cloderia.helion.ide.builder.errai;

import com.cloderia.helion.ide.app.Entity;
import com.cloderia.helion.ide.app.Module;
import com.cloderia.helion.ide.builder.BuilderConfig;
import com.cloderia.helion.ide.builder.EntityBuilder;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEUtils;

/**
 * @author adrian
 *
 */
public class ErraiEntityViewBuilder implements EntityBuilder {

	/**
	 * Errai ui output directory
	 */
	private static final String UI_DIR = IDEConstants.JAVA_DIR + "com/cloderia/helion/client/local/";

	public void build(BuilderConfig config, Module module) {
		for (Entity entity : module.getEntities()) {
			config.setEntity(entity);
			config.setOutputDir(UI_DIR + entity.getName().toLowerCase() + "/");
			build(config, entity);
		}
	}
	
	
	public void build(BuilderConfig config, Entity entity) {
		doBuildCreateView(config, entity);
		doBuildEditView(config, entity);
		doBuildSingleView(config, entity);
		doBuildListView(config, entity);
		doBuildEntityPresenter(config, entity);
		doBuildBaseEntityEditPage(config, entity);
		doBuildEntityEditorComponent(config, entity);
		doBuildEntityListItemComponent(config, entity);
		doBuildEntitySingleViewComponent(config, entity);
	}
	
	/**
	 * @param config
	 * @param entity
	 */
	public void doBuildCreateView(BuilderConfig config, Entity entity) {
		config.setInputFile("components/errai/create-entity.ftl");
		config.setOutputFile("Create" + entity.getName() + "Page.java");
		
		if(entity.getCreateViewTemplate() != null) config.setInputFile(entity.getCreateViewTemplate());
		IDEUtils.generateArtifact(config);
	}
	
	/**
	 * @param config
	 * @param entity
	 */
	public void doBuildEditView(BuilderConfig config, Entity entity) {
		config.setInputFile("components/errai/edit-entity.ftl");
		config.setOutputFile("Edit" + entity.getName() + "Page.java");
		
		if(entity.getEditViewTemplate() != null) config.setInputFile(entity.getEditViewTemplate());
		IDEUtils.generateArtifact(config);
	}
	
	/**
	 * @param config
	 * @param entity
	 */
	public void doBuildSingleView(BuilderConfig config, Entity entity) {
		config.setInputFile("components/errai/view-entity.ftl");
		config.setOutputFile("View" + entity.getName() + "Page.java");
		
		if(entity.getSingleViewTemplate() != null) config.setInputFile(entity.getSingleViewTemplate());
		IDEUtils.generateArtifact(config);
	}
	/**
	 * @param config
	 * @param entity
	 */
	public void doBuildListView(BuilderConfig config, Entity entity) {
		config.setInputFile("components/errai/list-entity.ftl");
		config.setOutputFile("List" + entity.getName() + "Page.java");
		
		if(entity.getListViewTemplate() != null) config.setInputFile(entity.getListViewTemplate());
		IDEUtils.generateArtifact(config);
	}
	/**
	 * @param config
	 * @param entity
	 */
	public void doBuildEntityListItemComponent(BuilderConfig config, Entity entity) {
		config.setInputFile("components/errai/entity-list-display.ftl");
		config.setOutputFile(entity.getName() + "ListItemDisplay.java");
		IDEUtils.generateArtifact(config);
	}
	
	/**
	 * @param config
	 * @param entity
	 */
	public void doBuildEntityEditorComponent(BuilderConfig config, Entity entity) {
		config.setInputFile("components/errai/entity-editor.ftl");
		config.setOutputFile(entity.getName() + "Editor.java");
		IDEUtils.generateArtifact(config);
	}
	
	/**
	 * @param config
	 * @param entity
	 */
	public void doBuildEntityPresenter(BuilderConfig config, Entity entity) {
		config.setInputFile("components/errai/entity-presenter.ftl");
		config.setOutputFile(entity.getName() + "Presenter.java");
		IDEUtils.generateArtifact(config);
	}
	
	/**
	 * @param config
	 * @param entity
	 */
	public void doBuildEntitySingleViewComponent(BuilderConfig config, Entity entity) {
		config.setInputFile("components/errai/entity-display.ftl");
		config.setOutputFile(entity.getName() + "Display.java");
		IDEUtils.generateArtifact(config);
	}
	
	/**
	 * @param config
	 * @param entity
	 */
	public void doBuildBaseEntityEditPage(BuilderConfig config, Entity entity) {
		config.setInputFile("components/errai/base-entity-edit-page.ftl");
		config.setOutputFile("Base" + entity.getName() + "Page.java");
		IDEUtils.generateArtifact(config);
	}

}
