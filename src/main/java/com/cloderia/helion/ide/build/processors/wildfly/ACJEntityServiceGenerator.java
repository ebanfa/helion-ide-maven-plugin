/**
 * 
 */
package com.cloderia.helion.ide.build.processors.wildfly;

import com.cloderia.helion.ide.IDEException;
import com.cloderia.helion.ide.artifacts.Entity;
import com.cloderia.helion.ide.artifacts.Module;
import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator;
import com.cloderia.helion.ide.build.processors.BuildProcessor;
import com.cloderia.helion.ide.util.IDEUtil;

/**
 * @author adrian
 *
 */
public class ACJEntityServiceGenerator extends AbstractBuildProcessorDecorator {

	private static final String SERVICES_INTERFACE_FTL = "services/entity-service-interface.ftl";
	private static final String SERVICES_IMPLEMENTATION_FTL = "services/entity-service-implementation.ftl";
	
	/**
	 * @param processor
	 */
	public ACJEntityServiceGenerator(BuildProcessor<BuildContext> processor){
		super(processor);
	}

	@Override
	protected BuildContext decorate(BuildContext context) {
		// The target 'components' directory
		String entityTargetDir = context.getTargetDir().concat(ACJProjectDirectoryBuilder.JAVA_SERVICE_PERSISTENCE_DIR);
		String entityOpTargetDir = context.getTargetDir().concat(ACJProjectDirectoryBuilder.JAVA_SERVICE_IMPL_PERSISTENCE_DIR);
		// Loop through module down to entities and for each entity generate its artefacts
		for(Module moduleData: context.getApplication().getModules()) {
			for(Entity entity : moduleData.getEntities()) {
				try {
					System.out.println(">>>>>>>>>>>>>>>" + entity.getName());
					String serviceFileName = entity.getName().concat("EntityService.java");
					String serviceImplOpFileName = entity.getName().concat("EntityServiceImpl.java");
					IDEUtil.generateArtifact(context, entity, SERVICES_INTERFACE_FTL, serviceFileName, entityTargetDir);
					IDEUtil.generateArtifact(context, entity, SERVICES_IMPLEMENTATION_FTL, serviceImplOpFileName, entityOpTargetDir);
				} catch (IDEException e) {
					e.printStackTrace();
				}
			}
		}
		return context;
	}

}
