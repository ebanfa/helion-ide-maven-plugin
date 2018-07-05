/**
 * 
 */
package com.cloderia.helion.pipeline.util;

import java.util.List;

import com.cloderia.helion.exception.HelionException;
import com.cloderia.helion.model.database.DataBase;
import com.cloderia.helion.model.entity.Entity;
import com.cloderia.helion.model.module.EjbDataModule;
import com.cloderia.helion.model.module.Module;
import com.cloderia.helion.model.pipeline.PipelineContext;
import com.cloderia.helion.util.ArtifactConfigUtil;
import com.cloderia.helion.util.IDEConstants;
import com.cloderia.helion.util.TemplateUtil;

/**
 * @author Edward Banfa
 *
 */
public class EjbDataModuleUtil {

	/**
	 * @param module
	 * @param context
	 * @return
	 * @throws HelionException 
	 */
	public static <T extends Module> T loadEntitiesIntoModule(T module, List<Entity> entitiesInDB, PipelineContext context) throws HelionException {
		// Load the entities from the config file
		String entitiesConfigFile = ArtifactConfigUtil.getConfigParameterValue(
				IDEConstants.MODULE_ENTITIES_FILE_CONFIG_PARAM, module);
		EjbDataModule jPADataModule = ConfigurationUtil.loadModule(entitiesConfigFile, EjbDataModule.class);
		// Copy the entities specified in the config file from the DB entities into the module
		for(Entity dbEntity: entitiesInDB) {
			for(Entity configuredEntity: jPADataModule.getEntities()) {
				if(dbEntity.getId().equals(configuredEntity.getId())) {
					dbEntity.setModule(module);
					module.getEntities().add(dbEntity);
				}
			}
		}
		return module;
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
		String moduleDir = MavenUtil.getJavaPackageDir(module, context);
		String ejbEntitySourceDir = moduleDir.concat(IDEConstants.JAVA_PERSISTENCE_DIR) ;
		String ejbEntityOpsSourceDir = moduleDir.concat(IDEConstants.JAVA_PERSISTENCE_OPS_DIR) ;
		String jpaEntityServiceSourceDir = moduleDir.concat(IDEConstants.JAVA_SERVICE_DIR) ;
		
		for(Entity entity: module.getEntities()) {
			String entitySourceFileName = entity.getName().concat(".java");
			String entityOpsSourceFileName = entity.getName().concat("Operation.java");
			String entityServiceSourceFileName = entity.getName().concat("EntityService.java");
			String entityServiceImplSourceFileName = entity.getName().concat("EntityServiceImpl.java");
			TemplateUtil.generateArtifact(context, entity, TemplateUtil.getEntityTemplate(entity), entitySourceFileName, ejbEntitySourceDir);
			TemplateUtil.generateArtifact(context, entity, TemplateUtil.getEntityOpsTemplate(entity), entityOpsSourceFileName, ejbEntityOpsSourceDir);
			TemplateUtil.generateArtifact(context, entity, TemplateUtil.getEntityServiceTemplate(entity), entityServiceSourceFileName, jpaEntityServiceSourceDir);
			TemplateUtil.generateArtifact(context, entity, TemplateUtil.getEntityServiceImplTemplate(entity), entityServiceImplSourceFileName, jpaEntityServiceSourceDir);
		}
	}

	/**
	 * @param module
	 * @param context
	 * @throws HelionException
	 */
	private static void generatePersistenceXMLFile(Module module, PipelineContext context) throws HelionException {
		String moduleDir = MavenUtil.getProjectDir(module, context);
		String metaInfDir = moduleDir.concat(IDEConstants.RESOURCES_META_INF_DIR);
		DataBase databaseData = context.getApplication().getDataBase();
		TemplateUtil.generateArtifact(context, databaseData, IDEConstants.PERSISTENCE_XML_TMPL_FTL, IDEConstants.PERSISTENCE_XML, metaInfDir);
	}
}
