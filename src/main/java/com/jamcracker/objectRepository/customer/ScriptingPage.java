package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class ScriptingPage extends TestBase {
	
	public ScriptingPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Manage")
	public WebElement manageLink;
	
	
	@FindBy(partialLinkText="scripting")
	public WebElement scriptingLink;
	
	@FindBy(xpath="//a[@title='Add Script']")
	public WebElement addScript;
	
	@FindBy(name="googlesearch")
	public WebElement scriptSearchTextBox;
	
	@FindBy(xpath="//div[@id='viewDetailsVol']//div[text()='Go']")
	public WebElement goButton;
	
	@FindBy(xpath="//form[@id='addscriptAction']//select[@name='scriptProvider']")
	public WebElement providerDropDown;
	
	
	@FindBy(xpath="//form[@id='addscriptAction']//select[@name='scriptResource']")
	public WebElement resourceTypeDropDown;
	
	@FindBy(xpath="//form[@id='addscriptAction']//select[@name='ActionDropDown']")
	public WebElement templateDropDown;
	
	@FindBy(xpath="//div[@id='addScriptUsing']//input[@name='addScriptName']")
	public WebElement scriptNameTextBox;
	
	@FindBy(xpath="//div[@id='addScriptUsing']//textarea")
	public WebElement scriptAreaTextBox;
	
	@FindBy(id="addScripting-submit")
	public WebElement scriptSaveButton;
	
	@FindBy(id="addScripting-execute")
	public WebElement scriptExecuteButton;
	
	@FindBy(id="addScripting-reset")
	public WebElement scriptCancelButton;
	
	@FindBy(xpath="//div[@id='viewDetailsVol']//img[@class='mSettingIcn']")
	public WebElement settingIcon;
	
	@FindBy(linkText="Edit")
	public WebElement EditScript;
	
	@FindBy(linkText="Execute")
	public WebElement executeScript;
	
	@FindBy(linkText="Delete")
	public WebElement DeleteScript;
	
	
	public WebElement scriptAction(String scriptName){
		
		return driver.findElement(By.xpath("//table[@id='viewDetailsVol_main']//div[text()='"+scriptName+"']//parent::td//following-sibling::td[contains(text(),'Action')]"));
	}
	
	public String getScriptStatus(String scriptName)
	{
		return driver.findElement(By.xpath("//td[div[text()='"+scriptName+"']]//following-sibling::td[6]")).getText();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
