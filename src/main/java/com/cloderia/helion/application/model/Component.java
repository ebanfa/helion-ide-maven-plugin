/**
 * 
 */
package com.cloderia.helion.application.model;

import java.util.ArrayList;
import java.util.List;

import com.cloderia.helion.application.action.Action;
import com.cloderia.helion.config.Artifact;

/**
 * A component is an abstract application building block.
 * Application, modules and submodules are examples of artifacts.
 * An artifact can be composed of zero or more artifacts
 * 
 * @author Edward Banfa
 */
public class Component {
	
	private Artifact config;
	private List<Action> actions = new ArrayList<Action>();

	/**
	 * 
	 */
	public Component() {
	}
	
	/**
	 * 
	 */
	public Component(Artifact config) {
		this.config = config;
	}

	/**
	 * @return the config
	 */
	public Artifact getConfig() {
		return config;
	}

	/**
	 * @return the actions
	 */
	public List<Action> getActions() {
		return actions;
	}

	/**
	 * @param actions the actions to set
	 */
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	
}
