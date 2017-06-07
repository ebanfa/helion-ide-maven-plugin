/**
 * 
 */
package com.cloderia.helion.ide.builder.errais;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.cloderia.helion.ide.app.Entity;
import com.cloderia.helion.ide.app.Field;
import com.cloderia.helion.ide.builder.AbstractEntityArtifactBuilder;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public class JPAEntityBuilder extends AbstractEntityArtifactBuilder {
	
	private static final String ENTITIES_ERRAI_ENTITY_FTL = "entities/errai/entity.ftl";
	private static final String ENTITIES_ERRAI_ENTITY_OPS_FTL = "entities/errai/entity-ops.ftl";

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.AbstractEntityArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration, com.cloderia.helion.ide.app.Entity)
	 */
	public void build(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		this.processRelatedUIEntityRelationship(buildConfiguration, entity);
		Map<String, Field> uniqueFields = new HashMap<String, Field>();
		for(Field field : entity.getFields()){
			if(field.isRelationshipField()) {
				if(!uniqueFields.containsKey(field.getDataType()))
					uniqueFields.put(field.getDataType(), field);
			}
		}
		entity.setVirtualFields(new ArrayList<Field>(uniqueFields.values()));
		

		if(entity.getModelTemplate() == null) entity.setModelTemplate(ENTITIES_ERRAI_ENTITY_FTL);
		if(entity.getEntityOpsTemplate() == null) entity.setEntityOpsTemplate(ENTITIES_ERRAI_ENTITY_OPS_FTL);
		
		this.generateArtifact(buildConfiguration, entity, entity.getModelTemplate(), 
				entity.getName() + ".java", buildConfiguration.getTargetDir().concat(IDEConstants.MODEL_DIR));
		
		this.generateArtifact(buildConfiguration, entity, entity.getEntityOpsTemplate(), 
				entity.getName() + "Operation.java", buildConfiguration.getTargetDir().concat(IDEConstants.OPS_DIR));
	}
	
	
}
