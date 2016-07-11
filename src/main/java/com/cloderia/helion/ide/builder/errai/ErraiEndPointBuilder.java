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
public class ErraiEndPointBuilder extends AbstractEntityArtifactBuilder {


	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.AbstractEntityArtifactBuilder#build(com.cloderia.helion.ide.configuration.BuildConfiguration, com.cloderia.helion.ide.app.Entity)
	 */
	public void build(BuildConfiguration buildConfiguration, Entity entity) throws IDEException {
		String apiTempate = entity.getEndPointTemplate();
		String apiImplTempate = entity.getEndPointImplTemplate();
		
		if(apiTempate == null) apiTempate = "endpoints/errai/interface.ftl";
		if(apiImplTempate == null) apiImplTempate = "endpoints/errai/implementation.ftl";
		
		this.generateArtifact(buildConfiguration, entity, apiTempate, 
				entity.getName() + "EndPoint.java", buildConfiguration.getTargetDir().concat(IDEConstants.REST_INTERFACE_DIR));
		this.generateArtifact(buildConfiguration, entity, apiImplTempate, 
				entity.getName() + "EndPointImpl.java", buildConfiguration.getTargetDir().concat(IDEConstants.REST_IMPLEMENTATION_DIR));
	}

}
