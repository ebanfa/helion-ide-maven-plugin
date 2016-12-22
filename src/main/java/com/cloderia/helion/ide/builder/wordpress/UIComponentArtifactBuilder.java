/**
 * 
 */
package com.cloderia.helion.ide.builder.wordpress;

import com.cloderia.helion.ide.app.Application;
import com.cloderia.helion.ide.app.Module;
import com.cloderia.helion.ide.app.UiComponent;
import com.cloderia.helion.ide.builder.AbstractArtifactBuilder;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEException;
import com.cloderia.helion.ide.util.IDEUtils;

/**
 * @author adrian
 *
 */
public class UIComponentArtifactBuilder extends AbstractArtifactBuilder {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.ArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public void build(BuildConfiguration buildConfiguration) throws IDEException {
		String targetDir = buildConfiguration.getTargetDir();
		Application application = buildConfiguration.getApplication();
		for(Module module : application.getModules()){
			for(UiComponent uiComponent : module.getUiComponents()){
				String htmlDir = IDEConstants.WP_UICOMPONENT_HTML_TEMPLATES_DIR.concat(uiComponent.getUiGroup().concat("/"));
				IDEUtils.createDirectoryIfNeeded(htmlDir);
				// The HTML templates
				this.generateArtifact(buildConfiguration, uiComponent, 
						uiComponent.getHtmlTemplate(), uiComponent.getName().concat(".php"), targetDir.concat(htmlDir));
				// The component class
				if(uiComponent.getClassTemplate() != null) 
					this.generateArtifact(buildConfiguration, uiComponent, uiComponent.getClassTemplate(), 
							uiComponent.getClassName().concat(".php"), targetDir.concat(IDEConstants.WP_UICOMPONENT_TEMPLATES_DIR));
				// The component model class
				if(uiComponent.getUiComponentModel() != null) 
					this.generateArtifact(buildConfiguration, uiComponent, uiComponent.getUiComponentModel(), 
							uiComponent.getClassName().concat("Model.php"), targetDir.concat(IDEConstants.WP_UICOMPONENT_TEMPLATES_DIR));
			}
		}
	}

}
