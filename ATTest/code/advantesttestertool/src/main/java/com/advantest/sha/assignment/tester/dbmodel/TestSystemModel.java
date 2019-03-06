package com.advantest.sha.assignment.tester.dbmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.advantest.sha.assignment.tester.utils.SupportedOS;

public class TestSystemModel {
	private String id;
	private String name;
	private SupportedOS supportedOS;
	private boolean isBusy;
	private List<DeviceModel> devices;
	
	private TestSystemModel() {
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public SupportedOS getSupportedOS() {
		return supportedOS;
	}

	public boolean isBusy() {
		return isBusy;
	}

	public void setBusy(final boolean isBusy) {
		this.isBusy = isBusy;
	}

	public List<DeviceModel> getDevices() {
		return devices;
	}

	public static class Builder {
		private String id;
		private String name;
		private SupportedOS supportedOS;
		private List<DeviceModel> devices;
        
        public Builder(final SupportedOS supportedOS) {
            this.id = UUID.randomUUID().toString();
            this.supportedOS = supportedOS;
            this.devices = new ArrayList<>();
        }
        
        public Builder withName(final String name){
            this.name = name;
            return this;
        }
        
        public Builder addDevice(final DeviceModel device){
            this.devices.add(device);
            return this;
        }
        
        public TestSystemModel build(){
        	TestSystemModel testSystem = new TestSystemModel();
        	testSystem.id = this.id;
            testSystem.name = this.name;
            testSystem.supportedOS = this.supportedOS;
            testSystem.devices = this.devices;
            return testSystem;
        }
    }
}
