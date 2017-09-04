/**
 * 
 */
package com.cloderia.helion.ide.build.processors.wp;

import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator;
import com.cloderia.helion.ide.build.processors.BuildProcessor;
import com.cloderia.helion.ide.util.FileUtil;
import com.cloderia.helion.ide.util.StringUtil;

/**
 * @author adrian
 *
 */
public class WPProjectDirectoryBuilder extends AbstractBuildProcessorDecorator {

	/* Target directories */
	public static final String WP_INCLUDES_DIR = StringUtil.trailingSlashIt("inc");
	
	/**
	 * @param processor
	 */
	public WPProjectDirectoryBuilder(BuildProcessor<BuildContext> processor){
		super(processor);
	}
	
	@Override
	protected BuildContext decorate(BuildContext context) {
		System.out.println("############################## WPProjectDirectoryBuilder");
		FileUtil.createDirectoryIfNeeded(context.getWpTargetDir());
		FileUtil.createDirectoryIfNeeded(context.getWpTargetDir().concat(WPProjectResourceProcessor.WP_INCLUDES_DIR));
		FileUtil.createDirectoryIfNeeded(context.getWpTargetDir().concat(WPProjectResourceProcessor.WP_ENDPOINTS_DIR));
		return context;
	}

}
