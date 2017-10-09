package com.jamcracker.commonFunctions.marketplace;

import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.MarketplaceHomePage;
import com.jamcracker.objectRepository.marketplace.MemberManagementPage;
import com.jamcracker.objectRepository.marketplace.StoreRequestsPage;
import com.jamcracker.utilities.TwoWindowsSwitch;

public class StoreRequestApprove
{
	
	  public static void testStoreRequestApprove(String storeAdminEmail,String companyName, String companyAcronym )
	    
	  {
	    	try {
				MarketplaceHomePage objMpHomePage = new MarketplaceHomePage();
				objMpHomePage.AdministrationLink.click();
				StoreRequestsPage objStoreRequestPage = new StoreRequestsPage();
				objStoreRequestPage.storeRequestLink.click();
				objStoreRequestPage.getStoreSelectCheckbox(storeAdminEmail).click();
				objStoreRequestPage.storeApproveSelectedButton.click();
				TwoWindowsSwitch.getWindowHandles();
				TwoWindowsSwitch.switchToChild();
				objStoreRequestPage.yesButton.click();;
				TwoWindowsSwitch.switchToParent();
				objMpHomePage.AdministrationLink.click();
				MemberManagementPage objMemberMgmtPage = new MemberManagementPage();
				objMemberMgmtPage.memberManagementLink.click();
				objMemberMgmtPage.storeLink.click();
				objMemberMgmtPage.searchTextBox.sendKeys(companyName);
				objMemberMgmtPage.goButton.click();
				System.out.println(objMemberMgmtPage.getStoreStatus(companyAcronym).getText());
				Assert.assertEquals(objMemberMgmtPage.getStoreStatus(companyAcronym).getText(),"Active");
				Reporter.log("Company Approved successfully");
			} 
	    	catch (Exception e) {
				
				e.printStackTrace();
				
				Reporter.log("<p style='color:Red'>Looks like issue while approving store please check the issue.</p>");			}
		
	    	
	    	
	    }

}
