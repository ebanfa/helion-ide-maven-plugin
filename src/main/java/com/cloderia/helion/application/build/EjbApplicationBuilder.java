/**
 * 
 */
package com.cloderia.helion.application.build;

import com.cloderia.helion.application.model.Component;
import com.cloderia.helion.application.model.Container;
import com.cloderia.helion.config.Artifact;
import com.cloderia.helion.context.Context;

/**
 * @author Edward Banfa
 */
public class EjbApplicationBuilder implements ApplicationBuilder {

	@Override
	public Container build(Artifact applicationConfig, Context context) {
		return this.buildApplication(applicationConfig, context);
	}

	/**
	 * @param applicationConfig
	 * @param context
	 * @return
	 */
	private Container buildApplication(Artifact applicationConfig, Context context) {
		Container application = new Container(applicationConfig);
		
		for(Artifact moduleConfig : applicationConfig.getArtifacts()) {
			Container module = buildModule(moduleConfig,  context);
			application.getComponents().add(module);
		}
		return application;
	}
	
	/**
	 * @param moduleConfig
	 * @param application
	 * @param context
	 */
	private Container buildModule(Artifact moduleConfig, Context context) {
		Container module = new Container(moduleConfig);
		
		for(Artifact subModuleConfig : moduleConfig.getArtifacts()) {
			Container subModule = buildSubModules(subModuleConfig, context);
			module.getComponents().add(subModule);
		}
		return module;
	}

	/**
	 * @param subModuleConfig
	 * @param module
	 * @param context
	 */
	private Container buildSubModules(Artifact subModuleConfig, Context context) {
		Container subModule = new Container(subModuleConfig);
		
		for(Artifact artifact : subModuleConfig.getArtifacts()) {
			Component component = new Component(artifact);
			subModule.getComponents().add(component);
		}
		return subModule;
	}

}
