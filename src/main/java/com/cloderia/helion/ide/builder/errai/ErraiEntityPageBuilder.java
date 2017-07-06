/**
 * 
 */
package com.cloderia.helion.ide.builder.errai;

import com.cloderia.helion.ide.artifact.Entity;
import com.cloderia.helion.ide.builder.AbstractEntityArtifactProcessor;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.BuilderUtils;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public class ErraiEntityPageBuilder extends AbstractEntityArtifactProcessor {
	
	public static final String UI_PAGES_DIR = "ui/page/";

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.AbstractEntityArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration, com.cloderia.helion.ide.app.Entity)
	 */
	public void execute(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		this.doBuildPages(buildConfiguration, entity);
	}

	/**
	 * @param buildConfiguration
	 * @param entity
	 * @throws IDEException
	 */
	private void doBuildPages(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		if(entity.isHasUI()){
			String baseEntityView = "Base".concat(entity.getName().concat("View.java"));
			String targetDir = buildConfiguration.getTargetDir().concat(IDEConstants.UI_DIR).concat(UI_PAGES_DIR);
			BuilderUtils.generateArtifact(buildConfiguration, entity, "ui/page-components/base-entity-view.ftl", baseEntityView, targetDir);
			
			buildCreateView(buildConfiguration, entity);
			if(!entity.getIsVirtual()) buildListView(buildConfiguration, entity);
			if(!entity.getIsVirtual()) buildSingleView(buildConfiguration, entity);
		}
	}

	/**
	 * @param buildConfiguration
	 * @param entity
	 * @throws IDEException
	 */
	private void buildListView(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		if(entity.getListPageTemplate() == null) entity.setListPageTemplate("ui/page-html/list-page.ftl");
		if(entity.getListViewTemplate() == null) entity.setListViewTemplate("ui/page-components/list-page.ftl");
		if(entity.getListItemTemplate() == null) entity.setListItemTemplate("ui/page-components/list-item-display.ftl");
		
		String listPageView = "List".concat(entity.getName().concat("Page.java"));
		String listPageItemView = "List".concat(entity.getName().concat("ItemDisplay.java"));
		String listPageHTML = "list-".concat(entity.getName().toLowerCase().concat("-page.html"));
		String targetDir = buildConfiguration.getTargetDir().concat(IDEConstants.UI_DIR).concat(UI_PAGES_DIR);

		BuilderUtils.generateArtifact(buildConfiguration, entity, entity.getListPageTemplate(), listPageHTML, targetDir);
		BuilderUtils.generateArtifact(buildConfiguration, entity, entity.getListViewTemplate(), listPageView, targetDir);
		BuilderUtils.generateArtifact(buildConfiguration, entity, entity.getListItemTemplate(), listPageItemView, targetDir);
	}

	/**
	 * @param buildConfiguration
	 * @param entity
	 */
	private void buildCreateView(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		if(entity.getCreatePageTemplate() == null) entity.setCreatePageTemplate("ui/page-html/create-page.ftl");
		if(entity.getCreateViewTemplate() == null) entity.setCreateViewTemplate("ui/page-components/create-page.ftl");
		if(entity.getEditorTemplate() == null) entity.setEditorTemplate("ui/page-components/entity-editor.ftl");
		
		String createPageView = "Create".concat(entity.getName().concat("Page.java"));
		String createPageHTML = "create-".concat(entity.getName().toLowerCase().concat("-page.html"));
		String editorComponent = entity.getName().concat("Editor.java");
		String targetDir = buildConfiguration.getTargetDir().concat(IDEConstants.UI_DIR).concat(UI_PAGES_DIR);

		BuilderUtils.generateArtifact(buildConfiguration, entity, entity.getCreatePageTemplate(), createPageHTML, targetDir);
		BuilderUtils.generateArtifact(buildConfiguration, entity, entity.getCreateViewTemplate(), createPageView, targetDir);
		BuilderUtils.generateArtifact(buildConfiguration, entity, entity.getEditorTemplate(), editorComponent, targetDir);
		
	}
	
	/**
	 * @param buildConfiguration
	 * @param entity
	 */
	private void buildSingleView(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		if(entity.getSinglePageTemplate() == null) entity.setSinglePageTemplate("ui/page-html/single-page.ftl");
		if(entity.getSingleViewTemplate() == null) entity.setSingleViewTemplate("ui/page-components/single-page.ftl");
		if(entity.getSingleDisplayTemplate() == null) entity.setSingleDisplayTemplate("ui/page-components/entity-display.ftl");
		
		String singlePageView = "Single".concat(entity.getName().concat("Page.java"));
		String singlePageHTML = "single-".concat(entity.getName().toLowerCase().concat("-page.html"));
		String displayComponent = entity.getName().concat("Display.java");
		String targetDir = buildConfiguration.getTargetDir().concat(IDEConstants.UI_DIR).concat(UI_PAGES_DIR);

		BuilderUtils.generateArtifact(buildConfiguration, entity, entity.getSinglePageTemplate(), singlePageHTML, targetDir);
		BuilderUtils.generateArtifact(buildConfiguration, entity, entity.getSingleViewTemplate(), singlePageView, targetDir);
		BuilderUtils.generateArtifact(buildConfiguration, entity, entity.getSingleDisplayTemplate(), displayComponent, targetDir);
	}
}
