package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class EnterPriseAdminLoginPage extends TestBase {
	
	public EnterPriseAdminLoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	

	@FindBy(id="loginEmail")
	public WebElement usernameTextBox;
	
	@FindBy(id="password")
	public WebElement passwordTextBox;
	
	@FindBy(xpath="//button[@title='login']")
	public WebElement signInButton;
	
}
