package com.cloderia.helion;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Parameter;

import com.cloderia.helion.config.Artifact;
import com.cloderia.helion.context.Context;
import com.cloderia.helion.context.ContextFactory;
import com.cloderia.helion.util.JAXBUtil;

public abstract class AbstractHelionMojo extends AbstractMojo {

    /**
     * The buildConfiguration.
     */
    @Parameter(property = "helion.configurationFile")
    protected String configurationFile;
	

	/* (non-Javadoc)
	 * @see org.apache.maven.plugin.Mojo#execute()
	 */
	public void execute() throws MojoExecutionException, MojoFailureException {
		try {
			// Load the configuration from a file (e.g build.xml) and use it to initialize a build context
			Artifact contextConfig = JAXBUtil.loadArtifact(configurationFile, Artifact.class);
			Context context = ContextFactory.getInstance(contextConfig);
			// Pass the build context to the subclass
			this.doExecute(context);
		} catch (HelionException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param buildConfiguration
	 */
	protected abstract void doExecute(Context context) throws HelionException;

}
