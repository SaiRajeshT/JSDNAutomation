package com.jamcracker.commonFunctions.marketplace;

import java.io.File;

import com.jamcracker.objectRepository.marketplace.SetUpPage;
import com.jamcracker.utilities.TwoWindowsSwitch;

public class StoreInvoiceSettings {
	
	private SetUpPage objSetUpPage = SetUpPage.getInstance();
	private final static StoreInvoiceSettings instance = new StoreInvoiceSettings();
	private StoreInvoiceSettings() {

	}

	public static   StoreInvoiceSettings getInstance() {
		return instance;
	}

	public void invoicePageSetup() {
		objSetUpPage.uploadLogoLink.click();
		// Switching to upload logo page
		TwoWindowsSwitch.getWindowHandles();
		TwoWindowsSwitch.switchToChild();
		objSetUpPage.invoiceLogoBrowseButton.sendKeys(System.getProperty("user.dir") + File.separator + "Data" + File.separator
				+ "Logos" + File.separator + "CompanyLogo.JPG");
		objSetUpPage.submitButton.click();
		TwoWindowsSwitch.switchToParent();
		objSetUpPage.saveAndNextButton.click();

	}

}
