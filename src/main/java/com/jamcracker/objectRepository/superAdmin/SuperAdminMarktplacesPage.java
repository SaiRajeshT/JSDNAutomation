package com.jamcracker.objectRepository.superAdmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class SuperAdminMarktplacesPage extends TestBase
{
	public SuperAdminMarktplacesPage()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[text()='Add Marketplace']")
	public WebElement addMarketplaceLink;

	@FindBy(xpath = "//input[@name='marketplaceURL']")
	public WebElement marketplaceUrlTextBox;

	@FindBy(name = "companyName")
	public WebElement companyNameTextBox;
	
	@FindBy(name="companyAcroName")
	public WebElement companyAcronymTextBox;
	
	@FindBy(name="rootUserMailId")
	public WebElement rootUserIdTextBox;
	
	@FindBy(name="rootUserPwd")
	public WebElement rootUserPasswordTextBox;
	
	
	@FindBy(name="rootUserPwdReconfirmation")
	public WebElement confirmPasswordTextBox;
	
	@FindBy(name="marketplaceFullName")
	public WebElement marketplaceFNameTextBox;
	
	@FindBy(name="marketplaceShortName")
	public WebElement marketPlaceSNameTextBox;
	
	
	@FindBy(name="marketplaceAcronym")
	public WebElement marketplaceAcronymTextBox;
	
	@FindBy(id="createMP")
	public WebElement createMarketplaceButton;
	
	public WebElement  getMarketplaceName(String marketplaceName)
	{
		return driver.findElement(By.xpath("//td[text()='"+marketplaceName+"']"));
	}
	
	public WebElement getMarketplaceProxy(String companyName)
	{
		String proxyObjPath = "//tr[td[text()='<REPLACE>']]//a[text()='Proxy']";
		proxyObjPath = proxyObjPath.replaceAll("<REPLACE>", companyName);
		return driver.findElement(By.xpath(proxyObjPath));
	}
	
	public WebElement getMarketplaceActivate(String companyAcronym)
	{
		String activateObjPath = "//tr[td[text()='<REPLACE>']]//img[@title='Click here to activate registration']";
		activateObjPath = activateObjPath.replaceAll("<REPLACE>", companyAcronym);
		return driver.findElement(By.xpath(activateObjPath));
	}
	
	
	@FindBy(linkText="Logout")
	public WebElement logOutLInk;
	
	

}
