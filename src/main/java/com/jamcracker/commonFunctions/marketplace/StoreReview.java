package com.jamcracker.commonFunctions.marketplace;

import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.SetUpPage;
import com.jamcracker.objectRepository.marketplace.StoreRequestsPage;

public class StoreReview 
{
	StoreRequestsPage objStoreReqPage = new StoreRequestsPage();
	
	
	public void testStoreReview(String storeAdminEmail)
	{
		objStoreReqPage.getStoreReviewLink(storeAdminEmail).click();
		
		if(SetUpPage.getInstance().storeURLTextBox.isDisplayed())
			Reporter.log("Successfully clicked on store review link");
		else
			Reporter.log("<p style='color:red'>Issue in clicking on store Review link. Please check the issue</p>");
		
	}

}
