package com.cloderia.helion.ide;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Parameter;

import com.cloderia.helion.ide.app.Application;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.generator.ArtifactGeneratorFactory;
import com.cloderia.helion.ide.util.IDEException;
import com.cloderia.helion.ide.util.IDEUtils;

public abstract class AbstractIDEMojo extends AbstractMojo {

	private BuildConfiguration buildConfiguration;
	
    /**
     * The buildConfiguration.
     */
    @Parameter(property = "helion.ideConfiguration")
    protected String ideConfiguration;

	/**
	 * @return the buiderConfig
	 */
	public BuildConfiguration getBuildConfiguration() {
		return buildConfiguration;
	}

	/**
	 * @param buiderConfig the buiderConfig to set
	 */
	public void setBuildConfiguration(BuildConfiguration buildConfiguration) {
		this.buildConfiguration = buildConfiguration;
	}
	
	/* (non-Javadoc)
	 * @see org.apache.maven.plugin.Mojo#execute()
	 */
	public void execute() throws MojoExecutionException, MojoFailureException {
		try {
			BuildConfiguration buildConfiguration = IDEUtils.loadIDEConfiguration(ideConfiguration);
			// Load the configured artifact generator
			buildConfiguration.setArtifactGenerator(
					ArtifactGeneratorFactory.getArtifactGenerator(buildConfiguration.getGeneratorName()));
			// Load the application configuration file
			buildConfiguration.setApplication(
					IDEUtils.loadApplicationXMLData(buildConfiguration.getConfigFile()));
			execute(buildConfiguration);
		} catch (IDEException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param buildConfiguration
	 */
	public abstract void execute(BuildConfiguration buildConfiguration) throws IDEException;
	
	
}
