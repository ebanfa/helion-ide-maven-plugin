/**
 * 
 */
package com.cloderia.helion.ide.generator;

import com.cloderia.helion.ide.artifact.ArtifactData;

/**
 * @author adrian
 *
 */
public class ArtifactGeneratorData {

	private ArtifactData data;
	private String inputFile;
	private String outputFile;
	private String outputDir;
	
	
	/**
	 * @param data
	 * @param inputFile
	 * @param outputFile
	 * @param outputDir
	 */
	public ArtifactGeneratorData(ArtifactData data, String inputFile, String outputFile, String outputDir) {
		super();
		this.data = data;
		this.inputFile = inputFile;
		this.outputFile = outputFile;
		this.outputDir = outputDir;
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
	 * @return the inputFie
	 */
	public String getInputFile() {
		return inputFile;
	}
	/**
	 * @param inputFie the inputFie to set
	 */
	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}
	/**
	 * @return the data
	 */
	public ArtifactData getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(ArtifactData data) {
		this.data = data;
	}

}
