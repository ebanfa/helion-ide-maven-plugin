/**
 * 
 */
package com.cloderia.helion.ide.build.processors.a4;

import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessor;
import com.cloderia.helion.ide.build.processors.BuildLogger;
import com.cloderia.helion.ide.build.processors.EntityFieldProcessor;

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
				  new EntityFieldProcessor (
				    new A4EntityDataObjectGenerator(
				      new A4EntityServiceGenerator(
				        new A4PortalEntityComponentGenerator(
				          new BuildLogger()))))))
			   .build(context);
	}

}
