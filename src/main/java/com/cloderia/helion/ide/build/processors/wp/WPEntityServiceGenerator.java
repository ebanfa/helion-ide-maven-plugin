/**
 * 
 */
package com.cloderia.helion.ide.build.processors.wp;

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
public class WPEntityServiceGenerator extends AbstractBuildProcessorDecorator {

	private static final String WP_ENTITY_SERVICE_TMPL_FTL = "service/${entity}-service-php.ftl";

	/**
	 * @param processor
	 */
	public WPEntityServiceGenerator(BuildProcessor<BuildContext> processor) {
		super(processor);
	}
	
	@Override
	protected BuildContext decorate(BuildContext context) {
		// The target 'components' directory
		/*String servicesDir = context.getWpTargetDir().concat(WPProjectResourceProcessor.WP_SERVICES_DIR);
		// Loop through module down to entities and for each entity generate its artefacts
		for(ModuleData moduleData: context.getApplicationData().getModules()) {
			for(EntityData entity : moduleData.getEntities()) {
				if(entity.isHasServices()) {
					try {
						String dataObjectTarget = entity.getName() + "Service.php";
						IDEUtil.generateArtifact(context, entity, WP_ENTITY_SERVICE_TMPL_FTL, dataObjectTarget, servicesDir);
					} catch (IDEException e) {
						e.printStackTrace();
					}
				}
			}
		}*/
		return context;
	}

}
