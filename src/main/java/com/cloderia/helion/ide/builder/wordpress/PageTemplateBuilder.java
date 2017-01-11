/**
 * 
 */
package com.cloderia.helion.ide.builder.wordpress;

import com.cloderia.helion.ide.app.Application;
import com.cloderia.helion.ide.app.Module;
import com.cloderia.helion.ide.app.Page;
import com.cloderia.helion.ide.builder.AbstractArtifactBuilder;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEException;
import com.cloderia.helion.ide.util.IDEUtils;

/**
 * @author adrian
 *
 */
public class PageTemplateBuilder extends AbstractArtifactBuilder {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.ArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public void build(BuildConfiguration buildConfiguration) throws IDEException {
		String baseDir = buildConfiguration.getProjectDir();
		String templatesDir = baseDir.concat("templates/wp-ee/wp-ee-ua/wp-tutor/");

		Application application = buildConfiguration.getApplication();
		for(Module module : application.getModules()){
			for(Page page : module.getPages()){
				if(page.getGenerateTemplate() != null) {

					String name = page.getName().toLowerCase();
					String viewDir = templatesDir.concat(IDEConstants.WP_VIEW_DIR.concat(page.getUiGroup().concat("/")));
					String viewHTMLDir = templatesDir.concat("html/page/".concat(page.getUiGroup().concat("/")));
					String actionDir = templatesDir.concat(IDEConstants.WP_COMMAND_DIR.concat(page.getUiGroup().concat("/")));
					String componentDir = templatesDir.concat(IDEConstants.WP_UICOMPONENT_TEMPLATES_DIR.concat(page.getUiGroup().concat("/")));
					String componentHTMLDir = templatesDir.concat("html/uicomponent/".concat(page.getUiGroup().concat("/")));

					IDEUtils.createDirectoryIfNeeded(viewDir);
					IDEUtils.createDirectoryIfNeeded(viewHTMLDir);
					IDEUtils.createDirectoryIfNeeded(actionDir);
					IDEUtils.createDirectoryIfNeeded(componentDir);
					IDEUtils.createDirectoryIfNeeded(componentHTMLDir);

					IDEUtils.copyFileToFile(templatesDir.concat("html/page/portal/dashboard-page-php.ftl"), viewHTMLDir.concat(name.concat("-page-php.ftl")));
					IDEUtils.copyFileToFile(templatesDir.concat("includes/ui/view/portal/dashboard-view-php.ftl"), viewDir.concat(name.concat("-view-php.ftl")));
					IDEUtils.copyFileToFile(templatesDir.concat("includes/ui/view/portal/dashboard-view-model-php.ftl"), viewDir.concat(name.concat("-view-model-php.ftl")));
					IDEUtils.copyFileToFile(templatesDir.concat("includes/action/portal/dashboard-action-php.ftl"), actionDir.concat(name.concat("-action-php.ftl")));
					//IDEUtils.copyFileToDirectory(templatesDir.concat("wp-tutor/html/page/portal/dashboard-page-php.ftl"), viewHTMLDir);
					IDEUtils.copyFileToFile(templatesDir.concat("includes/ui/uicomponent/portal/dashboard-panel-model-php.ftl"), componentDir.concat(name.concat("-panel-model-php.ftl")));
					IDEUtils.copyFileToFile(templatesDir.concat("html/uicomponent/portal/dashboard-panel-php.ftl"), componentHTMLDir.concat(name.concat("-panel-php.ftl")));
				
				}
			}
		}

	}

}
