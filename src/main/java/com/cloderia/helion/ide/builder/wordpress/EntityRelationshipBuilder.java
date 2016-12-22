/**
 * 
 */
package com.cloderia.helion.ide.builder.wordpress;

import java.util.ArrayList;
import java.util.List;

import com.cloderia.helion.ide.app.Application;
import com.cloderia.helion.ide.app.Entity;
import com.cloderia.helion.ide.app.Field;
import com.cloderia.helion.ide.app.Module;
import com.cloderia.helion.ide.builder.AbstractArtifactBuilder;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public class EntityRelationshipBuilder extends AbstractArtifactBuilder {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.ArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public void build(BuildConfiguration buildConfiguration) throws IDEException {
		Application application = buildConfiguration.getApplication();
		for (Module module : application.getModules()) {
			this.processRelatedChildEntities(module);
		}
	}
	
	/**
	 * @param module
	 */
	private void processRelatedChildEntities(Module module) {
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
						if(item.getPostName().equals(targetEntityPostName)) {
							String fieldName = field.getName(); //+ UUID.randomUUID().toString();
							item.getRelatedChildEntities().put(fieldName, entity);
						}
					}
				}
			}
		}
		module.setEntities(cloneOfEntitiesInModule);
	}

}
