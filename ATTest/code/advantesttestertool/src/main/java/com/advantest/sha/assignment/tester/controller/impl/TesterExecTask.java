package com.advantest.sha.assignment.tester.controller.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.advantest.sha.assignment.tester.controller.ITesterTestSuiteExecJob;
import com.advantest.sha.assignment.tester.data.TestSuites;
import com.advantest.sha.assignment.tester.data.TestSystems;
import com.advantest.sha.assignment.tester.dbmodel.TestSuiteModel;
import com.advantest.sha.assignment.tester.dbmodel.TestSystemModel;
import com.advantest.sha.assignment.tester.utils.SendMail;
import com.advantest.sha.assignment.tester.utils.TesterUtil;

public class TesterExecTask implements ITesterTestSuiteExecJob {
	
	private static Logger LOG = LoggerFactory.getLogger(TesterExecTask.class);
	
	private String testSuiteName;
	private boolean isRunning;
	private String engineer;

	public TesterExecTask(String testSuiteName) {
		this.engineer = System.getProperty("user.name");
		this.isRunning = false;
		this.testSuiteName = testSuiteName;
	}

	@Override
	public boolean isRunning() {
		return this.isRunning;
	}

	private boolean isEnteredTestSuiteNameIsValid(String testSuiteName) {
		return TestSuites.getInstance().isTestSuiteValid(testSuiteName);
	}

	@Override
	public void run() {
		this.isRunning = true;
		LOG.info("Starting processing testsuite filename : " + this.testSuiteName);
		TestSuiteModel testSuite = TesterUtil.getTestSuiteModel(this.testSuiteName);
		if (!isEnteredTestSuiteNameIsValid(this.testSuiteName)) {
			String msg = "Entered testsuite name is invalid";
			LOG.error(msg);
			return;
		}
		List<TestSystemModel> foundTestSystem = TestSystems.getInstance().findAvailableTestSystem(testSuite);
		if (foundTestSystem.isEmpty()) {
			String msg = "Unable to find test system with required OS and devices";
			LOG.error(msg);
			return;
		}

		boolean successFlag = false;
		try {
			while (!testSuite.isExceuted()) {
				List<TestSystemModel> freeTestSystem = foundTestSystem.stream().filter(t -> !t.isBusy())
						.collect(Collectors.toList());
				if (freeTestSystem.isEmpty()) {
					sleep(1, TimeUnit.SECONDS);
				}
				TestSystemModel system = freeTestSystem.get(0);
				startExecution(system, testSuite);
				successFlag = true;
			}
		} catch (Exception e) {
			successFlag = false;
		}
		sendReport(testSuite, successFlag);

		this.isRunning = false;
	}
	
	@Override
	public void sendReport(TestSuiteModel testSuite, boolean successFlag) {
		try {
			SendMail mailHelper = new SendMail();
			// Here ideally we should call LDAP get find the proper email address
			String toEmailAdd = this.engineer + "@advantest.com";
			String subject = "Execution report of " + testSuite.getName();
			String message = "Test Suite " + testSuite.getName() + " executed sucessfully";
			if (!successFlag) {
				message = "Test Suite " + testSuite.getName()
						+ " executed not sucessfully. Please see logs for more information";
			}
			mailHelper.sendEmail(toEmailAdd, subject, message);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void startExecution(TestSystemModel system, TestSuiteModel testSuite) {
		system.setBusy(true);
		long executionTime = testSuite.getExceutionTime();
		LOG.info("Executing " + testSuite.getName() + " on " + system.getName() + " it will take " + executionTime + " minutes to complete");
		sleep(executionTime, TimeUnit.MINUTES);
		testSuite.setExceuted(true);
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
