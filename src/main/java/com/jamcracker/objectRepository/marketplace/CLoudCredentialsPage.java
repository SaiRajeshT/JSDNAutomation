package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class CLoudCredentialsPage extends TestBase {
	
	public CLoudCredentialsPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id="addButton")
	public WebElement addCredentialsButton;
	
	@FindBy(id="providers")
	public WebElement cloudProviderDropDown;
	
	@FindBy(id="isvAccountType")
	public WebElement accountTypeDropDown;
	
	@FindBy(id="isvAccountId")
	public WebElement accountIDTextBox;
	
	@FindBy(name="username")
	public WebElement userNameTextBox;
	
	@FindBy(name="password")
	public WebElement passwordTextBox;
	
	@FindBy(name="secretKey")
	public WebElement secretKeyTextBox;
	
	@FindBy(name="accessKey")
	public WebElement accessKeyTextBox;
	
	@FindBy(name="BUCKETNAME")
	public WebElement bucketNameTextBox;
	
	@FindBy(name="usageFileName")
	public WebElement usageFileNameTextBox;
	
	@FindBy(xpath="//input[@id='save']")
	public WebElement saveButton;
	
	@FindBy(xpath="//button[@id='save']")
	public WebElement saveButton1;
	
	@FindBy(name="cancel")
	public WebElement cancelButton;
	
	@FindBy(name="_iframe-addAccDtlsWindow")
	public WebElement credentialsFrame;
	
	@FindBy(linkText="Cloud Service Credentials")
	public WebElement cloudServiceCredentialsLink;
	
	@FindBy(id="accountIDLabelMessage")
	public WebElement accountIDLabel;
	
	public WebElement validateIcon(String accountID) {
		return getDriver().findElement(By.xpath("//tr[td[@title='"+accountID+"']]//td/a/img[@title='Validate']"));
	}
	
	public WebElement credStatus(String accountID) {
		return getDriver().findElement(By.xpath("//tr[td[@title='"+accountID+"']]//td[text()='Active']"));
	}
	
	public WebElement credFailedStatus(String accountID) {
		return getDriver().findElement(By.xpath("//tr[td[@title='"+accountID+"']]//td[text()='Authorization Failed']"));
	}

}
