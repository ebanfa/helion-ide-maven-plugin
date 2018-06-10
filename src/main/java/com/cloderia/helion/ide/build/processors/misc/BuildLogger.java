/**
 * 
 */
package com.cloderia.helion.ide.build.processors.misc;

import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessor;

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
