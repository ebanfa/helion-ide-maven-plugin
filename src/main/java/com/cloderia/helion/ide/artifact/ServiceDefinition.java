/**
 * 
 */
package com.cloderia.helion.ide.artifact;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author adrian
 *
 */
public class ServiceDefinition implements ArtifactData {
	
	private String name;
	private String description;
	private String serviceInterface;
	private String serviceInterfaceImpl;
	private String serviceImplementation;
	private String dataObject;
	
	private Module module;

	/**
	 * 
	 */
	public ServiceDefinition() {
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the serviceInterface
	 */
	public String getServiceInterface() {
		return serviceInterface;
	}

	/**
	 * @param serviceInterface the serviceInterface to set
	 */
	@XmlElement
	public void setServiceInterface(String serviceInterface) {
		this.serviceInterface = serviceInterface;
	}

	/**
	 * @return the serviceInterfaceImpl
	 */
	public String getServiceInterfaceImpl() {
		return serviceInterfaceImpl;
	}

	/**
	 * @param serviceInterfaceImpl the serviceInterfaceImpl to set
	 */
	@XmlElement
	public void setServiceInterfaceImpl(String serviceInterfaceImpl) {
		this.serviceInterfaceImpl = serviceInterfaceImpl;
	}

	/**
	 * @return the serviceImplementation
	 */
	public String getServiceImplementation() {
		return serviceImplementation;
	}

	/**
	 * @param serviceImplementation the serviceImplementation to set
	 */
	@XmlElement
	public void setServiceImplementation(String serviceImplementation) {
		this.serviceImplementation = serviceImplementation;
	}

	/**
	 * @return the module
	 */
	public Module getModule() {
		return module;
	}

	/**
	 * @param module the module to set
	 */
	public void setModule(Module module) {
		this.module = module;
	}

	/**
	 * @return the dataObject
	 */
	@XmlElement
	public String getDataObject() {
		return dataObject;
	}

	/**
	 * @param dataObject the dataObject to set
	 */
	public void setDataObject(String dataObject) {
		this.dataObject = dataObject;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.app.ArtifactData#getArtifactDataType()
	 */
	public String getArtifactDataType() {
		return "service";
	}

}
