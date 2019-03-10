package com.advantest.sha.assignment.tester.dbmodel;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.advantest.sha.assignment.tester.utils.OS_Enum;

/**
 * The Class TestSystemModel.
 */
public class TestSystemModel {
	
	/** The id. */
	private String id;
	
	/** The name. */
	private String name;
	
	/** The supported OS. */
	private OS_Enum supportedOS;
	
	/** The is busy. */
	private boolean isBusy;
	
	/** The devices. */
	private Map<String, DeviceModel> devices;

	/**
	 * Instantiates a new test system model.
	 */
	private TestSystemModel() {
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
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
	 * Gets the supported OS.
	 *
	 * @return the supported OS
	 */
	public OS_Enum getSupportedOS() {
		return supportedOS;
	}

	/**
	 * Checks if is busy.
	 *
	 * @return true, if is busy
	 */
	public boolean isBusy() {
		return isBusy;
	}

	/**
	 * Gets the devices.
	 *
	 * @return the devices
	 */
	public Map<String, DeviceModel> getDevices() {
		return devices;
	}

	/**
	 * Sets the busy.
	 *
	 * @param isBusy the new busy
	 */
	public void setBusy(final boolean isBusy) {
		this.isBusy = isBusy;
	}

	/**
	 * The Class Builder.
	 */
	public static class Builder {
		
		/** The id. */
		private String id;
		
		/** The name. */
		private String name;
		
		/** The supported OS. */
		private OS_Enum supportedOS;
		
		/** The devices. */
		private Map<String, DeviceModel> devices;

		/**
		 * Instantiates a new builder.
		 *
		 * @param supportedOS the supported OS
		 */
		public Builder(final OS_Enum supportedOS) {
			this.id = UUID.randomUUID().toString();
			this.supportedOS = supportedOS;
			this.devices = new HashMap<>();
		}

		/**
		 * With name.
		 *
		 * @param name the name
		 * @return the builder
		 */
		public Builder withName(final String name) {
			this.name = name;
			return this;
		}

		/**
		 * Adds the device.
		 *
		 * @param device the device
		 * @return the builder
		 */
		public Builder addDevice(final DeviceModel device) {
			this.devices.put(device.getName(), device);
			return this;
		}

		/**
		 * Builds the.
		 *
		 * @return the test system model
		 */
		public TestSystemModel build() {
			TestSystemModel testSystem = new TestSystemModel();
			testSystem.id = this.id;
			testSystem.name = this.name;
			testSystem.supportedOS = this.supportedOS;
			testSystem.devices = this.devices;
			testSystem.isBusy = false;
			return testSystem;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TestSystemModel [id=" + id + ", name=" + name + ", supportedOS=" + supportedOS + ", isBusy=" + isBusy
				+ ", devices=" + devices + "]";
	}
}
