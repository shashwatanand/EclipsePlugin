package com.advantest.sha.assignment.tester.dbmodel;

import java.util.UUID;

/**
 * The Class DeviceModel.
 */
public class DeviceModel {
	
	/** The id. */
	private String id;
	
	/** The name. */
	private String name;

	/**
	 * Instantiates a new device model.
	 *
	 * @param name the name
	 */
	public DeviceModel(String name) {
		super();
		this.id = UUID.randomUUID().toString();
		this.name = name;
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
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DeviceModel [id=" + id + ", name=" + name + "]";
	}

}
