/**
 * 
 */
package com.cloderia.helion.ide.pipeline.util;

import java.util.List;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.ide.model.Application;
import com.cloderia.helion.ide.model.Module;
import com.cloderia.helion.ide.pipeline.ModuleConfigurationProcessor;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.pipeline.PipelineContext;

/**
 * Contains utility methods for read data from helion configuration files.
 * 
 * @author adrian
 */
public class ConfigurationUtil {

	private static Logger logger = LoggerFactory.getLogger(ModuleConfigurationProcessor.class);
	
	/**
	 * @param configFile
	 * @return
	 * @throws HelionException
	 */
	public static PipelineContext loadBuildData(String configFile) throws HelionException {
		try {
			logger.debug("Loading project build file {}" , configFile);
			JAXBContext jaxbContext = JAXBContext.newInstance(PipelineContext.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			PipelineContext configuration = (PipelineContext) jaxbUnmarshaller.unmarshal(new File(configFile));
			return configuration;
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new HelionException(e.getMessage());
		}
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloderia.helion.ide.loader.ArtifactDataLoader#loadArtifactsData(com.
	 * cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public static List<Module> loadConfiguredModules(PipelineContext context) throws HelionException {
		try {
			String configFile = context.getConfigDir().concat(IDEConstants.MODULE_CONFIG_FILE);
			logger.debug("Loading modules from configuration file {}", configFile);
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Application.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Application application = (Application) jaxbUnmarshaller.unmarshal(new File(configFile));
			
			return application.getModules();
		} catch (JAXBException e) {
			throw new HelionException(e);

		}
	}
}
