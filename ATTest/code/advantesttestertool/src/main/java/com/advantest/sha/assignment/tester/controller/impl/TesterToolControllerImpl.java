package com.advantest.sha.assignment.tester.controller.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.advantest.sha.assignment.tester.controller.ITesterToolController;
import com.advantest.sha.assignment.tester.data.TestSuites;
import com.advantest.sha.assignment.tester.data.TestSystems;
import com.advantest.sha.assignment.tester.utils.TesterUtil;

/**
 * The Class TesterToolControllerImpl.
 */
public class TesterToolControllerImpl implements ITesterToolController {
	
	/** The log. */
	private static Logger LOG = LoggerFactory.getLogger(TesterToolControllerImpl.class);
	
	/**
	 * Instantiates a new tester tool controller impl.
	 */
	public TesterToolControllerImpl() {
		TestSystems testSystemInstance = TestSystems.getInstance();
		testSystemInstance.createTextSystems();
		TestSuites.getInstance();
		LOG.debug("In memory model initialized");
	}

	/* (non-Javadoc)
	 * @see com.advantest.sha.assignment.tester.controller.ITesterToolController#processArguments(java.lang.String[])
	 */
	@Override
	public void processArguments(String[] args) {
		LOG.info("Inside processArguments");
		long timeout = 0;
		for (String arg : args) {
			long exceTime = TesterUtil.findExecutionTime(arg);
			if (exceTime >= timeout) {
				timeout = exceTime;
			}
		}
		ExecutorService executorService = Executors.newFixedThreadPool(TestSystems.getInstance().getInMemTestSystem().size());
		for (String arg : args) {
			executorService.submit(new TesterExecTask(arg));
		}
		try {
			executorService.awaitTermination(timeout, TimeUnit.MINUTES);
			executorService.shutdown();
		} catch (InterruptedException e) {
			LOG.debug("InterruptedException {} ", e);
		}
	}
}
