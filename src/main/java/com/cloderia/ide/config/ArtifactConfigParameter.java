/**
 * 
 */
package com.cloderia.ide.config;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Edward Banfa
 *
 */
public class ArtifactConfigParameter  {

	private String paramName;
	private String paramValue;
	
	/**
	 * @return the name
	 */
	public String getParamName() {
		return paramName;
	}
	
	/**
	 * @param name the name to set
	 */
	@XmlElement
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	
	/**
	 * @return the value
	 */
	public String getParamValue() {
		return paramValue;
	}
	
	/**
	 * @param value the value to set
	 */
	@XmlElement
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ArtifactConfigParameter [paramName=" + paramName + ", paramValue=" + paramValue + "]";
	}
}
