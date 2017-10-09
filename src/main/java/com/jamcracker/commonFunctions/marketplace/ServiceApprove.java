package com.jamcracker.commonFunctions.marketplace;

import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.MarketplaceHomePage;
import com.jamcracker.objectRepository.marketplace.ServiceManagementPage;
import com.jamcracker.utilities.TwoWindowsSwitch;

public class ServiceApprove {

		
		  public static void serviceApprove(String serviceName )
		    
		  {
		    	try {
					MarketplaceHomePage objMpHomePage = new MarketplaceHomePage();
					objMpHomePage.AdministrationLink.click();
					ServiceManagementPage objServicePage = new ServiceManagementPage();
					objServicePage.serviceManagementLink.click();
					objServicePage.searchTextBox.sendKeys(serviceName);
					objServicePage.goButton.click();
					
					objServicePage.getSelectServiceCheckbox(serviceName).click();
					objServicePage.ApproveButton.click();
					Thread.sleep(5000);
					TwoWindowsSwitch.getWindowHandles();
					TwoWindowsSwitch.switchToChild();
					objServicePage.yesButton.click();
					TwoWindowsSwitch.switchToParent();
					
					Assert.assertEquals(objServicePage.getServiceStatus(serviceName).getText(),"Approved");
					Reporter.log("Service  Approved successfully");
				} 
		    	catch (Exception e) {
					
					e.printStackTrace();
					
					Reporter.log("<p style='color:Red'>Looks like issue while approving Service please check the issue.</p>");			
		    		Assert.fail();}
		    	
		    }

	}


