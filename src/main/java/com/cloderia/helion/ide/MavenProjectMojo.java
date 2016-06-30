/**
 * 
 */
package com.cloderia.helion.ide;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEUtils;

/**
 * @author adrian
 *
 */
@Mojo(name="mvn-project")
public class MavenProjectMojo extends AbstractHelionMojo {
	
	
	

	/* (non-Javadoc)
	 * @see org.apache.maven.plugin.Mojo#execute()
	 */
	public void execute() throws MojoExecutionException, MojoFailureException {
		String projectBuildDir = targetDir.concat(name).concat("/");
		IDEUtils.deleteDir(projectBuildDir);
		IDEUtils.createDirectoryIfNeeded(projectBuildDir);
		IDEUtils.createDirectoryIfNeeded(projectBuildDir.concat(IDEConstants.SRC_DIR));
		IDEUtils.createDirectoryIfNeeded(projectBuildDir.concat(IDEConstants.MAIN_DIR));
		IDEUtils.createDirectoryIfNeeded(projectBuildDir.concat(IDEConstants.JAVA_DIR));
		IDEUtils.createDirectoryIfNeeded(projectBuildDir.concat(IDEConstants.WEBAPPS_DIR));
		IDEUtils.createDirectoryIfNeeded(projectBuildDir.concat(IDEConstants.RESOURCES_DIR));
		IDEUtils.createDirectoryIfNeeded(projectBuildDir.concat(IDEConstants.TARGET_DIR));
		
		getLog().info(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + "errai/java/"));
		IDEUtils.copyFileToDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + "errai/pom.xml"), projectBuildDir);
		IDEUtils.copyFileToDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + "errai/LICENSE"), projectBuildDir);
		IDEUtils.copyFileToDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + "errai/README.md"), projectBuildDir);
		IDEUtils.copyFileToDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + "errai/.project"), projectBuildDir);
		IDEUtils.copyFileToDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + "errai/.classpath"), projectBuildDir);
		IDEUtils.copyDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + "errai/.settings/"), projectBuildDir.concat("/.settings/"));
		IDEUtils.copyDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + "errai/java/"), projectBuildDir.concat(IDEConstants.JAVA_DIR));
		IDEUtils.copyDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + "errai/webapp/"), projectBuildDir.concat(IDEConstants.WEBAPPS_DIR));
		IDEUtils.copyDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + "errai/resources/"), projectBuildDir.concat(IDEConstants.RESOURCES_DIR));
	}

}
