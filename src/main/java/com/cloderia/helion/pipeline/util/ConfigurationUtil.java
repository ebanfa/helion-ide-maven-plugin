/**
 * 
 */
package com.cloderia.helion.pipeline.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloderia.helion.exception.HelionException;
import com.cloderia.helion.model.application.Application;
import com.cloderia.helion.model.module.Module;
import com.cloderia.helion.model.pipeline.PipelineContext;

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
	public static <T extends Application> T loadApplication(String configFile, Class<T> clazz) throws HelionException {
		return JAXBUtil.loadArtifact(configFile, clazz);
	}
	
	/**
	 * @param configFile
	 * @param clazz
	 * @return
	 * @throws HelionException
	 */
	public static <T extends Module> T loadModule(String configFile, Class<T> clazz) throws HelionException {
		return JAXBUtil.loadArtifact(configFile, clazz);
	}

	/**
	 * @param configurationFile
	 * @param clazz
	 * @return
	 * @throws HelionException
	 */
	public static PipelineContext loadPipelineContext(String configurationFile, Class<PipelineContext> clazz) throws HelionException {
		return JAXBUtil.loadArtifact(configurationFile, clazz);
	}

	
}
