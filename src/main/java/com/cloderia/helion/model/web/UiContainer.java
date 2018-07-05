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
public interface UiContainer extends Artifact {

	/**
	 * @return the uiWidgets
	 */
	public <T extends UiWidget> List<T> getUiWidgets();
}
