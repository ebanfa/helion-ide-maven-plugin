/**
 * 
 */
package com.cloderia.helion.ide.build.processors.wp;

import com.cloderia.helion.ide.IDEException;
import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator;
import com.cloderia.helion.ide.build.processors.BuildProcessor;
import com.cloderia.helion.ide.util.IDEUtil;

/**
 * @author adrian
 *
 */
public class WPProjectConfigurationProcessor extends AbstractBuildProcessorDecorator {
	
	private static final String WP_BUILD_CONFIG = "config/errai/altium/altium-wp.xml";

	public WPProjectConfigurationProcessor(BuildProcessor<BuildContext> processor) {
		super(processor);
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator#decorate(com.cloderia.helion.ide.build.BuildContext)
	 */
	@Override
	protected BuildContext decorate(BuildContext context) {
		System.out.println("############################## WPProjectConfigurationProcessor");
		try {
			String wpConfiguration = context.getProjectDir().concat(WP_BUILD_CONFIG);
			context.put("wpConfigData", IDEUtil.loadApplicationData(wpConfiguration));
		} catch (IDEException e) {
			e.printStackTrace();
		}
		return context;
	}

}
