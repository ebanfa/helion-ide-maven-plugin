/**
 * 
 */
package com.cloderia.helion.util;

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
	
	/**
	 * @param packageName
	 * @return
	 */
	public static String packageNameToFilePath(String packageName) {
		return StringUtil.trailingSlashIt(packageName.replace('.', '/'));
	}

	/**
	 * @param tableName
	 * @return
	 */
	public static String tableNameToJavaClassName(String tableName) {
		tableName = WordUtils.capitalize(tableName.toLowerCase(), '_');
		return concatDelimitedString(tableName, "_");
	}
	
	/**
	 * @param moduleId
	 * @return
	 */
	public static String moduleIdToJavaClassName(String moduleId) {
		moduleId = WordUtils.capitalize(moduleId.toLowerCase(), '-');
		return concatDelimitedString(moduleId, "-");
	}

	/**
	 * @param tableName
	 * @return
	 */
	private static String concatDelimitedString(String delimitedString, String delimiter) {
		String[] parts = delimitedString.split(delimiter);
		if (parts.length == 1)
			return delimitedString;
		String newString = "";
		for (int i = 0; i < parts.length; i++) {
			newString = newString.concat(parts[i]);
		}
		return newString;
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
