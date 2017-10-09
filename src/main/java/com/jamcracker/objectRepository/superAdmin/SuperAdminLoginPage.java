package com.jamcracker.objectRepository.superAdmin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class SuperAdminLoginPage extends TestBase
{
	public SuperAdminLoginPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="superAdminEmail")
	public WebElement superAdminEmailTextBox;
	
	@FindBy(name="superAdminPassword")
	public WebElement superAdminPasswordTextBox;
	
	@FindBy(xpath="//button[text()='Login']")
	public WebElement superAdminLoginButton;
	
	@FindBy(linkText="Logout")
	public WebElement superAdminLogOutLink;

}
