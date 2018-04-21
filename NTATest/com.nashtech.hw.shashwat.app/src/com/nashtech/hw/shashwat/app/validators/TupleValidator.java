package com.nashtech.hw.shashwat.app.validators;

import com.nashtech.hw.shashwat.app.util.Util;

public class TupleValidator {
	public boolean validateTupleStr(final String tupleLine) {
		return isTupleHaving4Inputs(tupleLine) && isTupleFirstPartIsInteger(tupleLine)
				&& isTupleLastPartIsBoolean(tupleLine);
	}
	
	private boolean isTupleHaving4Inputs(final String tupleLine) {
		return tupleLine.split(",").length == 4;
	}
	
	private boolean isTupleFirstPartIsInteger(final String tupleLine) {
		final String firstPart = tupleLine.split(",")[0].trim();
		return Util.isInteger(firstPart);
	}
	
	private boolean isTupleLastPartIsBoolean(final String tupleLine) {
		final String lastPart = tupleLine.split(",")[3].trim();
		return Util.isInteger(lastPart);
	}
}
