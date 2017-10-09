package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.jamcracker.utilities.TestBase;

public class MarketplaceLoginPage extends TestBase {
	
	public MarketplaceLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	public WebElement getEmailTextBox;
	
	@FindBy(id="password")
	public WebElement getPasswordTextBox;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	public WebElement getLoginButton;
	
}
