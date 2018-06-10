/**
 * 
 */
package com.cloderia.helion.ide.build.processors.misc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cloderia.helion.ide.artifacts.Application;
import com.cloderia.helion.ide.artifacts.Entity;
import com.cloderia.helion.ide.artifacts.FieldData;
import com.cloderia.helion.ide.artifacts.Module;
import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator;
import com.cloderia.helion.ide.build.processors.BuildProcessor;
import com.cloderia.helion.ide.util.StringUtil;

/**
 * @author adrian
 *
 */
public class EntityFieldProcessor extends AbstractBuildProcessorDecorator {

	public EntityFieldProcessor(BuildProcessor<BuildContext> processor) {
		super(processor);
	}

	@Override
	protected BuildContext decorate(BuildContext context) {
		// The target 'components' directory
		for(Module moduleData: context.getApplication().getModules()) {
			processEntitiesInModule(context, moduleData);
			inspectRelatedChildEntities(moduleData);
		}
		return context;
	}

	/**
	 * @param context
	 * @param moduleData
	 */
	protected void processEntitiesInModule(BuildContext context, Module moduleData) {
		for(Entity entity : moduleData.getEntities()) {
			for(FieldData field: entity.getFields()) {
				field.setJavaName(StringUtil.columnNameToJavaFieldName(field.getName()));
				
				if(field.getName().equals("name")) 
					field.setSize("75");
				else if(field.getName().equals("entity_code")) 
					field.setSize("35");
				else if(field.getSize().equals("large")) 
					field.setSize("255");
				else if(field.getSize().equals("medium")) 
					field.setSize("35");
				if(field.isRelationshipField()){
					field.setParentEntity(findEntityInApplication(field.getDataType(), context.getApplication()));
					field.setRelId(String.valueOf(new Date().getTime()));
				}
			}
		}
	}

	/**
	 * @param name
	 * @param application
	 * @return
	 */
	public Entity findEntityInApplication(String name, Application application){
		for(Module module: application.getModules()){
			for(Entity entity: module.getEntities()){
				if(entity.getName().equals(name)){
					return entity;
				}
			}
		}
		return null;
	}

	public Module inspectRelatedChildEntities(Module module) {
		List<Entity> entitiesInModule = module.getEntities();
		List<Entity> cloneOfEntitiesInModule = new ArrayList<Entity>(entitiesInModule);
		// Loop through all the entities in the module
		for(Entity entity : module.getEntities()){
			List<FieldData> fieldsInEntity = entity.getFields();
			// Process the fields in the entity
			for(FieldData field : fieldsInEntity){
				// Only process relationship fields
				if(field.isRelationshipField()){
					String targetEntityPostName = field.getDataType();
					
					for(Entity item: cloneOfEntitiesInModule){
						if(item.getName().equals(targetEntityPostName)) {
							String fieldName = field.getName(); //+ UUID.randomUUID().toString();
							//item.getRelatedChildFields().put(fieldName, field);
							item.getRelatedChildEntities().put(fieldName, entity);
						}

					}
				}

			}
		}
		module.setEntities(cloneOfEntitiesInModule);
		return module;
	}

}
