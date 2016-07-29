/**
 * 
 */
package com.cloderia.helion.ide.app;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author adrian
 *
 */
public class Navigation implements ArtifactData {

	List<NavItem> items = new ArrayList<NavItem>();


	/**
	 * @return the items
	 */
	public List<NavItem> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	@XmlElement(name="navItem")
	public void setItems(List<NavItem> items) {
		this.items = items;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.app.ArtifactData#getArtifactDataType()
	 */
	public String getArtifactDataType() {
		return "menubar";
	}

}