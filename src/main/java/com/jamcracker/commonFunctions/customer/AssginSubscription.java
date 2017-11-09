package com.jamcracker.commonFunctions.customer;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.jamcracker.objectRepository.customer.UsersPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class AssginSubscription extends TestBase{

	JavascriptExecutor js;

	public void assignSubscription (String email,String phoneNo,String offerName,String siteName,String callingPermission,
			String language,String phoneType,String phoneName)
	{
		try{
			UsersPage objUserPage = new UsersPage();
		
		objUserPage.manageLink.click();
		objUserPage.UsersLink.click();
		objUserPage.getAssignSubscription(email).click();
		objUserPage.assignSubscription.click();
		explicitWait(objUserPage.assignSubscriptionSearchTextBox);
		objUserPage.selectOfferCheckBox(offerName).click();
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", objUserPage.saveAndNextButton);
		objUserPage.saveAndNextButton.click();
		HandleDropDown.selectDDLByVisibletext(objUserPage.siteDropDown, siteName);
		HandleDropDown.selectDDLByVisibletext(objUserPage.callingDropDown, callingPermission);
		HandleDropDown.selectDDLByVisibletext(objUserPage.languageDropDown, language);
		objUserPage.mobileNoTextBox.sendKeys(phoneNo);
		
		HandleDropDown.selectDDLByVisibletext(objUserPage.phoneTypeDropdown, phoneType);
		
		Select select1 = new Select(objUserPage.phoneNumberDropdown);
		List<WebElement> options1 = select1.getOptions();
		select1.selectByVisibleText(options1.get(1).getText());
		objUserPage.phoneName.sendKeys(phoneName);
		objUserPage.saveAndFinishButton.click();
		
		Thread.sleep(5000);
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
	}
	
}
