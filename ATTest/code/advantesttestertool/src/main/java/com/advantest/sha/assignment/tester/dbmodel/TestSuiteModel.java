package com.advantest.sha.assignment.tester.dbmodel;

import java.util.List;

import com.advantest.sha.assignment.tester.utils.OS_Enum;

public class TestSuiteModel {

	private String name;
	private OS_Enum suportedOS;
	private List<DeviceModel> deviceList;
	private long exceutionTime;
	private boolean isExceuted;

	public TestSuiteModel(String name, OS_Enum suportedOS, List<DeviceModel> deviceList, long exceutionTime) {
		super();
		this.name = name;
		this.suportedOS = suportedOS;
		this.deviceList = deviceList;
		this.exceutionTime = exceutionTime;
		this.isExceuted = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OS_Enum getSuportedOS() {
		return suportedOS;
	}

	public void setSuportedOS(OS_Enum suportedOS) {
		this.suportedOS = suportedOS;
	}

	public List<DeviceModel> getDeviceList() {
		return deviceList;
	}

	public void setDeviceList(List<DeviceModel> deviceList) {
		this.deviceList = deviceList;
	}

	public long getExceutionTime() {
		return exceutionTime;
	}

	public void setExceutionTime(long exceutionTime) {
		this.exceutionTime = exceutionTime;
	}

	public boolean isExceuted() {
		return isExceuted;
	}

	public void setExceuted(boolean isExceuted) {
		this.isExceuted = isExceuted;
	}

}
