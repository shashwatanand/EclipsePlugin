package com.advantest.sha.assignment.tester.controller;

import com.advantest.sha.assignment.tester.dbmodel.TestSuiteModel;
import com.advantest.sha.assignment.tester.dbmodel.TestSystemModel;

/**
 * The Interface ITesterTestSuiteExecJob.
 */
public interface ITesterTestSuiteExecJob extends Runnable {
	
	/**
	 * Checks if is running.
	 *
	 * @return true, if is running
	 */
	boolean isRunning();
	
	/**
	 * Send report.
	 *
	 * @param testSuite the test suite
	 * @param successFlag the success flag
	 */
	void sendReport(TestSuiteModel testSuite, boolean successFlag);
	
	/**
	 * Start execution.
	 *
	 * @param system the system
	 * @param testSuite the test suite
	 */
	void startExecution(TestSystemModel system, TestSuiteModel testSuite);
}
