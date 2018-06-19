/**
 * 
 */
package com.cloderia.helion.ide.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author adrian
 *
 */
public class UiConfig implements Artifact {
	
	private String themeColor;
	private String defaultPage;
	private List<ContainerData> containerDatas = new ArrayList<ContainerData>();
	

	/**
	 * @return the themeColor
	 */
	public String getThemeColor() {
		return themeColor;
	}

	/**
	 * @param themeColor the themeColor to set
	 */
	@XmlElement
	public void setThemeColor(String themeColor) {
		this.themeColor = themeColor;
	}

	/**
	 * @return the defaultPage
	 */
	public String getDefaultPage() {
		return defaultPage;
	}

	/**
	 * @param defaultPage the defaultPage to set
	 */
	@XmlElement
	public void setDefaultPage(String defaultPage) {
		this.defaultPage = defaultPage;
	}

	/**
	 * @return the pageDatas
	 */
	public List<ContainerData> getContainerDatas() {
		return containerDatas;
	}

	/**
	 * @param pageDatas the pageDatas to set
	 */
	@XmlElement(name="container")
	public void setContainerDatas(List<ContainerData> containerDatas) {
		this.containerDatas = containerDatas;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.data.ArtifactData#getArtifactDataType()
	 */
	public String getArtifactType() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.data.ArtifactData#getName()
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
