/**
 * 
 */
package com.cloderia.helion.ide.builder.wordpress;

import com.cloderia.helion.ide.app.Application;
import com.cloderia.helion.ide.app.Module;
import com.cloderia.helion.ide.app.Service;
import com.cloderia.helion.ide.builder.AbstractArtifactBuilder;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public class ServiceArtifactBuilder extends AbstractArtifactBuilder {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.ArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public void build(BuildConfiguration buildConfiguration) throws IDEException {
		String targetDir = buildConfiguration.getTargetDir();
		Application application = buildConfiguration.getApplication();
		for(Module module : application.getModules()){
			for(Service service : module.getServices()){
				this.generateArtifact(buildConfiguration, service, 
						service.getServiceTemplate(), service.getName().concat(".php"), targetDir.concat(
								IDEConstants.WP_SERVICE_DIR).concat(service.getUiGroup().concat(IDEConstants.T_SLASH)));
				
			}
		}

	}

}
