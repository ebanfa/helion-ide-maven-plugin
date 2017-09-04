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
		if(string == null)
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

	public static String columnNameToJavaFieldName(String colName) {
		String[] parts = colName.split("_");
		if(parts.length == 1) return colName;
		String javaClassName = "";
		for (int i = 0; i < parts.length; i++) {
			javaClassName = javaClassName.concat(WordUtils.capitalize(parts[i])); 
		}
		return WordUtils.uncapitalize(javaClassName);
	}

}
