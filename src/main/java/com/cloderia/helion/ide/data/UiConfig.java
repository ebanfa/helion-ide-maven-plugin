/**
 * 
 */
package com.cloderia.helion.ide.data;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author adrian
 *
 */
public class UiConfig implements ArtifactData {
	
	private String themeColor;
	private String defaultPage;
	private List<PageData> pageDatas = new ArrayList<PageData>();
	

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
	public List<PageData> getPageDatas() {
		return pageDatas;
	}

	/**
	 * @param pageDatas the pageDatas to set
	 */
	@XmlElement(name="page")
	public void setPageDatas(List<PageData> pageDatas) {
		this.pageDatas = pageDatas;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.data.ArtifactData#getArtifactDataType()
	 */
	public String getArtifactDataType() {
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
