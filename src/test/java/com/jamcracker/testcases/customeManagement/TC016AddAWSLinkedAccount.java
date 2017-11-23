package com.jamcracker.testcases.customeManagement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.AddCloudCredentials;
import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.commonFunctions.customer.CustomerLogout;
import com.jamcracker.utilities.TestBase;

public class TC016AddAWSLinkedAccount extends TestBase {
	
	@DataProvider(name = "AWSLinked")
	public String[][] getAwsLinked() {
		return getData("CloudCredentials.xls", "AWSLinked");
	}
	
	@BeforeMethod
	@Parameters({"browser","storeUrl"})
	public void setUp(String browser, String url) {
		init(browser, url);
	}
	
	@Test(dataProvider = "AWSLinked", enabled = false)
	public void testAddAwsLinkedCredentials(String loginEmail, String loginPassword, String cloudProvider, String accountID, String userName, String password, String secretKey, String accessKey) throws Exception {
		CustomerAdminLogin clogin = new CustomerAdminLogin();
		clogin.customerAdminLogin(loginEmail, loginPassword);
		AddCloudCredentials addCloud = new AddCloudCredentials();
		addCloud.addAWSLinkedCredentails(cloudProvider, accountID, userName, password, secretKey, accessKey);
	}
	
	@AfterMethod
	public void tearDown() {
		CustomerLogout.logOut();
		closeBrowser();
	}

}
