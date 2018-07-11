/**
 * 
 */
package com.cloderia.ide.module;

import java.util.ArrayList;
import java.util.List;

import com.cloderia.ide.AbstractArtifact;

/**
 * An abstract implementation of an application module artifact.
 * 
 * @author Edward Banfa
 */
public abstract class AbstractModule<T extends SubModule> extends AbstractArtifact implements Module {
	
	private List<T> subModules = new ArrayList<>();

	/* (non-Javadoc)
	 * @see com.cloderia.helion.model.Artifact#getArtifactType()
	 */
	@Override
	public String getArtifactType() {
		return "module";
	}

	/**
	 * @return the subModules
	 */
	public List<T> getSubModules() {
		return subModules;
	}
}
