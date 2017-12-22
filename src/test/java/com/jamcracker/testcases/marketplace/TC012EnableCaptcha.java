package com.jamcracker.testcases.marketplace;

import java.util.ArrayList;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.pivotpath.DisableCaptcha;
import com.jamcracker.commonFunctions.pivotpath.EnableCaptcha;
import com.jamcracker.commonFunctions.pivotpath.LoginToPivotpath;
import com.jamcracker.commonFunctions.pivotpath.LogoutPivotPath;
import com.jamcracker.utilities.ExcelcolumnReader;
import com.jamcracker.utilities.TestBase;

public class TC012EnableCaptcha extends TestBase {
	
	@BeforeMethod
	@Parameters({"browser","superAdminPivotPathUrl"})
	public void setUp(String browser,String url)
	{
		init(browser,url);
	}
	
	@Test
	public void disableCaptcha()
	{
		String organization =  getData("TestData.xls", "CredentialsSheet", "Pivot Path Login", 2);
		String userName =  getData("TestData.xls", "CredentialsSheet", "Pivot Path Login", 3);
		String password =  getData("TestData.xls", "CredentialsSheet", "Pivot Path Login", 4);
		ArrayList<String> acronym = ExcelcolumnReader.extractExcelContentByColumnIndex("TestData.xls", "CredentialsSheet", 5);
		LoginToPivotpath.login(organization, userName, password);
		for(String str:acronym){
		EnableCaptcha.captchaEnable(str);}
	
		
		
	}
	
  @AfterMethod
  public void logout(ITestResult result)
  {	//The method will receive ITestResult runtime object for the test that has just finished. This code is added to print Reporter.log in after method also
	  Reporter.setCurrentTestResult(result);
		 LogoutPivotPath.logout();
		 driver.quit();
  }
}
