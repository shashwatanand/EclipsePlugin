package com.advantest.sha.assignment.tester.dbmodel;

import java.util.List;

import com.advantest.sha.assignment.tester.utils.OS_Enum;

/**
 * The Class TestSuiteModel.
 */
public class TestSuiteModel {

	/** The name. */
	private String name;
	
	/** The suported OS. */
	private OS_Enum suportedOS;
	
	/** The device list. */
	private List<DeviceModel> deviceList;
	
	/** The exceution time. */
	private long exceutionTime;
	
	/** The is exceuted. */
	private boolean isExceuted;

	/**
	 * Instantiates a new test suite model.
	 *
	 * @param name the name
	 * @param suportedOS the suported OS
	 * @param deviceList the device list
	 * @param exceutionTime the exceution time
	 */
	public TestSuiteModel(String name, OS_Enum suportedOS, List<DeviceModel> deviceList, long exceutionTime) {
		super();
		this.name = name;
		this.suportedOS = suportedOS;
		this.deviceList = deviceList;
		this.exceutionTime = exceutionTime;
		this.isExceuted = false;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the suported OS.
	 *
	 * @return the suported OS
	 */
	public OS_Enum getSuportedOS() {
		return suportedOS;
	}

	/**
	 * Sets the suported OS.
	 *
	 * @param suportedOS the new suported OS
	 */
	public void setSuportedOS(OS_Enum suportedOS) {
		this.suportedOS = suportedOS;
	}

	/**
	 * Gets the device list.
	 *
	 * @return the device list
	 */
	public List<DeviceModel> getDeviceList() {
		return deviceList;
	}

	/**
	 * Sets the device list.
	 *
	 * @param deviceList the new device list
	 */
	public void setDeviceList(List<DeviceModel> deviceList) {
		this.deviceList = deviceList;
	}

	/**
	 * Gets the exceution time.
	 *
	 * @return the exceution time
	 */
	public long getExceutionTime() {
		return exceutionTime;
	}

	/**
	 * Sets the exceution time.
	 *
	 * @param exceutionTime the new exceution time
	 */
	public void setExceutionTime(long exceutionTime) {
		this.exceutionTime = exceutionTime;
	}

	/**
	 * Checks if is exceuted.
	 *
	 * @return true, if is exceuted
	 */
	public boolean isExceuted() {
		return isExceuted;
	}

	/**
	 * Sets the exceuted.
	 *
	 * @param isExceuted the new exceuted
	 */
	public void setExceuted(boolean isExceuted) {
		this.isExceuted = isExceuted;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TestSuiteModel [name=" + name + ", suportedOS=" + suportedOS + ", deviceList=" + deviceList
				+ ", exceutionTime=" + exceutionTime + ", isExceuted=" + isExceuted + "]";
	}

}
