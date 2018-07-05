/**
 * 
 */
package com.cloderia.helion.model.module;

import java.util.List;

import com.cloderia.helion.model.web.UiModule;
import com.cloderia.helion.model.web.WebService;

/**
 * @author Edward Banfa
 */
public interface WebModule extends Module {
	
	/**
	 * @return the hasUi
	 */
	public Boolean getHasUi();
	
	/**
	 * @return the hasWebServices
	 */
	public Boolean getHasWebServices();
	
	/**
	 * @return the uiModules
	 */
	public <T extends UiModule> List<T> getUiModules();
	
	/**
	 * @return the webServices
	 */
	public <T extends WebService> List<T> getWebServices();
}
