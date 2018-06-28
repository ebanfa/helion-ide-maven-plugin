/**
 * 
 */
package com.cloderia.helion.ide.pipeline.util;

import java.util.List;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.ide.model.DatabaseData;
import com.cloderia.helion.ide.model.Entity;
import com.cloderia.helion.ide.model.Module;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.StringUtil;
import com.cloderia.helion.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.PipelineException;

/**
 * @author Edward Banfa
 *
 */
public class EJBDataModuleUtil {


	/**
	 * @param module
	 * @param context
	 * @return
	 */
	public static Module loadEntitiesIntoModule(Module module, List<Entity> entitiesInDB, PipelineContext context) {
		try {
			// Load the entities from the config file
			List<Entity> configuredEntities = ConfigurationUtil.loadEntities(module, context);
			// Copy the entities specified in the config file from the DB entities into the module
			for(Entity dbEntity: entitiesInDB) {
				for(Entity configuredEntity: configuredEntities) {
					if(dbEntity.getId().equals(configuredEntity.getId())) {
						dbEntity.setParentModule(module);
						module.getEntities().add(dbEntity);
					}
				}
			}
			return module;
		} catch (HelionException e) {
			throw new PipelineException(e);
		}
	}
	
	/**
	 * @param module
	 * @param context
	 * @throws HelionException
	 */
	public static void generateEJBDataArtifacts(Module module, PipelineContext context) throws HelionException {
		// Generate the JPA entities, the persistence XML and the JPA entity services
		generateJPAEntitySources(module, context);
		generatePersistenceXMLFile(module, context);
	}

	/**
	 * @param module
	 * @param context
	 * @throws HelionException
	 */
	private static void generateJPAEntitySources(Module module, PipelineContext context) throws HelionException {
		String moduleDir = ModuleUtil.getPackageDir(module, context);
		String ejbEntitySourceDir = moduleDir.concat(IDEConstants.JAVA_PERSISTENCE_DIR) ;
		String ejbEntityOpsSourceDir = moduleDir.concat(IDEConstants.JAVA_PERSISTENCE_OPS_DIR) ;
		String jpaEntityServiceSourceDir = moduleDir.concat(IDEConstants.JAVA_SERVICE_DIR) ;
		
		for(Entity entity: module.getEntities()) {
			String entitySourceFileName = entity.getName().concat(".java");
			String entityOpsSourceFileName = entity.getName().concat("Operation.java");
			String entityServiceSourceFileName = entity.getName().concat("EntityService.java");
			String entityServiceImplSourceFileName = entity.getName().concat("EntityServiceImpl.java");
			TemplateUtil.generateArtifact(context, entity, getEntityTemplate(entity), entitySourceFileName, ejbEntitySourceDir);
			TemplateUtil.generateArtifact(context, entity, getEntityOpsTemplate(entity), entityOpsSourceFileName, ejbEntityOpsSourceDir);
			TemplateUtil.generateArtifact(context, entity, getEntityServiceTemplate(entity), entityServiceSourceFileName, jpaEntityServiceSourceDir);
			TemplateUtil.generateArtifact(context, entity, getEntityServiceImplTemplate(entity), entityServiceImplSourceFileName, jpaEntityServiceSourceDir);
		}
	}

	/**
	 * @param module
	 * @param context
	 * @throws HelionException
	 */
	private static void generatePersistenceXMLFile(Module module, PipelineContext context) throws HelionException {
		String moduleDir = ModuleUtil.getProjectDir(module, context);
		String metaInfDir = moduleDir.concat(IDEConstants.RESOURCES_META_INF_DIR);
		DatabaseData databaseData = context.getApplication().getDatabase();
		TemplateUtil.generateArtifact(context, databaseData, IDEConstants.PERSISTENCE_XML_TMPL_FTL, IDEConstants.PERSISTENCE_XML, metaInfDir);
	}
	
	/**
	 * @param entity
	 * @return
	 */
	private static String getEntityServiceTemplate(Entity entity) {
		if(entity.getArtifactConfig() != null) {
			if(StringUtil.isValidString(entity.getArtifactConfig().getEntityServiceTemplateFile()))
				return entity.getArtifactConfig().getEntityServiceTemplateFile();
		}
		return IDEConstants.ENTITY_JAVA_SERVICE_TMPL_FTL;
	}

	/**
	 * @param entity
	 * @return
	 */
	private static String getEntityServiceImplTemplate(Entity entity) {
		if(entity.getArtifactConfig() != null) {
			if(StringUtil.isValidString(entity.getArtifactConfig().getEntityServiceImplTemplateFile()))
				return entity.getArtifactConfig().getEntityServiceImplTemplateFile();
		}
		return IDEConstants.ENTITY_JAVA_SERVICE_IMPL_TMPL_FTL;
	}

	/**
	 * @param entity
	 * @return
	 */
	private static String getEntityTemplate(Entity entity) {
		if(entity.getArtifactConfig() != null) {
			if(StringUtil.isValidString(entity.getArtifactConfig().getEntityTemplateFile()))
				return entity.getArtifactConfig().getEntityTemplateFile();
		}
		return IDEConstants.ENTITY_JAVA_TMPL_FTL;
	}

	/**
	 * @param entity
	 * @return
	 */
	private static String getEntityOpsTemplate(Entity entity) {
		if(entity.getArtifactConfig() != null) {
			if(StringUtil.isValidString(entity.getArtifactConfig().getEntityOpsTemplateFile()))
				return entity.getArtifactConfig().getEntityOpsTemplateFile();
		}
		return IDEConstants.ENTITY_OPS_JAVA_TMPL_FTL;
	}
}
