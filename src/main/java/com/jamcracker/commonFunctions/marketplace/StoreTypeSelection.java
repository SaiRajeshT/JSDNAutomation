package com.jamcracker.commonFunctions.marketplace;

import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.SetUpPage;

public class StoreTypeSelection 
{
	//static SetUpPage  objSetUpPage = SetUpPage.getInstance(); 
	//org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?

	
	public static void testStoreSelect(String storeType,String budget)
	{
		SetUpPage  objSetUpPage = SetUpPage.getInstance();
		if(storeType.equalsIgnoreCase("E"))
		{
			objSetUpPage.enterpriseRadioButton.click();
			Reporter.log("Store Type selected as Enterprise");
			
			try{
				objSetUpPage.enableBudgetCheckbox.click();
				Reporter.log("Enabled Budget selection Enterprise");
			}
			catch (Exception e)
			{
				Reporter.log("<p style='color:Red'>Budget checkbox not selected Please check the issue </p>");
			}

		}
		
		else
		{
			objSetUpPage.resellerRadioButton.click();
			Reporter.log("Store Type selected as Reseller store");
		}
		
		objSetUpPage.saveAndNextButton.click();
	}

}
