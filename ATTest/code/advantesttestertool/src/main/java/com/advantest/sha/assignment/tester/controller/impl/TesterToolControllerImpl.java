package com.advantest.sha.assignment.tester.controller.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.advantest.sha.assignment.tester.controller.ITesterToolController;
import com.advantest.sha.assignment.tester.data.TestSuites;
import com.advantest.sha.assignment.tester.data.TestSystems;

public class TesterToolControllerImpl implements ITesterToolController {
	private static Logger LOG = LoggerFactory.getLogger(TesterToolControllerImpl.class);
	
	public TesterToolControllerImpl() {
		TestSystems testSystemInstance = TestSystems.getInstance();
		testSystemInstance.createTextSystems();
		TestSuites.getInstance();
		LOG.debug("In memory model initialized");
	}

	@Override
	public void processArguments(String[] args) {
		LOG.info("Inside processArguments");
		ExecutorService executorService = Executors.newFixedThreadPool(TestSystems.getInstance().getInMemTestSystem().size());
		for (String arg : args) {
			executorService.submit(new TesterExecTask(arg));
		}
	}
}
