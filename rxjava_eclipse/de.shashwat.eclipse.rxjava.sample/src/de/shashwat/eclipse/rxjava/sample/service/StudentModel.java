package de.shashwat.eclipse.rxjava.sample.service;

/**
 * The Class StudentModel.
 */
public class StudentModel {
	
	/** The id. */
	private String id;
	
	/** The name. */
	private String name;
	
	/** The department. */
	private String department;
	
	/** The college name. */
	private String collegeName;

	/**
	 * Instantiates a new student model.
	 *
	 * @param id the id
	 * @param name the name
	 * @param department the department
	 * @param collegeName the college name
	 */
	public StudentModel(String id, String name, String department, String collegeName) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.collegeName = collegeName;
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
	 * @param id the id to set
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
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the department.
	 *
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * Sets the department.
	 *
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * Gets the college name.
	 *
	 * @return the collegeName
	 */
	public String getCollegeName() {
		return collegeName;
	}

	/**
	 * Sets the college name.
	 *
	 * @param collegeName the collegeName to set
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
}
