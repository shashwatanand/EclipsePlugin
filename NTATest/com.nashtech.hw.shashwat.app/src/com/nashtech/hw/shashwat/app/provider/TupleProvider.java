package com.nashtech.hw.shashwat.app.provider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import com.nashtech.hw.shashwat.app.exceptions.TupleNotInFormatException;
import com.nashtech.hw.shashwat.app.exceptions.TupleNotUniqueException;
import com.nashtech.hw.shashwat.app.validators.TupleValidator;

public class TupleProvider {
	/** The logger. */
	private final Logger logger = Logger.getLogger(TupleProvider.class.getSimpleName());

	public void getTuples(final String fileStr) throws TupleNotInFormatException, TupleNotUniqueException {
		try {
			final File tupleFile = new File(fileStr);
			if (tupleFile.exists()) {
				final TupleValidator validator = new TupleValidator();
				Stream<String> lines = Files.lines(Paths.get(fileStr), StandardCharsets.UTF_8);
				lines.forEach(tupleLine -> {
					if (validator.validateTupleStr(tupleLine)) {
						
					}
				});
				lines.close();
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, "IO Exception happned while reading the tuple file! " + e);
		}
	}

}
