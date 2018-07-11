package com.cloderia.helion;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Parameter;

import com.cloderia.helion.exception.HelionException;
import com.cloderia.ide.config.ContextConfig;

public abstract class AbstractHelionMojo extends AbstractMojo {

    /**
     * The buildConfiguration.
     */
    @Parameter(property = "helion.configurationFile")
    protected String configurationFile;

    @Parameter(property = "helion.configurationClass")
    protected String configurationClass;
	

	/* (non-Javadoc)
	 * @see org.apache.maven.plugin.Mojo#execute()
	 */
	public void execute() throws MojoExecutionException, MojoFailureException {
		try {
			ContextConfig contextConfig = ContextConfigFactory.getInstance(configurationFile, configurationClass);
			BuildContext context = BuildContextFactory.getInstance(contextConfig);
			this.doExecute(context);
		} catch (HelionException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param buildConfiguration
	 */
	protected abstract void doExecute(BuildContext context) throws HelionException;

}
