package com.advantest.sha.assignment.tester.utils;

/**
 * The Class OSValidator.
 */
public final class OSValidator {

	/** The Constant OS. */
	public static final String OS = System.getProperty("os.name").toLowerCase();

	/**
	 * Checks if is windows.
	 *
	 * @return true, if is windows
	 */
	public static final boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	/**
	 * Checks if is mac.
	 *
	 * @return true, if is mac
	 */
	public static final boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}

	/**
	 * Checks if is unix or linux.
	 *
	 * @return true, if is unix or linux
	 */
	public static final boolean isUnixOrLinux() {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
	}

	/**
	 * Checks if is solaris.
	 *
	 * @return true, if is solaris
	 */
	public static final boolean isSolaris() {
		return (OS.indexOf("sunos") >= 0);
	}

}