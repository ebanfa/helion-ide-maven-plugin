/**
 * 
 */
package com.cloderia.helion.ide.build.processors;

import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.artifacts.EntityModuleProcessor;
import com.cloderia.helion.ide.build.processors.artifacts.ModuleDataProcessor;
import com.cloderia.helion.ide.build.processors.loaders.DBApplicationDataLoader;
import com.cloderia.helion.ide.build.processors.misc.BuildLogger;
import com.cloderia.helion.ide.build.processors.wildfly.ACJProjectDirectoryBuilder;

/**
 * @author adrian
 *
 */
public class NGWildflyApplicationGenerator extends AbstractBuildProcessor<BuildContext> {

	@Override
	protected BuildContext doBuild(BuildContext context) {
		System.out.println("#####################################################");
		System.out.println("########### NGWildflyApplicationGenerator ###########");
		System.out.println("#####################################################");
		return new ACJProjectDirectoryBuilder(
			new DBApplicationDataLoader(
				new ModuleDataProcessor (
					new EntityModuleProcessor (new BuildLogger())))).build(context);
	}

}
