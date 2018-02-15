package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class SmartDashboardPage extends TestBase {

	public SmartDashboardPage(){
		PageFactory.initElements(driver, this);
			}
	@FindBy(xpath="//a[contains(text(),'Dashboard')]")
	public WebElement selectDashboard;
	
	@FindBy(xpath="//a[contains(text(),'Smartboard')]")
	public WebElement smartDashboard;
	
	public WebElement gettingStartedLink(String offerName){
	String requiredXpath = "//span[contains(text(),'needsSubstitution')]//..//..//a[contains(text(),'Getting Started')]";
	return 	driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", offerName)));
	}
	
	@FindBy(xpath="//div[@id='header_popUpId']//following::a[@id='consentLinkId']")
	public WebElement provideConsentLink;
  
	@FindBy(xpath="//input[@name='loginfmt']")
	public WebElement enterEmailTextBox;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement nextButton;
	
	@FindBy(xpath="//input[@name='passwd']")
	public WebElement passwordTextBox;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement signInButton;
	
	@FindBy(xpath="//input[@id='currentPassword']")
	public WebElement currentPasswordTextBox;
	
	@FindBy(xpath="//input[@id='newPassword']")
	public WebElement newPasswordTextBox;
	
	@FindBy(xpath="//input[@id='confirmNewPassword']")
	public WebElement confirmNewPasswordTextBox;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement acceptButton;
	
	@FindBy(xpath="//input[@type='button']")
	public WebElement noButton;
	
	@FindBy(xpath="//div[@id='header_popUpId']//following::span[contains(text(),'Close')]")
	public WebElement closeButton;
	
	
	
	


}

	
	
	

