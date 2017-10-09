package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jamcracker.utilities.TestBase;

public class MarketplaceHomePage extends TestBase {
	String objXPath;
	public MarketplaceHomePage() {		
		PageFactory.initElements(driver, this);
	}
	
	public void waitForMpHomePage() {		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wrapper")));
	}
	
	
	@FindBy(linkText = "Home")
	public WebElement homeLink;
	
	@FindBy(linkText="Marketplace")
	public WebElement marketplaceLink;
	
	@FindBy(linkText = "IaaS")
	public WebElement IaaSConsoleLink;
	
	@FindBy(linkText = "Administration")
	public WebElement AdministrationLink;
	
	@FindBy(id="serviceSearchValue")
	public WebElement globalSearchTextBox;
	
	@FindBy(xpath="//img[@alt='Search']")
	public WebElement searchIcon;
	
	@FindBy(xpath="//a[contains(text(),'My Company')]")
	public WebElement myCompanyLink;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	public WebElement logOutLink;
	
	@FindBy(xpath="//input[@value='Approve Selected']")
	public WebElement approveSelectedButton;
	
	@FindBy(xpath="//input[@value='View All']//parent::td//following-sibling::td//input")
	public WebElement serviceApproveButton;
	
	@FindBy(xpath="//tbody[tr[td[span[contains(text(),'New Store Requests')]]]]//input[@value='Approve Selected']")
	public WebElement storeApproveSelectedButton;
	
	@FindBy(xpath="//button[text()='Yes']")
	public WebElement yesButton;
	
	@FindBy(xpath="//td[@title='Store Admin Email']//following-sibling::td//a[text()='Review']")
	public WebElement storeReviewLink;
	
	
	
	
	
	public WebElement companySelectCheckbox(String email)
	{
	   objXPath="//td[@title='<REPLACE>']//preceding-sibling::td//input[@name='chk1']";
	   objXPath = objXPath.replaceAll("<REPLACE>", email);
	  return driver.findElement(By.xpath(objXPath));
	}
	
	public WebElement serviceSelectCheckbox(String serviceName)
	{
	   objXPath="//td[@title='<REPLACE>']//preceding-sibling::td[4]//input";
	   objXPath = objXPath.replaceAll("<REPLACE>", serviceName);
	  return driver.findElement(By.xpath(objXPath));
	}
	
	
	public WebElement storeSelectCheckbox(String storeAdminEmail)
	{
	   objXPath="//tr[td[@title='<REPLACE>']]//input[@type='checkbox'][@name='chk1']";
	   objXPath = objXPath.replaceAll("<REPLACE>", storeAdminEmail);
	  return driver.findElement(By.xpath(objXPath));
	}
		
}
