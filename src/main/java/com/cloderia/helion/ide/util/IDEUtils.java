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

import com.cloderia.helion.ide.app.Application;
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

	public static void copyFileToDirectory(String srcDir, String dstDir) {
		File source = new File(srcDir);
		File destination = new File(dstDir);
		try {
			FileUtils.copyFileToDirectory(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param buildConfiguration
	 * @return
	 */
	public static Configuration loadFMConfiguration(BuildConfiguration buildConfiguration) {
		/* Create and adjust the configuration */
		Configuration configuration = new Configuration();
		try {
			configuration.setDirectoryForTemplateLoading(new File(buildConfiguration.getTemplatesDir()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		configuration.setObjectWrapper(new DefaultObjectWrapper());
		configuration.setDefaultEncoding("UTF-8");
		configuration.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
		configuration.setIncompatibleImprovements(new Version(2, 3, 20));
		return configuration;
	}
	
	/*public static void generateFreeMarkerArtifact(BuildConfiguration buildConfiguration, Map<String, Object> context) throws IDEException {
		
		try {

			IDEMojo builder = buildConfiguration.getiDEMojo();
			if(!context.containsKey(IDEUtils.FM_CONFIGURATION))
				throw new IDEException(IDEUtils.FM_CONFIGURATION_EXCEPTION);
			
			if(!context.containsKey(IDEUtils.FM_OUTPUT_DIR) || 
					!context.containsKey(IDEUtils.FM_OUTPUT_FILE) || 
							!context.containsKey(IDEUtils.FM_INPUT_FILE)) 
				throw new IDEException(IDEUtils.FM_TEMPLATE_DIR_DATA_EXCEPTION);

			Map<String, Object> root = new HashMap<String, Object>();
			Configuration configuration = (Configuration) context.get(IDEUtils.FM_CONFIGURATION);
			
			String inputFile = (String) context.get(IDEUtils.FM_INPUT_FILE);
			String outputDir = (String) context.get(IDEUtils.FM_OUTPUT_DIR);
			String outputFile = (String) context.get(IDEUtils.FM_OUTPUT_FILE);
			outputDir = buildConfiguration.getTargetDir().concat(outputDir);
			
			createDirectoryIfNeeded(outputDir);
			
			if(context.containsKey(IDEUtils.FM_CONTEXT_DATA_APPLICATION))	
				root.put(IDEUtils.FM_CONTEXT_DATA_APPLICATION, 
						context.get(IDEUtils.FM_CONTEXT_DATA_APPLICATION));
			
			if(context.containsKey(IDEUtils.FM_CONTEXT_DATA_MODULE))	
				root.put(IDEUtils.FM_CONTEXT_DATA_MODULE, 
						context.get(IDEUtils.FM_CONTEXT_DATA_MODULE));
			
			if(context.containsKey(IDEUtils.FM_CONTEXT_DATA_ENTITY))	
				root.put(IDEUtils.FM_CONTEXT_DATA_ENTITY, 
						context.get(IDEUtils.FM_CONTEXT_DATA_ENTITY));
			
			Template template = configuration.getTemplate(inputFile);
			FileOutputStream outputStream = new FileOutputStream(outputDir.concat(outputFile));
			template.process(root, new OutputStreamWriter(outputStream));

		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
*/
}
