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
public class ErraiEntityPageBuilder implements EntityBuilder {
	
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
		doBuildEntityCreatePage(config, entity);
		doBuildEntityEditPage(config, entity);
		doBuildEntitySinglePage(config, entity);
		doBuildEntityListPage(config, entity);
	}

	private void doBuildEntityCreatePage(BuilderConfig config, Entity entity) {
		config.setInputFile("html/errai/create-entity.ftl");
		config.setOutputFile("create-" + entity.getName().toLowerCase() + "-page.html");
		if(entity.getCreatePageTemplate() != null) config.setInputFile(entity.getCreatePageTemplate());
		IDEUtils.generateArtifact(config);
	}

	private void doBuildEntityEditPage(BuilderConfig config, Entity entity) {
		config.setInputFile("html/errai/create-entity.ftl");
		config.setOutputFile("edit-" + entity.getName().toLowerCase() + "-page.html");
		if(entity.getEditPageTemplate() != null) config.setInputFile(entity.getEditPageTemplate());
		IDEUtils.generateArtifact(config);
	}

	private void doBuildEntitySinglePage(BuilderConfig config, Entity entity) {
		config.setInputFile("html/errai/view-entity.ftl");
		config.setOutputFile("view-" + entity.getName().toLowerCase() + "-page.html");
		if(entity.getViewPageTemplate() != null) config.setInputFile(entity.getViewPageTemplate());
		IDEUtils.generateArtifact(config);
	}

	private void doBuildEntityListPage(BuilderConfig config, Entity entity) {
		config.setInputFile("html/errai/list-entity.ftl");
		config.setOutputFile("list-" + entity.getName().toLowerCase() + "-page.html");
		if(entity.getListPageTemplate() != null) config.setInputFile(entity.getListPageTemplate());
		IDEUtils.generateArtifact(config);
	}

}
