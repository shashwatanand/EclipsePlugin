package de.shashwat.eg.xviewer.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class XViewerLogger {
	public static Logger logger = Logger.getLogger("XViewer Log");

	public static void logAndPopup(Class<?> activatorClass, Level level, String message) {
		log(activatorClass, level, message);
		UIUtil.popup("ERROR", message);
	}

	public static void log(Class<?> activatorClass, Level level, String message) {
		if (level.intValue() >= Level.SEVERE.intValue()) {
			logger.log(level, message, new Exception("used to get a stack trace"));
		} else {
			logger.log(level, message);
		}
	}

	public static void logAndPopup(Class<?> activatorClass, Level level, Throwable th) {
		log(activatorClass, level, th.getLocalizedMessage(), th);
		UIUtil.popup("ERROR", th.getLocalizedMessage());
	}

	public static void log(Class<?> activatorClass, Level level, Throwable th) {
		logger.log(level, th.getLocalizedMessage(), th);
	}

	public static void log(Class<?> activatorClass, Level level, String message, Throwable th) {
		logger.log(level, message, th);
	}
}
