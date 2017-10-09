package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class StoreRequestsPage extends TestBase
{
	String objXPath;
	public StoreRequestsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Store Requests")
	public WebElement storeRequestLink;
	
	
	public WebElement getStoreReviewLink(String storeAdminEmail)
	{
		 objXPath ="//td[text()='<REPLACE>']//following-sibling::td//a[text()='Review']";
		 objXPath=objXPath.replaceAll("<REPLACE>", storeAdminEmail);
		return driver.findElement(By.xpath(objXPath));
	}
	
	public WebElement getStoreSelectCheckbox(String storeAdminEmail)
	{
	  objXPath="//tr[td[@title='<REPLACE>']]//input[@type='checkbox'][@name='chk1']";
	   objXPath = objXPath.replaceAll("<REPLACE>", storeAdminEmail);
	  return driver.findElement(By.xpath(objXPath));
	}
	
	@FindBy(xpath="//input[@value='Approve Selected']")
	public WebElement storeApproveSelectedButton;
	
	@FindBy(xpath="//button[text()='Yes']")
	public WebElement yesButton;
	
	
}
