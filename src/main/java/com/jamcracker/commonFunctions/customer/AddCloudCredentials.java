package com.jamcracker.commonFunctions.customer;

import com.jamcracker.objectRepository.customer.CloudServiceCredentialsPage;
import com.jamcracker.objectRepository.customer.CustomerMenuAndSubmenuObjects;
import com.jamcracker.objectRepository.customer.ResultsFromDB;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class AddCloudCredentials extends TestBase {
	
public void addAWSCloudCredentails(String cloudProvider, String accountID, String userName, String password, String secretKey, String accessKey) throws Exception {
		
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
		objCloudCred.userNameTextBox.clear();
		objCloudCred.userNameTextBox.sendKeys(userName);
		objCloudCred.passwordTextBox.clear();
		objCloudCred.passwordTextBox.sendKeys(password);
		objCloudCred.secretKeyTextBox.clear();
		objCloudCred.secretKeyTextBox.sendKeys(secretKey);
		objCloudCred.accessKeyTextBox.clear();
		objCloudCred.accessKeyTextBox.sendKeys(accessKey);
		
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
		
	}

}
