/**
 * 
 */
package com.cloderia.helion.ide.builder.errai;

import com.cloderia.helion.ide.artifact.Module;
import com.cloderia.helion.ide.artifact.ServiceDefinition;
import com.cloderia.helion.ide.builder.AbstractServiceArtifactProcessor;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.BuilderUtils;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEException;

/**
 * @author adrian
 *
 */
public class ErraiMicroServiceBuilder extends AbstractServiceArtifactProcessor {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.builder.AbstractServiceArtifactProcessor#execute(com.cloderia.helion.ide.configuration.BuildConfiguration, com.cloderia.helion.ide.artifact.ServiceDefinition)
	 */
	@Override
	public void execute(BuildConfiguration buildConfiguration, ServiceDefinition serviceDefinition)
			throws IDEException {

		Module module = serviceDefinition.getModule();
		String modulePath = module.getName().toLowerCase().concat("/");
		
		String dataObjectTemplate = serviceDefinition.getDataObject();
		String interfaceTemplate = serviceDefinition.getServiceInterface();
		String interfaceImplementationTemplate = serviceDefinition.getServiceInterfaceImpl();
		String serviceImplementationTemplate = serviceDefinition.getServiceImplementation();
		
		BuilderUtils.generateArtifact(buildConfiguration, serviceDefinition, interfaceTemplate, 
				serviceDefinition.getName() + "Service.java", buildConfiguration.getTargetDir().concat(IDEConstants.INTERFACE_DIR).concat(modulePath));
		
		BuilderUtils.generateArtifact(buildConfiguration, serviceDefinition, interfaceImplementationTemplate, 
				serviceDefinition.getName() + "ServiceImpl.java", buildConfiguration.getTargetDir().concat(IDEConstants.IMPLEMENTATION_DIR).concat(modulePath));
		
		BuilderUtils.generateArtifact(buildConfiguration, serviceDefinition, serviceImplementationTemplate, 
				serviceDefinition.getName() + "MicroService.java", buildConfiguration.getTargetDir().concat(IDEConstants.IMPLEMENTATION_DIR).concat(modulePath));
		
		BuilderUtils.generateArtifact(buildConfiguration, serviceDefinition, dataObjectTemplate, 
				serviceDefinition.getName() + "Operation.java", buildConfiguration.getTargetDir().concat(IDEConstants.OPS_DIR));
	}

}
