package com.jamcracker.commonFunctions.customer;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.constants.Constants;
import com.jamcracker.objectRepository.customer.UsersPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class AssginSubscription extends TestBase{

	JavascriptExecutor js;

	public void assignSubscription (String email,String offerName)
	{
		try{
			UsersPage objUserPage = new UsersPage();
		
		objUserPage.manageLink.click();
		objUserPage.UsersLink.click();
		objUserPage.userSearchTextBox.clear();
		objUserPage.userSearchTextBox.sendKeys(email);
		Thread.sleep(3000);
		objUserPage.userSearchTextBox.sendKeys(Keys.ENTER);
		objUserPage.getAction(email).click();
		objUserPage.assignSubscription.click();
		explicitWait(objUserPage.assignSubscriptionSearchTextBox);
		objUserPage.selectOfferCheckBox(offerName).click();
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", objUserPage.saveAndNextButton);
		objUserPage.saveAndNextButton.click();
		if(objUserPage.successMsgBar.getText().equalsIgnoreCase(Constants.SERVICE_ASSIGN_MESSAGE))
		{
			Reporter.log("Service Assign intiated for user " + email );
		}
		Thread.sleep(2000);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
	}
	
}
