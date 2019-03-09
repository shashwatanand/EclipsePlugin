package com.advantest.sha.assignment.tester;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
	

	/**
	 * Setup.
	 * @throws IOException 
	 */
	@BeforeClass
	public static void setup() throws IOException {
		TestSystems.getInstance().createTextSystems();
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
			}
		}
	}
	
	@Test
	public void isTestSuiteExist() {
		assertTrue(TestSuites.getInstance().isTestSuiteValid("TSuite_win7_D1_D2_D3_2"));
	}
	
	@Test
	public void isTestSuiteNotExist() {
		assertFalse(TestSuites.getInstance().isTestSuiteValid("TSuite_win10_D1_D2_D3"));
	}

}
