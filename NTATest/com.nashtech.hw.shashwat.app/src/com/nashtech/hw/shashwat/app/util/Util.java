package com.nashtech.hw.shashwat.app.util;


public class Util {
	private static Util thisRef;


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
}
