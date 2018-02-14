package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class PivotpathPages extends TestBase {
   public PivotpathPages(){
   PageFactory.initElements(getDriver(), this);
  }
  
   @FindBy(name="companyAcronym")
   public WebElement organizationTextBox;
   
   @FindBy(name="username")
   public WebElement userNameTextBox;
   
   @FindBy(name="password")
   public WebElement passwordTextBox;
   
   @FindBy(xpath="//button[text()='Log In']")
   public WebElement loginButton;
   
   @FindBy(linkText="Administration")
   public WebElement administrationLink;
   
   @FindBy(linkText="Member Organizations")
   public WebElement memberOrgLink;
   
   @FindBy(name="searchValue")
   public WebElement searchTextBox;
   
   @FindBy(xpath="//button[text()='Search']")
   public WebElement searchButton;
   
   @FindBy(linkText="Organization Administration")
   public WebElement organizationAdminLink;
   
   @FindBy(linkText="Security Policy")
   public WebElement securityPolicyLink;
   
   @FindBy(name="captchaProcessReqd")
   public WebElement captchCheckbox;
   
   @FindBy(name="save")
   public WebElement SaveButton;
   
   @FindBy(linkText="Log Out")
   public WebElement logOutLink;
   
   @FindBy(linkText="Manage")
   public WebElement manageLink;
   
   
   public String getAdminPassword(){
	   return getDriver().findElement(By.xpath("//input[@id='adminPassword']")).getAttribute("value");
   }
   
   public String getAdminUserName(){
	   return getDriver().findElement(By.xpath("//input[@id='adminUserName']")).getAttribute("value");
   }
   
   public WebElement editService(String offerName)
   {
   return getDriver().findElement(By.xpath("//td[@title='"+offerName+"']//following-sibling::td//a//img[@title='Edit Service']"));
   }
   
   public WebElement getProxyLink(String acronym)
   {
    return getDriver().findElement(By.xpath("(//td[@title='"+acronym+"']//following-sibling::td/a[text()='Proxy'])[1]"));
   }
   
   
   
}