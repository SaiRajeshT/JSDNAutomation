package com.jamcracker.commonFunctions.customer;

import org.testng.Assert;

import com.jamcracker.objectRepository.customer.CustomerMenuAndSubmenuObjects;
import com.jamcracker.objectRepository.customer.SetPasswordPage;
import com.jamcracker.objectRepository.customer.StoreHomePage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class SetPassword extends TestBase {
	
	public void setPassword(String email, String newPassword, String securityQuestion, String securityAnswer) {
		
		StoreHomePage storeHome = new StoreHomePage();
		storeHome.signInLink.click();
		explicitWait(storeHome.signInSection);
		storeHome.usernameTextBox.sendKeys(email);
		storeHome.passwordTextBox.sendKeys("root123");
		storeHome.signInButton.click();
		CustomerMenuAndSubmenuObjects custCommon = new CustomerMenuAndSubmenuObjects();
		custCommon.dashboardLink.click();
		explicitWait(custCommon.smartboardLink);
		custCommon.smartboardLink.click();
		SetPasswordPage setPassword = new SetPasswordPage();
		explicitWait(setPassword.setPasswordPopup);
		setPassword.newPasswordTextBox.sendKeys(newPassword);
		setPassword.confirmPasswordTextBox.sendKeys(newPassword);
		HandleDropDown.selectDDLByVisibletext(setPassword.securityQuestionDropDown, securityQuestion);
		setPassword.securityAnswerTextBox.sendKeys(securityAnswer);
		setPassword.saveAndFinishButton.click();
		explicitWait(setPassword.passwordNotifyMsg);
		SetPasswordPage passwordPage = new SetPasswordPage();
		String actualMessage = passwordPage.passwordNotifyMsg.getText();
		String expectedMessage = "Your password has been updated successfully.";
		Assert.assertEquals(actualMessage, expectedMessage);
		
	}

}
