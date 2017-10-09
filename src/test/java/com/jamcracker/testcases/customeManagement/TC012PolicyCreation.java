package com.jamcracker.testcases.customeManagement;

import java.io.File;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.commonFunctions.customer.PolicyCreation;
import com.jamcracker.entity.service.PolicyCreationData;
import com.jamcracker.excel.reader.PolicyCreationReader;
import com.jamcracker.utilities.TestBase;

public class TC012PolicyCreation extends TestBase {
	
	@DataProvider(name="restrictPolicyCreationData")
	public PolicyCreationData[] getRestrictPolicyData() {
		PolicyCreationReader reader = new PolicyCreationReader(System.getProperty("user.dir") + File.separator + "Data" + File.separator + "PolicyCreationData.xls");
		return reader.getRestrictPolicyCreationData("RestrictPolicySheet");
	}
	
	@DataProvider(name="instancePolicyCreationData")
	public PolicyCreationData[] getInstancePolicyData() {
		PolicyCreationReader reader = new PolicyCreationReader(System.getProperty("user.dir") + File.separator + "Data" + File.separator + "PolicyCreationData.xls");
		return reader.getInstancePolicyCreationData("InstancePolicySheet");
	}
	
	@BeforeMethod
	@Parameters({"browser","storeUrl"})
	public void setUp(String browser, String url) {
		init("chrome", "https://clrstore.jamcracker.com");
	}
	
	@Test(dataProvider="restrictPolicyCreationData")
	public void testRestrictPolicyCreation(PolicyCreationData pcData) {
		
		CustomerAdminLogin custAdmin = new CustomerAdminLogin();
		custAdmin.customerAdminLogin("storeuser111@gmail.com", "Root123#");
		PolicyCreation policy = new PolicyCreation();
		policy.policyCreation(pcData);
		
	}
	
	@Test(dataProvider="instancePolicyCreationData", enabled=false)
	public void testInstancePolicyCreation(PolicyCreationData pcData) {
		
		CustomerAdminLogin custAdmin = new CustomerAdminLogin();
		custAdmin.customerAdminLogin(pcData.getEmail(), pcData.getPassword());
		PolicyCreation policy = new PolicyCreation();
		policy.policyCreation(pcData);
		
	}
	
	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}

}
