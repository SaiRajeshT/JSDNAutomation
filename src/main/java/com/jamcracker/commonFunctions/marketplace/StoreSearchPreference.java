package com.jamcracker.commonFunctions.marketplace;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.SetUpPage;
import com.jamcracker.utilities.TestBase;
import com.jamcracker.utilities.TwoWindowsSwitch;


public class StoreSearchPreference extends TestBase
{
	private StoreSearchPreference()
	{
		
	}
	
	//private static  SetUpPage objSetUpPage = SetUpPage.getInstance();
	//private final static StoreSearchPreference instance = new StoreSearchPreference();
	
	public static StoreSearchPreference getInstance()
	{
		return  new StoreSearchPreference();
	}

	//Configuring Final search preference and submitting store for approval
	public  void storeSearchPreference()
	{
		 SetUpPage objSetUpPage = SetUpPage.getInstance();
		objSetUpPage.finishButton.click();
		TwoWindowsSwitch.getWindowHandles();
		TwoWindowsSwitch.switchToChild();
		try {
			getDriver().get("javascript:document.getElementById('overridelink').click();");
		} catch (Exception e) {
			Reporter.log("Browser is not Internet Explorer");
		}
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		try {
			explicitWait(objSetUpPage.submitStoreApproveButton);
			js.executeScript("arguments[0].scrollIntoView(true);",objSetUpPage.submitStoreApproveButton);
			objSetUpPage.submitStoreApproveButton.click();
		} catch (Exception e) {
			explicitWait(objSetUpPage.submitStoreApproveButton);
			js.executeScript("arguments[0].scrollIntoView(true);",objSetUpPage.submitStoreApproveButton);
			objSetUpPage.submitStoreApproveButton.click();
		}
		try {
			explicitWait(objSetUpPage.browseMarketplaceButton);
			js.executeScript("arguments[0].scrollIntoView(true);",objSetUpPage.browseMarketplaceButton);
			objSetUpPage.browseMarketplaceButton.click();
		} catch (Exception e) {
			explicitWait(objSetUpPage.browseMarketplaceButton);
			js.executeScript("arguments[0].scrollIntoView(true);",objSetUpPage.browseMarketplaceButton);
			objSetUpPage.browseMarketplaceButton.click();
		}
		//objSetUpPage.submitButton.click();
		TwoWindowsSwitch.switchToParent();
		
	}
	
	//Need to verify whether navigated from this page
}