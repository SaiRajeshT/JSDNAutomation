package com.jamcracker.commonFunctions.marketplace;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.SetUpPage;
import com.jamcracker.utilities.TestBase;
import com.jamcracker.utilities.TwoWindowsSwitch;

public class StoreInvoiceSettings extends TestBase{
	
	//private SetUpPage objSetUpPage = SetUpPage.getInstance();
	//private final static StoreInvoiceSettings instance = new StoreInvoiceSettings();
	private StoreInvoiceSettings() {

	}

	public static   StoreInvoiceSettings getInstance() {
		return new StoreInvoiceSettings();
	}

	public void invoicePageSetup() throws Exception {
		
		 SetUpPage objSetUpPage = SetUpPage.getInstance();
		objSetUpPage.uploadLogoLink.click();
		// Switching to upload logo page
		TwoWindowsSwitch.getWindowHandles();
		TwoWindowsSwitch.switchToChild();
		try {
			getDriver().get("javascript:document.getElementById('overridelink').click();");
		} catch (Exception e) {
			Reporter.log("Browser is not Internet Explorer");
		}
		objSetUpPage.invoiceLogoBrowseButton.sendKeys(System.getProperty("user.dir") + File.separator + "Data" + File.separator
				+ "Logos" + File.separator + "CompanyLogo.JPG");
		objSetUpPage.submitButton.click();
		TwoWindowsSwitch.switchToParent();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		try {
			js.executeScript("arguments[0].scrollIntoView(true);",objSetUpPage.saveAndNextButton);
			objSetUpPage.saveAndNextButton.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].scrollIntoView(true);",objSetUpPage.saveAndNextButton);
			objSetUpPage.saveAndNextButton.click();
		}

	}

}