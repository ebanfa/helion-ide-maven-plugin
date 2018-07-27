/**
 * 
 */
package com.cloderia.helion.application.action;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.application.model.Component;
import com.cloderia.helion.application.model.Container;
import com.cloderia.helion.context.Context;

/**
 * @author Edward Banfa
 */
public abstract class AbstractApplicationAction extends AbstractAction {

	@Override
	public void doExecute(Component application, Context context) throws HelionException {
		if(application instanceof Container)
			this.executeApplication((Container) application, context);
	}
	
	/**
	 * @param application
	 * @param params
	 * @param context
	 * @throws HelionException 
	 */
	private void executeApplication(Container application, Context context) throws HelionException {
		// Process the application
		this.doExecuteApplication(application, context);
		// Process the modules
		for(Component module : application.getComponents()) {
			if(module instanceof Container)
				this.executeModule((Container) module, application, context);
		}
	}

	/**
	 * @param module
	 * @param application
	 * @param params
	 * @param context
	 */
	private void executeModule(Container module, Container application, Context context) {
		// Process the module
		this.doExecuteModule(module, context);
		// Process the sub modules
		for(Component subModule : module.getComponents()) {
			if(subModule instanceof Container)
				this.executeSubModuleModule((Container) subModule, module, context);
		}
	}
	
	/**
	 * @param subModule
	 * @param module
	 * @param params
	 * @param context
	 */
	private void executeSubModuleModule(Container subModule, Container module, Context context) {
		this.doExecuteSubModuleModule(subModule, module,  context);
	}

	/**
	 * @param application
	 * @param params
	 * @param context
	 * @throws HelionException 
	 */
	protected abstract void doExecuteApplication(Container application, Context context) throws HelionException;
	
	/**
	 * @param module
	 * @param params
	 * @param context
	 */
	protected abstract void doExecuteModule(Container module, Context context);

	/**
	 * @param subModule
	 * @param module
	 * @param params
	 * @param context
	 */
	protected abstract void doExecuteSubModuleModule(Container subModule, Container module, Context context) ;

}
