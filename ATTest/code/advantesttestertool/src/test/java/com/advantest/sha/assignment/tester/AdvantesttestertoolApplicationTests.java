package com.advantest.sha.assignment.tester;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import com.advantest.sha.assignment.tester.data.TestSuites;
import com.advantest.sha.assignment.tester.data.TestSystems;
import com.advantest.sha.assignment.tester.dbmodel.TestSuiteModel;
import com.advantest.sha.assignment.tester.dbmodel.TestSystemModel;
import com.advantest.sha.assignment.tester.utils.TesterUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdvantesttestertoolApplicationTests {
	
	private static Map<String, TestSystemModel> avaibleTestSystems;

	/**
	 * Setup.
	 * @throws IOException 
	 */
	@BeforeClass
	public static void setup() throws IOException {
		TestSystems.getInstance().createTextSystems();
		avaibleTestSystems = TestSystems.getInstance().getInMemTestSystem();
		
		/*
		 * File folderRes = new ClassPathResource("testsuites").getFile(); if
		 * (folderRes.isDirectory()) { String[] fileNames = folderRes.list(); for
		 * (String fileName : fileNames) { TestSuiteModel testSuiteModel =
		 * TesterUtil.getTestSuiteModel(fileName);
		 * avaiableTestSuites.put(testSuiteModel.getName(), testSuiteModel); } }
		 */
	}

	@Test
	public void isTestSystemExistsForTestSuite() throws IOException {
		File folderRes = new ClassPathResource("testsuites").getFile();
		if (folderRes.isDirectory()) {
			String[] fileNames = folderRes.list();
			for (String fileName : fileNames) {
				TestSuiteModel testSuite = TesterUtil.getTestSuiteModel(fileName);
				List<TestSystemModel> foundTestSystem = TestSystems.getInstance().findAvailableTestSystem(testSuite);
				System.out.println(foundTestSystem.size() + " test system found for " + fileName);
			    //assertTrue(foundTestSystem.isEmpty());
			}
		}
	}

}
