package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class TMPaymentGatewayPage extends TestBase {
	
	public TMPaymentGatewayPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@value='0'][@name='ERR_CODE']")
	public WebElement successRadioButton;
	
	@FindBy(xpath="//input[@value='1'][@name='ERR_CODE']")
	public WebElement failureRadioButton;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement submitButton;

}
