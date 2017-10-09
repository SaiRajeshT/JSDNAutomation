package com.jamcracker.commonFunctions.marketplace;

import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.SetUpPage;

public class StoreAvailableServiceSelection
{
	static SetUpPage  objSetUpPage = SetUpPage.getInstance();
	public static void  selectSerivces(String select)
	{
		if(select.equalsIgnoreCase("Yes"))
		{
			try{
				objSetUpPage.selectAllcheckbox.click();
				Reporter.log("All the available services are selected for store. user can resell and continue .");
				}
			catch(Exception e)
			{
				Reporter.log("<p style='color:Red'> Services are not selected. Please check the issue.</p>" );
			}
		}
		
		else
		{
			objSetUpPage.unSelectServiceCheckbox.click();
			Reporter.log("Services are Unchecked");

		}
		
		objSetUpPage.saveAndNextButton.click();

	}
	
	// We can add for each service but we have to take data from excel and proceed 

}
