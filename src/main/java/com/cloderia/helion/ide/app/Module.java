/**
 * 
 */
package com.cloderia.helion.ide.app;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author adrian
 *
 */
public class Module implements ArtifactData {
	
	private String name;
	private String description;
	private String uiClass;
		
	private Navigation navigation;
	List<Page> pages = new ArrayList<Page>();
	List<String> events = new ArrayList<String>();
	List<Action> actions = new ArrayList<Action>();
	List<Entity> entities = new ArrayList<Entity>();
	List<Service> services = new ArrayList<Service>();
	List<BpmAction> bpmActions = new ArrayList<BpmAction>();
	List<UiComponent> uiComponents = new ArrayList<UiComponent>();

	/**
	 * 
	 */
	public Module() {
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
	 * @return the navigation
	 */
	@XmlElement
	public Navigation getNavigation() {
		return navigation;
	}

	/**
	 * @param navigation the navigation to set
	 */
	public void setNavigation(Navigation navigation) {
		this.navigation = navigation;
	}

	/**
	 * @return the entities
	 */
	public List<Entity> getEntities() {
		return entities;
	}

	/**
	 * @param entities the entities to set
	 */
	@XmlElement(name="entity")
	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}

	/**
	 * @return the services
	 */
	public List<Service> getServices() {
		return services;
	}

	/**
	 * @param services the services to set
	 */
	@XmlElement(name="service")
	public void setServices(List<Service> services) {
		this.services = services;
	}

	/**
	 * @return the events
	 */
	public List<String> getEvents() {
		return events;
	}

	/**
	 * @param events the events to set
	 */
	@XmlElement(name="event")
	public void setEvents(List<String> events) {
		this.events = events;
	}

	/**
	 * @return the pages
	 */
	public List<Page> getPages() {
		return pages;
	}

	/**
	 * @param pages the pages to set
	 */
	@XmlElement(name="page")
	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

	/**
	 * @return the actions
	 */
	public List<Action> getActions() {
		return actions;
	}

	/**
	 * @param actions the actions to set
	 */
	@XmlElement(name="action")
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	/**
	 * @return the actions
	 */
	public List<BpmAction> getBpmActions() {
		return bpmActions;
	}

	/**
	 * @param actions the actions to set
	 */
	@XmlElement(name="bpmAction")
	public void setBpmActions(List<BpmAction> bpmActions) {
		this.bpmActions = bpmActions;
	}

	/**
	 * @return the uiComponents
	 */
	public List<UiComponent> getUiComponents() {
		return uiComponents;
	}

	/**
	 * @param uiComponents the uiComponents to set
	 */
	@XmlElement(name="uiComponent")
	public void setUiComponents(List<UiComponent> uiComponents) {
		this.uiComponents = uiComponents;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.app.ArtifactData#getArtifactDataType()
	 */
	public String getArtifactDataType() {
		return "module";
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
	 * @return the cssClass
	 */
	public String getUiClass() {
		return uiClass;
	}

	/**
	 * @param cssClass the cssClass to set
	 */
	@XmlElement
	public void setUiClass(String cssClass) {
		this.uiClass = cssClass;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 
	@Override
	public String toString() {
		return "Module [name=" + name + ", description=" + description + ", uiClass=" + uiClass + ", navigation="
				+ navigation + ", entities=" + entities + "]";
	}*/

}
