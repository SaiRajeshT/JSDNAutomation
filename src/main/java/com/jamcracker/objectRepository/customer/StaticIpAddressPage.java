package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class StaticIpAddressPage extends TestBase {
	public  StaticIpAddressPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//td[div[@id='header_popUpId']]//select[@id='providerCode']")
	public WebElement providerDropdown;
	
	

}
