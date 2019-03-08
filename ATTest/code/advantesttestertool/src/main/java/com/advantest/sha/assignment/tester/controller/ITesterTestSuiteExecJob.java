package com.advantest.sha.assignment.tester.controller;

import com.advantest.sha.assignment.tester.dbmodel.TestSuiteModel;
import com.advantest.sha.assignment.tester.dbmodel.TestSystemModel;

public interface ITesterTestSuiteExecJob extends Runnable {
	boolean isRunning();
	void sendReport(TestSuiteModel testSuite, boolean successFlag);
	void startExecution(TestSystemModel system, TestSuiteModel testSuite);
}
