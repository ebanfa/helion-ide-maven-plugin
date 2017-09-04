/**
 * 
 */
package com.cloderia.helion.ide.build.processors;

import com.cloderia.helion.ide.build.BuildContext;

/**
 * @author adrian
 *
 */
public class BuildLogger extends AbstractBuildProcessor<BuildContext> {

	@Override
	protected BuildContext doBuild(BuildContext context) {
		System.out.println(context);
		return context;
	}

}
