/**
 * 
 */
package com.cloderia.helion.util;

import java.util.List;
import java.util.Optional;

import com.cloderia.helion.exception.ArtifactConfigException;
import com.cloderia.helion.exception.HelionRuntimeException;
import com.cloderia.ide.Artifact;
import com.cloderia.ide.config.ArtifactConfigLite;
import com.cloderia.ide.config.ArtifactConfigParameter;
import com.cloderia.ide.config.ArtifactLite;

/**
 * @author Edward Banfa
 *
 */
public class ArtifactConfigUtil {

	/**
	 * @param artifact
	 * @return
	 */
	public static String getArtifactConfigFile(ArtifactLite artifact) {
		try {
			// Verify the presence of the entity config file or throw exception
			Optional<ArtifactConfigLite> artifactConfigOpt = Optional.of(artifact.getArtifactConfig()); 
			Optional<String> configFileOpt = Optional.of(artifactConfigOpt.get().getConfigFile());
			return configFileOpt.get();
		} catch (NullPointerException e) {
			throw new ArtifactConfigException("Configuration file not found for artifact " + artifact.getId(), e);
		}
	}
	
	/**
	 * @param artifact
	 * @return
	 */
	public static String getArtifactConfigFileOrNull(ArtifactLite artifact) {
		try {
			// Verify the presence of the entity config file or throw exception
			Optional<ArtifactConfigLite> artifactConfigOpt = Optional.ofNullable(artifact.getArtifactConfig()); 
			if(!artifactConfigOpt.isPresent()) return null;
			Optional<String> configFileOpt = Optional.ofNullable(artifactConfigOpt.get().getConfigFile());
			if(!configFileOpt.isPresent()) return null;
			return configFileOpt.get();
		} catch (NullPointerException e) {
			throw new ArtifactConfigException("Configuration file not found for artifact " + artifact.getId(), e);
		}
	}
	
	/**
	 * @param paramName
	 * @param artifact
	 * @return
	 * @throws HelionRuntimeException if the parameter was not found
	 */
	public static String getConfigParameterValue(String paramName, ArtifactLite artifact) {
		try {
			Optional<List<ArtifactConfigParameter>> configParamsListOpt = getAsOptional(artifact);
			String paramValue = findConfigParameterValue(paramName, artifact, configParamsListOpt);
			
			// Nothing found we throw an exception
			if(!StringUtil.isValidString(paramValue))
				throw new ArtifactConfigException("Configuration parameter  " + paramName + " not found on " + artifact.getId());
			
			return paramValue;
			
		} catch (NullPointerException e) {
			throw new ArtifactConfigException("Invalid configuration on artifact " + artifact.getId(), e);
		}
		
	}

	/**
	 * @param paramName
	 * @param artifact
	 * @param configParamsListOpt
	 */
	private static String findConfigParameterValue(String paramName, ArtifactLite artifact,	Optional<List<ArtifactConfigParameter>> configParamsListOpt) {
		for(ArtifactConfigParameter configParameter: configParamsListOpt.get()) {
			System.out.println("##################" + configParameter);
			if(configParameter.getParamName().equalsIgnoreCase(paramName)) {
				if(!StringUtil.isValidString(configParameter.getParamValue()))
					throw new ArtifactConfigException("Invalid config parameter value for param " + paramName + " on artifact " + artifact.getId());
				return configParameter.getParamValue();
			}
		}
		return null;
	}

	/**
	 * @param artifact
	 * @return
	 */
	private static Optional<List<ArtifactConfigParameter>> getAsOptional(ArtifactLite artifact) {
		// Verify the presence of the entity config file or throw exception
		Optional<ArtifactConfigLite> artifactConfigOpt = Optional.of(artifact.getArtifactConfig()); 
		Optional<List<ArtifactConfigParameter>> configParamsListOpt = Optional.of(artifactConfigOpt.get().getConfigParameters());
		return configParamsListOpt;
	}
}
