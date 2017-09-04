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

import com.cloderia.helion.ide.IDEException;
import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.BuildProcessor;
import com.cloderia.helion.ide.data.ApplicationData;
import com.cloderia.helion.ide.data.ArtifactData;
import com.cloderia.helion.ide.data.EntityData;
import com.cloderia.helion.ide.data.ModuleData;
import com.cloderia.helion.ide.generator.ArtifactGenerator;
import com.cloderia.helion.ide.generator.ArtifactGeneratorData;
import com.cloderia.helion.ide.generator.FreeMarkerArtifactGenerator;

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
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.loader.ArtifactDataLoader#loadArtifactsData(com.cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public static ApplicationData loadApplicationData(String configFile) throws IDEException {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ApplicationData.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			ApplicationData application = (ApplicationData) jaxbUnmarshaller.unmarshal(new File(configFile));
			ArtifactUtil.preProcess(application);
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
		for(String processor: buildContext.getProcessor()) {
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
	public static void generateArtifact(BuildContext context, ArtifactData artifactData,
			String inputFile, String outputFile, String outputDirectory) throws IDEException {
		ArtifactGeneratorData generatorData = new ArtifactGeneratorData(artifactData, inputFile, outputFile, outputDirectory);
		ArtifactGenerator artifactGenerator = new FreeMarkerArtifactGenerator();
		artifactGenerator.generateArtifact(context, generatorData);
	}
	
	/**
	 * @param module
	 * @return
	 */
	public static String getModulePath(ModuleData module){
		return module.getName().toLowerCase().concat("/");
	}
	
	public static String getEntityPath(EntityData entity){
		return getModulePath(entity.getModule()).concat(entity.getName().toLowerCase().concat("/"));
	}
}
