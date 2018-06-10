/**
 * 
 */
package com.cloderia.helion.ide.util;

import org.apache.commons.lang3.text.WordUtils;

/**
 * @author adrian
 *
 */
public class StringUtil {

	/**
	 * @param string
	 * @return
	 */
	public static boolean isValidString(String string) {
		if (string == null)
			return false;
		else if (string.isEmpty())
			return false;
		else if (string.trim().equals(""))
			return false;
		return true;
	}

	/**
	 * @param string
	 * @return
	 */
	public static String trailingSlashIt(String string) {
		return string.concat("/");
	}

	/**
	 * @param string
	 * @return
	 */
	public static String lowerCase(String string) {
		return string.toLowerCase();
	}

	public static String tableNameToJavaClassName(String tableName) {
		tableName = WordUtils.capitalize(tableName.toLowerCase(), '_');
		String[] parts = tableName.split("_");
		if (parts.length == 1)
			return tableName;
		String javaClassName = "";
		for (int i = 0; i < parts.length; i++) {
			javaClassName = javaClassName.concat(parts[i]);
		}
		return javaClassName;
	}

	public static String columnNameToJavaFieldName(String colName) {
		colName = WordUtils.capitalize(colName.toLowerCase(), '_');
		String[] parts = colName.split("_");
		if (parts.length == 1)
			return colName;
		String javaClassName = "";
		for (int i = 0; i < parts.length; i++) {
			javaClassName = javaClassName.concat(WordUtils.capitalize(parts[i]));
		}
		return WordUtils.uncapitalize(javaClassName);
	}

}
