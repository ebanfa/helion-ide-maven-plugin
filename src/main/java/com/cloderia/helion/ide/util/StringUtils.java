/**
 * 
 */
package com.cloderia.helion.ide.util;

//import org.apache.commons.lang.WordUtils;

/**
 * @author adrian
 *
 */
public class StringUtils {
	
	public static String tableNameToJavaClassName(String tableName) {
		//tableName = WordUtils.capitalize(tableName);
		String[] parts = tableName.split("_");
		if(parts.length == 1) return tableName;
		String javaClassName = "";
		for (int i = 0; i < parts.length; i++) {
			javaClassName = javaClassName.concat(parts[i]); 
		}
		return javaClassName;
	}
	
	public static String columnNameToJavaFieldName(String colName) {
		String[] parts = colName.split("_");
		if(parts.length == 1) return colName;
		String javaClassName = "";
		for (int i = 0; i < parts.length; i++) {
			//javaClassName = javaClassName.concat(WordUtils.capitalize(parts[i])); 
		}
		return colName;
		//return WordUtils.uncapitalize(javaClassName);
	}

	public static boolean isValidString(String string) {
		if(string == null)
			return false;
		else if (string.isEmpty())
			return false;
		else if (string.trim().equals(""))
			return false;
		return true;
	}

}
