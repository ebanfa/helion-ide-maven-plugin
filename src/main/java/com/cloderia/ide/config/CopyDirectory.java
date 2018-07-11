/**
 * 
 */
package com.cloderia.ide.config;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Edward Banfa
 *
 */
public class CopyDirectory  {
	
	private String source;
	private String target;
	private boolean copyInto;

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

	/**
	 * @return the copyInto
	 */
	public boolean isCopyInto() {
		return copyInto;
	}

	/**
	 * @param copyInto the copyInto to set
	 */
	@XmlElement
	public void setCopyInto(boolean copyInto) {
		this.copyInto = copyInto;
	}

}
