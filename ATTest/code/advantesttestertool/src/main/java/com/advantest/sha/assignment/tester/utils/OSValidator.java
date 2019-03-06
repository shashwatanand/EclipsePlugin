package com.advantest.sha.assignment.tester.utils;

public final class OSValidator {

	public static final String OS = System.getProperty("os.name").toLowerCase();

	public static final boolean isWindows7() {
		return (OS.indexOf("windows 7") >= 0);
	}

	public static final boolean isWindows10() {
		return (OS.indexOf("windows 10") >= 0);
	}

	public static final boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}
}