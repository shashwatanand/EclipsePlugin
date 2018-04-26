package com.nashtech.hw.shashwat.app.exceptions;

/**
 * The Class TupleNotInFormatException.
 * 
 * @author shashwat.anand
 */
public class TupleNotInFormatException extends RuntimeException {
	
	/** adding serial version id. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new tuple not in format exception.
	 *
	 * @param message the message
	 */
	public TupleNotInFormatException(final String message) {
		super(message);
	}
}
