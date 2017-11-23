package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.By;
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
	
	public WebElement authorizationStatus(String accountId) {
		return driver.findElement(By.xpath("//td[text()='"+accountId+"']//following-sibling::td//span[@title='Waiting for Authorization']"));
	}
	
	public WebElement activeStatus(String accountId) {
		return driver.findElement(By.xpath("//td[text()='"+accountId+"']//following-sibling::td[contains(text(),'Active')]"));
	}
	
	@FindBy(id="table_search")
	public WebElement searchBox;
	
	@FindBy(xpath="//div[contains(text(),'Go')]")
	public WebElement goButton;
	
	public WebElement actionLink(String accountId) {
		return driver.findElement(By.xpath("//td[text()='"+accountId+"']//following-sibling::td[contains(@class,'lastaction')]//span"));
	}
	
	@FindBy(linkText="Validate")
	public WebElement validateLink;
	
	@FindBy(name="BUCKETNAME")
	public WebElement bucketNameTextBox;
	
	@FindBy(name="usageFileName")
	public WebElement usageFileNameTextBox;
	
	@FindBy(id="isvAccountType")
	public WebElement accountTypeDropDown;

}