/**
 * 
 */
package com.cloderia.helion.ide.build.processors.a4;

import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator;
import com.cloderia.helion.ide.build.processors.BuildProcessor;
import com.cloderia.helion.ide.util.FileUtil;
import com.cloderia.helion.ide.util.StringUtil;

/**
 * @author adrian
 *
 */
public class A4ProjectDirectoryBuilder extends AbstractBuildProcessorDecorator {
	
	/* Target directories */
	public static final String A4_SRC_DIR = StringUtil.trailingSlashIt("src");
	public static final String A4_APP_DIR = A4_SRC_DIR + StringUtil.trailingSlashIt("app");
	public static final String A4_API_DIR = A4_APP_DIR + StringUtil.trailingSlashIt("api");
	public static final String A4_DATA_DIR = A4_APP_DIR + StringUtil.trailingSlashIt("data");
	public static final String A4_SERVICES_DIR = A4_APP_DIR + StringUtil.trailingSlashIt("services");
	public static final String A4_COMPONENTS_DIR = A4_APP_DIR + StringUtil.trailingSlashIt("components");
	
	/**
	 * @param processor
	 */
	public A4ProjectDirectoryBuilder(BuildProcessor<BuildContext> processor){
		super(processor);
	}
	
	@Override
	protected BuildContext decorate(BuildContext context) {
		System.out.println("############################## A4ProjectDirectoryBuilder");
		//FileUtil.deleteDir(context.getTargetDir());
		FileUtil.createDirectoryIfNeeded(context.getTargetDir());
		FileUtil.createDirectoryIfNeeded(context.getTargetDir().concat(A4_SRC_DIR));
		FileUtil.createDirectoryIfNeeded(context.getTargetDir().concat(A4_APP_DIR));
		FileUtil.createDirectoryIfNeeded(context.getTargetDir().concat(A4_COMPONENTS_DIR));
		FileUtil.createDirectoryIfNeeded(context.getTargetDir().concat(A4_SERVICES_DIR));
		FileUtil.createDirectoryIfNeeded(context.getTargetDir().concat(A4_DATA_DIR));
		FileUtil.createDirectoryIfNeeded(context.getTargetDir().concat(A4_API_DIR));
		return context;
	}

	
}
