package com.nashtech.hw.shashwat.app.model;

/**
 * The Class Tuple.
 * 
 * @author shashwat.anand
 */
public class Tuple {
	
	/** The id. */
	private Integer id;
	
	/** The name. */
	private String name;
	
	/** The pattern. */
	private String pattern;
	
	/** The flag. */
	private boolean flag;
	
	/**
	 * Instantiates a new tuple.
	 *
	 * @param id the id
	 * @param name the name
	 * @param pattern the pattern
	 * @param flag the flag
	 */
	public Tuple(Integer id, String name, String pattern, boolean flag) {
		this.id = id;
		this.name = name;
		this.pattern = pattern;
		this.flag = flag;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(int id) {
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
	 * Gets the pattern.
	 *
	 * @return the pattern
	 */
	public String getPattern() {
		return pattern;
	}
	
	/**
	 * Sets the pattern.
	 *
	 * @param pattern the pattern to set
	 */
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	/**
	 * Checks if is flag.
	 *
	 * @return the flag
	 */
	public boolean isFlag() {
		return flag;
	}
	
	/**
	 * Sets the flag.
	 *
	 * @param flag the flag to set
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return id + ", " + name + ", " + pattern + ", " + flag;
	}
	
}
