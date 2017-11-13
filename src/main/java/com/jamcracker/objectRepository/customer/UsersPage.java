package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class UsersPage extends TestBase {

	public UsersPage(){
		PageFactory.initElements(driver, this);
			}
	
	@FindBy(linkText="Manage")
	public WebElement manageLink;
	
	@FindBy(linkText="Users")
	public WebElement UsersLink;
	
	@FindBy(id="addUser")
	public WebElement addUserLink;
	
	
	@FindBy(id="firstName")
	public WebElement firstNameTextBox;
	
	@FindBy(id="lastName")
	public WebElement lastNameTextBox;
	
	@FindBy(id="email")
	public WebElement emailTextBox;
	
	@FindBy(id="contactPhone")
	public WebElement contactPhoneTextBox;
	
	@FindBy(id="role")
	public WebElement roleDropDown;
	
	
	@FindBy(id="department")
	public WebElement departmentDropDown;
	
	@FindBy(id="saveexit")
	public WebElement saveAndExitButton;
	
	@FindBy(id="searchString")
	public WebElement assignSubscriptionSearchTextBox;
	
	@FindBy(id="sNext")
	public WebElement saveAndNextButton;
	
	
	public WebElement getAction(String email)
	{
		return driver.findElement(By.xpath("//td[text()='"+email+"']//following-sibling::td//span[contains(text(),'Actions')]"));
	}
	
	public WebElement selectOfferCheckBox(String offerName)
	{
		return driver.findElement(By.xpath("//span[@title='"+offerName+"']//preceding-sibling::input[@type='checkbox']"));
	}
	
	
	@FindBy(id="siteDropDown")
	public WebElement siteDropDown;
	
	@FindBy(id="calling")
	public WebElement callingDropDown;
	
	@FindBy(id="language")
	public WebElement languageDropDown;
	
	@FindBy(id="mobileid")
	public WebElement mobileNoTextBox;
	
	@FindBy(id="phoneType")
	public WebElement phoneTypeDropdown;
	
	@FindBy(id="phoneNumber")
	public WebElement phoneNumberDropdown;
	
	@FindBy(id="btnSaveFinish")
	public WebElement saveAndFinishButton;
	
	@FindBy(linkText="Assign Subscriptions")
	public WebElement assignSubscription;
	
	@FindBy(linkText="View Subscriptions")
	public WebElement viewSubscription;
	
	
	@FindBy(xpath="//div[@class='notify-msg']")
	public WebElement successMsgBar;
	
	@FindBy(id="phoneid")
	public WebElement phoneName;
	
	@FindBy(xpath="//div[@class='notify-msg']")
	public WebElement successMsg;
	
	@FindBy(id="table_search")
	public WebElement userSearchTextBox;
	
	public String getofferStatus(String offerName)
	{
		return driver.findElement(By.xpath("//td[text()='"+offerName+"']//following-sibling::td//span")).getText();
	}
	
	
	
	
}
