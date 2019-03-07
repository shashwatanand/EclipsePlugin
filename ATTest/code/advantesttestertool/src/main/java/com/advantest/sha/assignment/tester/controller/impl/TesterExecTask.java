package com.advantest.sha.assignment.tester.controller.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.advantest.sha.assignment.tester.data.TestSuites;
import com.advantest.sha.assignment.tester.data.TestSystems;
import com.advantest.sha.assignment.tester.dbmodel.TestSuiteModel;
import com.advantest.sha.assignment.tester.dbmodel.TestSystemModel;

public class TesterExecTask implements Callable<String> {
	private static Logger LOG = LoggerFactory.getLogger(TesterExecTask.class);
	private String testSuiteName;
	private Map<String, TestSystemModel> inMemTestSystem;
	private Map<String, TestSuiteModel> avaibleTestSuites;
	private boolean isRunning;

	public TesterExecTask(String testSuiteName) {
		this.isRunning = false;
		this.testSuiteName = testSuiteName;
		this.inMemTestSystem = TestSystems.getInstance().getInMemTestSystem();
		this.avaibleTestSuites = TestSuites.getInstance().getAvaiableTestSuites();
	}

	@Override
	public String call() throws Exception {
		this.isRunning = true;
		LOG.info("Starting processing testsuite name : " + this.testSuiteName);
		if (!isEnteredTestSuiteNameIsValid(this.testSuiteName)) {
			String msg = "Entered testsuite name is invalid";
			LOG.error(msg);
			return msg;
		}
		TestSuiteModel testSuite = this.avaibleTestSuites.get(this.testSuiteName);
		
		List<TestSystemModel> foundTestSystem = TestSystems.getInstance().findAvailableTestSystem(testSuite);
		if (foundTestSystem.isEmpty()) {
			String msg = "Unable to find test system with required OS and devices";
			LOG.error(msg);
			return msg;
		}
		
		List<TestSystemModel> freeTestSystem = foundTestSystem.stream().filter(t -> !t.isBusy()).collect(Collectors.toList());
		
		this.isRunning = false;
		return null;
	}
	
	public boolean isRunning() {
		return this.isRunning;
	}

	private boolean isTestSystemExistForTestSuite(TestSuiteModel testSuite) {
		return !TestSystems.getInstance().findAvailableTestSystem(testSuite).isEmpty();
	}

	private boolean isEnteredTestSuiteNameIsValid(String testSuiteName) {
		return this.avaibleTestSuites.containsKey(testSuiteName);
	}

}
