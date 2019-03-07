package com.advantest.sha.assignment.tester.data;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.advantest.sha.assignment.tester.dbmodel.DeviceModel;
import com.advantest.sha.assignment.tester.dbmodel.TestSuiteModel;
import com.advantest.sha.assignment.tester.dbmodel.TestSystemModel;
import com.advantest.sha.assignment.tester.utils.OS_Enum;

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
		this.inMemTestSystem.put("TestSystem1", new TestSystemModel.Builder(OS_Enum.MAC).withName("TestSystem1")
				.addDevice(new DeviceModel("D1")).build());
		this.inMemTestSystem.put("TestSystem2", new TestSystemModel.Builder(OS_Enum.WIN7).withName("TestSystem2")
				.addDevice(new DeviceModel("D1")).addDevice(new DeviceModel("D2")).build());
		this.inMemTestSystem.put("TestSystem3",
				new TestSystemModel.Builder(OS_Enum.WIN7).withName("TestSystem3").addDevice(new DeviceModel("D1"))
						.addDevice(new DeviceModel("D2")).addDevice(new DeviceModel("D3")).build());
		this.inMemTestSystem.put("TestSystem4", new TestSystemModel.Builder(OS_Enum.WIN7).withName("TestSystem4")
				.addDevice(new DeviceModel("D1")).build());
		this.inMemTestSystem.put("TestSystem5",
				new TestSystemModel.Builder(OS_Enum.WIN10).withName("TestSystem5").addDevice(new DeviceModel("D1"))
						.addDevice(new DeviceModel("D2")).addDevice(new DeviceModel("D3")).build());
	}
	
	public Map<String, TestSystemModel> getInMemTestSystem() {
		return inMemTestSystem;
	}
	
	public List<TestSystemModel> findAvailableTestSystem(TestSuiteModel testSuiteModel) {
		OS_Enum requiredOs = testSuiteModel.getSuportedOS();
		List<DeviceModel> neededDevices = testSuiteModel.getDeviceList();
		return this.inMemTestSystem.values().stream().filter(t -> t.getSupportedOS() == requiredOs).filter(t -> {
			boolean isAllRequiredDevicesExists = false;
			Map<String, DeviceModel> systemDevices = t.getDevices();
			for (DeviceModel deviceModel : neededDevices) {
				if (systemDevices.containsKey(deviceModel.getName())) {
					isAllRequiredDevicesExists = true;
				}
			}
			return isAllRequiredDevicesExists;
		}).collect(Collectors.toList());
	}
}
