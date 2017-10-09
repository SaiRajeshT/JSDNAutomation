package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class SetPasswordPage extends TestBase {
	
	public SetPasswordPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="setPasswordForm")
	public WebElement setPasswordPopup;
	
	@FindBy(id="newPassword")
	public WebElement newPasswordTextBox;
	
	@FindBy(id="confirmPassword")
	public WebElement confirmPasswordTextBox;
	
	@FindBy(id="securityQuestion")
	public WebElement securityQuestionDropDown;
	
	@FindBy(id="securityQueAns")
	public WebElement securityAnswerTextBox;
	
	@FindBy(id="setPwdSaveClose")
	public WebElement saveAndFinishButton;
	
	@FindBy(xpath="//div[@class='notify-msg']")
	public WebElement passwordNotifyMsg;
	
}
