package com.cloderia.helion;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Parameter;

import com.cloderia.helion.ide.pipeline.util.ConfigurationUtil;
import com.cloderia.helion.pipeline.PipelineContext;

public abstract class AbstractHelionMojo extends AbstractMojo {

	private PipelineContext buildContext;
	
    /**
     * The buildConfiguration.
     */
    @Parameter(property = "helion.ideConfiguration")
    protected String ideConfiguration;

	/**
	 * @return the buiderConfig
	 */
	public PipelineContext getBuildConfiguration() {
		return buildContext;
	}

	/**
	 * @param buiderConfig the buiderConfig to set
	 */
	public void setBuildConfiguration(PipelineContext buildContext) {
		this.buildContext = buildContext;
	}
	
	/* (non-Javadoc)
	 * @see org.apache.maven.plugin.Mojo#execute()
	 */
	public void execute() throws MojoExecutionException, MojoFailureException {
		try {
			doExecute(ConfigurationUtil.loadBuildData(ideConfiguration));
		} catch (HelionException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param buildConfiguration
	 */
	protected abstract void doExecute(PipelineContext buildContext) throws HelionException;
	
	
}
