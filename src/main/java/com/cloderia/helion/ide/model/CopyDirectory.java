/**
 * 
 */
package com.cloderia.helion.ide.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Edward Banfa
 *
 */
public class CopyDirectory  {
	
	private String source;
	private String target;

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	@XmlElement
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the target
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	@XmlElement
	public void setTarget(String target) {
		this.target = target;
	}

}
