/**
 * 
 */
package com.cloderia.helion.model.web;

import java.util.List;

import com.cloderia.helion.model.Artifact;

/**
 * @author Edward Banfa
 *
 */
public interface UiPage extends Artifact {
	
	/**
	 * @return the uiContainers
	 */
	public <T extends UiContainer> List<T> getUiContainers();
}
