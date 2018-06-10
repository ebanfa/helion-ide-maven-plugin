/**
 * 
 */
package com.cloderia.helion.ide.build.processors.artifacts;

import java.util.List;

import com.cloderia.helion.ide.IDEException;
import com.cloderia.helion.ide.artifacts.Application;
import com.cloderia.helion.ide.artifacts.Module;
import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator;
import com.cloderia.helion.ide.build.processors.BuildProcessor;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEUtil;

/**
 * @author adrian
 *
 */
public class ModuleDataProcessor extends AbstractBuildProcessorDecorator {

	public ModuleDataProcessor(BuildProcessor<BuildContext> processor) {
		super(processor);
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator#decorate(com.cloderia.helion.ide.build.BuildContext)
	 */
	@Override
	protected BuildContext decorate(BuildContext context) throws IDEException{
		Application application = context.getApplication();
		// Load the modules from the module configuration file
		String moduleConfigFile = context.getConfigDir().concat(IDEConstants.MODULE_CONFIG_FILE);
		List<Module> modules = IDEUtil.loadApplicationData(moduleConfigFile).getModules();
		application.setModules(modules);
		return context;
	}

}
