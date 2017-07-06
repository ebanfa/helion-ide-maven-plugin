/**
 * 
 */
package com.cloderia.helion.ide.util;

import java.util.ArrayList;
import java.util.List;

import com.cloderia.helion.ide.artifact.Entity;
import com.cloderia.helion.ide.artifact.Field;
import com.cloderia.helion.ide.artifact.Module;

/**
 * @author adrian
 *
 */
public class PropertyUtils {
	
	public static Module inspectEntityFields(Module module) {
		List<Entity> entitiesInModule = module.getEntities();
		// Loop through all the entities in the module
		for(Entity entity : module.getEntities()){
			List<Field> fieldsInEntity = entity.getFields();
			// Process the fields in the entity
			for(Field field : fieldsInEntity){
				// Only process relationship fields
				String javaName = "";
				String fieldName = field.getName();
				if(fieldName.contains("_")){
					String[] nameParts = fieldName.split("_");
					for (int i = 0; i < nameParts.length; i++) {
						String part = nameParts[i];
						if(i != 0) {
							part = part.substring(0, 1).toUpperCase() + part.substring(1);
						}
						javaName = javaName.concat(part);
					}
				}
				else {
					javaName = fieldName;
				}
				field.setJavaName(javaName);
			}
		}
		module.setEntities(entitiesInModule);
		return module;
	}
	

	public static Module inspectRelatedChildEntities(Module module) {
		List<Entity> entitiesInModule = module.getEntities();
		List<Entity> cloneOfEntitiesInModule = new ArrayList(entitiesInModule);
		// Loop through all the entities in the module
		for(Entity entity : module.getEntities()){
			List<Field> fieldsInEntity = entity.getFields();
			// Process the fields in the entity
			for(Field field : fieldsInEntity){
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
