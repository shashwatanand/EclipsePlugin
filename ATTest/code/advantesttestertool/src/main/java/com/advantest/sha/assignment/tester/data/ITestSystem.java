package com.advantest.sha.assignment.tester.data;

import java.util.List;
import java.util.Map;

import com.advantest.sha.assignment.tester.dbmodel.TestSuiteModel;
import com.advantest.sha.assignment.tester.dbmodel.TestSystemModel;

/**
 * The Interface ITestSystem.
 */
public interface ITestSystem {
	
	/**
	 * Creates the text systems.
	 */
	void createTextSystems();

	/**
	 * Gets the in mem test system.
	 *
	 * @return the in mem test system
	 */
	Map<String, TestSystemModel> getInMemTestSystem();

	/**
	 * Find available test system.
	 *
	 * @param testSuiteModel the test suite model
	 * @return the list
	 */
	List<TestSystemModel> findAvailableTestSystem(TestSuiteModel testSuiteModel);

}
