package com.jamcracker.commonFunctions.marketplace;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.Reporter;

import com.jamcracker.objectRepository.superAdmin.SuperAdminMarktplacesPage;
import com.jamcracker.utilities.TestBase;

public class ActivateMarketplace  extends TestBase
{
	public void activateMarketplace(String companyAcronym)
	{
		/*SuperAdminLogin superAdminLogin = new SuperAdminLogin();
		String superAdminEmail =  getData("TestData.xls", "CredentialsSheet", "Email Address", 2);
		String superAdminPassword =  getData("TestData.xls", "CredentialsSheet", "Password", 2);
		superAdminLogin.superAdminLogin(superAdminEmail, superAdminPassword);*/
		try{
		SuperAdminMarktplacesPage superobjects = new SuperAdminMarktplacesPage();
		superobjects.getMarketplaceActivate(companyAcronym).click();
		driver.switchTo().alert().accept();
		superobjects.verifyActivate(companyAcronym).isDisplayed();
		Reporter.log("Marketplace"+companyAcronym+" is activated");
		}
		catch(Exception e)
		{
			Reporter.log("<p style='colors:red'>Marketplace is not activated. </p>");
			Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e)+"</p>");
			e.printStackTrace();
		}
		
		
	}

}
