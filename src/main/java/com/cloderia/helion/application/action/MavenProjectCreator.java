/**
 * 
 */
package com.cloderia.helion.application.action;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.application.model.Container;
import com.cloderia.helion.context.Context;
import com.cloderia.helion.util.ArtifactConfigUtil;
import com.cloderia.helion.util.IDEConstants;
import com.cloderia.helion.util.MavenUtil;
import com.cloderia.helion.util.TemplateUtil;

/**
 * @author Edward Banfa
 *
 */
public class MavenProjectCreator extends AbstractApplicationAction {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.application.action.AbstractApplicationAction#doExecuteApplication(com.cloderia.helion.application.model.Container, java.util.List, com.cloderia.helion.context.Context)
	 */
	@Override
	protected void doExecuteApplication(Container application, Context context) throws HelionException {
		// Get the target directory
		String targetDir = ArtifactConfigUtil.getConfigParameterValue(IDEConstants.TARGET_DIR_PARAM, context.getContextConfig());
		// Create the top level parent project
		MavenUtil.createMavenProjectFileSystem(targetDir, true, null);
		// Generate the POM.XML and the README.MD file
		TemplateUtil.generateArtifact(context, application, IDEConstants.APPLICATION_POM_TMPL_FTL, IDEConstants.POM_XML_FILE_NAME, targetDir);
		TemplateUtil.generateArtifact(context, application, IDEConstants.APPLICATION_README_TMPL_FTL, IDEConstants.README_MD_FILE_NAME, targetDir);
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.application.action.AbstractApplicationAction#doExecuteModule(com.cloderia.helion.application.model.Container, java.util.List, com.cloderia.helion.context.Context)
	 */
	@Override
	protected void doExecuteModule(Container module, Context context) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.application.action.AbstractApplicationAction#doExecuteSubModuleModule(com.cloderia.helion.application.model.Container, com.cloderia.helion.application.model.Container, java.util.List, com.cloderia.helion.context.Context)
	 */
	@Override
	protected void doExecuteSubModuleModule(Container subModule, Container module, Context context) {
		// TODO Auto-generated method stub

	}

}
