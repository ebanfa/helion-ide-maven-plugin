/**
 * 
 */
package com.cloderia.helion.model.module;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.cloderia.helion.model.entity.Entity;
import com.cloderia.helion.model.entity.JPAEntity;
import com.cloderia.helion.model.web.UiModule;
import com.cloderia.helion.model.web.WebService;

/**
 * @author Edward Banfa
 *
 */
@XmlRootElement(name="module")
public class JavaWebModule extends AbstractWebModule implements WebModule {

	private List<JPAEntity> entities = new ArrayList<JPAEntity>();

	/**
	 * @return the entities
	 */
	public List<JPAEntity> getEntities() {
		return entities;
	}
	
	/**
	 * @param entities the entities to set
	 */
	@XmlElement(name="entity")
	@XmlElementWrapper(name="entities")
	public void setEntities(List<JPAEntity> entities) {
		this.entities = entities;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.model.module.WebModule#getUiModules()
	 */
	@Override
	public <T extends UiModule> List<T> getUiModules() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.model.module.WebModule#getWebServices()
	 */
	@Override
	public <T extends WebService> List<T> getWebServices() {
		// TODO Auto-generated method stub
		return null;
	}

}
