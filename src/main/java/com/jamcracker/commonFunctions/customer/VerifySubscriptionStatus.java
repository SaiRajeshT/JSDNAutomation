package com.jamcracker.commonFunctions.customer;


import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.objectRepository.customer.UsersPage;
import com.jamcracker.utilities.TestBase;

public class VerifySubscriptionStatus extends TestBase{
	public static  void verifySubscriptionStatus(String email,String offerName){
		
		try{
			UsersPage objUserPage = new UsersPage();
		
		objUserPage.manageLink.click();
		objUserPage.UsersLink.click();
		objUserPage.userSearchTextBox.clear();
		objUserPage.userSearchTextBox.sendKeys(email);
		Thread.sleep(3000);
		objUserPage.userSearchTextBox.sendKeys(Keys.ENTER);
		objUserPage.getAction(email).click();
		objUserPage.viewSubscription.click();
		while(true)
		{
			if(objUserPage.getofferStatus(offerName).equalsIgnoreCase("Active")){
				Reporter.log("Service assigned successfully");
				break;
			}
			else if(objUserPage.getofferStatus(offerName).equalsIgnoreCase("Failed")){
				Reporter.log("<p style='color:red'>Service assign failed at "+ java.time.LocalDateTime.now()+"<p>");
				break;
			}
			else{
				driver.navigate().refresh();
				continue;
			}
		}
		}
		
		catch(Exception e)
		{
			Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e)+"</p>");
			Assert.fail();
		}
		
	}

}
