package com.advantest.sha.assignment.tester.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

public class TestSuites {
	private static Logger LOG = LoggerFactory.getLogger(TestSuites.class);
	private static TestSuites INSTANCE;
	
	private TestSuites() {
		INSTANCE = this;
	}

	public static TestSuites getInstance() {
		if (INSTANCE == null) {
			new TestSuites();
		}
		return INSTANCE;
	}

	public boolean isTestSuiteValid(String fileName) {
		try {
			new ClassPathResource("testsuites/" + fileName).getInputStream();
			LOG.info("Test suite exists");
			return true;
		} catch (Exception e) {
			LOG.debug("Unable to test suite in resource folder");
		}
		return false;
	}
}
