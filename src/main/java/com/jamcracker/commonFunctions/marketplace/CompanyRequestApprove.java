package com.jamcracker.commonFunctions.marketplace;

import com.jamcracker.objectRepository.marketplace.CompanyRequestsPage;
import com.jamcracker.objectRepository.marketplace.MarketplaceHomePage;
import com.jamcracker.utilities.TwoWindowsSwitch;

public class CompanyRequestApprove 
{
    public static void companyRequestApprove(String storeName)
    {
    	MarketplaceHomePage mpHomePageObj = new MarketplaceHomePage();
    	mpHomePageObj.companySelectCheckbox(storeName).click();
    	mpHomePageObj.approveSelectedButton.click();
    	TwoWindowsSwitch.getWindowHandles();
    	TwoWindowsSwitch.switchToChild();
    	CompanyRequestsPage objcompReqPage = new CompanyRequestsPage();
    	objcompReqPage.yesButton.click();
    	TwoWindowsSwitch.switchToParent();
    	
    	
    }
    
    
   
	
}
