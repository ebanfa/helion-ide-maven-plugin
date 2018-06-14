/**
 * 
 */
package com.cloderia.helion.pipeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.util.IDEConstants;
import com.cloderia.helion.util.IDEUtil;

/**
 * Load module definitions from the module-config.xml file
 * 
 * @author Edward Banfa
 */
public class ModuleConfigurationLoader extends AbstractPipelineItem {
	private static Logger logger = LoggerFactory.getLogger(ModuleConfigurationLoader.class);

	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.AbstractPipelineItem#doExecute(com.cloderia.helion.pipeline.PipelineContext)
	 */
	@Override
	protected PipelineContext doExecute(PipelineContext context) throws HelionException {
		logger.debug("Executing module configuration loader " + context);
		// Load the modules for this application as configured in the module configuration file
		String moduleConfigFile = context.getConfigDir().concat(IDEConstants.MODULE_CONFIG_FILE);
		context.getApplication().setModules(IDEUtil.loadApplicationData(moduleConfigFile).getModules());
		logger.debug("Executed module configuration loader " + context);
		return context;
	}

}
