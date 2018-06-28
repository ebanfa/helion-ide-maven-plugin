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
import com.cloderia.helion.ide.model.Module;

/**
 * @author Edward Banfa
 */
@XmlRootElement(name="webModule")
public class WebModule extends AbstractArtifact {
	private Boolean hasUi;
	private Boolean hasServices;
	private Module parentModule;
	private WebModuleConfig artifactConfig;
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
	public WebModuleConfig getArtifactConfig() {
		return artifactConfig;
	}

	/**
	 * @param extraConfig the extraConfig to set
	 */
	@XmlElement
	public void setArtifactConfig(WebModuleConfig artifactConfig) {
		this.artifactConfig = artifactConfig;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.model.Artifact#getArtifactType()
	 */
	@Override
	public String getArtifactType() {
		return "webModule";
	}
	
	/**
	 * @return the hasUi
	 */
	public Boolean getHasUi() {
		return hasUi;
	}

	/**
	 * @param hasUi the hasUi to set
	 */
	@XmlElement
	public void setHasUi(Boolean hasUi) {
		this.hasUi = hasUi;
	}

	/**
	 * @return the hasServices
	 */
	public Boolean getHasServices() {
		return hasServices;
	}

	/**
	 * @param hasServices the hasServices to set
	 */
	@XmlElement
	public void setHasServices(Boolean hasServices) {
		this.hasServices = hasServices;
	}

	/**
	 * @return the parentModule
	 */
	public Module getParentModule() {
		return parentModule;
	}

	/**
	 * @param parentModule the parentModule to set
	 */
	public void setParentModule(Module parentModule) {
		this.parentModule = parentModule;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WebModule [extraConfig=" + artifactConfig + ", uiModules=" + uiModules + ", webServices=" + webServices
				+ "]";
	}

}
