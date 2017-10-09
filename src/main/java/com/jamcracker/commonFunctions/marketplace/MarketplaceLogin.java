package com.jamcracker.commonFunctions.marketplace;

import com.jamcracker.objectRepository.marketplace.MarketplaceLoginPage;
import com.jamcracker.utilities.TestBase;

public class MarketplaceLogin extends TestBase {
	
	MarketplaceLoginPage mpLogin = new MarketplaceLoginPage();
	
	public void login(String username, String password) {
		mpLogin.getEmailTextBox.sendKeys(username);
		mpLogin.getPasswordTextBox.sendKeys(password);
		mpLogin.getLoginButton.click();
		
		try{
			 driver.switchTo().alert().dismiss();
			 
			 //Need to change password here
			/* boolean logoutLink = getCommonObject("Logout_xpath").isDisplayed();
			  Assert.assertEquals(true, logoutLink,"Login to Store is Failed");
			  Reporter.log("Step1: Logged in to Store for reselling the service",false);*/
			 
		}
		
		catch(Exception e)
		{
			
			
		}
		
	}

}
