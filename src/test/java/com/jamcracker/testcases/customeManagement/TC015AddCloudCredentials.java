package com.jamcracker.testcases.customeManagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.AddCloudCredentials;
import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.utilities.TestBase;

public class TC015AddCloudCredentials extends TestBase{
	
	@DataProvider(name = "AWS Cloud Credentials")
	public String[][] getAwsCloudCredentials() {
		return getData("CloudCredentials.xls", "AWSCloudCredentials");
	}
	
	@DataProvider(name = "Openstack Cloud Credentials")
	public String[][] getOpenstackCloudCredentials() {
		return getData("CloudCredentials.xls", "OpenstackCloudCredentials");
	}
	
	@BeforeMethod
	@Parameters({"browser","storeUrl"})
	public void setUp(String browser, String url) {
		init(browser, url);
	}
	
	@Test(dataProvider = "AWS Cloud Credentials", enabled = false)
	public void testAddAwsCloudCredentials(String custEmail, String custPassword, String cloudProvider, String accountID, String userName, String password, String secretKey, String accessKey) throws Exception {
		CustomerAdminLogin clogin = new CustomerAdminLogin();
		clogin.customerAdminLogin(custEmail, custPassword);
		AddCloudCredentials addCloud = new AddCloudCredentials();
		addCloud.addAWSCloudCredentails(cloudProvider, accountID, userName, password, secretKey, accessKey);
	}
	
	@Test(dataProvider = "Openstack Cloud Credentials")
	public void testAddOpenstackCloudCredentials(String custEmail, String custPassword, String cloudProvider, String projectName, String userName, String password) throws Exception {
		CustomerAdminLogin clogin = new CustomerAdminLogin();
		clogin.customerAdminLogin(custEmail, custPassword);
		AddCloudCredentials addCloud = new AddCloudCredentials();
		addCloud.addOpenStackCloudCredentials(cloudProvider, projectName, userName, password);
	}

}