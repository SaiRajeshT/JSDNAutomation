package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class MemberManagementPage extends TestBase
{
	  public MemberManagementPage()
	  {
		  PageFactory.initElements(driver, this);
		  
	  }
	  
	 @FindBy(xpath="//a[contains(text(),'Member Management')]")
	 public WebElement memberManagementLink;
	 
	 @FindBy(xpath="//a[contains(text(),'Stores')]")
	 public WebElement storeLink;
	 
	 @FindBy(id="searchValue")
	 public WebElement searchTextBox;
	 
	 @FindBy(xpath="//button[contains(text(),'Go')]")
	 public WebElement goButton;
	 
	 @FindBy(xpath="//input[@value='Add']")
	 public WebElement addStoreButton;
	 
	 @FindBy(name="companyName")
	 public WebElement companyNameTextBox;
	 
	 @FindBy(name="companyAcronym")
	 public WebElement companyAcronymTextBox;
	 
	 
	 @FindBy(name="companyURL")
	 public WebElement companyURLTextBox;
	 
	 @FindBy(name="companyLogo")
	 public WebElement companyLogoButton;

	 @FindBy(id="companyDesc")
	 public WebElement companyDescTextBox;
	 
	 @FindBy(name="addressLine1")
	 public WebElement addressLine1TextBox;
	 
	 @FindBy(name="addressLine2")
	 public WebElement addressLineT2extBox;
	 
	 @FindBy(name="addressLine3")
	 public WebElement addressLine3TextBox;
	 
	 @FindBy(name="country")
	 public WebElement countryDropdown;
	 
	 @FindBy(name="state")
	 public WebElement stateDropdown;
	 
	 @FindBy(name="city")
	 public WebElement cityTextBox;
	 
	 @FindBy(name="zip")
	 public WebElement zipCodeTextBox;
	 
	 @FindBy(name="firstName")
	 public WebElement firstNameTextBox;
	 
	 @FindBy(name="lastName")
	 public WebElement lastNameTextBox;
	 	 
	 @FindBy(name="emailAddress")
	 public WebElement emailAddressTextBox;
	 
	 @FindBy(name="phone")
	 public WebElement telephoneTextBox;
	 
	 @FindBy(name="fax")
	 public WebElement faxTextBox;
	 
	 @FindBy(name="timeZoneId")
	 public WebElement timeZoneDropDown;
	 
	 @FindBy(name="save")
	 public WebElement saveButton;

	 public WebElement getStoreName(String storeName)
	 
	 {
		 String objPath ="(//td[text()='<REPLACE>'])[1]//following-sibling::td[12][text()='New']";
		 objPath = objPath.replaceAll("<REPLACE>", storeName);
		return driver.findElement(By.xpath(objPath));
		 
	 }
	 
 public WebElement getcompanyAcronym(String companyAcronym)
	 
	 {
		 String objPath ="//td[text()='<REPLACE>']//following-sibling::td[text()='New']";
		 objPath = objPath.replaceAll("<REPLACE>", companyAcronym);
		return driver.findElement(By.xpath(objPath));
		 
	 }
	 
 public WebElement  getStoreStatus(String companyAcronym)
 {
	 String objPath="//td[text()='<REPLACE>']//following-sibling::td[10][text()='Active']" ;
	 objPath = objPath.replaceAll("<REPLACE>", companyAcronym);
	 System.out.println(objPath);
	 return driver.findElement(By.xpath(objPath));
 }

	
	 
	 

	 
	 
}
