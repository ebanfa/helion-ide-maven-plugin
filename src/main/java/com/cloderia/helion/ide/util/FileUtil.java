/**
 * 
 */
package com.cloderia.helion.ide.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * @author adrian
 *
 */
public class FileUtil {
	
	/**
	 * @param directoryName
	 */
	public static File createDirectoryIfNeeded(String directoryName) {
		File theDir = new File(directoryName);
		if (!theDir.exists()) {
			theDir.mkdirs();
		}
		return theDir;
	}

	/**
	 * @param directoryName
	 * @return
	 */
	public static boolean deleteDir(String directoryName) {
		File theDir = new File(directoryName);
		if (theDir.exists()) {
			File[] files = theDir.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					deleteDir(files[i].getPath());
				} else {
					files[i].delete();
				}
			}
		}
		return (theDir.delete());
	}

	/**
	 * @param srcDir
	 * @param dstDir
	 */
	public static void copyDirectory(String srcDir, String dstDir) {
		File source = new File(srcDir);
		File destination = createDirectoryIfNeeded(dstDir);
		//System.out.printf("Copying directory %s to %s \n", source,  destination);
		try {
			FileUtils.copyDirectory(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void copyDirectoryToDirectory(String srcDir, String dstDir) {
		File source = new File(srcDir);
		File destination = createDirectoryIfNeeded(dstDir);
		//System.out.printf("Copying directory %s to within directory %s \n", source,  destination);
		try {
			FileUtils.copyDirectoryToDirectory(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param srcDir
	 * @param dstDir
	 */
	public static void copyFileToFile(String srcDir, String dstDir) {
		File source = new File(srcDir);
		File destination = new File(dstDir);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void copyFileToDirectory(String srcDir, String dstDir) {
		File source = new File(srcDir);
		File destination = new File(dstDir);
		try {
			FileUtils.copyFileToDirectory(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param directories
	 * @param templateNm
	 * @return
	 */
	public static Boolean doesTemplateExit(List<String> directories, String templateNm) {
		for(String directory: directories){
			return searchDirectory(new File(directory), templateNm);
		}
		return false;
	}
	
	/**
	 * @param directory
	 * @param fileNameToSearch
	 * @return
	 */
	public static Boolean searchDirectory(File directory, String fileNameToSearch) {
		if (directory.isDirectory()) {
			return search(directory, fileNameToSearch);
		} 
		return false;
	}

	/**
	 * @param file
	 * @param fileNameToSearch
	 * @return
	 */
	private static Boolean search(File file, String fileNameToSearch) {
		if (file.isDirectory()) {
			//System.out.println("Searching directory ... " + file.getAbsoluteFile());
			// do you have permission to read this directory?
			if (file.canRead()) {
				for (File temp : file.listFiles()) {
					if (temp.isDirectory()) {
						search(temp, fileNameToSearch);
					} else {
						System.out.println("Searching " + fileNameToSearch + ":::" + temp.getName());
						if (fileNameToSearch.equals(temp.getName())) {
							System.out.println("################found");
							return true;
						}
					}
				}
			} else {
				System.out.println(file.getAbsoluteFile() + "Permission Denied");
			}
		}
		return false;
	}
}
