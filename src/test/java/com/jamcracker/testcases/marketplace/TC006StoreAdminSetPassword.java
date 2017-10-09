package com.jamcracker.testcases.marketplace;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.marketplace.SetPassword;
import com.jamcracker.utilities.ExcelcolumnReader;
import com.jamcracker.utilities.TestBase;
@Listeners(com.jamcracker.listeners.TestListener.class)
public class TC006StoreAdminSetPassword extends TestBase {
	
	private String getURL() 
	{
		return getData("TestData.xls", "URLSheet", "URL", 3);
	}


	
	@DataProvider(name = "setPasswordData")
	 public String[] getSetPasswordData() {
	  ArrayList<String> emailist = ExcelcolumnReader.extractExcelContentByColumnIndex("TestData.xls",
	    "Store Creation Sheet", 15);
	  String[] emailistData = emailist.toArray(new String[emailist.size()]);
	  return emailistData;
	 }
	
	
	
	@BeforeMethod
	@Parameters({"browser"})
	public void setUp(String browser)
	{
		init(browser, getURL());
	}
	
	  @Test(dataProvider="setPasswordData")
	  public void storeAdminSetPassword(String emailId)
			 // String defaultPassword,String newPassword,String secQuestion,String secAnswer
	  {
		 String  defaultPassword=  getData("TestData.xls", "SetPassword", "Default Password", 2);
		 String newPassword =  getData("TestData.xls", "SetPassword", "New password", 2);
		 String secQuestion =  getData("TestData.xls", "SetPassword", "Security Question", 2);
		 String secAnswer  =  getData("TestData.xls", "SetPassword", "Security Answer", 2);
		  SetPassword.setPassword(emailId, defaultPassword, newPassword, secQuestion, secAnswer,"storeAdminSetPassword");
	  }
  
  
 

  @AfterMethod
  public void afterMethod() {
	  //driver.quit();
  }

}
