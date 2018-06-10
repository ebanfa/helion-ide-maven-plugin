/**
 * 
 */
package com.cloderia.helion.ide.build.processors.wildfly;

import com.cloderia.helion.ide.artifacts.Module;
import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator;
import com.cloderia.helion.ide.build.processors.BuildProcessor;
import com.cloderia.helion.ide.util.FileUtil;
import com.cloderia.helion.ide.util.StringUtil;

/**
 * @author adrian
 *
 */
public class ACJProjectDirectoryBuilder extends AbstractBuildProcessorDecorator {

	public static final String SRC_DIR = StringUtil.trailingSlashIt("src");
	public static final String SRC_MAIN_DIR = SRC_DIR + StringUtil.trailingSlashIt("main");
	public static final String JAVA_DIR = SRC_MAIN_DIR + StringUtil.trailingSlashIt("java");
	public static final String RESOURCES_DIR = SRC_MAIN_DIR + StringUtil.trailingSlashIt("resources");
	public static final String JAVA_PACKAGE_DIR = JAVA_DIR + StringUtil.trailingSlashIt("com/alstracoin/token");
	public static final String JAVA_PERSISTENCE_DIR = JAVA_PACKAGE_DIR + StringUtil.trailingSlashIt("persistence");
	public static final String JAVA_ENTITY_PERSISTENCE_DIR = JAVA_PERSISTENCE_DIR + StringUtil.trailingSlashIt("entity");
	public static final String JAVA_ENTITY_OP_PERSISTENCE_DIR = JAVA_PERSISTENCE_DIR + StringUtil.trailingSlashIt("operation");
	public static final String JAVA_SERVICE_PERSISTENCE_DIR = JAVA_PERSISTENCE_DIR + StringUtil.trailingSlashIt("service");
	public static final String JAVA_SERVICE_IMPL_PERSISTENCE_DIR = JAVA_SERVICE_PERSISTENCE_DIR + StringUtil.trailingSlashIt("impl");
	
	
	/**
	 * @param processor
	 */
	public ACJProjectDirectoryBuilder(BuildProcessor<BuildContext> processor){
		super(processor);
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator#decorate(com.cloderia.helion.ide.build.BuildContext)
	 */
	@Override
	protected BuildContext decorate(BuildContext context) {
		// Build the angular4 directory structure
		String targetDir = context.getTargetDir();
		FileUtil.deleteDir(targetDir);
		FileUtil.createDirectoryIfNeeded(targetDir);
		FileUtil.createDirectoryIfNeeded(targetDir.concat(SRC_DIR));
		FileUtil.createDirectoryIfNeeded(targetDir.concat(SRC_MAIN_DIR));
		FileUtil.createDirectoryIfNeeded(targetDir.concat(JAVA_DIR));
		FileUtil.createDirectoryIfNeeded(targetDir.concat(RESOURCES_DIR));
		FileUtil.createDirectoryIfNeeded(targetDir.concat(JAVA_PACKAGE_DIR));
		FileUtil.createDirectoryIfNeeded(targetDir.concat(JAVA_PERSISTENCE_DIR));
		return context;
	}
	
}
