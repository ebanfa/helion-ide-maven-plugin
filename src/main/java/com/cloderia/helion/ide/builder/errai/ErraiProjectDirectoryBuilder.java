/**
 * 
 */
package com.cloderia.helion.ide.builder.errai;

import com.cloderia.helion.ide.builder.AbstractArtifactProcessor;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEException;
import com.cloderia.helion.ide.util.IDEUtils;

/**
 * @author adrian
 *
 */
public class ErraiProjectDirectoryBuilder extends AbstractArtifactProcessor {

	public static final String APP_RESOURCE_DIR = "errai/";
	public static final String SRC_MAIN_JAVA = "src/main/java/";
	public static final String SRC_MAIN_WEBAPP = "src/main/webapp/";
	public static final String SRC_MAIN_RESOURCES = "src/main/resources/";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cloderia.helion.ide.builder.ArtifactBuilder#build(com.cloderia.helion
	 * .ide.configuration.BuildConfiguration)
	 */
	public void execute(BuildConfiguration buildConfiguration) throws IDEException {
		this.createDirectories(buildConfiguration);
		this.copyResources(buildConfiguration);
	}

	/**
	 * 
	 */
	private void createDirectories(BuildConfiguration buildConfiguration) {
		IDEUtils.deleteDir(buildConfiguration.getTargetDir());
		IDEUtils.createDirectoryIfNeeded(buildConfiguration.getTargetDir());
		IDEUtils.createDirectoryIfNeeded(buildConfiguration.getTargetDir().concat(IDEConstants.SRC_DIR));
		IDEUtils.createDirectoryIfNeeded(buildConfiguration.getTargetDir().concat(IDEConstants.MAIN_DIR));
		IDEUtils.createDirectoryIfNeeded(buildConfiguration.getTargetDir().concat(IDEConstants.JAVA_DIR));
		IDEUtils.createDirectoryIfNeeded(buildConfiguration.getTargetDir().concat(IDEConstants.WEBAPPS_DIR));
		IDEUtils.createDirectoryIfNeeded(buildConfiguration.getTargetDir().concat(IDEConstants.RESOURCES_DIR));
		IDEUtils.createDirectoryIfNeeded(buildConfiguration.getTargetDir().concat(IDEConstants.TARGET_DIR));
	}

	/**
	 * 
	 */
	private void copyResources(BuildConfiguration buildConfiguration) {
		String baseDir = buildConfiguration.getProjectDir();
		String targetDir = buildConfiguration.getTargetDir();
		IDEUtils.copyFileToDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + APP_RESOURCE_DIR + "pom.xml"), targetDir);
		IDEUtils.copyFileToDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + APP_RESOURCE_DIR + "LICENSE"), targetDir);
		IDEUtils.copyFileToDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + APP_RESOURCE_DIR + "README.md"), targetDir);
		IDEUtils.copyFileToDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + APP_RESOURCE_DIR + ".project"), targetDir);
		IDEUtils.copyFileToDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + APP_RESOURCE_DIR + ".classpath"), targetDir);
		IDEUtils.copyDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + APP_RESOURCE_DIR + ".settings/"), targetDir.concat("/.settings/"));
		IDEUtils.copyDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + APP_RESOURCE_DIR + SRC_MAIN_JAVA),	targetDir.concat(IDEConstants.JAVA_DIR));
		IDEUtils.copyDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + APP_RESOURCE_DIR + SRC_MAIN_WEBAPP), targetDir.concat(IDEConstants.WEBAPPS_DIR));
		IDEUtils.copyDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + APP_RESOURCE_DIR + SRC_MAIN_RESOURCES), targetDir.concat(IDEConstants.RESOURCES_DIR));
	}
	

}
