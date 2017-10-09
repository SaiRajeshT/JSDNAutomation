package com.jamcracker.commonFunctions.superAdmin;

import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.objectRepository.superAdmin.SuperAdminLoginPage;
import com.jamcracker.utilities.TestBase;



public class SuperAdminLogin extends TestBase 
{
	public void superAdminLogin(String userName, String passWord)
	{
	try{
		SuperAdminLoginPage superAdminLogin = new SuperAdminLoginPage();
		superAdminLogin.superAdminEmailTextBox.sendKeys(userName);
		superAdminLogin.superAdminPasswordTextBox.sendKeys(passWord);
		superAdminLogin.superAdminLoginButton.click();
		
		if(superAdminLogin.superAdminLogOutLink.isDisplayed())
		{
			Reporter.log("Super admin Login successfull");
		}
		else
		{
			Reporter.log("<p style= 'color:red'> Super admin Login is not successfull.Please check the issue </p>");
		}
		
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
		Assert.fail();
		Reporter.log("<p style= 'color:red'> Super admin Login is not successfull.Please check the issue </p>");

		
	}
	
	}
}
