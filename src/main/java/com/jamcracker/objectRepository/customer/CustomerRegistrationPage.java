package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class CustomerRegistrationPage extends TestBase {
	
	public CustomerRegistrationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//div[@class='grid_12 marginTop-10']")
	public WebElement registrationPageSection;
	
	@FindBy(id="firstName")
	public WebElement firstNameTextBox;
	
	@FindBy(id="lastName")
	public WebElement lastNameTextBox;
	
	@FindBy(id="contactPhone")
	public WebElement contactPhoneTextBox;
	
	@FindBy(id="email")
	public WebElement  emailTextBox;
	
	@FindBy(id="companyName")
	public WebElement companyNameTextBox;
	
	@FindBy(id="mailingAddress1")
	public WebElement mailingAddress1TextBox;
	
	@FindBy(id="mailingPhone")
	public WebElement mailingPhoneTextBox;
	
	@FindBy(id="mailingcountry")
	public WebElement mailingcountryDropDown;
	
	@FindBy(id="mailingState")
	public WebElement mailingStateDropDown;
	
	@FindBy(id="mailingOtherState")
	public WebElement mailingOtherStateTextBox;
	
	@FindBy(id="mailingCity")
	public WebElement mailingCityTextBox;
	
	@FindBy(id="mailingZip")
	public WebElement mailingZipTextBox;
	
	@FindBy(id="billingCheck")
	public WebElement billingCheckBox;
	
	@FindBy(id="address1")
	public WebElement billingAddress1TextBox;
	
	@FindBy(id="phone")
	public WebElement billingPhoneTextBox;
	
	@FindBy(id="billingCountry")
	public WebElement billingCountryDropDown;
	
	@FindBy(id="billingState")
	public WebElement billingStateDropDown;
	
	@FindBy(id="otherState")
	public WebElement billingOtherStateTextBox;
	
	@FindBy(id="city")
	public WebElement billingCityTextBox;
	
	@FindBy(id="zip")
	public WebElement billingZipTextBox;
	
	@FindBy(id="timeZone")
	public WebElement timeZoneDropDown;
	
	@FindBy(id="i_agree")
	public WebElement i_agreeCheckBox;
	
	//@FindBy(id="btn_submit")
	@FindBy(xpath="//span[text()='Register']")
	public WebElement registerButton;
	
	@FindBy(id="cancel")
	public WebElement cancelButton;

}
