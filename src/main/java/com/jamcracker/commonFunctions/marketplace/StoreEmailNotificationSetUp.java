package com.jamcracker.commonFunctions.marketplace;

import com.jamcracker.objectRepository.marketplace.SetUpPage;

public class StoreEmailNotificationSetUp

{
	 private static SetUpPage  objSetUpPage =  SetUpPage.getInstance();
	private final static StoreEmailNotificationSetUp instance = new StoreEmailNotificationSetUp();

	private StoreEmailNotificationSetUp() {
	}

	public static StoreEmailNotificationSetUp getInstance()
	{
		return instance;
	}

	
	public  void emailPageSetup(String emailSignature,String storeRegisterEmail,String emailId, String notificationFromAddress
			,String supportEmailSignature,String contentRequestEmail,String supportFromAddress)
	{
		try{
		objSetUpPage.customerEmailNotificationLink.click();
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
			System.out.println(e.getMessage());
		}
		objSetUpPage.saveAndNextButton.click();

	}
}
