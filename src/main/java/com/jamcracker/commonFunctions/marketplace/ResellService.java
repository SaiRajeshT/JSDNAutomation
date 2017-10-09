package com.jamcracker.commonFunctions.marketplace;

import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.objectRepository.store.CatalogPage;
import com.jamcracker.objectRepository.store.MarketplacePage;
import com.jamcracker.utilities.SwitchFrame;
import com.jamcracker.utilities.TestBase;
import com.jamcracker.utilities.TwoWindowsSwitch;

public class ResellService extends TestBase {
	
	MarketplacePage objMarketplacePage = new MarketplacePage();
	CatalogPage objCatalogPage = new CatalogPage();
	
	public void resellService(String serviceName,String offerName,String retailPrice)
	{
		
		
			try{
			objMarketplacePage.globalSearchTextBox.sendKeys(serviceName);
			objMarketplacePage.searchIconTextBox.click();
			explicitWait(objMarketplacePage.collapseLink);
			Thread.sleep(9000);
			objMarketplacePage.getResellButton(serviceName).click();
			TwoWindowsSwitch.getWindowHandles();
			TwoWindowsSwitch.switchToChild();
			objMarketplacePage.pendingResellButton.click();
			TwoWindowsSwitch.switchToParent();
			objMarketplacePage.selectService(serviceName).click();
			objMarketplacePage.completeResellButton.click();
			Thread.sleep(9000);
			TwoWindowsSwitch.getWindowHandles();
			TwoWindowsSwitch.switchToChild();
			/*new StoreHomePage().storeLink.click();
			objCatalogPage.catalogLink.click();*/
			objMarketplacePage.goToCatalogButton.click();
			TwoWindowsSwitch.switchToParent();
			objCatalogPage.isEditServiceElementExist(offerName);
			
			
			if(!objCatalogPage.isNextElementExist()|| objCatalogPage.isEditServiceElementExist(offerName)){
				objCatalogPage.getEditService(offerName).click();
			}else{
				while (objCatalogPage.isNextElementExist()) {
					if(objCatalogPage.isEditServiceElementExist(offerName)){
						//objCatalogPage.getEditService(offerName).click();
						break;
					}
					objCatalogPage.nextIcon.click();
					explicitWaitToClickable(objCatalogPage.customizeCatalogButton);
				}
				objCatalogPage.getEditService(offerName).click();
			}
			
			


			if(objCatalogPage.inCatalogCheckBox.isDisplayed())
			{
				Reporter.log("Successfully Clicked on Edit service icon .");
			objCatalogPage.inCatalogCheckBox.click();}
			else{
				Reporter.log("<p style='color:red'> Issue while selecting in-catalog checkbox. Please check the issue.</p>");
			}
			try{
				SwitchFrame.elementSwitch(objCatalogPage.addCredentialsFrame);
				objCatalogPage.cancelButton.click();
				driver.switchTo().defaultContent();
			    
			}
			
			catch(Exception e)
			{
			  //need to capture screenshot here	
			}
			
			objCatalogPage.retailPriceTextBox.clear();
			objCatalogPage.retailPriceTextBox.sendKeys(retailPrice);
		    objCatalogPage.saveButton.click();
		    explicitWait(objCatalogPage.customizeCatalogButton);
		    
			  //Verifying whether service successfully resold or not
		   try{
		    if(!objCatalogPage.isNextElementExist()){
				   Assert.assertEquals(objCatalogPage.getresellStatus(offerName).getText(),"Yes","Service resell is not successfull");
				   Reporter.log("Service Resell is completed");
		    }
		    else{
				while (objCatalogPage.isNextElementExist()) {
					if(objCatalogPage.isEditServiceElementExist(offerName)){
						break;
					}
					objCatalogPage.nextIcon.click();
					explicitWaitToClickable(objCatalogPage.customizeCatalogButton);
				}
				Assert.assertEquals(objCatalogPage.getresellStatus(offerName).getText(),"Yes");
				Reporter.log("Service Resell is completed");
		    }}
		   catch(Exception e)
		   {
			   Reporter.log("<p style='color:red'> Service is not resold to store. Please check the issue </p>");
		   }
		    
		    
		    
		   
		   

			
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Assert.fail();
			}
			
		}
		
		
	

}
