/**
 * 
 */
package com.cloderia.helion.pipeline.util;

import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloderia.helion.BuildContext;
import com.cloderia.helion.exception.ConfigurationException;
import com.cloderia.helion.exception.HelionException;
import com.cloderia.helion.util.ArtifactConfigUtil;
import com.cloderia.ide.config.ApplicationLite;
import com.cloderia.ide.config.ContextConfig;
import com.cloderia.ide.config.ModuleLite;
import com.cloderia.ide.config.PipelineContextConfig;
import com.cloderia.ide.config.SubModuleLite;

/**
 * Contains utility methods for read data from helion configuration files.
 * 
 * @author Edward Banfa
 */
public class ConfigurationUtil {

	private static Logger logger = LoggerFactory.getLogger(ConfigurationUtil.class);
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloderia.helion.ide.loader.ArtifactDataLoader#loadArtifactsData(com.
	 * cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public static ApplicationLite readApplicationLite(String configFile) throws HelionException {
		ApplicationLite applicationConfig = JAXBUtil.loadArtifact(configFile, ApplicationLite.class);
		
		applicationConfig.getModules()
		.stream()
		.map(module -> { 
			return readModuleLite(module);
		}).collect(Collectors.toList());
		
		return applicationConfig;
	}
	
	/**
	 * @param configFile
	 * @param clazz
	 * @return
	 * @throws HelionException
	 */
	public static ModuleLite readModuleLite(ModuleLite moduleLite)  {
		try {
			String moduleConfigFile = ArtifactConfigUtil.getArtifactConfigFile(moduleLite);
			ModuleLite moduleConfig = JAXBUtil.loadArtifact(moduleConfigFile, ModuleLite.class);
			
			moduleConfig.getSubModules()
			.stream()
			.map(subModuleConfig -> {
				return readSubModuleLite(moduleConfig, subModuleConfig);
			}).collect(Collectors.toList());

			return moduleConfig;
		} catch (HelionException e) {
			throw new ConfigurationException(e);
		}
	}

	public static SubModuleLite readSubModuleLite(ModuleLite moduleConfig, SubModuleLite subModuleConfig) {
		try {
			Optional<String> subModuleConfigFileOpt = Optional.ofNullable(
					ArtifactConfigUtil.getArtifactConfigFileOrNull(subModuleConfig));
			
			if(subModuleConfigFileOpt.isPresent()) {
				SubModuleLite loadedSubModuleConfig = JAXBUtil.loadArtifact(subModuleConfigFileOpt.get(), SubModuleLite.class);
				return readArtifactsInSubModule(moduleConfig, loadedSubModuleConfig);
			}
			return subModuleConfig;
		} catch (HelionException e) {
			throw new ConfigurationException(e);
		}
	}

	/**
	 * @param moduleConfig
	 * @param subModuleConfig
	 * @return
	 */
	private static SubModuleLite readArtifactsInSubModule(ModuleLite moduleConfig, SubModuleLite subModuleConfig) {
		return subModuleConfig;
	}

	/**
	 * @param configurationFile
	 * @param clazz
	 * @return
	 * @throws HelionException
	 */
	public static <T extends ContextConfig> T loadContextConfiguration(String configurationFile, Class<T> clazz) throws HelionException {
		return JAXBUtil.loadArtifact(configurationFile, clazz);
	}

	
}
