/**
 * 
 */
package com.cloderia.helion.ide.build.processors;

import java.util.ArrayList;
import java.util.List;

import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.data.ApplicationData;
import com.cloderia.helion.ide.data.EntityData;
import com.cloderia.helion.ide.data.FieldData;
import com.cloderia.helion.ide.data.ModuleData;
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
		for(ModuleData moduleData: context.getApplicationData().getModules()) {
			processEntitiesInModule(context, moduleData);
			inspectRelatedChildEntities(moduleData);
		}
		return context;
	}

	/**
	 * @param context
	 * @param moduleData
	 */
	protected void processEntitiesInModule(BuildContext context, ModuleData moduleData) {
		for(EntityData entity : moduleData.getEntities()) {
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
					field.setParentEntity(findEntityInApplication(field.getDataType(), context.getApplicationData()));
				}
			}
		}
	}

	/**
	 * @param name
	 * @param application
	 * @return
	 */
	public EntityData findEntityInApplication(String name, ApplicationData application){
		for(ModuleData module: application.getModules()){
			for(EntityData entity: module.getEntities()){
				if(entity.getName().equals(name)){
					return entity;
				}
			}
		}
		return null;
	}

	public ModuleData inspectRelatedChildEntities(ModuleData module) {
		List<EntityData> entitiesInModule = module.getEntities();
		List<EntityData> cloneOfEntitiesInModule = new ArrayList<EntityData>(entitiesInModule);
		// Loop through all the entities in the module
		for(EntityData entity : module.getEntities()){
			List<FieldData> fieldsInEntity = entity.getFields();
			// Process the fields in the entity
			for(FieldData field : fieldsInEntity){
				// Only process relationship fields
				if(field.isRelationshipField()){
					String targetEntityPostName = field.getDataType();
					
					for(EntityData item: cloneOfEntitiesInModule){
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
