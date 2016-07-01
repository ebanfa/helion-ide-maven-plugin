package com.cloderia.helion.ide;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Parameter;

import com.cloderia.helion.ide.app.Application;
import com.cloderia.helion.ide.builder.BuilderConfig;
import com.cloderia.helion.ide.util.IDEUtils;

import freemarker.template.Configuration;

public abstract class AbstractHelionMojo extends AbstractMojo {
	

	protected Application application;
	protected BuilderConfig buiderConfig;
	protected Configuration configuration;
	
    /**
     * The name.
     */
    @Parameter(property = "helion.name")
    protected String name;
    
    /**
     * The description.
     */
    @Parameter(property = "helion.description")
    protected String description;
    

    /**
     * The packageName.
     */
    @Parameter(property = "helion.packageName")
    protected String packageName;
    
    /**
     * The configuration file.
     */
    @Parameter(property = "helion.config")
    protected String config;
    
    /**
     * The target directory.
     */
    @Parameter(property = "helion.targetDir")
    protected String targetDir;
    
    /**
     * The freemarker template.
     */
    @Parameter(property = "helion.templateDir")
    protected String templateDir;
    
    /**
     * The project base directory
     */
    @Parameter(property = "helion.baseDir")
    protected String baseDir;

    /**
     *  The entity overrides configuration
     */
    @Parameter(property = "helion.entityOverrides")
    protected String entityOverrides;

	/**
	 * @return the application
	 */
	public Application getApplication() {
		return application;
	}

	/**
	 * @param application the application to set
	 */
	public void setApplication(Application application) {
		this.application = application;
	}

	/**
	 * @return the buiderConfig
	 */
	public BuilderConfig getBuiderConfig() {
		return buiderConfig;
	}

	/**
	 * @param buiderConfig the buiderConfig to set
	 */
	public void setBuiderConfig(BuilderConfig buiderConfig) {
		this.buiderConfig = buiderConfig;
	}

	/**
	 * @return the configuration
	 */
	public Configuration getConfiguration() {
		return configuration;
	}

	/**
	 * @param configuration the configuration to set
	 */
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
	
	/* (non-Javadoc)
	 * @see org.apache.maven.plugin.Mojo#execute()
	 */
	public void execute() throws MojoExecutionException, MojoFailureException {
		application = IDEUtils.loadApplicationDefinition(config, templateDir);
		execute(application);
	}
	
	public abstract void execute(Application application);
	
	public BuilderConfig initBulderConfig() {
		buiderConfig = new BuilderConfig();
		buiderConfig.setGenerateSourcesDir(targetDir);
		buiderConfig.setTargetDir(targetDir.concat(name).concat("/"));
		return buiderConfig;
	}
}
