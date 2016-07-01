/**
 * 
 */
package com.cloderia.helion.ide.util;

import org.apache.commons.lang.WordUtils;

/**
 * @author adrian
 *
 */
public class StringUtils {
	
	public static String tableNameToJavaClassName(String tableName) {
		tableName = WordUtils.capitalize(tableName);
		String[] parts = tableName.split("_");
		if(parts.length == 1) return tableName;
		String javaClassName = "";
		for (int i = 0; i < parts.length; i++) {
			javaClassName.concat(parts[i]); 
		}
		return javaClassName;
	}

}
