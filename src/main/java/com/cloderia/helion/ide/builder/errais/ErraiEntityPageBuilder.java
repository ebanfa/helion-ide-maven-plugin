/**
 * 
 */
package com.cloderia.helion.ide.builder.errais;

import com.cloderia.helion.ide.app.Entity;
import com.cloderia.helion.ide.builder.AbstractEntityArtifactBuilder;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public class ErraiEntityPageBuilder extends AbstractEntityArtifactBuilder {
	
	public static final String UI_PAGES_DIR = "ui/page/";

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.AbstractEntityArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration, com.cloderia.helion.ide.app.Entity)
	 */
	public void build(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		this.doBuildPages(buildConfiguration, entity);
	}

	/**
	 * @param buildConfiguration
	 * @param entity
	 * @throws IDEException
	 */
	private void doBuildPages(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		String baseEntityViewTemplate = "ui/page-components/base-entity-view.ftl";
		String listItemDisplayTemplate = "ui/page-components/list-item-display.ftl";
		
		if(entity.getListPageTemplate() == null) entity.setListPageTemplate("ui/page-html/list-page.ftl");
		if(entity.getListViewTemplate() == null) entity.setListViewTemplate("ui/page-components/list-page.ftl");

		String listPageView = "List".concat(entity.getName().concat("Page.java"));
		String listPageItemView = "List".concat(entity.getName().concat("ItemDisplay.java"));
		String baseEntityView = "Base".concat(entity.getName().concat("View.java"));
		String listPageHTML = "list-".concat(entity.getName().toLowerCase().concat("-page.html"));
		String targetDir = buildConfiguration.getTargetDir().concat(IDEConstants.UI_DIR).concat(UI_PAGES_DIR);

		this.generateArtifact(buildConfiguration, entity, baseEntityViewTemplate, baseEntityView, targetDir);
		this.generateArtifact(buildConfiguration, entity, entity.getListPageTemplate(), listPageHTML, targetDir);
		this.generateArtifact(buildConfiguration, entity, entity.getListViewTemplate(), listPageView, targetDir);
		this.generateArtifact(buildConfiguration, entity, listItemDisplayTemplate, listPageItemView, targetDir);
	}
}
