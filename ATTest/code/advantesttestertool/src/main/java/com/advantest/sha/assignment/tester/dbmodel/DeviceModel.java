package com.advantest.sha.assignment.tester.dbmodel;

import java.util.UUID;

public class DeviceModel {
	private String id;
	private String name;

	/**
	 * @param id
	 * @param name
	 */
	public DeviceModel(String name) {
		super();
		this.id = UUID.randomUUID().toString();
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
