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

/**
 * @author adrian
 *
 */
public class PageArtifactBuilder extends AbstractArtifactBuilder {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.ArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public void build(BuildConfiguration buildConfiguration) throws IDEException {
		String targetDir = buildConfiguration.getTargetDir();
		Application application = buildConfiguration.getApplication();
		for(Module module : application.getModules()){
			for(Page page : module.getPages()){
				String pageName = page.getName().toLowerCase().concat("-page.php");
				String viewDir = targetDir.concat(IDEConstants.WP_VIEW_DIR.concat(page.getUiGroup().concat("/")));
				String actionDir = targetDir.concat(IDEConstants.WP_COMMAND_DIR.concat(page.getUiGroup().concat("/")));
				String htmlDir = targetDir.concat(IDEConstants.WP_PAGE_HTML_TEMPLATES_DIR.concat(page.getUiGroup().concat("/")));
				// Generate the artifacts (page, view and actions)
				this.generateArtifact(buildConfiguration, page, page.getPageTemplate(), pageName, htmlDir);
				this.generateArtifact(buildConfiguration, page, page.getViewTemplate(), page.getName().concat("View.php"), viewDir);
				if(page.getViewModelTemplate() != null)
					this.generateArtifact(buildConfiguration, page, page.getViewModelTemplate(), page.getName().concat("ViewModel.php"), viewDir);
				this.generateArtifact(buildConfiguration, page, page.getViewActionTemplate(), page.getName().concat("Action.php"), actionDir);
				
			}
		}

	}

}
