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
public class ErraiEntityPageBuilder extends AbstractEntityArtifactBuilder {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.AbstractEntityArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration, com.cloderia.helion.ide.app.Entity)
	 */
	public void build(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		if (entity.isHasOverride()) {
			this.doBuildPages(buildConfiguration, entity);
		}
	}

	/**
	 * @param buildConfiguration
	 * @param entity
	 * @throws IDEException
	 */
	private void doBuildPages(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		String createPageTempate = entity.getCreatePageTemplate();
		String editPageTempate = entity.getEditPageTemplate();
		String viewPageTempate = entity.getViewPageTemplate();
		String listPageTempate = entity.getListPageTemplate();
		
		if(createPageTempate == null) createPageTempate = "html/errai/edit-entity.ftl";
		if(editPageTempate == null) editPageTempate = "html/errai/edit-entity.ftl";
		if(viewPageTempate == null) viewPageTempate = "html/errai/view-entity.ftl";
		if(listPageTempate == null) listPageTempate = "html/errai/list-entity.ftl";
		
		String entityNameLC = entity.getName().toLowerCase();
		String htmlUIDir = buildConfiguration.getTargetDir().concat(IDEConstants.UI_DIR).concat(entityNameLC).concat("/");
		
		String createOutputFile = "create-" + entityNameLC + "-page.html";
		String editOutputFile = "edit-" + entityNameLC + "-page.html";
		String viewOutputFile = "view-" + entityNameLC + "-page.html";
		String listOutputFile = "list-" + entityNameLC + "-page.html";
		
		this.generateArtifact(buildConfiguration, entity, createPageTempate, createOutputFile, htmlUIDir);
		this.generateArtifact(buildConfiguration, entity, editPageTempate, editOutputFile, htmlUIDir);
		this.generateArtifact(buildConfiguration, entity, viewPageTempate, viewOutputFile, htmlUIDir);
		this.generateArtifact(buildConfiguration, entity, listPageTempate, listOutputFile, htmlUIDir);
		//this.generateArtifact(buildConfiguration, entity, "html/errai/home.ftl", "home.html", htmlUIDir);
	}
}
