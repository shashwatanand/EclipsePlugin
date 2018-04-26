package com.nashtech.hw.shashwat.app.provider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IProgressMonitor;

import com.nashtech.hw.shashwat.app.exceptions.TupleNotInFormatException;
import com.nashtech.hw.shashwat.app.exceptions.TupleNotUniqueException;
import com.nashtech.hw.shashwat.app.model.Tuple;
import com.nashtech.hw.shashwat.app.util.Util;
import com.nashtech.hw.shashwat.app.validators.TupleValidator;

/**
 * The Class TupleProvider.
 * 
 * @author shashwat.anand
 */
public class TupleProvider {
	/** The logger. */
	private final Logger logger = Logger.getLogger(TupleProvider.class.getSimpleName());

	/**
	 * Load tuples for file.
	 *
	 * @param fileStr the file str
	 * @param monitor the monitor
	 * @throws TupleNotInFormatException the tuple not in format exception
	 * @throws TupleNotUniqueException the tuple not unique exception
	 */
	public void loadTuplesForFile(final String fileStr, final IProgressMonitor monitor) throws TupleNotInFormatException, TupleNotUniqueException {
		try {
			final File tupleFile = new File(fileStr);
			if (tupleFile.exists()) {
				final TupleValidator validator = new TupleValidator();
				Map<Integer, Tuple> tuplesMap = Util.getInstance().getInMemTuples();
				long startLoadFile = System.currentTimeMillis();
				final Stream<String> lines = Files.lines(Paths.get(fileStr), StandardCharsets.UTF_8);
				List<String> tupleList = lines.collect(Collectors.toList());
				lines.close();
				final long count = tupleList.size();
				long endLoadFile = System.currentTimeMillis();
				logger.log(Level.INFO, "Time take to load file : " + (endLoadFile - startLoadFile));
				monitor.beginTask("Processing tuple", (int) count);
				tupleList.forEach(tupleLine -> {
					monitor.worked(1);
					if (validator.validateTupleStr(tupleLine)) {
						String[] split = tupleLine.split(",");
						final Integer id = Integer.parseInt(split[0].trim());
						final String name =  split[1].trim();
						final String pattern =  split[2].trim();
						final boolean flag = Boolean.parseBoolean(split[3].trim());
						if (tuplesMap.containsKey(id)) {
							throw new TupleNotUniqueException("Please check file tuples are not unique");
						}
						tuplesMap.put(id, new Tuple(id, name, pattern, flag));
					} else {
						throw new TupleNotInFormatException("Please check file tuples are not in proper format");
					}
				});
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, "IO Exception happned while reading the tuple file! " + e);
		}
	}

}
