package com.advantest.sha.assignment.tester.data;

import java.util.List;
import java.util.Map;

import com.advantest.sha.assignment.tester.dbmodel.TestSuiteModel;
import com.advantest.sha.assignment.tester.dbmodel.TestSystemModel;

public interface ITestSystem {
	void createTextSystems();

	Map<String, TestSystemModel> getInMemTestSystem();

	List<TestSystemModel> findAvailableTestSystem(TestSuiteModel testSuiteModel);

}
