package com.jamcracker.commonFunctions.marketplace;

import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.MarketplaceLoginPage;
import com.jamcracker.objectRepository.marketplace.ResetPasswordPage;
import com.jamcracker.utilities.CaptureScreenshot;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class SetPassword extends TestBase

{

	public static void setPassword(String LoginEmail, String defaultPassword,String newPassword,String secQuestion,String secAnswer,String sceenshotname)
	{
		
		
		
		try {
			ResetPasswordPage resetPasswordPageObj = new ResetPasswordPage();
			MarketplaceLoginPage mpLoginPageObj = new MarketplaceLoginPage();

			mpLoginPageObj.getEmailTextBox.sendKeys(LoginEmail);
			mpLoginPageObj.getPasswordTextBox.sendKeys(defaultPassword);
			mpLoginPageObj.getLoginButton.click();
			resetPasswordPageObj.newPasswordTextBox.sendKeys(newPassword);
			resetPasswordPageObj.confirmPasswordTextBox.sendKeys(newPassword);
			HandleDropDown.selectDDLByVisibletext(resetPasswordPageObj.securityQuestionDropDown, secQuestion);
			resetPasswordPageObj.securityAnswerTextBox.sendKeys(secAnswer);
			Thread.sleep(10000);
			resetPasswordPageObj.saveAndContinueButton.click();
			resetPasswordPageObj.acceptRadioButton.click();
			resetPasswordPageObj.continueButton.click();
			if (resetPasswordPageObj.logOutLink.isDisplayed()) {
				Reporter.log("Reset password is successfull");
			}

			else
				Reporter.log("<p style='color:red'> Reset password is not successFull. Please check the issue</p>");

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
			CaptureScreenshot.screenshot(driver,sceenshotname,testClassName,packageName);


		}
	}
	
}
