package com.advantest.sha.assignment.tester.utils;

public class TestUtil {
	public static boolean isEmpty(final String inputStr) {
		if (inputStr != null && !inputStr.isEmpty()) {
			return false;
		}
		return true;
	}
}
