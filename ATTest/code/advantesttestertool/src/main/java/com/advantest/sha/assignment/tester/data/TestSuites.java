package com.advantest.sha.assignment.tester.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import com.advantest.sha.assignment.tester.dbmodel.TestSuiteModel;
import com.advantest.sha.assignment.tester.utils.TesterUtil;

public class TestSuites {
	private static Logger LOG = LoggerFactory.getLogger(TestSuiteModel.class);
	private Map<String, TestSuiteModel> avaiableTestSuites;
	private static TestSuites INSTANCE;

	private TestSuites() {
		File folderRes;
		try {
			this.avaiableTestSuites = new HashMap<>();
			folderRes = new ClassPathResource("testsuites").getFile();
			if (folderRes.isDirectory()) {
				initTestSuite(folderRes.list());
			}
			INSTANCE = this;
		} catch (IOException e) {
			LOG.debug("Error: {}", e);
		}
	}

	public static TestSuites getInstance() {
		if (INSTANCE == null) {
			new TestSuites();
		}
		return INSTANCE;
	}

	private void initTestSuite(String[] fileNames) {
		for (String fileName : fileNames) {
			TestSuiteModel testSuiteModel = TesterUtil.getTestSuiteModel(fileName);
			this.avaiableTestSuites.put(testSuiteModel.getName(), testSuiteModel);
		}
	}
}
