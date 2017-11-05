/**
 * 
 */
package com.cloderia.helion.ide.build.processors.wp;

import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessor;
import com.cloderia.helion.ide.build.processors.BuildLogger;

/**
 * @author adrian
 *
 */
public class WPApplicationGenerator extends AbstractBuildProcessor<BuildContext> {

	@Override
	protected BuildContext doBuild(BuildContext context) {
		System.out.println("############################## WPApplicationGenerator");
		return new WPProjectDirectoryBuilder(
			new WPProjectResourceProcessor(
				new WPEntityModelGenerator (
					new WPEntityServiceGenerator (
						new BuildLogger()))))
		.build(context);
	}


}
