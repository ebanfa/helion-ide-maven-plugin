/**
 * 
 */
package com.cloderia.helion.ide.build.processors.a4;

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
public class A4EntityServiceGenerator extends AbstractBuildProcessorDecorator {

	private static final String SERVICES_ERRAI_INTERFACE_FTL = "services/entity-interface.ftl";
	private static final String SERVICES_ERRAI_IMPLEMENTATION_FTL = "services/entity-implementation.ftl";
	
	
	/**
	 * @param processor
	 */
	public A4EntityServiceGenerator(BuildProcessor<BuildContext> processor){
		super(processor);
	}
	
	@Override
	protected BuildContext decorate(BuildContext context) {
		String componentDir = context.getTargetDir().concat(A4ProjectResourcesProcessor.A4_APP_SERVICES_DIR);
		return generateServices(context, componentDir);
	}

	/**
	 * @param context
	 */
	protected BuildContext generateServices(BuildContext context, String componentDir) {
		
		for(Module moduleData: context.getApplication().getModules()){
			for(Entity entity : moduleData.getEntities()) {
				if(entity.isHasServices()) {
					try {
						generateEntityService(context, entity, componentDir.concat(IDEUtil.getEntityPath(entity)));
					} catch (IDEException e) {
						e.printStackTrace();
					}
				}	
			}
		}
		return context;
	}

	/**
	 * @param context
	 * @param entity
	 * @param moduleDir
	 * @throws IDEException
	 */
	protected void generateEntityService(BuildContext context, Entity entity, String moduleDir)
			throws IDEException {
		String interfaceTarget = entity.getLCName() + "-interface.service.ts";
		String implementationTarget = entity.getLCName() + "-implementation.service.ts";
		
		IDEUtil.generateArtifact(context, entity, SERVICES_ERRAI_INTERFACE_FTL, interfaceTarget, moduleDir);
		IDEUtil.generateArtifact(context, entity, SERVICES_ERRAI_IMPLEMENTATION_FTL, implementationTarget, moduleDir);
	}

	
	

}
