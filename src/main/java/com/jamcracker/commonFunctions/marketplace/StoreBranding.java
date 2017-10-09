package com.jamcracker.commonFunctions.marketplace;

import java.io.File;

import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.SetUpPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;
import com.jamcracker.utilities.TwoWindowsSwitch;

public class StoreBranding extends TestBase
{
   public void storeBranding(String theme)
   {
		SetUpPage objSetUpPage = SetUpPage.getInstance();
		explicitWait(objSetUpPage.storeURLTextBox);
		//objSetUpPage.storeURLTextBox.sendKeys(keysToSend);
		objSetUpPage.uploadLogoLink.click();
		//Switching to upload logo page
		TwoWindowsSwitch.getWindowHandles();
		TwoWindowsSwitch.switchToChild();
		objSetUpPage.browseButton.sendKeys(System.getProperty("user.dir")+File.separator+"Data"+File.separator+"Logos"+File.separator+"CompanyLogo.JPG");
		objSetUpPage.submitButton.click();
		TwoWindowsSwitch.switchToParent();
		//HandleDropDown dropdownObj = new HandleDropDown();
		HandleDropDown.selectDDLByVisibletext(objSetUpPage.themeDropdown,theme);
		/*Select select = new Select(objSetUpPage.themeDropdown);
		String selectedText = select.getFirstSelectedOption().getText();*/
	String selectedText=	HandleDropDown.getSelectedValue(objSetUpPage.themeDropdown);
		if(theme.equalsIgnoreCase(selectedText))
		 Reporter.log(selectedText +" Theme Successfully Theme configured to store.");
		else
			Reporter.log("</p style='color:red'>Theme configuration for store is failed. Please check the issue. <p>");
		
		objSetUpPage.saveAndNextButton.click();
		
		if(SetUpPage.getInstance().addTimezoneButton.isDisplayed())
		{
			Reporter.log("Successfully completed Branding and navigated to Regional settings page." );
		}
		
		else
		{
			Reporter.log("<p style='color:red'> Looks like issue in Branding page set up. Please check the issue.</p>");
		}
	   
   }

}
