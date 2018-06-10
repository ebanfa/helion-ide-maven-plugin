/**
 * 
 */
package com.cloderia.helion.ide.build.processors.wp;

import com.cloderia.helion.ide.IDEException;
import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator;
import com.cloderia.helion.ide.build.processors.BuildProcessor;
import com.cloderia.helion.ide.util.FileUtil;
import com.cloderia.helion.ide.util.IDEUtil;
import com.cloderia.helion.ide.util.StringUtil;

/**
 * @author adrian
 *
 */
public class WPProjectResourceProcessor extends AbstractBuildProcessorDecorator {

	/* Build resources directories */
	public static final String WP_INCLUDES_DIR = StringUtil.trailingSlashIt("inc");
	public static final String WP_VENDOR_PHP_DIR = StringUtil.trailingSlashIt("vendor");
	public static final String WP_TEMPLATES_PHP_DIR = StringUtil.trailingSlashIt("templates");
	public static final String WP_SERVICES_DIR = WP_INCLUDES_DIR + StringUtil.trailingSlashIt("service");
	public static final String WP_MODEL_DIR = WP_INCLUDES_DIR + StringUtil.trailingSlashIt("model");
	public static final String WP_UTIL_DIR = WP_INCLUDES_DIR + StringUtil.trailingSlashIt("util");
	public static final String WP_ENDPOINTS_DIR = WP_INCLUDES_DIR + StringUtil.trailingSlashIt("endpoint");
	private static final String WP_UTIL_FTL = "util/service-map-php.ftl";
	private static final String WP_INCLUDES_FTL = "wp-includes-php.ftl";
	private static final String WP_STYLE_FTL = "misc/styles-css.ftl";
	private static final String WP_DDL_FTL = "model/ddl-sql.ftl";
	
	/**
	 * @param processor
	 */
	public WPProjectResourceProcessor(BuildProcessor<BuildContext> processor){
		super(processor);
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.build.processors.AbstractProcessorDecorator#decorate(com.cloderia.helion.ide.build.BuildContext)
	 */
	@Override
	protected BuildContext decorate(BuildContext context) {

		/*FileUtil.copyFileToDirectory(context.getWpResourcesDir().concat("functions.php"), context.getWpTargetDir());
		FileUtil.copyFileToDirectory(context.getWpResourcesDir().concat("index.php"), context.getWpTargetDir());
		FileUtil.copyFileToDirectory(context.getWpResourcesDir().concat("style.css"), context.getWpTargetDir());
		FileUtil.copyFileToDirectory(context.getWpResourcesDir().concat("404.php"), context.getWpTargetDir());
		FileUtil.copyFileToDirectory(context.getWpResourcesDir().concat("README.txt"), context.getWpTargetDir());
		FileUtil.copyFileToDirectory(context.getWpResourcesDir().concat("screenshot.png"), context.getWpTargetDir());
		
		String wpUaAppPath = context.getArtifactId().concat("-wp/");

		FileUtil.copyDirectory(context.getWpResourcesDir().concat(WP_INCLUDES_DIR), context.getWpTargetDir().concat(WP_INCLUDES_DIR));
		FileUtil.copyDirectory(context.getWpResourcesDir().concat(WP_VENDOR_PHP_DIR), context.getWpTargetDir().concat(WP_VENDOR_PHP_DIR));
		FileUtil.copyDirectory(context.getWpUaResourcesDir().concat(wpUaAppPath.concat(WP_INCLUDES_DIR)), context.getWpTargetDir().concat(WP_INCLUDES_DIR));
		FileUtil.copyDirectory(context.getWpUaResourcesDir().concat(wpUaAppPath.concat(WP_TEMPLATES_PHP_DIR)), context.getWpTargetDir().concat(WP_TEMPLATES_PHP_DIR));
*/

		//FileUtil.copyDirectory(context.getWpResourcesDir().concat(WP_TEMPLATES_PHP_DIR), context.getWpTargetDir().concat(WP_TEMPLATES_PHP_DIR));
			//IDEUtil.generateArtifact(context, context.getApplicationData(), WP_INCLUDES_FTL, "wpee-classes.php", context.getWpTargetDir().concat(WP_INCLUDES_DIR));
			//IDEUtil.generateArtifact(context, context.getApplicationData(), WP_UTIL_FTL, "ServiceMap.php", context.getWpTargetDir().concat(WP_UTIL_DIR));
			//IDEUtil.generateArtifact(context, context.getApplicationData(), WP_STYLE_FTL, "style.css", context.getWpTargetDir());
			//IDEUtil.generateArtifact(context, context.getApplicationData(), WP_DDL_FTL, "ddl.sql", context.getWpTargetDir());

		return context;
	}


}
