package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class ResetPasswordPage extends TestBase
{
	public ResetPasswordPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="newPassword")
	public WebElement newPasswordTextBox;
	
	@FindBy(id="confirmPassword")
	public WebElement confirmPasswordTextBox;
	
	@FindBy(id="securityQuestionList")
	public WebElement securityQuestionDropDown;
	
	@FindBy(id="securityAnswer")
	public WebElement securityAnswerTextBox;
	
	@FindBy(xpath="//button[@name='save']")
	public WebElement saveAndContinueButton;
	
	@FindBy(id="radiobuttonAccept")
	public WebElement acceptRadioButton;
	
	@FindBy(xpath="//button[contains(text(),'Continue >>')]")
	public WebElement continueButton;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	public WebElement logOutLink;
	
	

}
