package com.jamcracker.commonFunctions.customer;

import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.objectRepository.customer.CloudServiceCredentialsPage;
import com.jamcracker.objectRepository.customer.CustomerMenuAndSubmenuObjects;
import com.jamcracker.objectRepository.customer.ResultsFromDB;
import com.jamcracker.objectRepository.marketplace.CLoudCredentialsPage;
import com.jamcracker.objectRepository.marketplace.MarketplaceHomePage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.SwitchFrame;
import com.jamcracker.utilities.TestBase;

public class AddCloudCredentials extends TestBase {
	
	public void addAWSLinkedCredentails(String cloudProvider, String accountID, String userName, String password, String secretKey, String accessKey) throws Exception {
		
		CustomerMenuAndSubmenuObjects objMenu = new CustomerMenuAndSubmenuObjects();
		objMenu.manageLink.click();
		objMenu.cloudCredentialsLink.click();
		CloudServiceCredentialsPage objCloudCred = new CloudServiceCredentialsPage();
		objCloudCred.addCloudServiceCredentialsButton.click();
		String actorID = ResultsFromDB.getActorID(cloudProvider);
		HandleDropDown.selectDDLByValue(objCloudCred.cloudProviderDropDown, actorID);
		explicitWait(objCloudCred.accountIDTextBox);
		objCloudCred.accountIDTextBox.clear();
		objCloudCred.accountIDTextBox.sendKeys(accountID);
		objCloudCred.accountIDLabel.click();
		explicitWait(objCloudCred.userNameTextBox);
		objCloudCred.userNameTextBox.clear();
		objCloudCred.userNameTextBox.sendKeys(userName);
		objCloudCred.passwordTextBox.clear();
		objCloudCred.passwordTextBox.sendKeys(password);
		objCloudCred.secretKeyTextBox.clear();
		objCloudCred.secretKeyTextBox.sendKeys(secretKey);
		objCloudCred.accessKeyTextBox.clear();
		objCloudCred.accessKeyTextBox.sendKeys(accessKey);
		authorizingCredentials(accountID);
		
	}
	
	public void addAWSPayingCredentials(String cloudProvider, String accountID, String userName, String password, String secretKey, String accessKey, String bucketName, String usageFileName, String urlType) throws Exception {
		
		switch (urlType) {
		case "Marketplace":
			MarketplaceHomePage mHome = new MarketplaceHomePage();
			mHome.IaaSConsoleLink.click();
			CLoudCredentialsPage objCloudCred = new CLoudCredentialsPage();
			objCloudCred.cloudServiceCredentialsLink.click();
			objCloudCred.addCredentialsButton.click();
			SwitchFrame.elementSwitch(objCloudCred.credentialsFrame);
			addDetails(cloudProvider, accountID, userName, password, secretKey, accessKey, bucketName, usageFileName);
			SwitchFrame.defaultSwitch();
			objCloudCred.validateIcon(accountID).click();
			Assert.assertTrue(objCloudCred.credStatus(accountID).isDisplayed());
			break;

		case "Store":
			CustomerMenuAndSubmenuObjects objMenu = new CustomerMenuAndSubmenuObjects();
			objMenu.manageLink.click();
			objMenu.cloudCredentialsLink.click();
			CloudServiceCredentialsPage objSerCloudCred = new CloudServiceCredentialsPage();
			objSerCloudCred.addCloudServiceCredentialsButton.click();
			addDetails(cloudProvider, accountID, userName, password, secretKey, accessKey, bucketName, usageFileName);
			authorizingCredentials(accountID);
			break;
		}
				
	}
	
	public void addDetails(String cloudProvider, String accountID, String userName, String password, String secretKey, String accessKey, String bucketName, String usageFileName) throws Exception {
		
		CLoudCredentialsPage objCloudCred = new CLoudCredentialsPage();
		String actorID = ResultsFromDB.getActorID(cloudProvider);
		HandleDropDown.selectDDLByValue(objCloudCred.cloudProviderDropDown, actorID);
		explicitWait(objCloudCred.accountTypeDropDown);
		Thread.sleep(2000);
		HandleDropDown.selectDDLByValue(objCloudCred.accountTypeDropDown, "PAYEE");
		explicitWait(objCloudCred.accountIDTextBox);
		objCloudCred.accountIDTextBox.clear();
		objCloudCred.accountIDTextBox.sendKeys(accountID);
		objCloudCred.accountIDLabel.click();
		explicitWait(objCloudCred.userNameTextBox);
		Thread.sleep(2000);
		objCloudCred.userNameTextBox.clear();
		objCloudCred.userNameTextBox.sendKeys(userName);
		objCloudCred.passwordTextBox.clear();
		objCloudCred.passwordTextBox.sendKeys(password);
		objCloudCred.secretKeyTextBox.clear();
		objCloudCred.secretKeyTextBox.sendKeys(secretKey);
		objCloudCred.accessKeyTextBox.clear();
		objCloudCred.accessKeyTextBox.sendKeys(accessKey);
		objCloudCred.bucketNameTextBox.clear();
		objCloudCred.bucketNameTextBox.sendKeys(bucketName);
		objCloudCred.usageFileNameTextBox.clear();
		objCloudCred.usageFileNameTextBox.sendKeys(usageFileName);
		try {
			objCloudCred.saveButton.click();
		} catch (Exception e) {
			objCloudCred.saveButton1.click();
		}
		
	}
	
	public void addOpenStackCloudCredentials(String cloudProvider, String projectName, String userName, String password) throws Exception {
		
		CustomerMenuAndSubmenuObjects objMenu = new CustomerMenuAndSubmenuObjects();
		objMenu.manageLink.click();
		objMenu.cloudCredentialsLink.click();
		CloudServiceCredentialsPage objCloudCred = new CloudServiceCredentialsPage();
		objCloudCred.addCloudServiceCredentialsButton.click();
		String actorID = ResultsFromDB.getActorID(cloudProvider);
		HandleDropDown.selectDDLByValue(objCloudCred.cloudProviderDropDown, actorID);
		explicitWait(objCloudCred.accountIDTextBox);
		objCloudCred.accountIDTextBox.clear();
		objCloudCred.accountIDTextBox.sendKeys(projectName);
		objCloudCred.accountIDLabel.click();
		explicitWait(objCloudCred.userNameTextBox);
		objCloudCred.userNameTextBox.clear();
		objCloudCred.userNameTextBox.sendKeys(userName);
		objCloudCred.passwordTextBox.clear();
		objCloudCred.passwordTextBox.sendKeys(password);
		objCloudCred.saveButton.click();
		authorizingCredentials(projectName);
		
	}
	
	public void authorizingCredentials(String accountId) throws Exception {
		
		boolean test = true;
		long startTime = (System.currentTimeMillis()) / 1000;
		CloudServiceCredentialsPage objCloudCred = new CloudServiceCredentialsPage();
		while(test) {
			if ((System.currentTimeMillis() / 1000) - startTime > timeout) {
				Reporter.log("<p style='color:red'>Waited for"+timeout+" Seconds. Status of the Cloud Credentials added is not Waiting for Authorization.<p>");
				Assert.fail();
				break;
			}
			try {
				if (objCloudCred.authorizationStatus(accountId).isDisplayed()) {
					test = false;
					Reporter.log("Cloud Credentials are in Waiting for Authorization state.");
				}
			} catch (Exception e) {
				Thread.sleep(3000);
				explicitWait(objCloudCred.searchBox);
				objCloudCred.searchBox.clear();
				objCloudCred.searchBox.sendKeys(accountId);
				objCloudCred.goButton.click();
			}
		}
		objCloudCred.actionLink(accountId).click();
		objCloudCred.validateLink.click();
		boolean test1 = true;
		while(test1) {
			if ((System.currentTimeMillis() / 1000) - startTime > timeout) {
				Reporter.log("<p style='color:red'>Waited for"+timeout+" Seconds. Status of the Cloud Credentials added is not Active.<p>");
				Assert.fail();
				break;
			}
			try {
				if (objCloudCred.activeStatus(accountId).isDisplayed()) {
					test1 = false;
					Reporter.log("Cloud Credentials are in Active Status.");
				}
			} catch (Exception e) {
				Thread.sleep(3000);
				explicitWait(objCloudCred.searchBox);
				objCloudCred.searchBox.clear();
				objCloudCred.searchBox.sendKeys(accountId);
				objCloudCred.goButton.click();
			}
		}		
	}

}
