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

/**
 * The Class TesterExecTask.
 */
public class TesterExecTask implements ITesterTestSuiteExecJob {
	
	/** The log. */
	private static Logger LOG = LoggerFactory.getLogger(TesterExecTask.class);
	
	/** The test suite name. */
	private String testSuiteName;
	
	/** The is running. */
	private boolean isRunning;
	
	/** The engineer. */
	private String engineer;

	/**
	 * Instantiates a new tester exec task.
	 *
	 * @param testSuiteName the test suite name
	 */
	public TesterExecTask(String testSuiteName) {
		this.engineer = System.getProperty("user.name");
		this.isRunning = false;
		this.testSuiteName = testSuiteName;
	}

	/* (non-Javadoc)
	 * @see com.advantest.sha.assignment.tester.controller.ITesterTestSuiteExecJob#isRunning()
	 */
	@Override
	public boolean isRunning() {
		return this.isRunning;
	}

	/**
	 * Checks if is entered test suite name is valid.
	 *
	 * @param testSuiteName the test suite name
	 * @return true, if is entered test suite name is valid
	 */
	private boolean isEnteredTestSuiteNameIsValid(String testSuiteName) {
		return TestSuites.getInstance().isTestSuiteValid(testSuiteName);
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
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
	
	/* (non-Javadoc)
	 * @see com.advantest.sha.assignment.tester.controller.ITesterTestSuiteExecJob#sendReport(com.advantest.sha.assignment.tester.dbmodel.TestSuiteModel, boolean)
	 */
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
						+ " executed not successfully. Please see logs for more information";
			}
			mailHelper.sendEmail(toEmailAdd, subject, message);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.advantest.sha.assignment.tester.controller.ITesterTestSuiteExecJob#startExecution(com.advantest.sha.assignment.tester.dbmodel.TestSystemModel, com.advantest.sha.assignment.tester.dbmodel.TestSuiteModel)
	 */
	@Override
	public void startExecution(TestSystemModel system, TestSuiteModel testSuite) {
		system.setBusy(true);
		long executionTime = testSuite.getExceutionTime();
		LOG.info("Executing " + testSuite.getName() + " on " + system.getName() + " it will take " + executionTime + " minutes to complete");
		sleep(executionTime, TimeUnit.MINUTES);
		testSuite.setExceuted(true);
		system.setBusy(false);
	}

	/**
	 * Sleep.
	 *
	 * @param sleepValue the sleep value
	 * @param unit the unit
	 */
	private void sleep(final long sleepValue, final TimeUnit unit) {
		try {
			unit.sleep(sleepValue);
		} catch (InterruptedException e) {
			LOG.debug("InterruptedException {} " + e);
		}
	}

}
