package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class QuickHelpPage extends TestBase{
	
	public QuickHelpPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@id='pageBodyTemplate']//li[contains(text(),'Quick Help')]")
	public WebElement quickHelpLink;
	
	@FindBy(linkText="Search instances")
	public WebElement searchInstanceLink;
	
	@FindBy(linkText="Manage instances")
	public WebElement manageInstanceLink;
	
	@FindBy(linkText="Launch vendor console")
	public WebElement launchVendorConsoleLink;
	
	public WebElement getLink(String Linkname)
	{
		return driver.findElement(By.linkText(Linkname));
	}
	
}
