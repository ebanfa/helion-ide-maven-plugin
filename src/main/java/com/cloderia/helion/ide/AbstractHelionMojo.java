package com.cloderia.helion.ide;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Parameter;

import com.cloderia.helion.ide.app.Application;
import com.cloderia.helion.ide.builder.BuilderConfig;

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
     * The freemarker.
     */
    @Parameter(property = "helion.templateDir")
    protected String templateDir;
    
    @Parameter(property = "helion.baseDir")
    protected String baseDir;

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
}
