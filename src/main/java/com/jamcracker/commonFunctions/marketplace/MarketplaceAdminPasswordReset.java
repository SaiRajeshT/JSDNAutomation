package com.jamcracker.commonFunctions.marketplace;

import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.MarketplaceLoginPage;
import com.jamcracker.objectRepository.marketplace.ResetPasswordPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class MarketplaceAdminPasswordReset extends TestBase

{
	public void mpPasswordReset(String LoginEmail, String defaultPassword,String newPassword,String secQuestion,String secAnswer)
	{
		ResetPasswordPage resetPasswordPageObj = new ResetPasswordPage();
		MarketplaceLoginPage mpLoginPageObj = new MarketplaceLoginPage();
		
		mpLoginPageObj.getEmailTextBox.sendKeys(LoginEmail);
		mpLoginPageObj.getPasswordTextBox.sendKeys(defaultPassword);
		mpLoginPageObj.getLoginButton.click();
		resetPasswordPageObj.newPasswordTextBox.sendKeys(newPassword);
		resetPasswordPageObj.confirmPasswordTextBox.sendKeys(newPassword);
		HandleDropDown.selectDDLByVisibletext(resetPasswordPageObj.securityQuestionDropDown, secQuestion);
		resetPasswordPageObj.securityAnswerTextBox.sendKeys(secAnswer);
		resetPasswordPageObj.saveAndContinueButton.click();
		resetPasswordPageObj.acceptRadioButton.click();
		resetPasswordPageObj.continueButton.click();
		if(resetPasswordPageObj.logOutLink.isDisplayed())
		{
			Reporter.log("Reset password is successfull");
		}
		
		else
			Reporter.log("<p style='color:red'> Reset password is not successFull. Please check the issue</p>");
	}

}
