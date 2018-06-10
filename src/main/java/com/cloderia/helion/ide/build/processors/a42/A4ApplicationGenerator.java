/**
 * 
 */
package com.cloderia.helion.ide.build.processors.a42;

import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessor;
import com.cloderia.helion.ide.build.processors.misc.BuildLogger;
import com.cloderia.helion.ide.build.processors.misc.EntityFieldProcessor;

/**
 * @author adrian
 *
 */
public class A4ApplicationGenerator extends AbstractBuildProcessor<BuildContext> {

	@Override
	protected BuildContext doBuild(BuildContext context) {
		System.out.println("############################## A4ApplicationGenerator");
		return new A4ProjectDirectoryBuilder(
				new A4ProjectResourcesProcessor(
					new EntityFieldProcessor(
						new ModuleArtifactsGenerator(
							new A4ModuleResourcesProcessor(
								new BuildLogger()))))).build(context);
	}

}
