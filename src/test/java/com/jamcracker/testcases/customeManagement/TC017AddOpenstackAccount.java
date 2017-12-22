package com.jamcracker.testcases.customeManagement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.AddCloudCredentials;
import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.commonFunctions.customer.CustomerLogout;
import com.jamcracker.utilities.TestBase;
@Listeners(com.jamcracker.listeners.TestListener.class)

public class TC017AddOpenstackAccount extends TestBase {
	
	@DataProvider(name = "Openstack")
	public String[][] getOpenstackCredentials() {
		return getData("CustomerData.xls", "Openstack");
	}
	
	@BeforeMethod
	@Parameters({"browser","storeUrl"})
	public void setUp(String browser, String url) {
		init(browser, url);
	}
	
	@Test(dataProvider = "Openstack")
	public void testAddOpenstackCloudCredentials(String loginEmail, String loginPassword, String cloudProvider, String projectName, String userName, String password) throws Exception {
		CustomerAdminLogin clogin = new CustomerAdminLogin();
		clogin.customerAdminLogin(loginEmail, loginPassword);
		AddCloudCredentials addCloud = new AddCloudCredentials();
		addCloud.addOpenStackCloudCredentials(cloudProvider, projectName, userName, password);
	}
	
	@AfterMethod
	public void tearDown() {
		CustomerLogout.logOut();
		closeBrowser();
	}

}
