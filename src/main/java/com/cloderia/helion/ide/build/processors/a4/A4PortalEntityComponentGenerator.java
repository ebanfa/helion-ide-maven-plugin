/**
 * 
 */
package com.cloderia.helion.ide.build.processors.a4;

import com.cloderia.helion.ide.IDEException;
import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator;
import com.cloderia.helion.ide.build.processors.BuildProcessor;
import com.cloderia.helion.ide.data.EntityData;
import com.cloderia.helion.ide.data.ModuleData;
import com.cloderia.helion.ide.util.IDEUtil;

/**
 * @author adrian
 *
 */
public class A4PortalEntityComponentGenerator extends AbstractBuildProcessorDecorator {
	
	private static final String A4_LIST_COMPONENT_HTML_TMPL_FTL = "ui/page-components/list-${entity}-component-html.ftl";
	private static final String A4_LIST_COMPONENT_CLASS_TMPL_FTL = "ui/page-components/list-${entity}-component-ts.ftl";
	private static final String A4_LIST_COMPONENT_CSS_TMPL_FTL = "ui/page-components/entity-component-css.ftl";
	private static final String A4_CREATE_COMPONENT_HTML_TMPL_FTL = "ui/page-components/create-${entity}-component-html.ftl";
	private static final String A4_CREATE_COMPONENT_CLASS_TMPL_FTL = "ui/page-components/create-${entity}-component-ts.ftl";
	private static final String A4_CREATE_COMPONENT_CSS_TMPL_FTL = "ui/page-components/entity-component-css.ftl";
	private static final String A4_EDIT_COMPONENT_HTML_TMPL_FTL = "ui/page-components/edit-${entity}-component-html.ftl";
	private static final String A4_EDIT_COMPONENT_CSS_TMPL_FTL = "ui/page-components/entity-component-css.ftl";
	private static final String A4_EDIT_COMPONENT_CLASS_TMPL_FTL = "ui/page-components/edit-${entity}-component-ts.ftl";
	private static final String A4_SINGLE_COMPONENT_HTML_TMPL_FTL = "ui/page-components/view-${entity}-component-html.ftl";
	private static final String A4_SINGLE_COMPONENT_CSS_TMPL_FTL = "ui/page-components/entity-component-css.ftl";
	private static final String A4_SINGLE_COMPONENT_CLASS_TMPL_FTL = "ui/page-components/view-${entity}-component-ts.ftl";
	
	/**
	 * @param processor
	 */
	public A4PortalEntityComponentGenerator(BuildProcessor<BuildContext> processor){
		super(processor);
	}

	@Override
	protected BuildContext decorate(BuildContext context) {
		String componentDir = context.getTargetDir().concat(A4ProjectResourcesProcessor.A4_APP_COMPONENTS_DIR);
		return generateServices(context, componentDir.concat("portal/"));
	}

	/**
	 * @param context
	 */
	protected BuildContext generateServices(BuildContext context, String componentDir) {
		
		for(ModuleData moduleData: context.getApplicationData().getModules()){
			for(EntityData entity : moduleData.getEntities()) {
				if(entity.isHasUI()) {
					try {
						generateEntityComponents(context, entity, componentDir.concat(IDEUtil.getEntityPath(entity)));
					} catch (IDEException e) {
						e.printStackTrace();
					}
				}	
			}
		}
		return context;
	}

	/**
	 * @param context
	 * @param entity
	 * @param moduleDir
	 * @throws IDEException
	 */
	protected void generateEntityComponents(BuildContext context, EntityData entity, String moduleDir)
			throws IDEException {
		String listHtmlTarget = "list-" + entity.getLCName() + ".component.html";
		String listComponentTarget = "list-" + entity.getLCName() + ".component.ts";
		String listCssTarget = "list-" + entity.getLCName() + ".component.css";
		String createHtmlTarget = "create-" + entity.getLCName() + ".component.html";
		String createComponentTarget = "create-" + entity.getLCName() + ".component.ts";
		String createCssTarget = "create-" + entity.getLCName() + ".component.css";
		String editHtmlTarget = "edit-" + entity.getLCName() + ".component.html";
		String editComponentTarget = "edit-" + entity.getLCName() + ".component.ts";
		String editCssTarget = "edit-" + entity.getLCName() + ".component.css";
		String singleHtmlTarget = "view-" + entity.getLCName() + ".component.html";
		String singleCssTarget = "view-" + entity.getLCName() + ".component.css";
		String singleComponentTarget = "view-" + entity.getLCName() + ".component.ts";
		
		IDEUtil.generateArtifact(context, entity, A4_LIST_COMPONENT_HTML_TMPL_FTL, listHtmlTarget, moduleDir);
		IDEUtil.generateArtifact(context, entity, A4_LIST_COMPONENT_CLASS_TMPL_FTL, listComponentTarget, moduleDir);
		IDEUtil.generateArtifact(context, entity, A4_LIST_COMPONENT_CSS_TMPL_FTL, listCssTarget, moduleDir);
		IDEUtil.generateArtifact(context, entity, A4_CREATE_COMPONENT_HTML_TMPL_FTL, createHtmlTarget, moduleDir);
		IDEUtil.generateArtifact(context, entity, A4_CREATE_COMPONENT_CLASS_TMPL_FTL, createComponentTarget, moduleDir);
		IDEUtil.generateArtifact(context, entity, A4_CREATE_COMPONENT_CSS_TMPL_FTL, createCssTarget, moduleDir);
		IDEUtil.generateArtifact(context, entity, A4_EDIT_COMPONENT_HTML_TMPL_FTL, editHtmlTarget, moduleDir);
		IDEUtil.generateArtifact(context, entity, A4_EDIT_COMPONENT_CLASS_TMPL_FTL, editComponentTarget, moduleDir);
		IDEUtil.generateArtifact(context, entity, A4_EDIT_COMPONENT_CSS_TMPL_FTL, editCssTarget, moduleDir);
		IDEUtil.generateArtifact(context, entity, A4_SINGLE_COMPONENT_HTML_TMPL_FTL, singleHtmlTarget, moduleDir);
		IDEUtil.generateArtifact(context, entity, A4_SINGLE_COMPONENT_CLASS_TMPL_FTL, singleComponentTarget, moduleDir);
		IDEUtil.generateArtifact(context, entity, A4_SINGLE_COMPONENT_CSS_TMPL_FTL, singleCssTarget, moduleDir);
	}

}
