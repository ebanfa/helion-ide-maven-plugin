/**
 * 
 */
package com.cloderia.helion.ide.util;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.FileUtils;

import com.cloderia.helion.ide.artifact.Application;
import com.cloderia.helion.ide.configuration.BuildConfiguration;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

/**
 * @author adrian
 *
 */
@SuppressWarnings("restriction")
public class IDEUtils {

	public static final String FM_CONFIGURATION = "FM_CONFIGURATION";
	public static final String FM_OUTPUT_DIR = null;
	public static final String FM_INPUT_FILE = null;
	public static final String FM_OUTPUT_FILE = null;
	public static final String FM_TEMPLATE_DIR_DATA_EXCEPTION = null;
	public static final String FM_CONFIGURATION_EXCEPTION = null;
	public static final String FM_CONTEXT_DATA_APPLICATION = null;
	public static final String FM_CONTEXT_DATA_ENTITY = null;
	public static final String FM_CONTEXT_DATA_MODULE = null;
	
	
	/**
	 * @param templateDir
	 * @return
	 * @throws IDEException 
	 */
	public static BuildConfiguration loadIDEConfiguration(String config) throws IDEException {
		return loadIDEXMLData(config);
	}
	
	/**
	 * @param templateDir
	 * @return
	 * @throws IDEException 
	 */
	public static Application loadApplicationDefinition(String config, String templateDir) throws IDEException {
		Application application = loadApplicationXMLData(config);
		application.setTemplatesDir(templateDir);
		return application;
	}
	
	public static void writeApplicationXML(String config, Application application) {
		try {
			File file = new File(config);
			JAXBContext jaxbContext = JAXBContext.newInstance(Application.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(application, file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	/**Application
	 * @param configFile
	 * @throws IDEException 
	 */
	public static BuildConfiguration loadIDEXMLData(String configFile) throws IDEException {
		try {
			File file = new File(configFile);
			JAXBContext jaxbContext = JAXBContext.newInstance(BuildConfiguration.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			BuildConfiguration configuration = (BuildConfiguration) jaxbUnmarshaller.unmarshal(file);
			return configuration;
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new IDEException(e.getMessage());
		}
	}
	/**Application
	 * @param configFile
	 */
	public static Application loadApplicationXMLData(String configFile) throws IDEException {
		try {
			File file = new File(configFile);
			JAXBContext jaxbContext = JAXBContext.newInstance(Application.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Application application = (Application) jaxbUnmarshaller.unmarshal(file);
			return application;
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new IDEException(e.getMessage());
		}
	}

	/**
	 * @param application
	 * @return
	 */
	public static Configuration loadApplicationConfiguration(Application application) {
		/* Create and adjust the configuration */
		Configuration configuration = new Configuration();
		try {
			configuration.setDirectoryForTemplateLoading(new File(application.getTemplatesDir()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		configuration.setObjectWrapper(new DefaultObjectWrapper());
		configuration.setDefaultEncoding("UTF-8");
		configuration.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
		configuration.setIncompatibleImprovements(new Version(2, 3, 20));
		return configuration;
	}

	/**
	 * @param directoryName
	 */
	public static File createDirectoryIfNeeded(String directoryName) {
		File theDir = new File(directoryName);
		if(!theDir.exists()) {
			try {
				if (!theDir.mkdirs()) System.out.println("Could not create directory:" + directoryName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		return theDir;
	}

	public static boolean deleteDir(String directoryName) {
		File theDir = new File(directoryName);
		if (theDir.exists()) {
			File[] files = theDir.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					deleteDir(files[i].getPath());
				} else {
					files[i].delete();
				}
			}
		}
		return (theDir.delete());
	}

	public static void copyDirectory(String srcDir, String dstDir) {
		File source = new File(srcDir);
		File destination = new File(dstDir);
		try {
			FileUtils.copyDirectory(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void copyFileToFile(String srcDir, String dstDir) {
		File source = new File(srcDir);
		File destination = new File(dstDir);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void copyFileToDirectory(String srcDir, String dstDir) {
		File source = new File(srcDir);
		File destination = new File(dstDir);
		try {
			FileUtils.copyFileToDirectory(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
