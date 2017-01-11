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
public class EventsArtifactBuilder extends AbstractArtifactBuilder {

	public static final String EVENT_TYPES_FILE = "EventTypes.php";
	public static final String EVENT_TYPES_TMP_FILE = "includes/event/event-types-php.ftl";
	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.ArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public void build(BuildConfiguration buildConfiguration) throws IDEException {
		String targetDir = buildConfiguration.getTargetDir();
		Application application = buildConfiguration.getApplication();
		String eventDir = targetDir.concat(IDEConstants.WP_EVENT_DIR);
		this.generateArtifact(buildConfiguration, application, EVENT_TYPES_TMP_FILE, EVENT_TYPES_FILE, eventDir);
	}

}
