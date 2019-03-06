package com.advantest.sha.assignment.tester.data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.advantest.sha.assignment.tester.dbmodel.DeviceModel;
import com.advantest.sha.assignment.tester.dbmodel.TestSystemModel;
import com.advantest.sha.assignment.tester.utils.SupportedOS;

public class TestSystems {
	private static TestSystems INSTANCE;
	private Map<String, TestSystemModel> inMemTestSystem;

	private TestSystems() {
		if (INSTANCE == null) {
			this.inMemTestSystem = new ConcurrentHashMap<>();
			INSTANCE = this;
		}
	}

	public static TestSystems getInstance() {
		if (INSTANCE == null) {
			new TestSystems();
		}
		return INSTANCE;
	}

	public void createTextSystems() {
		this.inMemTestSystem.put("TestSystem1", new TestSystemModel.Builder(SupportedOS.WIN7).withName("TestSystem1")
				.addDevice(new DeviceModel("D1")).build());
		this.inMemTestSystem.put("TestSystem2", new TestSystemModel.Builder(SupportedOS.WIN7).withName("TestSystem2")
				.addDevice(new DeviceModel("D1")).addDevice(new DeviceModel("D2")).build());
		this.inMemTestSystem.put("TestSystem3",
				new TestSystemModel.Builder(SupportedOS.WIN7).withName("TestSystem3").addDevice(new DeviceModel("D1"))
						.addDevice(new DeviceModel("D2")).addDevice(new DeviceModel("D3")).build());
		this.inMemTestSystem.put("TestSystem4", new TestSystemModel.Builder(SupportedOS.WIN7).withName("TestSystem4")
				.addDevice(new DeviceModel("D1")).build());
	}
	
	public Map<String, TestSystemModel> getInMemTestSystem() {
		return inMemTestSystem;
	}
}
