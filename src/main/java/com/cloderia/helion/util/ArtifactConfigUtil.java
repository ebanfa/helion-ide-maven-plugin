/**
 * 
 */
package com.cloderia.helion.util;

import java.util.List;
import java.util.Optional;

import com.cloderia.helion.HelionRuntimeException;
import com.cloderia.helion.application.model.Component;
import com.cloderia.helion.config.Artifact;
import com.cloderia.helion.config.ArtifactConfig;
import com.cloderia.helion.config.ArtifactConfigParameter;
import com.cloderia.helion.config.ArtifactException;

/**
 * @author Edward Banfa
 *
 */
public class ArtifactConfigUtil {

	/**
	 * @param artifact
	 * @return
	 */
	public static String getArtifactConfigFile(Artifact artifact) {
		try {
			// Verify the presence of the entity config file or throw exception
			Optional<ArtifactConfig> artifactConfigOpt = Optional.of(artifact.getArtifactConfig()); 
			Optional<String> configFileOpt = Optional.of(artifactConfigOpt.get().getConfigFile());
			return configFileOpt.get();
		} catch (NullPointerException e) {
			throw new ArtifactException("Configuration file not found for artifact " + artifact.getId(), e);
		}
	}
	
	/**
	 * @param artifact
	 * @return
	 */
	public static boolean hasArtifactConfigFile(Artifact artifact) {
		try {
			Optional<ArtifactConfig> artifactConfigOpt = Optional.ofNullable(artifact.getArtifactConfig()); 
			if(!artifactConfigOpt.isPresent()) return false;
			
			Optional<String> configFileOpt = Optional.ofNullable(artifactConfigOpt.get().getConfigFile());
			if(!configFileOpt.isPresent()) return false;
			
			return true;
		} catch (NullPointerException e) {
			throw new ArtifactException("Configuration file not found for artifact " + artifact.getId(), e);
		}
	}
	
	/**
	 * @param paramName
	 * @param artifact
	 * @return
	 * @throws HelionRuntimeException if the parameter was not found
	 */
	public static String getConfigParameterValue(String paramName, Artifact artifact) {
		try {
			Optional<List<ArtifactConfigParameter>> configParamsListOpt = getAsOptional(artifact);
			String paramValue = findConfigParameterValue(paramName, artifact, configParamsListOpt);
			
			// Nothing found we throw an exception
			if(!StringUtil.isValidString(paramValue))
				throw new ArtifactException("Configuration parameter  " + paramName + " not found on " + artifact.getId());
			
			return paramValue;
			
		} catch (NullPointerException e) {
			throw new ArtifactException("Invalid configuration on artifact " + artifact.getId(), e);
		}
		
	}

	/**
	 * @param paramName
	 * @param artifact
	 * @param configParamsListOpt
	 */
	private static String findConfigParameterValue(String paramName, Artifact artifact,	Optional<List<ArtifactConfigParameter>> configParamsListOpt) {
		for(ArtifactConfigParameter configParameter: configParamsListOpt.get()) {
			if(configParameter.getParamName().equalsIgnoreCase(paramName)) {
				if(!StringUtil.isValidString(configParameter.getParamValue()))
					throw new ArtifactException("Invalid config parameter value for param " + paramName + " on artifact " + artifact.getId());
				return configParameter.getParamValue();
			}
		}
		return null;
	}

	/**
	 * @param artifact
	 * @return
	 */
	private static Optional<List<ArtifactConfigParameter>> getAsOptional(Artifact artifact) {
		// Verify the presence of the entity config file or throw exception
		Optional<ArtifactConfig> artifactConfigOpt = Optional.of(artifact.getArtifactConfig()); 
		Optional<List<ArtifactConfigParameter>> configParamsListOpt = Optional.of(artifactConfigOpt.get().getParams());
		return configParamsListOpt;
	}
}
