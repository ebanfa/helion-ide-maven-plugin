/**
 * 
 */
package com.cloderia.helion.ide.build.processors.artifacts;

import java.util.List;
import java.util.stream.Collectors;

import com.cloderia.helion.ide.IDEException;
import com.cloderia.helion.ide.artifacts.Entity;
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
public class EntityModuleProcessor extends AbstractBuildProcessorDecorator {

	/**
	 * @param processor
	 */
	public EntityModuleProcessor(BuildProcessor<BuildContext> processor) {
		super(processor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator#
	 * decorate(com.cloderia.helion.ide.build.BuildContext)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected BuildContext decorate(BuildContext context) throws IDEException {
		// List of modules in the application object
		List<Module> modulesInApplication = context.getApplication().getModules();
		// List of modules from the entities-config.xml
		List<Module> modulesInConfiguration = this.loadModulesConfiguration(context);
		System.out.println("decorate modulesInApplication >>>>>>>>>>>>>>>>>>>>" + modulesInApplication);
		System.out.println("decorate modulesInConfig >>>>>>>>>>>>>>>>>>>>" + modulesInConfiguration);
		// List of entities reversed engineered from the database
		List<Entity> entitiesInDB = (List<Entity>) context.get(IDEConstants.ENTITIES_IN_DB_CONTEXT_KEY);
		modulesInApplication.stream().map(module -> this.processModule(module, modulesInConfiguration, entitiesInDB));
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
		System.out.println("processModule modulesInConfig >>>>>>>>>>>>>>>>>>>>" + modulesInConfig);
		List<Entity> entitiesForModule = entitiesInDB.stream()
				.filter(entityInDB -> this.doesEntityBelongToModule(entityInDB, moduleInApp, modulesInConfig)).collect(Collectors.toList());
		moduleInApp.setEntities(entitiesForModule);
		return null;
	}

	private Boolean doesEntityBelongToModule(Entity entityInDB, Module moduleInApp, List<Module> modulesInConfig) {
		// We filter out the module that contains the entity
		List<Module> singleModuleList = modulesInConfig.stream()
				.filter(moduleInConfig -> moduleInConfig.containsEntity(moduleInConfig, entityInDB)).collect(Collectors.toList());
		System.out.println("doesEntityBelongToModuleodule> entityInDB >>>>>>>>>>>>>>>>>>>>" + entityInDB);
		// An empty list means the current entity does not have a parent
		if(singleModuleList.isEmpty()) return false;
		// This should be a list with only one items
		if(singleModuleList.size() > 1)
			try {
				throw new IDEException("Invalid module configuration in entities-config.xml. More than one module has entity " + entityInDB);
			} catch (IDEException e) {
				e.printStackTrace();
			}
		// Now we need to check if the filtered module has the same id as the module from the app
		// if the there is an id match then add the entity from the database to the module from the app
		if(singleModuleList.get(0).getId() == moduleInApp.getId()) 
			moduleInApp.getEntities().add(entityInDB);
		return true;
	}

	private List<Module> loadModulesConfiguration(BuildContext context) throws IDEException {
		String entitiesConfigFile = context.getConfigDir().concat(IDEConstants.ENTITY_CONFIG_FILE);
		return IDEUtil.loadApplicationData(entitiesConfigFile).getModules();
	}

}
