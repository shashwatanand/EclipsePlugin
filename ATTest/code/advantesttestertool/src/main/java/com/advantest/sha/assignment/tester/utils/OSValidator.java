package com.advantest.sha.assignment.tester.utils;

/**
 * The Class OSValidator.
 */
public final class OSValidator {

	/** The Constant OS. */
	public static final String OS = System.getProperty("os.name").toLowerCase();

	/**
	 * Checks if is windows 7.
	 *
	 * @return true, if is windows 7
	 */
	public static final boolean isWindows7() {
		return (OS.indexOf("windows 7") >= 0);
	}

	/**
	 * Checks if is windows 10.
	 *
	 * @return true, if is windows 10
	 */
	public static final boolean isWindows10() {
		return (OS.indexOf("windows 10") >= 0);
	}

	/**
	 * Checks if is mac.
	 *
	 * @return true, if is mac
	 */
	public static final boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}
}