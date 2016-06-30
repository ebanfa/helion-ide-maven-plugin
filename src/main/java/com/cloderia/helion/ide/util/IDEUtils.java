/**
 * 
 */
package com.cloderia.helion.ide.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.FileUtils;

import com.cloderia.helion.ide.app.Application;
import com.cloderia.helion.ide.builder.BuildService;
import com.cloderia.helion.ide.builder.BuilderConfig;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

/**
 * @author adrian
 *
 */
public class IDEUtils {

	/**
	 * @param templateDir
	 * @return
	 */
	public static Application loadApplicationDefinition(String config, String templateDir) {
		Application application = loadApplicationXMLData(config);
		application.setTemplatesDir(templateDir);
		return application;
	}

	public static void writeApplicationXML(String config, Application application) {
		try {

			File file = new File(config);
			JAXBContext jaxbContext = JAXBContext.newInstance(Application.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(application, file);
			jaxbMarshaller.marshal(application, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param config
	 */
	private static Application loadApplicationXMLData(String config) {
		try {
			File file = new File(config);
			JAXBContext jaxbContext = JAXBContext.newInstance(Application.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			System.out.println(">>>>>>>>>>>>>>" + file.toString());
			Application application = (Application) jaxbUnmarshaller.unmarshal(file);
			return application;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
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
		// if the directory does not exist, create it
		if (!theDir.exists()) {
			try {
				if (theDir.mkdirs()) {
					// System.out.println("Created directory:" + directoryName);
				} else {
					// the place
					// System.out.println("Could not create directory:" +
					// directoryName);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// System.out.println(String.format("The directory %s already
			// exits", directoryName));
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

	public static void generateArtifact(BuilderConfig config) {
		try {

			BuildService builder = config.getApplicationBuilder();
			Application application = builder.getApplication();
			Configuration configuration = builder.getConfiguration();
			Template template = configuration.getTemplate(config.getInputFile());
			String outputDir = config.getTargetDir().concat(config.getOutputDir());

			createDirectoryIfNeeded(outputDir);
			FileOutputStream fos = new FileOutputStream(outputDir.concat(config.getOutputFile()));
			Writer out = new OutputStreamWriter(fos);

			Map<String, Object> root = new HashMap<String, Object>();
			root.put("application", application);
			root.put("module", config.getModule());
			root.put("entity", config.getEntity());
			template.process(root, out);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}

}
