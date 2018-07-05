/**
 * 
 */
package com.cloderia.helion.util;

import java.util.List;
import java.util.Optional;

import com.cloderia.helion.exception.ArtifactConfigException;
import com.cloderia.helion.exception.HelionRuntimeException;
import com.cloderia.helion.model.Artifact;
import com.cloderia.helion.model.ArtifactConfig;
import com.cloderia.helion.model.ArtifactConfigParameter;

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
			throw new ArtifactConfigException("Configuration file not found for artifact " + artifact.getId(), e);
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
			// Verify the presence of the entity config file or throw exception
			Optional<ArtifactConfig> artifactConfigOpt = Optional.of(artifact.getArtifactConfig()); 
			Optional<List<ArtifactConfigParameter>> configParamsListOpt = Optional.of(artifactConfigOpt.get().getConfigParameters());
			
			for(ArtifactConfigParameter configParameter: configParamsListOpt.get()) {
				if(configParameter.getParamName().equalsIgnoreCase(paramName)) {
					if(!StringUtil.isValidString(configParameter.getParamValue()))
						throw new ArtifactConfigException("Invalid config parameter value for param " + paramName + " on artifact " + artifact.getId());
					return configParameter.getParamValue();
				}
			}
			// Nothing found we throw an exception
			throw new ArtifactConfigException("Configuration parameter  " + paramName + " not found on " + artifact.getId());
		} catch (NullPointerException e) {
			throw new ArtifactConfigException("Invalid configuration on artifact " + artifact.getId(), e);
		}
		
	}
}
