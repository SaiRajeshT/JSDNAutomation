package com.jamcracker.commonFunctions.customer;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.TestNG;

import com.gargoylesoftware.htmlunit.javascript.host.Set;
import com.jamcracker.constants.Constants;
import com.jamcracker.objectRepository.customer.UsersPage;
import com.jamcracker.utilities.TestBase;

public class AssginSubscription extends TestBase{

	JavascriptExecutor js;

	public void assignSubscription (String email,String offerName, String mscsp,String mailNickName,String displayName)
	{
		try{
			
			UsersPage objUserPage = new UsersPage();
			getDriver().navigate().refresh();
		objUserPage.manageLink.click();
		objUserPage.UsersLink.click();
		objUserPage.userSearchTextBox.clear();
		objUserPage.userSearchTextBox.sendKeys(email);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		objUserPage.userSearchTextBox.sendKeys(Keys.ENTER);
		objUserPage.getAction(email).click();
		objUserPage.assignSubscription.click();
		explicitWait(objUserPage.assignSubscriptionSearchTextBox);
	//	objUserPage.selectOfferCheckBox(offerName).click();
		try{
			if(objUserPage.selectOfferCheckBox(offerName).isDisplayed())
			{
				objUserPage.selectOfferCheckBox(offerName).click();
			}
		}
		catch(Exception e)
		{
			Reporter.log("<p style='color:red'>Offer is not avialable in the store.</p>");
			objUserPage.cancelButton.click();	
		}
		js = (JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", objUserPage.saveAndNextButton);
		objUserPage.saveAndNextButton.click();
		
		
		
		
		if(mscsp.equalsIgnoreCase("Y"))
		{	
		objUserPage.mailNicknameTextBox.sendKeys(mailNickName);
		Thread.sleep(2000);
		objUserPage.displayNameTextBox.sendKeys(displayName);
		objUserPage.saveAndFinishButton.click();
		}	
		
	
		
		if(objUserPage.successMsgBar.getText().equalsIgnoreCase(Constants.SERVICE_ASSIGN_MESSAGE))
		{
			Reporter.log("Service Assign intiated for user " + email );
		}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	catch(Exception e)
		{
		Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e)+"</p>");
			Assert.fail();
		}
		
	}
	
}
