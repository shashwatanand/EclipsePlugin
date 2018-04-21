package com.nashtech.hw.shashwat.app.exceptions;

/**
 * The Class TupleNotUniqueException.
 * 
 * @author shashwat.anand
 */
public class TupleNotUniqueException extends RuntimeException {
	
	/** adding serial version id. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new tuple not unique exception.
	 *
	 * @param message the message
	 */
	public TupleNotUniqueException(final String message) {
		super(message);
	}
}
