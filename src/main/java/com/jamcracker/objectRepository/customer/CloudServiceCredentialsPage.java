package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class CloudServiceCredentialsPage extends TestBase {
	
	public CloudServiceCredentialsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Add Cloud Service Credentials')]")
	public WebElement addCloudServiceCredentialsButton;
	
	@FindBy(id="providers")
	public WebElement cloudProviderDropDown;
	
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
	
	@FindBy(id="save")
	public WebElement saveButton;
	
	@FindBy(id="cancel")
	public WebElement cancelButton;
	
	@FindBy(id="update")
	public WebElement updateButton;
	
	@FindBy(id="accountIDLabelMessage")
	public WebElement accountIDLabel;

}
