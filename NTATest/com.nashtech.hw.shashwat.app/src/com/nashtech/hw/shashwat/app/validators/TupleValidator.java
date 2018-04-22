package com.nashtech.hw.shashwat.app.validators;

import com.nashtech.hw.shashwat.app.util.Util;

/**
 * The Class TupleValidator.
 * 
 * @author shashwat.anand
 */
public class TupleValidator {
	
	/**
	 * Validate tuple str.
	 *
	 * @param tupleLine the tuple line
	 * @return true, if successful
	 */
	public boolean validateTupleStr(final String tupleLine) {
		return isTupleHaving4Inputs(tupleLine) && isTupleFirstPartIsInteger(tupleLine)
				&& isTupleLastPartIsBoolean(tupleLine);
	}
	
	/**
	 * Checks if is tuple having 4 inputs.
	 *
	 * @param tupleLine the tuple line
	 * @return true, if is tuple having 4 inputs
	 */
	private boolean isTupleHaving4Inputs(final String tupleLine) {
		return tupleLine.split(",").length == 4;
	}
	
	/**
	 * Checks if is tuple first part is integer.
	 *
	 * @param tupleLine the tuple line
	 * @return true, if is tuple first part is integer
	 */
	private boolean isTupleFirstPartIsInteger(final String tupleLine) {
		final String firstPart = tupleLine.split(",")[0].trim();
		return Util.isInteger(firstPart);
	}
	
	/**
	 * Checks if is tuple last part is boolean.
	 *
	 * @param tupleLine the tuple line
	 * @return true, if is tuple last part is boolean
	 */
	private boolean isTupleLastPartIsBoolean(final String tupleLine) {
		final String lastPart = tupleLine.split(",")[3].trim();
		return Util.isBoolean(lastPart);
	}
}
