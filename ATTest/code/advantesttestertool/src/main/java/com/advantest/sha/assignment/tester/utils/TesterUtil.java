package com.advantest.sha.assignment.tester.utils;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.advantest.sha.assignment.tester.dbmodel.DeviceModel;
import com.advantest.sha.assignment.tester.dbmodel.TestSuiteModel;

/**
 * The Class TesterUtil.
 */
public class TesterUtil {
	
	/** The log. */
	private static Logger LOG = LoggerFactory.getLogger(TesterUtil.class);
	
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
	 * Gets the test suite model.
	 *
	 * @param fileName the file name
	 * @return the test suite model
	 */
	public static TestSuiteModel getTestSuiteModel(String fileName) {
		LOG.info("Inside TesterUtil.getTestSuiteModel() with filename : " + fileName);
		long exceutionTime = 0;
		List<DeviceModel> deviceList = new ArrayList<>();
		String[] variables = fileName.split("_");
		OS_Enum supportedOS = getSupportedOs(variables[1]);
		for (int index = 2; index < variables.length; index++) {
			if (index == variables.length - 1) {
				exceutionTime = Long.valueOf(variables[index]);
			} else {
				deviceList.add(new DeviceModel(variables[index]));
			}
		}
		String name = variables[0] + exceutionTime;
		return new TestSuiteModel(name, supportedOS, deviceList, exceutionTime);
	}
	
	/**
	 * Gets the supported os.
	 *
	 * @param osStr the os str
	 * @return the supported os
	 */
	public static OS_Enum getSupportedOs(String osStr) {
		switch (osStr) {
		case "win7":
			return OS_Enum.WIN7;
		case "win10":
			return OS_Enum.WIN10;
		case "mac":
			return OS_Enum.MAC;
		}
		return null;
	}
	
	/**
	 * Find execution time.
	 *
	 * @param fileName the file name
	 * @return the long
	 */
	public static long findExecutionTime(String fileName) {
		if (fileName.contains("_")) {
			return Long.valueOf(fileName.substring(fileName.lastIndexOf("_") + 1));
		}
		return 0;
	}
}
