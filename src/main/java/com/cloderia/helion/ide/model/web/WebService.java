/**
 * 
 */
package com.cloderia.helion.ide.model.web;

import javax.xml.bind.annotation.XmlElement;

import com.cloderia.helion.ide.model.AbstractArtifact;

/**
 * @author Edward Banfa
 *
 */
public class WebService extends AbstractArtifact {
	
	private WebModule webModule;
	private String servicePath;
	private WebServiceConfig artifactConfig;

	/**
	 * @return the webModule
	 */
	public WebModule getWebModule() {
		return webModule;
	}

	/**
	 * @param webModule the webModule to set
	 */
	public void setWebModule(WebModule webModule) {
		this.webModule = webModule;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.model.Artifact#getArtifactType()
	 */
	@Override
	public String getArtifactType() {
		return "webService";
	}

	/**
	 * @return the artifactConfig
	 */
	public WebServiceConfig getArtifactConfig() {
		return artifactConfig;
	}

	/**
	 * @param artifactConfig the artifactConfig to set
	 */
	@XmlElement
	public void setArtifactConfig(WebServiceConfig artifactConfig) {
		this.artifactConfig = artifactConfig;
	}

	/**
	 * @return the servicePath
	 */
	public String getServicePath() {
		return servicePath;
	}

	/**
	 * @param servicePath the servicePath to set
	 */
	@XmlElement
	public void setServicePath(String servicePath) {
		this.servicePath = servicePath;
	}

}
