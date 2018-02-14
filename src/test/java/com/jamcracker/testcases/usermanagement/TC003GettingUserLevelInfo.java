package com.jamcracker.testcases.usermanagement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.GettingUserLevelInfo;
import com.jamcracker.commonFunctions.pivotpath.LoginToPivotpath;
import com.jamcracker.utilities.TestBase;

public class TC003GettingUserLevelInfo extends TestBase {

	//private String getURL() {
	//	return getData("CustomerData.xls", "CredentialsSheet", "URL", 4);
	//}
	

	@BeforeClass
	@Parameters({ "browser","mpPivothPathUrl" })
	public void setUp(String browser, String url) {
		init(browser, url);
	}
	
	@DataProvider(name="GettingData")
	public String[][] getUserData(){
		return getData("CustomerData.xls", "GettingUserLevelInfoSheet");
	}

	@Test(dataProvider = "GettingData")
	public void testGettingInfo(String executable, String acronym, String userName, 
			String password, String organizationName, String offerName) throws Exception 
	{
		
	
	if(executable.equalsIgnoreCase("y"))
	{  
		LoginToPivotpath objloginPivotpath = new LoginToPivotpath();
		objloginPivotpath.login(acronym, userName, password);
		GettingUserLevelInfo objConsent = new GettingUserLevelInfo();
	    objConsent.gettingInfo(acronym, userName, password, organizationName, offerName);
		
		
	}
	
	}
	
	@AfterMethod
	public void teardown(){
		closeBrowser();
	}
}

