package com.jamcracker.commonFunctions.marketplace;

import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.SetUpPage;

public class IdentityManagement
{
	
	static SetUpPage  objSetUpPage = SetUpPage.getInstance();
	public static void testIdentityManagement(String identiyManagement)
	{
		if (identiyManagement.equalsIgnoreCase("NO"))
		{
			objSetUpPage.identityMgmtNoRadioButton.click();
			Reporter.log("Store is configured as normal store.");
			
		}
			
		else
		{
			objSetUpPage.identityMgmtYesRadioButton.click();
			Reporter.log("Store is configured as Enterprise store.");
			
		}
		
		objSetUpPage.saveAndFinishButton.click();

	}

}
