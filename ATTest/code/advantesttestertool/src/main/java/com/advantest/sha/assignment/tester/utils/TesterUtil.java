package com.advantest.sha.assignment.tester.utils;

import java.util.ArrayList;
import java.util.List;

import com.advantest.sha.assignment.tester.dbmodel.DeviceModel;
import com.advantest.sha.assignment.tester.dbmodel.TestSuiteModel;

public class TesterUtil {
	public static boolean isEmpty(final String inputStr) {
		if (inputStr != null && !inputStr.isEmpty()) {
			return false;
		}
		return true;
	}

	public static TestSuiteModel getTestSuiteModel(String fileName) {
		long exceutionTime = 0;
		List<DeviceModel> deviceList = new ArrayList<>();
		String[] variables = fileName.split("_");
		SupportedOS supportedOS = getSupportedOs(variables[1]);
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
	
	public static SupportedOS getSupportedOs(String osStr) {
		switch (osStr) {
		case "win7":
			return SupportedOS.WIN7;
		case "win10":
			return SupportedOS.WIN10;
		case "mac":
			return SupportedOS.MAC;
		}
		return null;
	}
}
