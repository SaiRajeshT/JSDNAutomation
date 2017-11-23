package com.jamcracker.objectRepository.customer;


import java.util.List;

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
	public WebElement addscriptAreaTextBox;
	
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
	
	
	public WebElement getscriptAction(String scriptName){
		
		return driver.findElement(By.xpath("//table[@id='viewDetailsVol_main']//div[text()='"+scriptName+"']//parent::td//following-sibling::td[contains(text(),'Action')]"));
	}
	
	public String getScriptStatus(String scriptName)
	{
		return driver.findElement(By.xpath("//td[div[text()='"+scriptName+"']]//following-sibling::td[6]")).getText();
	}
	
	
	public List<WebElement> getActions()
	{
		return driver.findElements(By.xpath("//div[@class='actionhover']//a"));
	}
	
	@FindBy(linkText="View Log")
	public WebElement viewLogLink;
	
	@FindBy(id="pop_title")
	public WebElement viewLogPopUp;
	
	@FindBy(xpath="//p[text()='Success!']")
	public WebElement successMsg;
	
	@FindBy(xpath="//p[text()='Failure!']")
	public WebElement failureMsg;
	
	@FindBy(linkText="View Script")
	public WebElement viewScriptLink;
	
	@FindBy(linkText="Delete")
	public WebElement deleteLink;
	
	@FindBy(xpath="//form[@id='viewLogForm']//div/p[1])")
	public WebElement logStatus;
	
	@FindBy(id="ViewLog-reset")
	public WebElement viewLogCancelButton;
	
	@FindBy(id="viewScript-reset")
	public WebElement viewScriptCancelButton;
	
	@FindBy(id="editScript-submit")
	public WebElement updateScriptSaveButton;
	
	@FindBy(id="editScript-execute")
	public WebElement updateScriptExecuteButton;
	
	@FindBy(id="editScript-reset")
	public WebElement updateScriptCancelButton;
	
	@FindBy(xpath="//span[text()='Execute']")
	public WebElement executeButton;
	
	@FindBy(xpath="//span[text()='Save']")
	public WebElement SaveButton;
	
	@FindBy(xpath="//span[text()='Execute']")
	public WebElement cancelButton;
	
	@FindBy(xpath="//textarea")
	public WebElement scriptTextBox;
	
	public String getTemplateName(String scriptName)
	{
		return driver.findElement(By.xpath("//div[text()='"+scriptName+"']//parent::td//following-sibling::td[4]")).getText();
	}
	public List<WebElement> getLog()
	{
		return driver.findElements(By.xpath("//p[text()='Success!']//following::li"));
	}
	
	
	
	
	
	
	

}
