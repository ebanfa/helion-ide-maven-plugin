/**
 * 
 */
package com.cloderia.helion.ide.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * @author Edward Banfa
 *
 */
public class AbstractArtifactConfig implements ArtifactConfig {

	private List<CopyDirectory> copyDirectories = new ArrayList<CopyDirectory>();

	/**
	 * @return the copyDirectories
	 */
	public List<CopyDirectory> getCopyDirectories() {
		return copyDirectories;
	}

	/**
	 * @param copyDirectories the copyDirectories to set
	 */
	@XmlElement(name="copyDirectory")
	@XmlElementWrapper(name="copyResources")
	public void setCopyDirectories(List<CopyDirectory> copyDirectories) {
		this.copyDirectories = copyDirectories;
	}
}
