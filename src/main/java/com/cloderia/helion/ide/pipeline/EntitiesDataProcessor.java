/**
 * 
 */
package com.cloderia.helion.ide.pipeline;

import java.util.List;
import java.util.stream.Collectors;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.ide.model.Entity;
import com.cloderia.helion.ide.model.Module;
import com.cloderia.helion.ide.pipeline.util.ConfigurationUtil;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.pipeline.AbstractPipelineItem;
import com.cloderia.helion.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.PipelineException;

/**
 * @author adrian
 *
 */
public class EntitiesDataProcessor extends AbstractPipelineItem {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator#
	 * decorate(com.cloderia.helion.ide.build.BuildContext)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected PipelineContext doExecute(PipelineContext context) throws PipelineException {
		// List of modules in the application object
		List<Module> modulesInApplication = context.getApplication().getModules();
		try {
			// List of modules from the entities-config.xml
			List<Module> modulesInConfiguration = this.loadModulesConfiguration(context);
			// List of entities reversed engineered from the database
			List<Entity> entitiesInDB = (List<Entity>) context.get(IDEConstants.ENTITIES_IN_DB_CONTEXT_KEY);
			// Process all the modules defined in the application
			modulesInApplication = modulesInApplication.stream().map(module ->  {
				return this.processModule(module, modulesInConfiguration, entitiesInDB);
			}).collect(Collectors.toList());
		} catch (HelionException e) {
			throw new PipelineException(e);
		}
		return context;
	}

	/**
	 * Loop through all the entities from the database and filter out
	 * the ones that belong to the module that was defined in the application object. 
	 * The entities that belong to a module are configured in the entities-config.xml file.
	 * 
	 * 
	 * @param moduleInApp Module from list of modules in the application object
	 * @param modulesInConfig Module from the entities-config.xml
	 * @param entitiesInDB Entities that were loaded from the database
	 * @return
	 */
	private Module processModule(Module moduleInApp, List<Module> modulesInConfig, List<Entity> entitiesInDB) {
		List<Entity> entitiesForModule = entitiesInDB.stream().filter(entityInDB -> { 
			return this.doesEntityBelongToModule(entityInDB, moduleInApp, modulesInConfig);
		}).collect(Collectors.toList());
		//System.out.printf("Processed module %s  with entities %s \n", moduleInApp, entitiesForModule);
		moduleInApp.setEntities(entitiesForModule);
		return moduleInApp;
	}

	private Boolean doesEntityBelongToModule(Entity entityInDB, Module moduleInApp, List<Module> modulesInConfig) {
		// We filter out the module that contains the entity
		List<Module> singleModuleList = modulesInConfig.stream().filter(moduleInConfig ->  {
			return moduleInConfig.containsEntity(moduleInConfig, entityInDB);
		}).collect(Collectors.toList());
		// An non empty list means the current entity has a parent in modulesInConfig list
		//System.out.printf("Found a module %s  with entities  %s \n", singleModuleList, entityInDB);
		if(!singleModuleList.isEmpty()) {
			if(singleModuleList.size() > 1) {
				try {
					throw new HelionException("Invalid module configuration in "
							+ "entities-config.xml. More than one module has entity " + entityInDB);
				} catch (HelionException e) {
					e.printStackTrace();
				}
				return false;
			}
			// Now we need to check if the filtered module has the same id as the module from the app
			// if the there is an id match then add the entity from the database to the module from the app
			if(singleModuleList.get(0).getId().equals(moduleInApp.getId())) {
				return true;
			}
		}
		return false;
	}

	private List<Module> loadModulesConfiguration(PipelineContext context) throws HelionException {
		String entitiesConfigFile = context.getConfigDir().concat(IDEConstants.ENTITY_CONFIG_FILE);
		return ConfigurationUtil.loadConfiguredModules(context);
	}

}
