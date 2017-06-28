/**
 * 
 */
package com.cloderia.helion.ide.builder.errais;

import com.cloderia.helion.ide.app.Entity;
import com.cloderia.helion.ide.builder.AbstractEntityArtifactBuilder;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public class ErraiServiceBuilder extends AbstractEntityArtifactBuilder {

	private static final String SERVICES_ERRAI_INTERFACE_FTL = "services/interface.ftl";
	private static final String SERVICES_ERRAI_IMPLEMENTATION_FTL = "services/implementation.ftl";
	private static final String SERVICES_ERRAI_ENTITY_IMPLEMENTATION_FTL = "services/entity-implementation.ftl";

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.AbstractEntityArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration, com.cloderia.helion.ide.app.Entity)
	 */
	public void build(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		
		String apiTempate = (entity.getServiceTemplate() != null) ? entity.getServiceTemplate() : SERVICES_ERRAI_INTERFACE_FTL;
		String apiImplTempate = (entity.getServiceImplTemplate() != null) ? entity.getServiceImplTemplate() : SERVICES_ERRAI_IMPLEMENTATION_FTL;
		String entityApiImplTempate = (entity.getEntityServiceImplTemplate() != null) ? entity.getEntityServiceImplTemplate() : SERVICES_ERRAI_ENTITY_IMPLEMENTATION_FTL;
		
		if(entity.isHasEndpoint())
			this.generateArtifact(buildConfiguration, entity, apiTempate, entity.getName() + "RESTService.java", buildConfiguration.getTargetDir().concat(IDEConstants.INTERFACE_DIR));

		if(entity.isHasServices()) {
			this.generateArtifact(buildConfiguration, entity, apiImplTempate, entity.getName() + "RESTServiceImpl.java", buildConfiguration.getTargetDir().concat(IDEConstants.IMPLEMENTATION_DIR));
			this.generateArtifact(buildConfiguration, entity, entityApiImplTempate, entity.getName() + "EntityService.java", buildConfiguration.getTargetDir().concat(IDEConstants.IMPLEMENTATION_DIR));
		}
	}

}
