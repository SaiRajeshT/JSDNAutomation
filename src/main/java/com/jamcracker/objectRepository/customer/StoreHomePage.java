package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class StoreHomePage extends TestBase {
	
	public StoreHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Sign Up")
	public WebElement signUpLink;
	
	@FindBy(xpath="//div[@class='tb-megamenu-row row-fluid']")
	public WebElement signInSection;
	
	@FindBy(linkText="Sign In")
	public WebElement signInLink;
	
	@FindBy(xpath="//input[@id='edit-name--2']")
	public WebElement usernameTextBox;
	
	@FindBy(xpath="//input[@id='edit-pass--2']")
	public WebElement passwordTextBox;
	
	@FindBy(xpath="//input[@id='edit-submit--2']")
	public WebElement signInButton;
	
}
