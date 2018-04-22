package com.nashtech.hw.shashwat.app.util;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.services.events.IEventBroker;

import com.nashtech.hw.shashwat.app.model.Tuple;
import com.nashtech.hw.shashwat.app.ui.console.ConsoleLogObj;
import com.nashtech.hw.shashwat.app.ui.console.MessageType;

/**
 * The Class Util.
 */
public class Util {
	
	/** The this ref. */
	private static Util thisRef;
	
	/** The in mem tuples. */
	private Map<Integer, Tuple> inMemTuples;
	
	/** The event broker. */
	@Inject
	private IEventBroker eventBroker;
	
	/**
	 * Instantiates a new util.
	 */
	public Util() {
		this.inMemTuples = new LinkedHashMap<>();
		setInstance(this);
	}

	/**
	 * Sets the instance.
	 *
	 * @param util the new instance
	 */
	private void setInstance(Util util) {
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
	
	/**
	 * Checks if is integer.
	 *
	 * @param input the input
	 * @return true, if is integer
	 */
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
	
	/**
	 * Checks if is boolean.
	 *
	 * @param input the input
	 * @return true, if is boolean
	 */
	public static boolean isBoolean(final String input) {
		if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
			return true;
		}
		return false;
	}
	
	/**
	 * Gets the in mem tuples.
	 *
	 * @return the inMemTuples
	 */
	public Map<Integer, Tuple> getInMemTuples() {
		return inMemTuples;
	}
	
	/**
	 * Update log file.
	 *
	 * @param message the message
	 * @param messageType the message type
	 */
	public void updateLogFile(String message, final MessageType messageType) {
		this.eventBroker.send(Constants.CONSOLE_MESSAGE, 
				new ConsoleLogObj(messageType, message + "\n"));
	}


	/**
	 * Gets the installed file location str.
	 *
	 * @return the installed file location str
	 */
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
	
	/**
	 * Gets the input file.
	 *
	 * @return the input file
	 */
	public String getInputFile() {
		final String installedFilePath = getInstalledFileLocationStr();
		if (isEmpty(installedFilePath)) {
			return installedFilePath + File.separator + "input.txt";
		}
		return null;
	}
}
