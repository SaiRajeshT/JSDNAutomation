package com.jamcracker.mainTest;

import java.io.File;
import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;

public class TestMain {

	public static void main(String[] args) {
		
		TestNG testng = new TestNG();
		  List<String> suites = Lists.newArrayList();
		  suites.add(System.getProperty("user.dir")+File.separator+"testng.xml");
		  testng.setTestSuites(suites);
		  testng.run();
	}

}
