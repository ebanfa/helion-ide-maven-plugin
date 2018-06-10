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
import com.cloderia.helion.ide.util.StringUtil;

/**
 * @author adrian
 *
 */
public class ACJEntityDataObjectGenerator extends AbstractBuildProcessorDecorator {

	private static final String A4_ENTITY_DATA_OBJ_TMPL_FTL = "entities/${entity}.ftl";
	private static final String A4_ENTITY_OPS_OBJ_TMPL_FTL = "entities/${entity}-ops.ftl";

	/**
	 * @param processor
	 */
	public ACJEntityDataObjectGenerator(BuildProcessor<BuildContext> processor) {
		super(processor);
	}
	
	@Override
	protected BuildContext decorate(BuildContext context) {
		// The target 'components' directory
		String entityTargetDir = context.getTargetDir().concat(ACJProjectDirectoryBuilder.JAVA_ENTITY_PERSISTENCE_DIR);
		String entityOpTargetDir = context.getTargetDir().concat(ACJProjectDirectoryBuilder.JAVA_ENTITY_OP_PERSISTENCE_DIR);
		// Loop through module down to entities and for each entity generate its artefacts
		for(Module moduleData: context.getApplication().getModules()) {
			for(Entity entity : moduleData.getEntities()) {
				try {
					System.out.println(">>>>>>>>>>>>>>>" + entity.getName());
					String entityFileName = entity.getName().concat(".java");
					String entityOpFileName = entity.getName().concat("Operation.java");
					IDEUtil.generateArtifact(context, entity, A4_ENTITY_DATA_OBJ_TMPL_FTL, entityFileName, entityTargetDir);
					IDEUtil.generateArtifact(context, entity, A4_ENTITY_OPS_OBJ_TMPL_FTL, entityOpFileName, entityOpTargetDir);
				} catch (IDEException e) {
					e.printStackTrace();
				}
			}
		}
		return context;
	}

}
