/**
 * 
 */
package com.cloderia.helion.config;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * @author Edward Banfa
 *
 */
public class Action extends Artifact {

	private List<ArtifactConfigParameter> params = new ArrayList<ArtifactConfigParameter>();

	/**
	 * @return the params
	 */
	public List<ArtifactConfigParameter> getParams() {
		return params;
	}

	/**
	 * @param params the params to set
	 */
	@XmlElement(name="param")
	@XmlElementWrapper(name="params")
	public void setParams(List<ArtifactConfigParameter> params) {
		this.params = params;
	}
}
