/**
 * 
 */
package com.cloderia.helion.ide.build.processors.a4;

import com.cloderia.helion.ide.IDEException;
import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator;
import com.cloderia.helion.ide.build.processors.BuildProcessor;
import com.cloderia.helion.ide.data.EntityData;
import com.cloderia.helion.ide.data.ModuleData;
import com.cloderia.helion.ide.util.IDEUtil;

/**
 * @author adrian
 *
 */
public class A4EntityDataObjectGenerator extends AbstractBuildProcessorDecorator {

	private static final String A4_ENTITY_DATA_OBJ_TMPL_FTL = "entities/${entity}-data-ts.ftl";

	/**
	 * @param processor
	 */
	public A4EntityDataObjectGenerator(BuildProcessor<BuildContext> processor) {
		super(processor);
	}
	
	@Override
	protected BuildContext decorate(BuildContext context) {
		// The target 'components' directory
		String componentDir = context.getTargetDir().concat(
				A4ProjectResourcesProcessor.A4_APP_DATA_OBJECCT_DIR);
		// Loop through module down to entities and for each entity generate its artefacts
		for(ModuleData moduleData: context.getApplicationData().getModules()) {
			for(EntityData entity : moduleData.getEntities()) {
				if(entity.isHasServices()) {
					try {
						String dataObjectTarget = entity.getLCName() + ".ts";
						String moduleDir = componentDir.concat(IDEUtil.getEntityPath(entity));
						IDEUtil.generateArtifact(context, entity, A4_ENTITY_DATA_OBJ_TMPL_FTL, dataObjectTarget, moduleDir);
					} catch (IDEException e) {
						e.printStackTrace();
					}
				}	
			}
		}
		return context;
	}

}
