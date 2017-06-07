/**
 * 
 */
package com.cloderia.helion.ide.loader;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.cloderia.helion.ide.app.Application;
import com.cloderia.helion.ide.app.Entity;
import com.cloderia.helion.ide.app.Field;
import com.cloderia.helion.ide.app.Module;
import com.cloderia.helion.ide.configuration.ArtifactLoader;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEException;
import com.cloderia.helion.ide.util.StringUtils;

/**
 * @author adrian
 *
 */
public class XMLArtifactDataLoader implements ArtifactDataLoader {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.loader.ArtifactDataLoader#loadArtifactsData(com.cloderia.helion.ide.configuration.BuildConfiguration)
	 */
	public Application loadArtifactsData(BuildConfiguration buildConfiguration) throws IDEException {
		try {
			ArtifactLoader dataLoader = buildConfiguration.getLoader();
			File file = new File(dataLoader.getConfig());
			JAXBContext jaxbContext = JAXBContext.newInstance(Application.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Application application = (Application) jaxbUnmarshaller.unmarshal(file);
			this.preProcess(application);
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
	private void preProcess(Application application) {
		for (Module module : application.getModules()) {
			this.preProcessModule(module);
		}
	}

	/**
	 * @param module
	 */
	private void preProcessModule(Module module) {
		for (Entity entity : module.getEntities()) {
			this.preProcessEntity(entity, module);
		}
	}
	
	/**
	 * @param entity
	 * @param module
	 */
	private void preProcessEntity(Entity entity, Module module){
		for (Field field : entity.getFields()) {
			this.preProcessField(field);
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>" + entity.getName() + "::::" + entity.getIsVirtual());
		entity.setModule(module);
		entity.setPostName(entity.getName().toLowerCase());
	}

	/**
	 * @param field
	 */
	private void preProcessField(Field field) {
		if(field.isValidateRequired()){}
		field.setJavaName(StringUtils.columnNameToJavaFieldName(field.getName()));
		if(field.getName().equals("name")) field.setSize("75");
		else if(field.getName().equals("entity_code")) field.setSize("35");
		else if(field.getSize().equals("large")) field.setSize("255");
		else if(field.getSize().equals("medium")) field.setSize("35");
	}

}
