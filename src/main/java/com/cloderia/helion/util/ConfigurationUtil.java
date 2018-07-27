/**
 * 
 */
package com.cloderia.helion.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.config.Artifact;

/**
 * Contains utility methods for read data from helion configuration files.
 * 
 * @author Edward Banfa
 */
public class ConfigurationUtil {

	/**
	 * @param configFile
	 * @return
	 * @throws HelionException
	 */
	public static Artifact readApplicationConfig(String applicationConfigFile) throws HelionException {
		List<Artifact> modules = new ArrayList<Artifact>();
		Artifact applicationConfig = JAXBUtil.loadArtifact(applicationConfigFile, Artifact.class);
		
		for(Artifact moduleConfig: applicationConfig.getArtifacts()) {
			modules.add(readModuleConfig(moduleConfig));
		}
		
		applicationConfig.setArtifacts(modules);
		return applicationConfig;
	}
	
	/**
	 * @param moduleLite
	 * @return
	 * @throws HelionException
	 */
	public static Artifact readModuleConfig(Artifact moduleLite)  throws HelionException {
		String moduleConfigFile = ArtifactConfigUtil.getArtifactConfigFile(moduleLite);
		Artifact moduleConfig = JAXBUtil.loadArtifact(moduleConfigFile, Artifact.class);

		List<Artifact> subModules = new ArrayList<Artifact>();
		
		for(Artifact subModuleConfig: moduleConfig.getArtifacts()) {
			subModules.add(readSubModuleConfig(subModuleConfig, moduleConfig));
		}
		
		moduleConfig.setArtifacts(subModules);
		return moduleConfig;
	}

	/**
	 * @param subModuleConfig
	 * @param moduleConfig
	 * @return
	 * @throws HelionException
	 */
	public static Artifact readSubModuleConfig(Artifact subModuleConfig, Artifact moduleConfig) throws HelionException {
		Optional<String> subModuleConfigFileOpt = Optional.ofNullable(
				ArtifactConfigUtil.getArtifactConfigFileOrNull(subModuleConfig));
		
		if(subModuleConfigFileOpt.isPresent()) {
			Artifact loadedSubModuleConfig = JAXBUtil.loadArtifact(subModuleConfigFileOpt.get(), Artifact.class);
			return readArtifactsInSubModule(moduleConfig, loadedSubModuleConfig);
		}
		return subModuleConfig;
	}

	/**
	 * @param moduleConfig
	 * @param subModuleConfig
	 * @return
	 */
	private static Artifact readArtifactsInSubModule(Artifact moduleConfig, Artifact subModuleConfig) {
		return subModuleConfig;
	}
	
}
