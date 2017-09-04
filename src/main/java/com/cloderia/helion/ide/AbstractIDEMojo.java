package com.cloderia.helion.ide;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Parameter;

import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.util.IDEUtil;

public abstract class AbstractIDEMojo extends AbstractMojo {

	private BuildContext buildContext;
	
    /**
     * The buildConfiguration.
     */
    @Parameter(property = "helion.ideConfiguration")
    protected String ideConfiguration;

	/**
	 * @return the buiderConfig
	 */
	public BuildContext getBuildConfiguration() {
		return buildContext;
	}

	/**
	 * @param buiderConfig the buiderConfig to set
	 */
	public void setBuildConfiguration(BuildContext buildContext) {
		this.buildContext = buildContext;
	}
	
	/* (non-Javadoc)
	 * @see org.apache.maven.plugin.Mojo#execute()
	 */
	public void execute() throws MojoExecutionException, MojoFailureException {
		try {
			execute(IDEUtil.loadBuildData(ideConfiguration));
		} catch (IDEException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param buildConfiguration
	 */
	public abstract void execute(BuildContext buildContext) throws IDEException;
	
	
}
