/**
 * 
 */
package com.cloderia.helion.model.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Edward Banfa
 */
public class JPAEntity extends AbstractEntity {

	private String tableName;
	@JsonIgnore
	private List<JPAEntityField> fields = new ArrayList<JPAEntityField>();

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the fields
	 */
	public List<JPAEntityField> getFields() {
		return fields;
	}

	/**
	 * @param fields the fields to set
	 */
	public void setFields(List<JPAEntityField> fields) {
		this.fields = fields;
	}
	
}
