package com.jamcracker.testcases.marketplace;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.marketplace.AppStackCreation;
import com.jamcracker.utilities.TestBase;
@Listeners(com.jamcracker.listeners.TestListener.class)

public class TC008AppStackCreation extends TestBase {
	
	@DataProvider(name="mpURL")
	public String getURL() {
		return getData("TestData.xls", "URLSheet", "URL", 3);
	}
	
	@DataProvider(name="browserName")
	public String getBrowser() {
		return getData("TestData.xls", "BrowserSheet", "Browser", 3);
	}
	
	@DataProvider(name="stackCreationData")
	public String[][] getStackCreationData() {
		return getData("TestData.xls", "StackTemplateSheet");
	}
	
	@DataProvider(name="mpAdminEmail")
	public String getMpEmail() {
		return getData("TestData.xls", "CredentialsSheet", "Email Address", 3);
	}
	
	@DataProvider(name="mpAdminPassword")
	public String getMpPassword() {
		return getData("TestData.xls", "CredentialsSheet", "Password", 3);
	}
	
	@BeforeMethod
	@Parameters({"browser","targetMpUrl"})
	public void setUp(String browser,String url)
	{
		init(browser, url);
	}
	
	@Test(dataProvider="stackCreationData")
	public void testAppStackCreation(String runMode, String sName, String sDescription, String iName, String sgName, String sType, String chefType) throws Exception {
		
		String[][] tagsData = getData("TestData.xls", "TagsSheet");
		String[][] vendors = getData("TestData.xls", "StackSupportVendorsSheet");
		AppStackCreation appStack = new AppStackCreation();
		appStack.appStackCreation(getMpEmail(),getMpPassword(),runMode, sName, sDescription, iName, sgName, sType, chefType, tagsData, vendors);
				
	}
	
	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}

}
