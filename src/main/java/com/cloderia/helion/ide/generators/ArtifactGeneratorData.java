/**
 * 
 */
package com.cloderia.helion.ide.generators;

import com.cloderia.helion.ide.artifacts.Artifact;

/**
 * @author adrian
 *
 */
public class ArtifactGeneratorData {

	private Artifact data;
	private String inputFile;
	private String outputFile;
	private String outputDir;
	
	
	/**
	 * @param data
	 * @param inputFile
	 * @param outputFile
	 * @param outputDir
	 */
	public ArtifactGeneratorData(Artifact data, String inputFile, String outputFile, String outputDir) {
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
	public Artifact getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Artifact data) {
		this.data = data;
	}

}
