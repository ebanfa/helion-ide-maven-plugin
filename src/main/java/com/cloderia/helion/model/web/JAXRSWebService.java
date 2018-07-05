/**
 * 
 */
package com.cloderia.helion.model.web;

import javax.xml.bind.annotation.XmlTransient;

import com.cloderia.helion.model.module.WebModule;

/**
 * @author Edward Banfa
 */
public class JAXRSWebService extends AbstractWebService {
	
	private WebModule webModule;

	/**
	 * @return the webModule
	 */
	public WebModule getWebModule() {
		return webModule;
	}

	/**
	 * @param webModule the webModule to set
	 */
	@XmlTransient
	public void setWebModule(WebModule webModule) {
		this.webModule = webModule;
	}

}
