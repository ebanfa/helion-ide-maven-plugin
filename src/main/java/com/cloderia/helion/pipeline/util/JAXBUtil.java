/**
 * 
 */
package com.cloderia.helion.pipeline.util;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloderia.helion.exception.HelionException;
import com.cloderia.helion.model.Artifact;

/**
 * @author Edward Banfa
 *
 */
public class JAXBUtil {
	
	private static Logger logger = LoggerFactory.getLogger(JAXBUtil.class);
	
	/**
	 * @param file
	 * @param clazz
	 * @return
	 * @throws HelionException
	 */
	public static <T extends Artifact> T loadArtifact(String file, Class<T> clazz) throws HelionException {
		try {
			Unmarshaller jaxbUnmarshaller = unmarshal(file, clazz);
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
			Unmarshaller jaxbUnmarshaller = unmarshal(file, clazz);
			return (List<T>) jaxbUnmarshaller.unmarshal(new File(file));
		} catch (JAXBException e) {
			throw new HelionException(e);
		}
	}

	/**
	 * @param file
	 * @param clazz
	 * @return
	 * @throws JAXBException
	 */
	private static <T extends Artifact> Unmarshaller unmarshal(String file, Class<T> clazz) throws JAXBException {
		logger.debug("Loading artifact {} from file {}", clazz, file );
		JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
		return jaxbContext.createUnmarshaller();
	}
}
