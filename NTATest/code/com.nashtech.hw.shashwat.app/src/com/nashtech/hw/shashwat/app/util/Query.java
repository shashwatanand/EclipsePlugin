package com.nashtech.hw.shashwat.app.util;


/**
 * The Enum Query.
 * 
 * @author shashwat.anand
 */
public enum Query {
	
	/** The search by id. */
	SEARCH_BY_ID("Search by id"),
	
	/** The search by name. */
	SEARCH_BY_NAME("Search by name"),
	
	/** The search by pattern. */
	SEARCH_BY_PATTERN("Search by pattern"),
	
	/** The search by flag. */
	SEARCH_BY_FLAG("Search by flag");
	
	/** The value. */
	private String value;

	/**
	 * Instantiates a new query.
	 *
	 * @param value the value
	 */
	private Query(String value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	public String toString() {
		return this.value;
	}
	
	/**
	 * Gets the query enum.
	 *
	 * @param text the text
	 * @return the query enum
	 */
	public static Query getQueryEnum(final String text) {
        for (Query value : values()) {
            if (text.equalsIgnoreCase(value.toString())) {
                return value;
            }
        }
        return null;
    }
}
