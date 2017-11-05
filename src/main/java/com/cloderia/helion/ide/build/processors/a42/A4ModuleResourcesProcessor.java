/**
 * 
 */
package com.cloderia.helion.ide.build.processors.a42;

import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator;
import com.cloderia.helion.ide.build.processors.BuildProcessor;
import com.cloderia.helion.ide.util.FileUtil;
import com.cloderia.helion.ide.util.StringUtil;

/**
 * @author adrian
 *
 */
public class A4ModuleResourcesProcessor extends AbstractBuildProcessorDecorator {
	
	
	/**
	 * @param processor
	 */
	public A4ModuleResourcesProcessor(BuildProcessor<BuildContext> processor){
		super(processor);
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.build.processors.AbstractProcessorDecorator#decorate(com.cloderia.helion.ide.build.BuildContext)
	 */
	@Override
	protected BuildContext decorate(BuildContext context) {
		// Copy the main and ua src/app folders
		String sourceDir = context.getResourcesDir().concat(A4ProjectDirectoryBuilder.A4_APP_DIR);
		String uaResourceDir = context.getUaResourcesDir().concat(StringUtil.trailingSlashIt(context.getArtifactId()));
		
		FileUtil.copyDirectory(sourceDir, context.getTargetDir().concat(A4ProjectDirectoryBuilder.A4_APP_DIR));
		FileUtil.copyDirectory(uaResourceDir.concat(A4ProjectDirectoryBuilder.A4_APP_DIR), context.getTargetDir().concat(A4ProjectDirectoryBuilder.A4_APP_DIR));
		return context;
	}
}




