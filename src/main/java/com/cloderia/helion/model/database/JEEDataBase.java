/**
 * 
 */
package com.cloderia.helion.model.database;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Edward Banfa
 *
 */
public class JEEDataBase extends AbstractDataBase implements DataBase {

	private String dataSource;
	
	/**
	 * @return the dataSource
	 */
	public String getDataSource() {
		return dataSource;
	}

	/**
	 * @param dataSource the dataSource to set
	 */
	@XmlElement
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
}
