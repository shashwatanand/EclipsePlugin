package com.advantest.sha.assignment.tester.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * The Class TestSuites.
 */
public class TestSuites {
	
	/** The log. */
	private static Logger LOG = LoggerFactory.getLogger(TestSuites.class);
	
	/** The instance. */
	private static TestSuites INSTANCE;
	
	/**
	 * Instantiates a new test suites.
	 */
	private TestSuites() {
		INSTANCE = this;
	}

	/**
	 * Gets the single instance of TestSuites.
	 *
	 * @return single instance of TestSuites
	 */
	public static TestSuites getInstance() {
		if (INSTANCE == null) {
			new TestSuites();
		}
		return INSTANCE;
	}

	/**
	 * Checks if is test suite valid.
	 *
	 * @param fileName the file name
	 * @return true, if is test suite valid
	 */
	public boolean isTestSuiteValid(String fileName) {
		try {
			return new ClassPathResource("testsuites/" + fileName).exists();
		} catch (Exception e) {
			LOG.debug("Unable to test suite in resource folder");
		}
		return false;
	}
}
