/**
 * 
 */
package com.cloderia.helion.ide.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;

import com.cloderia.helion.ide.IDEException;
import com.cloderia.helion.ide.artifacts.Application;
import com.cloderia.helion.ide.artifacts.Artifact;
import com.cloderia.helion.ide.artifacts.Entity;
import com.cloderia.helion.ide.artifacts.Module;
import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.BuildProcessor;
import com.cloderia.helion.ide.generators.ArtifactGenerator;
import com.cloderia.helion.ide.generators.ArtifactGeneratorData;
import com.cloderia.helion.ide.generators.FreeMarkerArtifactGenerator;

/**
 * @author adrian
 *
 */
@SuppressWarnings("restriction")
public class IDEUtil {

	/**
	 * @param configFile
	 * @return
	 * @throws IDEException
	 */
	public static BuildContext loadBuildData(String configFile) throws IDEException {
		try {
			File file = new File(configFile);
			JAXBContext jaxbContext = JAXBContext.newInstance(BuildContext.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			BuildContext configuration = (BuildContext) jaxbUnmarshaller.unmarshal(file);
			return configuration;
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new IDEException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloderia.helion.ide.loader.ArtifactDataLoader#loadArtifactsData(com.
	 * cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public static Application loadApplicationData(String configFile) throws IDEException {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Application.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Application application = (Application) jaxbUnmarshaller.unmarshal(new File(configFile));
			//ArtifactUtil.preProcess(application);
			return application;
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new IDEException(e.getMessage());

		}
	}

	/**
	 * @param buildContext
	 * @return
	 */
	public static List<BuildProcessor<BuildContext>> getBuildProcessors(BuildContext buildContext) {
		List<BuildProcessor<BuildContext>> processors = new ArrayList<BuildProcessor<BuildContext>>();
		for (String processor : buildContext.getProcessor()) {
			try {
				processors.add((BuildProcessor<BuildContext>) Class.forName(processor).newInstance());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return processors;
	}

	/**
	 * @param buildConfiguration
	 * @throws IDEException
	 */
	public static void generateArtifact(BuildContext context, Artifact artifactData, String inputFile,
			String outputFile, String outputDirectory) throws IDEException {
		ArtifactGeneratorData generatorData = new ArtifactGeneratorData(artifactData, inputFile, outputFile,
				outputDirectory);
		ArtifactGenerator artifactGenerator = new FreeMarkerArtifactGenerator();
		artifactGenerator.generateArtifact(context, generatorData);
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

	/**
	 * @param module
	 * @return
	 */
	public static String getModulePath(Module module) {
		return module.getName().toLowerCase().concat("/");
	}

	public static String getEntityPath(Entity entity) {
		return getModulePath(entity.getModule()).concat(entity.getName().toLowerCase().concat("/"));
	}
}
