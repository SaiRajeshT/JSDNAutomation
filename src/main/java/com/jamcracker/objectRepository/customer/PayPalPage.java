package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class PayPalPage extends TestBase{
	
	public PayPalPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="outerWrapper")
	public WebElement paypalPage;
	
	@FindBy(name="injectedUl")
	public WebElement paypalDetailsFrame;
	
	@FindBy(id="email")
	public WebElement paypalEmailTextBox;
	
	@FindBy(id="password")
	public WebElement paypalPasswordTextBox;
	
	@FindBy(id="btnLogin")
	public WebElement loginButton;
	
	@FindBy(id="confirmButtonTop")
	public WebElement agreeButton;
	
}
