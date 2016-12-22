/**
 * 
 */
package com.cloderia.helion.ide.builder.wordpress;

import com.cloderia.helion.ide.app.Action;
import com.cloderia.helion.ide.app.Application;
import com.cloderia.helion.ide.app.Module;
import com.cloderia.helion.ide.builder.AbstractArtifactBuilder;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public class ActionArtifactBuilder extends AbstractArtifactBuilder {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.ArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public void build(BuildConfiguration buildConfiguration) throws IDEException {
		String targetDir = buildConfiguration.getTargetDir();
		Application application = buildConfiguration.getApplication();
		for(Module module : application.getModules()){
			for(Action action : module.getActions()){
				String actionDir = targetDir.concat(IDEConstants.WP_COMMAND_DIR.concat(action.getUiGroup().concat("/")));
				this.generateArtifact(buildConfiguration, action, action.getActionTemplate(), action.getName().concat(".php"), actionDir);
			}
		}

	}

}
