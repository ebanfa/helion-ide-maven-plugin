/**
 * 
 */
package com.cloderia.helion.ide.pipeline.util;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.HelionRuntimeException;
import com.cloderia.helion.ide.model.Application;
import com.cloderia.helion.ide.model.Artifact;
import com.cloderia.helion.ide.model.Module;
import com.cloderia.helion.ide.model.web.UiModule;
import com.cloderia.helion.ide.model.web.UiModuleConfig;
import com.cloderia.helion.ide.model.web.WebModule;
import com.cloderia.helion.ide.model.web.WebModuleConfig;
import com.cloderia.helion.ide.util.StringUtil;
import com.cloderia.helion.pipeline.PipelineContext;

/**
 * Contains utility methods for read data from helion configuration files.
 * 
 * @author adrian
 */
public class ConfigurationUtil {

	private static Logger logger = LoggerFactory.getLogger(ConfigurationUtil.class);
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloderia.helion.ide.loader.ArtifactDataLoader#loadArtifactsData(com.
	 * cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public static List<Module> loadModules(PipelineContext context) throws HelionException {
		Application application = loadArtifact(context.getModulesConfigFile(), Application.class);
		return application.getModules();
	}
	
	/**
	 * Loads the WebModule configuration
	 * @param module
	 * @param context
	 * @return
	 * @throws HelionException
	 */
	public static WebModule loadWebModule(String webModuleConfigFile, PipelineContext context) throws HelionException {
		// Load the web module and all its dependences
		WebModule webModule = loadArtifact(webModuleConfigFile, WebModule.class);
		webModule = loadWebModuleServicesConfiguration(webModule, context);
		loadWebModuleUiConfiguration(webModule, context);
		return webModule;
	}
	
	/**
	 * @param uiModule
	 * @param extraConfig
	 */
	public static WebModule loadWebModuleServicesConfiguration(WebModule webModule, PipelineContext context) throws HelionException {
		WebModuleConfig extraConfig = webModule.getExtraConfig();
		if(!StringUtil.isValidString(extraConfig.getServicesConfigFile())) return webModule;
		
		WebModule loadedWebModule = loadArtifact(extraConfig.getServicesConfigFile(), WebModule.class);
		webModule.setWebServices(loadedWebModule.getWebServices());
		return webModule;
	}

	/**
	 * @param module
	 * @param context
	 * @param webModule
	 * @throws HelionException 
	 */
	public static void loadWebModuleUiConfiguration(WebModule webModule, PipelineContext context ) throws HelionException {

		for(UiModule uiModule : webModule.getUiModules()) {
			if(uiModule.getExtraConfig() == null) continue;
			// Load the pages, containers and the widgets
			loadUiPages(uiModule, uiModule.getExtraConfig());
			loadUiContainers(uiModule, uiModule.getExtraConfig());
			loadUiWidgets(uiModule, uiModule.getExtraConfig());
		}
		return;
	}

	/**
	 * @param uiModule
	 * @param extraConfig
	 */
	public static void loadUiPages(UiModule uiModule, UiModuleConfig extraConfig) throws HelionException {
		if(!StringUtil.isValidString(extraConfig.getPagesConfigFile())) return;
		UiModule loadedUiModule = loadArtifact(extraConfig.getPagesConfigFile(), UiModule.class);
		uiModule.setPages(loadedUiModule.getPages());
	}
	
	/**
	 * @param uiModule
	 * @param extraConfig
	 */
	public static void loadUiContainers(UiModule uiModule, UiModuleConfig extraConfig) throws HelionException {
		if(!StringUtil.isValidString(extraConfig.getWidgetsConfigFile())) return;
		UiModule loadedUiModule = loadArtifact(extraConfig.getContainersConfigFile(), UiModule.class);
		uiModule.setContainers(loadedUiModule.getContainers());
	}
	
	/**
	 * @param uiModule
	 * @param extraConfig
	 */
	public static void loadUiWidgets(UiModule uiModule, UiModuleConfig extraConfig) throws HelionException {
		if(!StringUtil.isValidString(extraConfig.getContainersConfigFile())) return;
		UiModule loadedUiModule = loadArtifact(extraConfig.getWidgetsConfigFile(), UiModule.class);
		logger.debug("Loaded Ui module >>>>>>>>>> {}", loadedUiModule);
		uiModule.setWidgets(loadedUiModule.getWidgets());
	}
	
	/**
	 * @param file
	 * @param clazz
	 * @return
	 * @throws HelionException
	 */
	public static <T extends Artifact> T loadArtifact(String file, Class<T> clazz) throws HelionException {
		try {
			logger.debug("Loading artifact {} from file {}", clazz, file );
			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (T) jaxbUnmarshaller.unmarshal(new File(file));
		} catch (JAXBException e) {
			throw new HelionException(e);
		}
	}
	
	/**
	 * @param file
	 * @param clazz
	 * @return
	 * @throws HelionException
	 */
	public static <T extends Artifact> List<T> loadArtifacts(String file, Class<T> clazz) throws HelionException {
		try {
			logger.debug("Loading artifact {} from file {}", clazz, file );
			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (List<T>) jaxbUnmarshaller.unmarshal(new File(file));
		} catch (JAXBException e) {
			throw new HelionException(e);
		}
	}
}
