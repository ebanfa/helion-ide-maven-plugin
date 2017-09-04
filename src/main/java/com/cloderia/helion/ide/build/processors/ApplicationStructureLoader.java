/**
 * 
 */
package com.cloderia.helion.ide.build.processors;

import com.cloderia.helion.ide.IDEException;
import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.util.IDEUtil;

/**
 * @author adrian
 *
 */
public class ApplicationStructureLoader extends AbstractBuildProcessor<BuildContext> {

	@Override
	protected BuildContext doBuild(BuildContext context) {
		System.out.println("####Loading application Data");
		try {
			context.setApplicationData(IDEUtil.loadApplicationData(context.getConfig()));
		} catch (IDEException e) {
			e.printStackTrace();
		}
		return context;
	}

}
