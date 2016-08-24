/**
 * 
 */
package com.cloderia.helion.ide.builder.errai;

import com.cloderia.helion.ide.app.Application;
import com.cloderia.helion.ide.builder.AbstractArtifactBuilder;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEException;
import com.cloderia.helion.ide.util.IDEUtils;

/**
 * @author adrian
 *
 */
public class MiscProjectResourceBuilder extends AbstractArtifactBuilder {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.ArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public void build(BuildConfiguration buildConfiguration) throws IDEException {
		this.generateArtifact(buildConfiguration, buildConfiguration.getApplication(), 
				"misc/errai/all-entities.ftl", "all-entities.xml", buildConfiguration.getProjectDir().concat("config/"));
		this.generateArtifact(buildConfiguration, 
				buildConfiguration.getApplication(), 
				"components/errai/side-bar.ftl", "SideBar.java", buildConfiguration.getTargetDir().concat(IDEConstants.UI_DIR + "/ui/"));
		
		Application application = IDEUtils.loadApplicationXMLData(
				buildConfiguration.getConfigDir().concat("ui-config.xml"));
		
		this.generateArtifact(buildConfiguration, application, "html/errai/home.ftl", 
				"dashboard-page.html", buildConfiguration.getTargetDir().concat(IDEConstants.UI_DIR + "/ui/"));
	}

}
