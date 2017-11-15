package com.jamcracker.commonFunctions.customer;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.Reporter;

import com.jamcracker.constants.Constants;
import com.jamcracker.objectRepository.customer.ScriptingPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class AddSaveScript extends TestBase {
	
	
	public static void addScript(String provider,String resource,String template,String scriptName,String script){
		ScriptingPage objScriptPage = new ScriptingPage();
	try{	objScriptPage.manageLink.click();
		objScriptPage.scriptingLink.click();
	if(driver.getTitle().equals(Constants.MANAGE_SCRIPT_PAGE_TITLE))
	{
		Reporter.log("Successfully Navigated to Manage Script Page");
	}
	
	else{
		Reporter.log("<p style='color:red'>Issue while Navigating to Manage script Page. Look in to the issue. </p>");
		Assert.fail();
		}
	if( objScriptPage.addScript.isDisplayed())
	{
		Reporter.log("Add script Icon is displayed ");
	}
	else{
			Reporter.log("<p style='color:red'>Add script Icon is not displayed. Please look in to the issue.</p>");
			Assert.fail();
		}
	objScriptPage.addScript.click();
	if(driver.getTitle().equalsIgnoreCase(Constants.ADD_SCRIPT_PAGE_TITLE))
	{
		Reporter.log("Add script Page is displayed");
	}
	else{
		Reporter.log("<p style='color:red'>Add script page is not displayed. Please look in to the issue.</p>");
		Assert.fail();
	}
	
	
		HandleDropDown.selectDDLByVisibletext(objScriptPage.providerDropDown, provider);
		if (HandleDropDown.getSelectedValue(objScriptPage.providerDropDown).equalsIgnoreCase(provider))
		{
			Reporter.log(provider+" provider is selected for creating script.");
		}
	
		else{
		Reporter.log("<p style='color:red'>Issue while selecting the Vendor dropdown.</p>");
		Assert.fail();}
	
	
	
		HandleDropDown.selectDDLByVisibletext(objScriptPage.resourceTypeDropDown, resource);
		if(HandleDropDown.getSelectedValue(objScriptPage.resourceTypeDropDown).equalsIgnoreCase(resource))
		{
			Reporter.log(resource +"Is selected as resource");
		}
		else{
			Reporter.log("<p style='color:red'>Issue while selecting values in Using dropdown.</p>");
			Assert.fail();
			}
		

	
		HandleDropDown.selectDDLByVisibletext(objScriptPage.templateDropDown, template);
		if(HandleDropDown.getSelectedValue(objScriptPage.templateDropDown).equalsIgnoreCase(template)){
			Reporter.log(template + "Is selected as template");
		}
		else{
			Reporter.log("<p style='color:red'>Issue while selecting values from template dropdown.</p>");
		}
		objScriptPage.scriptNameTextBox.sendKeys(scriptName);
		objScriptPage.scriptAreaTextBox.sendKeys(script);
		objScriptPage.scriptSaveButton.click();
		
		objScriptPage.scriptSearchTextBox.sendKeys(scriptName);
		objScriptPage.scriptSearchTextBox.sendKeys(Keys.ENTER);
		if(objScriptPage.getScriptStatus(scriptName).equalsIgnoreCase("Saved"))
		{
			Reporter.log("Script Added successfully and its present in Saved Status.");
		}
		else
		{
			Reporter.log("<p style='color:red'>Issue while adding script.");
			Assert.fail();
		}
		
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
		Assert.fail();
	}
		
		
		
	}
	

}
