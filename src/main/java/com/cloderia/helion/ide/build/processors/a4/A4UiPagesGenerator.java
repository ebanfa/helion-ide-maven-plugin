/**
 * 
 */
package com.cloderia.helion.ide.build.processors.a4;

import com.cloderia.helion.ide.IDEException;
import com.cloderia.helion.ide.artifacts.ContainerData;
import com.cloderia.helion.ide.artifacts.UiConfig;
import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator;
import com.cloderia.helion.ide.build.processors.BuildProcessor;
import com.cloderia.helion.ide.util.FileUtil;
import com.cloderia.helion.ide.util.IDEUtil;
import com.cloderia.helion.ide.util.StringUtil;

/**
 * @author adrian
 *
 */
public class A4UiPagesGenerator extends AbstractBuildProcessorDecorator {

	private static final String DATAMODEL_LIST_PAGE_COMPONENT_HTML_TMPL_FTL = "ui/pages/datamodel-list-${entity}-component-html.ftl";
	private static final String DATAMODEL_LIST_PAGE_COMPONENT_CLASS_TMPL_FTL = "ui/pages/datamodel-list-${entity}-component-ts.ftl";
	private static final String DATAMODEL_CREATE_PAGE_COMPONENT_HTML_TMPL_FTL = "ui/pages/datamodel-create-${entity}-component-html.ftl";
	private static final String DATAMODEL_CREATE_PAGE_COMPONENT_CLASS_TMPL_FTL = "ui/pages/datamodel-create-${entity}-component-ts.ftl";
	private static final String DATAMODEL_VIEW_PAGE_COMPONENT_HTML_TMPL_FTL = "ui/pages/datamodel-view-${entity}-component-html.ftl";
	private static final String DATAMODEL_VIEW_PAGE_COMPONENT_CLASS_TMPL_FTL = "ui/pages/datamodel-view-${entity}-component-ts.ftl";
	private static final String DATAMODEL_EDIT_PAGE_COMPONENT_HTML_TMPL_FTL = "ui/pages/datamodel-edit-${entity}-component-html.ftl";
	private static final String DATAMODEL_EDIT_PAGE_COMPONENT_CLASS_TMPL_FTL = "ui/pages/datamodel-edit-${entity}-component-ts.ftl";
	private static final String UI_PAGE_COMPONENT_HTML_TMPL_FTL = "ui/pages/ui-${entity}-component-html.ftl";
	private static final String UI_PAGE_COMPONENT_CLASS_TMPL_FTL = "ui/pages/ui-${entity}-component-ts.ftl";


	protected A4UiPagesGenerator(BuildProcessor<BuildContext> processor) {
		super(processor);
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator#decorate(com.cloderia.helion.ide.build.BuildContext)
	 */
	@Override
	protected BuildContext decorate(BuildContext context) {
		/*UiConfig  config = context.getApplication().getUiConfig();*/
		// 1. Get the base component directory
		/*String frontendDir = context.getTargetDir().concat(A4ProjectDirectoryBuilder.A4_COMPONENTS_FRONTEND_DIR);
		String portalDir = context.getTargetDir().concat(A4ProjectDirectoryBuilder.A4_COMPONENTS_PORTAL_DIR);
		String commonDir = context.getTargetDir().concat(A4ProjectDirectoryBuilder.A4_COMPONENTS_COMMON_DIR);
		System.out.println("Frontend dir is " + frontendDir);
		System.out.println("portalDir dir is " + portalDir);
		System.out.println("commonDir dir is " + commonDir);
		// 2. For all pages
		for (ContainerData page : config.getPageDatas()) {
			String siteDir = null;
			
			if(page.getSite().equals("common")) siteDir = commonDir;
			if(page.getSite().equals("frontend")) siteDir = frontendDir;
			if(page.getSite().equals("portal")) siteDir = portalDir;
			
			String moduleDir = siteDir.concat(StringUtil.trailingSlashIt(page.getModule()));
			String pageDir = moduleDir.concat(StringUtil.trailingSlashIt(page.getName()));
			
			FileUtil.createDirectoryIfNeeded(moduleDir);
			FileUtil.createDirectoryIfNeeded(pageDir);

			generatePageTemplate(context, page, pageDir);
			// 7. Check if custom template for html template file exists
			// 8. Generate the html template
			
		}*/
		
		return context;
	}

	/**
	 * @param context
	 * @param page
	 * @param pageDir
	 */
	protected void generatePageTemplate(BuildContext context, ContainerData page, String pageDir) {
		String htmlTarget = page.getName() + ".component.html";
		String componentTarget = page.getName() + ".component.ts";
		// 5. Check if custom component template exists
		/*try {
			if(page.isHasDataModel()) {
				if(page.getDataModelAction().equals("list")){
					IDEUtil.generateArtifact(context, page, DATAMODEL_LIST_PAGE_COMPONENT_HTML_TMPL_FTL, htmlTarget, pageDir);
					IDEUtil.generateArtifact(context, page, DATAMODEL_LIST_PAGE_COMPONENT_CLASS_TMPL_FTL, componentTarget, pageDir);
				}
				if(page.getDataModelAction().equals("create")){
					IDEUtil.generateArtifact(context, page, DATAMODEL_CREATE_PAGE_COMPONENT_HTML_TMPL_FTL, htmlTarget, pageDir);
					IDEUtil.generateArtifact(context, page, DATAMODEL_CREATE_PAGE_COMPONENT_CLASS_TMPL_FTL, componentTarget, pageDir);
				}
				if(page.getDataModelAction().equals("view")){
					IDEUtil.generateArtifact(context, page, DATAMODEL_VIEW_PAGE_COMPONENT_HTML_TMPL_FTL, htmlTarget, pageDir);
					IDEUtil.generateArtifact(context, page, DATAMODEL_VIEW_PAGE_COMPONENT_CLASS_TMPL_FTL, componentTarget, pageDir);
				}
				if(page.getDataModelAction().equals("edit")){
					IDEUtil.generateArtifact(context, page, DATAMODEL_EDIT_PAGE_COMPONENT_HTML_TMPL_FTL, htmlTarget, pageDir);
					IDEUtil.generateArtifact(context, page, DATAMODEL_EDIT_PAGE_COMPONENT_CLASS_TMPL_FTL, componentTarget, pageDir);
				}
			}
			else {
				IDEUtil.generateArtifact(context, page, UI_PAGE_COMPONENT_HTML_TMPL_FTL, htmlTarget, pageDir);
				IDEUtil.generateArtifact(context, page, UI_PAGE_COMPONENT_CLASS_TMPL_FTL, componentTarget, pageDir);
			}
		} catch (IDEException e) {
			e.printStackTrace();
		}*/
	}

}
