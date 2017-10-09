package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class BrainTreePage extends TestBase{
	
	public BrainTreePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="braintree-dropin-frame")
	public WebElement ccDetailsFrame;
	
	@FindBy(id="credit-card-number")
	public WebElement ccnTextBox;
	
	@FindBy(id="expiration")
	public WebElement expirationTextBox;
	
	@FindBy(id="cvv")
	public WebElement cvvTextBox;
	
	@FindBy(id="paynow")
	public WebElement submitButton;

}
