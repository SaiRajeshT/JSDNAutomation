package com.jamcracker.commonFunctions.marketplace;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.SetUpPage;

public class StoreEmailNotificationSetUp

{
	 //private static SetUpPage  objSetUpPage =  SetUpPage.getInstance();
	//private final static StoreEmailNotificationSetUp instance = new StoreEmailNotificationSetUp();

	private StoreEmailNotificationSetUp() {
	}

	public static StoreEmailNotificationSetUp getInstance()
	{
		return new StoreEmailNotificationSetUp();
	}

	
	public  void emailPageSetup(String emailSignature,String storeRegisterEmail,String emailId, String notificationFromAddress
			,String supportEmailSignature,String contentRequestEmail,String supportFromAddress)
	{
		SetUpPage  objSetUpPage =  SetUpPage.getInstance();
		try{
			
		//objSetUpPage.customerEmailNotificationLink.click();
		objSetUpPage.storeEmailSignatureTextBox.clear();
		objSetUpPage.storeEmailSignatureTextBox.sendKeys(emailSignature);
		
		objSetUpPage.storeMemberOrderEmailTextBox.clear();
		objSetUpPage.storeMemberOrderEmailTextBox.sendKeys(emailId);
		
		objSetUpPage.storeRegistrantEmailTextBox.clear();
		objSetUpPage.storeRegistrantEmailTextBox.sendKeys(storeRegisterEmail);
		
		objSetUpPage.fromAddressEmailTextBox.clear();
		objSetUpPage.fromAddressEmailTextBox.sendKeys(notificationFromAddress);
		
		objSetUpPage.customerHelpDeskSignatureTextBox.clear();
		objSetUpPage.customerHelpDeskSignatureTextBox.sendKeys(supportEmailSignature);
		
		objSetUpPage.contentOnlyServiceEmailTextBox.clear();
		objSetUpPage.contentOnlyServiceEmailTextBox.sendKeys(contentRequestEmail);
		
		objSetUpPage.supportFromEmailTextBox.clear();
		objSetUpPage.supportFromEmailTextBox.sendKeys(supportFromAddress);
		}
		catch(Exception e)
		{
			Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e)+"</p>");
			System.out.println(e.getMessage());
			
		}
		objSetUpPage.saveAndNextButton.click();

	}
}
