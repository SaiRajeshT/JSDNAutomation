package com.jamcracker.commonFunctions.marketplace;

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
		SuperAdminMarktplacesPage superobjects = new SuperAdminMarktplacesPage();
		superobjects.getMarketplaceActivate(companyAcronym).click();
		driver.switchTo().alert().accept();
	}

}
