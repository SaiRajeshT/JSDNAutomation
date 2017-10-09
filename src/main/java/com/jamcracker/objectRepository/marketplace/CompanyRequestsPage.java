package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class CompanyRequestsPage extends TestBase
{
	public CompanyRequestsPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Company Requests")
	public WebElement companyRequestLink;
	
	@FindBy(id="simpleValue")
	public WebElement searchTextBox;
	
	@FindBy(xpath="//button[text()='Go']")
	public WebElement goButton;
	
	public WebElement companySelectCheckbox(String email)
	{
	  String objXPath="//td[@title='<REPLACE>']//preceding-sibling::td//input[@name='chk1']";
	   objXPath = objXPath.replaceAll("<REPLACE>", email);
	  return driver.findElement(By.xpath(objXPath));
	}
	
	 @FindBy(xpath="//button[text()='Yes']")
		public WebElement yesButton;

	
}
