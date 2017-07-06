/**
 * 
 */
package com.cloderia.helion.ide.builder.errai;

import com.cloderia.helion.ide.artifact.Entity;
import com.cloderia.helion.ide.artifact.Module;
import com.cloderia.helion.ide.builder.AbstractEntityArtifactProcessor;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.BuilderUtils;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public class ErraiEntityServiceBuilder extends AbstractEntityArtifactProcessor {

	private static final String SERVICES_ERRAI_INTERFACE_FTL = "services/interface.ftl";
	private static final String SERVICES_ERRAI_IMPLEMENTATION_FTL = "services/implementation.ftl";
	private static final String SERVICES_ERRAI_ENTITY_FTL = "services/entity-service-interface.ftl";
	private static final String SERVICES_ERRAI_ENTITY_IMPLEMENTATION_FTL = "services/entity-implementation.ftl";

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.AbstractEntityArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration, com.cloderia.helion.ide.app.Entity)
	 */
	public void execute(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		
		Module module = entity.getModule();
		String modulePath = module.getName().toLowerCase().concat("/");
		String apiTempate = (entity.getServiceTemplate() != null) ? entity.getServiceTemplate() : SERVICES_ERRAI_INTERFACE_FTL;
		String apiImplTempate = (entity.getServiceImplTemplate() != null) ? entity.getServiceImplTemplate() : SERVICES_ERRAI_IMPLEMENTATION_FTL;
		String entityApiTempate = (entity.getEntityServiceTemplate() != null) ? entity.getEntityServiceTemplate() : SERVICES_ERRAI_ENTITY_FTL;
		String entityApiImplTempate = (entity.getEntityServiceImplTemplate() != null) ? entity.getEntityServiceImplTemplate() : SERVICES_ERRAI_ENTITY_IMPLEMENTATION_FTL;
		
		if(entity.isHasEndpoint()){
			BuilderUtils.generateArtifact(buildConfiguration, entity, apiTempate, entity.getName() + "RESTService.java", buildConfiguration.getTargetDir().concat(IDEConstants.INTERFACE_DIR).concat(modulePath));
			BuilderUtils.generateArtifact(buildConfiguration, entity, apiImplTempate, entity.getName() + "RESTServiceImpl.java", buildConfiguration.getTargetDir().concat(IDEConstants.IMPLEMENTATION_DIR).concat(modulePath));
		}
		if(entity.isHasServices()) {
			BuilderUtils.generateArtifact(buildConfiguration, entity, entityApiTempate, entity.getName() + "EntityService.java", buildConfiguration.getTargetDir().concat(IDEConstants.IMPLEMENTATION_DIR).concat(modulePath));
			BuilderUtils.generateArtifact(buildConfiguration, entity, entityApiImplTempate, entity.getName() + "EntityServiceImpl.java", buildConfiguration.getTargetDir().concat(IDEConstants.IMPLEMENTATION_DIR).concat(modulePath));
		}
	}

}
