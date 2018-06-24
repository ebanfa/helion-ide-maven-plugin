/**
 * 
 */
package com.cloderia.helion.ide.model.web;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.cloderia.helion.ide.model.AbstractArtifact;

/**
 * @author Edward Banfa
 *
 */
@SuppressWarnings("restriction")
@XmlRootElement(name="uiModule")
public class UiModule extends AbstractArtifact {

	private String id;
	private String title;
	private UiModuleConfig extraConfig;
	private List<UiPage> pages;
	private List<UiContainer> containers;
	private List<UiWidget> widgets;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	@XmlElement
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.model.Artifact#getArtifactType()
	 */
	@Override
	public String getArtifactType() {
		return "uiModule";
	}

	/**
	 * @return the extraConfig
	 */
	@XmlElement
	public UiModuleConfig getExtraConfig() {
		return extraConfig;
	}

	/**
	 * @param extraConfig the extraConfig to set
	 */
	public void setExtraConfig(UiModuleConfig extraConfig) {
		this.extraConfig = extraConfig;
	}

	/**
	 * @return the pages
	 */
	public List<UiPage> getPages() {
		return pages;
	}

	/**
	 * @param pages the pages to set
	 */
	@XmlElement(name="uiPage")
	@XmlElementWrapper(name="uiPages")
	public void setPages(List<UiPage> pages) {
		this.pages = pages;
	}

	/**
	 * @return the containers
	 */
	public List<UiContainer> getContainers() {
		return containers;
	}

	/**
	 * @param containers the containers to set
	 */
	@XmlElement(name="uiContainer")
	@XmlElementWrapper(name="uiContainers")
	public void setContainers(List<UiContainer> containers) {
		this.containers = containers;
	}

	/**
	 * @return the widgets
	 */
	public List<UiWidget> getWidgets() {
		return widgets;
	}

	/**
	 * @param widgets the widgets to set
	 */
	@XmlElement(name="uiWidget")
	@XmlElementWrapper(name="uiWidgets")
	public void setWidgets(List<UiWidget> widgets) {
		this.widgets = widgets;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UiModule [id=" + id + ", title=" + title + ", extraConfig=" + extraConfig + ", pages=" + pages
				+ ", containers=" + containers + ", widgets=" + widgets + "]";
	}

}
