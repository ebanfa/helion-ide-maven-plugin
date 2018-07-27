/**
 * 
 */
package com.cloderia.helion.application.model;

import java.util.ArrayList;
import java.util.List;

import com.cloderia.helion.config.Artifact;

/**
 * @author Edward Banfa
 */
public class Container extends Component {
	
	private List<Component> components = new ArrayList<Component>();

	/**
	 * 
	 */
	public Container() {
	}

	/**
	 * @param config
	 */
	public Container(Artifact config) {
		super(config);
	}

	/**
	 * @return the components
	 */
	public List<Component> getComponents() {
		return components;
	}

	/**
	 * @param components the components to set
	 */
	public void setComponents(List<Component> components) {
		this.components = components;
	}
}
