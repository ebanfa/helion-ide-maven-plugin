/**
 * 
 */
package com.cloderia.helion.ide.model.web;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.cloderia.helion.ide.model.AbstractArtifact;

/**
 * @author Edward Banfa
 */
@XmlRootElement(name="webModule")
public class WebModule extends AbstractArtifact {

	private WebModuleConfig extraConfig;
	private List<UiModule> uiModules = new ArrayList<UiModule>();
	private List<WebService> webServices = new ArrayList<WebService>();
	
	/**
	 * @return the uiModules
	 */
	public List<UiModule> getUiModules() {
		return uiModules;
	}

	/**
	 * @param uiModules the uiModules to set
	 */
	@XmlElement(name="uiModule")
	@XmlElementWrapper(name="uiModules")
	public void setUiModules(List<UiModule> uiModules) {
		this.uiModules = uiModules;
	}
	
	/**
	 * @return the webServices
	 */
	public List<WebService> getWebServices() {
		return webServices;
	}

	/**
	 * @param webServices the webServices to set
	 */
	@XmlElement(name="webService")
	@XmlElementWrapper(name="webServices")
	public void setWebServices(List<WebService> webServices) {
		this.webServices = webServices;
	}

	/**
	 * @return the extraConfig
	 */
	public WebModuleConfig getExtraConfig() {
		return extraConfig;
	}

	/**
	 * @param extraConfig the extraConfig to set
	 */
	@XmlElement
	public void setExtraConfig(WebModuleConfig extraConfig) {
		this.extraConfig = extraConfig;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.model.Artifact#getArtifactType()
	 */
	@Override
	public String getArtifactType() {
		return "webModule";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WebModule [extraConfig=" + extraConfig + ", uiModules=" + uiModules + ", webServices=" + webServices
				+ "]";
	}

}
