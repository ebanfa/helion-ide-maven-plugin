/**
 * 
 */
package com.cloderia.helion.model.application;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.cloderia.helion.model.database.DataBase;
import com.cloderia.helion.model.database.JEEDataBase;
import com.cloderia.helion.model.module.EjbDataModule;
import com.cloderia.helion.model.module.EjbServiceModule;
import com.cloderia.helion.model.module.EjbSharedModule;
import com.cloderia.helion.model.module.JavaWebModule;

/**
 * @author Edward Banfa
 */
@SuppressWarnings("restriction")
@XmlRootElement(name="application")
public class JEEApplication extends AbstractApplication {
	
	private DataBase dataBase = new JEEDataBase();
	private List<JavaWebModule> webModules = new ArrayList<JavaWebModule>();
	private List<EjbDataModule> dataModules = new ArrayList<EjbDataModule>();
	private List<EjbSharedModule> sharedModules = new ArrayList<EjbSharedModule>();
	private List<EjbServiceModule> serviceModules = new ArrayList<EjbServiceModule>();

	
	/**
	 * @return the dataBase
	 */
	public DataBase getDataBase() {
		return dataBase;
	}

	/**
	 * @param dataBase the dataBase to set
	 */
	@XmlTransient
	public void setDataBase(DataBase dataBase) {
		this.dataBase = dataBase;
	}

	/**
	 * @return the webModules
	 */
	public List<JavaWebModule> getWebModules() {
		return webModules;
	}

	/**
	 * @param webModules the webModules to set
	 */
	@XmlElement(name="webModule")
	@XmlElementWrapper(name="webModules")
	public void setWebModules(List<JavaWebModule> webModules) {
		this.webModules = webModules;
	}

	/**
	 * @return the dataModules
	 */
	public List<EjbDataModule> getDataModules() {
		return dataModules;
	}

	/**
	 * @param dataModules the dataModules to set
	 */
	@XmlElement(name="dataModule")
	@XmlElementWrapper(name="dataModules")
	public void setDataModules(List<EjbDataModule> dataModules) {
		this.dataModules = dataModules;
	}
	
	/**
	 * @return the sharedModules
	 */
	public List<EjbSharedModule> getSharedModules() {
		return sharedModules;
	}

	/**
	 * @param sharedModules the sharedModules to set
	 */
	@XmlElement(name="sharedModule")
	@XmlElementWrapper(name="sharedModules")
	public void setSharedModules(List<EjbSharedModule> sharedModules) {
		this.sharedModules = sharedModules;
	}

	/**
	 * @return the serviceModules
	 */
	public List<EjbServiceModule> getServiceModules() {
		return serviceModules;
	}

	/**
	 * @param serviceModules the serviceModules to set
	 */
	@XmlElement(name="serviceModule")
	@XmlElementWrapper(name="serviceModules")
	public void setServiceModules(List<EjbServiceModule> serviceModules) {
		this.serviceModules = serviceModules;
	}


}
