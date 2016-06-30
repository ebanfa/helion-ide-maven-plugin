/**
 * 
 */
package com.cloderia.helion.ide.builder;

import com.cloderia.helion.ide.app.Entity;
import com.cloderia.helion.ide.app.Module;

/**
 * @author adrian
 *
 */
public class BuilderConfig {
	
	private Module module;
	private Entity entity;
	private String inputDir;
	private String inputFile;
	private String outputDir;
	private String outputFile;
	private String targetDir;
	private String generateSourcesDir;
	private BuildService applicationBuilder;

	/**
	 * 
	 */
	public BuilderConfig() {
	}

	/**
	 * @return the module
	 */
	public Module getModule() {
		return module;
	}

	/**
	 * @param module the module to set
	 */
	public void setModule(Module module) {
		this.module = module;
	}

	/**
	 * @return the entity
	 */
	public Entity getEntity() {
		return entity;
	}

	/**
	 * @param entity the entity to set
	 */
	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	/**
	 * @return the inputDir
	 */
	public String getInputDir() {
		return inputDir;
	}

	/**
	 * @param inputDir the inputDir to set
	 */
	public void setInputDir(String inputDir) {
		this.inputDir = inputDir;
	}

	/**
	 * @return the inputFile
	 */
	public String getInputFile() {
		return inputFile;
	}

	/**
	 * @param inputFile the inputFile to set
	 */
	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	/**
	 * @return the outputDir
	 */
	public String getOutputDir() {
		return outputDir;
	}

	/**
	 * @param outputDir the outputDir to set
	 */
	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;
	}

	/**
	 * @return the outputFile
	 */
	public String getOutputFile() {
		return outputFile;
	}

	/**
	 * @param outputFile the outputFile to set
	 */
	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}

	/**
	 * @return the targetDir
	 */
	public String getTargetDir() {
		return targetDir;
	}

	/**
	 * @param targetDir the targetDir to set
	 */
	public void setTargetDir(String targetDir) {
		this.targetDir = targetDir;
	}

	/**
	 * @return the generateSourcesDir
	 */
	public String getGenerateSourcesDir() {
		return generateSourcesDir;
	}

	/**
	 * @param generateSourcesDir the generateSourcesDir to set
	 */
	public void setGenerateSourcesDir(String generateSourcesDir) {
		this.generateSourcesDir = generateSourcesDir;
	}

	/**
	 * @return the applicationBuilder
	 */
	public BuildService getApplicationBuilder() {
		return applicationBuilder;
	}

	/**
	 * @param applicationBuilder the applicationBuilder to set
	 */
	public void setApplicationBuilder(BuildService applicationBuilder) {
		this.applicationBuilder = applicationBuilder;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BuilderConfig [module=" + module + ", entity=" + entity + ", inputDir=" + inputDir + ", inputFile="
				+ inputFile + ", outputDir=" + outputDir + ", outputFile=" + outputFile + ", targetDir=" + targetDir
				+ ", generateSourcesDir=" + generateSourcesDir + ", applicationBuilder=" + applicationBuilder + "]";
	}

	
}
