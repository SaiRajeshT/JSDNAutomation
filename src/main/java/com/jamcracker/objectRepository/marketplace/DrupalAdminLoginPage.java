package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class DrupalAdminLoginPage extends TestBase {
	
	public DrupalAdminLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="edit-name")
	public WebElement usernameTextBox;
	
	@FindBy(id="edit-pass")
	public WebElement passwordTextBox;
	
	@FindBy(id="edit-submit")
	public WebElement loginButton;

}
