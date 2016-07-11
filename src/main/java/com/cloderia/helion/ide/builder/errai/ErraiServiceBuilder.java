/**
 * 
 */
package com.cloderia.helion.ide.builder.errai;

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

	private static final String SERVICES_ERRAI_INTERFACE_FTL = "services/errai/interface.ftl";
	private static final String SERVICES_ERRAI_IMPLEMENTATION_FTL = "services/errai/implementation.ftl";

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.AbstractEntityArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration, com.cloderia.helion.ide.app.Entity)
	 */
	public void build(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		
		String apiTempate = (entity.getApiTemplate() != null) ? entity.getApiTemplate() : SERVICES_ERRAI_INTERFACE_FTL;
		String apiImplTempate = (entity.getApiImplTemplate() != null) ? entity.getApiImplTemplate() : SERVICES_ERRAI_IMPLEMENTATION_FTL;
		
		this.generateArtifact(buildConfiguration, entity, apiTempate, 
				entity.getName() + "Service.java", buildConfiguration.getTargetDir().concat(IDEConstants.INTERFACE_DIR));
		
		this.generateArtifact(buildConfiguration, entity, apiImplTempate, 
				entity.getName() + "ServiceImpl.java", buildConfiguration.getTargetDir().concat(IDEConstants.IMPLEMENTATION_DIR));
	}

}
