package com.jamcracker.commonFunctions.marketplace;

import com.jamcracker.objectRepository.marketplace.SetUpPage;
import com.jamcracker.utilities.TwoWindowsSwitch;


public class StoreSearchPreference 
{
	private StoreSearchPreference()
	{
		
	}
	
	private static  SetUpPage objSetUpPage = SetUpPage.getInstance();
	private final static StoreSearchPreference instance = new StoreSearchPreference();
	
	public static StoreSearchPreference getInstance()
	{
		return instance;
	}

	//Configuring Final search preference and submitting store for approval
	public  void storeSearchPreference()
	{
		objSetUpPage.finishButton.click();
		TwoWindowsSwitch.getWindowHandles();
		TwoWindowsSwitch.switchToChild();
		objSetUpPage.submitStoreApproveButton.click();
		objSetUpPage.browseMarketplaceButton.click();
		//objSetUpPage.submitButton.click();
		TwoWindowsSwitch.switchToParent();
		
	}
	
	//Need to verify whether navigated from this page
}

