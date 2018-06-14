/**
 * 
 */
package com.cloderia.helion.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.model.Application;
import com.cloderia.helion.model.Entity;
import com.cloderia.helion.model.Module;
import com.cloderia.helion.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.PipelineItem;

/**
 * @author adrian
 *
 */
@SuppressWarnings("restriction")
public class IDEUtil {

	/**
	 * @param configFile
	 * @return
	 * @throws HelionException
	 */
	public static PipelineContext loadBuildData(String configFile) throws HelionException {
		try {
			File file = new File(configFile);
			JAXBContext jaxbContext = JAXBContext.newInstance(PipelineContext.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			PipelineContext configuration = (PipelineContext) jaxbUnmarshaller.unmarshal(file);
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
	public static Application loadApplicationData(String configFile) throws HelionException {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Application.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Application application = (Application) jaxbUnmarshaller.unmarshal(new File(configFile));
			//ArtifactUtil.preProcess(application);
			return application;
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new HelionException(e.getMessage());

		}
	}

	/**
	 * @param buildContext
	 * @return
	 */
	public static List<PipelineItem> getBuildProcessors(PipelineContext buildContext) {
		List<PipelineItem> processors = new ArrayList<PipelineItem>();
		for (String processor : buildContext.getProcessor()) {
			try {
				processors.add((PipelineItem) Class.forName(processor).newInstance());
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
