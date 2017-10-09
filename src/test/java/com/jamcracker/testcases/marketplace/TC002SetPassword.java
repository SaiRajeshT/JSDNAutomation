package com.jamcracker.testcases.marketplace;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.marketplace.SetPassword;
import com.jamcracker.utilities.TestBase;

@Listeners(com.jamcracker.listeners.TestListener.class)
public class TC002SetPassword extends TestBase
{
	static ITestResult  result;
	 String  testClassName;
	private String getURL() 
	{
		return getData("TestData.xls", "URLSheet", "URL", 3);
	}


	
	@BeforeMethod
	@Parameters({"browser"})
	public void setUp(String browser)
	{
		init(browser, getURL());
	}
	
	@DataProvider(name="passwordReset")
	private String[][] getResetPasswordData()
	{
		return getData("TestData.xls","SetPassword");
		
	}

  @Test(dataProvider="passwordReset")
  public void setPassword(String emailId,String defaultPassword,String newPassword,String secQuestion,String secAnswer)
  {
	  SetPassword.setPassword(emailId, defaultPassword, newPassword, secQuestion, secAnswer,"setPassword");
	 //Assert.assertEquals(true, false);
	  
	  
	  
  }
  
	@AfterMethod
	public void teardown()
	{
		//driver.quit();
	}
	

/*	@AfterMethod
	  public void teardown(ITestResult result)
	  {
		packageName=this.getClass().getPackage().getName();
		packageName=packageName.substring(packageName.lastIndexOf(".")+1,packageName.length());
		  if(ITestResult.FAILURE== result.getStatus())
		  {
			  System.out.println("Capturing screenshot");
			  CaptureScreenshot.screenshot(driver,result.getName(),packageName);
		  }
	  }*/
 

}
