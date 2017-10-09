package com.jamcracker.commonFunctions.customer;

import org.testng.Reporter;

import com.jamcracker.objectRepository.customer.CustomerMenuAndSubmenuObjects;
import com.jamcracker.utilities.TestBase;

public class CustomerLogout extends TestBase {
	
public static void logOut()
{
	try{
	CustomerMenuAndSubmenuObjects objMenuPage = new CustomerMenuAndSubmenuObjects();
	explicitWaitToClickable(objMenuPage.profileIcon);
	Thread.sleep(3000);
	objMenuPage.profileIcon.click();
	objMenuPage.signOutLink.click();
	}
	
	catch(Exception e)
	{
		Reporter.log("Issue while performing Log out. Please look in to the issue.");
		e.printStackTrace();
	}
}

}
