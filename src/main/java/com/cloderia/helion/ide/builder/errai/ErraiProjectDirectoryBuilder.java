/**
 * 
 */
package com.cloderia.helion.ide.builder.errai;

import com.cloderia.helion.ide.builder.AbstractArtifactBuilder;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.generator.ArtifactGenerator;
import com.cloderia.helion.ide.generator.ArtifactGeneratorData;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEException;
import com.cloderia.helion.ide.util.IDEUtils;

/**
 * @author adrian
 *
 */
public class ErraiProjectDirectoryBuilder extends AbstractArtifactBuilder {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cloderia.helion.ide.builder.ArtifactBuilder#build(com.cloderia.helion
	 * .ide.configuration.BuildConfiguration)
	 */
	public void build(BuildConfiguration buildConfiguration) throws IDEException {
		this.createDirectories(buildConfiguration);
		this.copyResources(buildConfiguration);

		/*this.generateArtifact(buildConfiguration, 
				buildConfiguration.getApplication(), 
				"misc/errai/pom.ftl", "pom.xml", buildConfiguration.getTargetDir());*/

		this.generateArtifact(buildConfiguration, 
				buildConfiguration.getApplication(), 
				"misc/errai/read-md.ftl", "README.md", buildConfiguration.getTargetDir());
		this.generateArtifact(buildConfiguration, 
				buildConfiguration.getApplication(), 
				"html/errai/home.ftl", "dashboard-page.html", buildConfiguration.getTargetDir().concat(IDEConstants.UI_DIR + "/ui/"));
	}

	/**
	 * 
	 */
	private void createDirectories(BuildConfiguration buildConfiguration) {
		String targetDir = buildConfiguration.getTargetDir();
		IDEUtils.deleteDir(targetDir);
		IDEUtils.createDirectoryIfNeeded(targetDir);
		IDEUtils.createDirectoryIfNeeded(targetDir.concat(IDEConstants.SRC_DIR));
		IDEUtils.createDirectoryIfNeeded(targetDir.concat(IDEConstants.MAIN_DIR));
		IDEUtils.createDirectoryIfNeeded(targetDir.concat(IDEConstants.JAVA_DIR));
		IDEUtils.createDirectoryIfNeeded(targetDir.concat(IDEConstants.WEBAPPS_DIR));
		IDEUtils.createDirectoryIfNeeded(targetDir.concat(IDEConstants.RESOURCES_DIR));
		IDEUtils.createDirectoryIfNeeded(targetDir.concat(IDEConstants.TARGET_DIR));
	}

	/**
	 * 
	 */
	private void copyResources(BuildConfiguration buildConfiguration) {
		String baseDir = buildConfiguration.getProjectDir();
		String targetDir = buildConfiguration.getTargetDir();
		IDEUtils.copyFileToDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + "errai/pom.xml"), targetDir);
		IDEUtils.copyFileToDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + "errai/LICENSE"), targetDir);
		IDEUtils.copyFileToDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + "errai/README.md"), targetDir);
		IDEUtils.copyFileToDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + "errai/.project"), targetDir);
		IDEUtils.copyFileToDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + "errai/.classpath"), targetDir);
		IDEUtils.copyDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + "errai/.settings/"),
				targetDir.concat("/.settings/"));
		IDEUtils.copyDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + "errai/java/"),
				targetDir.concat(IDEConstants.JAVA_DIR));
		IDEUtils.copyDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + "errai/webapp/"),
				targetDir.concat(IDEConstants.WEBAPPS_DIR));
		IDEUtils.copyDirectory(baseDir.concat(IDEConstants.BUILD_RESOURCES_DIR + "errai/resources/"),
				targetDir.concat(IDEConstants.RESOURCES_DIR));
	}
	

	/**
	 * @param buildConfiguration
	 * @throws IDEException
	 */
	private void generateMavenConfig(BuildConfiguration buildConfiguration) throws IDEException {
	}
	
	/**
	 * @param buildConfiguration
	 * @throws IDEException
	 */
	private void generateMavenReadMeFile(BuildConfiguration buildConfiguration) throws IDEException {
		ArtifactGeneratorData generatorData = 
				new ArtifactGeneratorData(buildConfiguration.getApplication(), 
						"misc/errai/read-md.ftl", "README.md", buildConfiguration.getTargetDir());
		ArtifactGenerator artifactGenerator = buildConfiguration.getArtifactGenerator();
		artifactGenerator.generateArtifact(buildConfiguration, generatorData);
	}

}
