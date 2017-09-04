/**
 * 
 */
package com.cloderia.helion.ide.build.processors.wp;

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
public class WPEntityModelGenerator extends AbstractBuildProcessorDecorator {

	private static final String WP_ENTITY_MODEL_TMPL_FTL = "model/entity-model-php.ftl";

	/**
	 * @param processor
	 */
	public WPEntityModelGenerator(BuildProcessor<BuildContext> processor) {
		super(processor);
	}
	
	@Override
	protected BuildContext decorate(BuildContext context) {
		// The target 'components' directory
		String modelDir = context.getWpTargetDir().concat(WPProjectResourceProcessor.WP_MODEL_DIR);
		// Loop through module down to entities and for each entity generate its artefacts
		for(ModuleData moduleData: context.getApplicationData().getModules()) {
			for(EntityData entity : moduleData.getEntities()) {
                try {
                    String dataObjectTarget = entity.getName() + ".php";
                    IDEUtil.generateArtifact(context, entity, WP_ENTITY_MODEL_TMPL_FTL, dataObjectTarget, modelDir);
                } catch (IDEException e) {
                    e.printStackTrace();
                }
			}
		}
		return context;
	}

}
