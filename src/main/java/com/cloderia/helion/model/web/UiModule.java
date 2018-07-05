/**
 * 
 */
package com.cloderia.helion.model.web;

import java.util.List;

import com.cloderia.helion.model.module.Module;

/**
 * @author Edward Banfa
 *
 */
public interface UiModule extends Module {

	/**
	 * @return the uiPages
	 */
	public <T extends UiPage> List<T> getUiPages();
}
