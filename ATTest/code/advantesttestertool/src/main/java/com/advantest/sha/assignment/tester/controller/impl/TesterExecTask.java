package com.advantest.sha.assignment.tester.controller.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.advantest.sha.assignment.tester.data.TestSuites;
import com.advantest.sha.assignment.tester.data.TestSystems;
import com.advantest.sha.assignment.tester.dbmodel.TestSuiteModel;
import com.advantest.sha.assignment.tester.dbmodel.TestSystemModel;

public class TesterExecTask implements Runnable {
	private static Logger LOG = LoggerFactory.getLogger(TesterExecTask.class);
	private String testSuiteName;
	private Map<String, TestSuiteModel> avaibleTestSuites;
	private boolean isRunning;

	public TesterExecTask(String testSuiteName) {
		this.isRunning = false;
		this.testSuiteName = testSuiteName;
		this.avaibleTestSuites = TestSuites.getInstance().getAvaiableTestSuites();
	}

	public boolean isRunning() {
		return this.isRunning;
	}

	private boolean isEnteredTestSuiteNameIsValid(String testSuiteName) {
		return this.avaibleTestSuites.containsKey(testSuiteName);
	}

	@Override
	public void run() {
		this.isRunning = true;
		LOG.info("Starting processing testsuite name : " + this.testSuiteName);
		if (!isEnteredTestSuiteNameIsValid(this.testSuiteName)) {
			String msg = "Entered testsuite name is invalid";
			LOG.error(msg);
		}
		TestSuiteModel testSuite = this.avaibleTestSuites.get(this.testSuiteName);
		
		List<TestSystemModel> foundTestSystem = TestSystems.getInstance().findAvailableTestSystem(testSuite);
		if (foundTestSystem.isEmpty()) {
			String msg = "Unable to find test system with required OS and devices";
			LOG.error(msg);
		}

		while (!testSuite.isExceuted()) {
			List<TestSystemModel> freeTestSystem = foundTestSystem.stream().filter(t -> !t.isBusy())
					.collect(Collectors.toList());
			if (freeTestSystem.isEmpty()) {
				sleep(1, TimeUnit.SECONDS);
			}
			TestSystemModel system = freeTestSystem.get(0);
			startExecution(system, testSuite);
		}
		sendReport();

		this.isRunning = false;
	}
	
	private void sendReport() {
		// TODO Auto-generated method stub
	}

	private void startExecution(TestSystemModel system, TestSuiteModel testSuite) {
		system.setBusy(true);
		long executionTime = testSuite.getExceutionTime();
		LOG.info("Executing " + testSuite.getName() + " on " + system.getName() + " it will take " + executionTime + "minutes to complete");
		sleep(executionTime, TimeUnit.MINUTES);
		system.setBusy(false);
	}

	private void sleep(final long sleepValue, final TimeUnit unit) {
		try {
			unit.sleep(sleepValue);
		} catch (InterruptedException e) {
			LOG.debug("InterruptedException {} " + e);
		}
	}

}
