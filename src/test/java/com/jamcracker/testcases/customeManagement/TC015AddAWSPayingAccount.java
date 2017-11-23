package com.jamcracker.testcases.customeManagement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.AddCloudCredentials;
import com.jamcracker.commonFunctions.customer.CustomerLogout;
import com.jamcracker.commonFunctions.customer.EnterpriseAdminLogin;
import com.jamcracker.commonFunctions.marketplace.MarketplaceLogin;
import com.jamcracker.utilities.TestBase;

public class TC015AddAWSPayingAccount extends TestBase{
	
	@DataProvider(name = "AWSPaying")
	public String[][] getAwsPaying() {
		return getData("CloudCredentials.xls", "AWSPaying");
	}	
	
	@BeforeMethod
	@Parameters({"browser","payAccUrl"})
	public void setUp(String browser, String url) {
		init(browser,url);
	}
	
	@Test(dataProvider = "AWSPaying")
	public void testAddAwsPayingCredentials(String loginEmail, String loginPassword, String cloudProvider, String accountID, String userName, String password, String secretKey, String accessKey, String bucketName, String usageFileName, String urlType) throws Exception {
		AddCloudCredentials addCloud = new AddCloudCredentials();
		switch (urlType) {
		case "Marketplace":
			MarketplaceLogin mlogin = new MarketplaceLogin();
			mlogin.login(loginEmail, loginPassword);
			addCloud.addAWSPayingCredentials(cloudProvider, accountID, userName, password, secretKey, accessKey, bucketName, usageFileName, urlType);
			break;

		case "Store":
			EnterpriseAdminLogin entLogin = new EnterpriseAdminLogin();
			entLogin.enterpriseAdminLogin(loginEmail, loginPassword);
			addCloud.addAWSPayingCredentials(cloudProvider, accountID, userName, password, secretKey, accessKey, bucketName, usageFileName, urlType);
			CustomerLogout.logOut();
			break;
		}
	}
		
	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}

}