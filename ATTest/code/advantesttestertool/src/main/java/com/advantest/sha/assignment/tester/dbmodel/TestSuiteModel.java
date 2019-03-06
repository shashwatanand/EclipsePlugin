package com.advantest.sha.assignment.tester.dbmodel;

import java.util.List;

import com.advantest.sha.assignment.tester.utils.SupportedOS;

public class TestSuiteModel {

	private String name;
	private SupportedOS suportedOS;
	private List<DeviceModel> deviceList;
	private long exceutionTime;

	public TestSuiteModel(String name, SupportedOS suportedOS, List<DeviceModel> deviceList, long exceutionTime) {
		super();
		this.name = name;
		this.suportedOS = suportedOS;
		this.deviceList = deviceList;
		this.exceutionTime = exceutionTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SupportedOS getSuportedOS() {
		return suportedOS;
	}

	public void setSuportedOS(SupportedOS suportedOS) {
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

}
