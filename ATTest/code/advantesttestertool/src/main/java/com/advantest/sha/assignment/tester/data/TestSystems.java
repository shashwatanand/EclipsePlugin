package com.advantest.sha.assignment.tester.data;

import com.advantest.sha.assignment.tester.dbmodel.DeviceModel;
import com.advantest.sha.assignment.tester.dbmodel.TestSystemModel;
import com.advantest.sha.assignment.tester.utils.SupportedOS;

public class TestSystems {
	private static TestSystems INSTANCE;

	private TestSystems() {
		if (INSTANCE == null) {
			INSTANCE = this;
		}
	}

	public static TestSystems getINSTANCE() {
		if (INSTANCE == null) {
			new TestSystems();
		}
		return INSTANCE;
	}

	public void createTextSystems() {

		new TestSystemModel.Builder(SupportedOS.WIN7).withName("TestSystem1").addDevice(new DeviceModel("D1")).build();
	}
}
