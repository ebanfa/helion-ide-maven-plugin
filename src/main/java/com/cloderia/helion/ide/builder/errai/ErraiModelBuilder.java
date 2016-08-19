/**
 * 
 */
package com.cloderia.helion.ide.builder.errai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.cloderia.helion.ide.app.Application;
import com.cloderia.helion.ide.app.Entity;
import com.cloderia.helion.ide.app.Field;
import com.cloderia.helion.ide.app.Module;
import com.cloderia.helion.ide.app.RelatedEntity;
import com.cloderia.helion.ide.builder.AbstractEntityArtifactBuilder;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public class ErraiModelBuilder extends AbstractEntityArtifactBuilder {
	
	private static final String ENTITIES_ERRAI_ENTITY_FTL = "entities/errai/entity.ftl";
	private static final String ENTITIES_ERRAI_ENTITY_OPS_FTL = "entities/errai/entity-ops.ftl";

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.AbstractEntityArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration, com.cloderia.helion.ide.app.Entity)
	 */
	public void build(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		String modelTemplateFile = ENTITIES_ERRAI_ENTITY_FTL;
		this.processRelatedUIEntityRelationship(buildConfiguration, entity);
		if(entity.getModelTemplate() != null) modelTemplateFile = entity.getModelTemplate();
		Map<String, Field> uniqueFields = new HashMap<String, Field>();
		for(Field field : entity.getFields()){
			if(field.isRelationshipField()) {
				if(!uniqueFields.containsKey(field.getDataType()))
					uniqueFields.put(field.getDataType(), field);
			}
		}
		entity.setVirtualFields(new ArrayList<Field>(uniqueFields.values()));
		
		this.generateArtifact(buildConfiguration, entity, modelTemplateFile, 
				entity.getName() + ".java", buildConfiguration.getTargetDir().concat(IDEConstants.MODEL_DIR));
		
		this.generateArtifact(buildConfiguration, entity, ENTITIES_ERRAI_ENTITY_OPS_FTL, 
				entity.getName() + "Operation.java", buildConfiguration.getTargetDir().concat(IDEConstants.OPS_DIR));
	}
	/**
	 * @param buildConfiguration
	 * @param entity
	 * @throws IDEException
	 */
	protected void processRelatedUIEntityRelationship(BuildConfiguration buildConfiguration, Entity entity)
			throws IDEException {
		Application application = buildConfiguration.getApplication();
		for(RelatedEntity relatedEntity: entity.getRelatedEntity()){
			Entity relatedEntityObject = this.findEntityInApplication(relatedEntity.getName(), application);
			relatedEntity.setEntity(relatedEntityObject);
			
			/*if(relatedEntityObject!=null){
				String dialogTemplateFile = "components/errai/entity-editor-dialog.ftl";
				String dialogOutputFile = relatedEntityObject.getName() + "EditorDialog.java";
				String relatedEntityNameLC = relatedEntityObject.getName().toLowerCase();
				String relatedEntityViewUIDir = buildConfiguration.getTargetDir().concat(IDEConstants.UI_DIR).concat(relatedEntityNameLC).concat("/");
				this.generateArtifact(buildConfiguration, relatedEntityObject, dialogTemplateFile, dialogOutputFile, relatedEntityViewUIDir);
			}*/
		}
	}
	
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
}
