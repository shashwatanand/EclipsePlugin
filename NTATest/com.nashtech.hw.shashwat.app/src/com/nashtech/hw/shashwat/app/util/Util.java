package com.nashtech.hw.shashwat.app.util;

import java.io.File;

import org.eclipse.core.runtime.Platform;

/**
 * The Class Util.
 */
public class Util {
	
	/** The this ref. */
	private static Util thisRef;
	
	private Util() {
		thisRef = this;
	}


	/**
	 * Gets the single instance of Util.
	 *
	 * @return single instance of Util
	 */
	public static Util getInstance() {
		if (thisRef == null) {
			new Util();
		}
		return thisRef;
	}


	/**
	 * Checks if is empty.
	 *
	 * @param inputStr the input str
	 * @return true, if is empty
	 */
	public static boolean isEmpty(final String inputStr) {
		if (inputStr != null && !inputStr.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public static boolean isInteger(final String input) {
	    try { 
	        Integer.parseInt(input); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
	
	public static boolean isBoolean(final String input) {
	    try { 
	        Boolean.parseBoolean(input);
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
	
	public String getInstalledFileLocationStr() {
		return Platform.getInstallLocation().getURL().getFile();
	}
	
	/**
	 * Gets the installed file location.
	 *
	 * @return the installed file location
	 */
	public File getInstalledFileLocation() {
		String filePath;
		if ((filePath = getInstalledFileLocationStr()) != null) {
			return new File(filePath);
		}
		return null;
	}
	
	public String getInputFile() {
		final String installedFilePath = getInstalledFileLocationStr();
		if (isEmpty(installedFilePath)) {
			return installedFilePath + File.separator + "input.txt";
		}
		return null;
	}
}
