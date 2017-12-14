package com.jamcracker.commonFunctions.marketplace;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.CompanyRequestsPage;
import com.jamcracker.objectRepository.marketplace.MarketplaceHomePage;
import com.jamcracker.utilities.TwoWindowsSwitch;

public class CompanyRequestApprove 
{
    public static void companyRequestApprove(String storeName)
    {
    	try{
    	MarketplaceHomePage mpHomePageObj = new MarketplaceHomePage();
    	mpHomePageObj.companySelectCheckbox(storeName).click();
    	mpHomePageObj.approveSelectedButton.click();
    	Thread.sleep(3000);
    	TwoWindowsSwitch.getWindowHandles();
    	TwoWindowsSwitch.switchToChild();
    	CompanyRequestsPage objcompReqPage = new CompanyRequestsPage();
    	objcompReqPage.yesButton.click();
    	TwoWindowsSwitch.switchToParent();
    	}
    	catch(Exception e)
    	{	Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e)+"</p>");
    		e.printStackTrace();
    	}
    	
    }
    
    
   
	
}
