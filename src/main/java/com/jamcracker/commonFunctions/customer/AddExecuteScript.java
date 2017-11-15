package com.jamcracker.commonFunctions.customer;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.Reporter;

import com.jamcracker.constants.Constants;
import com.jamcracker.objectRepository.customer.ScriptingPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class AddExecuteScript extends TestBase {
	
	
	public static void addExecuteScript(String provider,String resource,String template,String scriptName,String script){
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
		objScriptPage.scriptExecuteButton.click();
		
		objScriptPage.scriptSearchTextBox.sendKeys(scriptName);
		Thread.sleep(3000);
		objScriptPage.scriptSearchTextBox.sendKeys(Keys.ENTER);
		boolean test = true;
		long startTime = (System.currentTimeMillis()) / 1000;
		while (test) {
			if ((System.currentTimeMillis() / 1000) - startTime > timeout) {
				Reporter.log("<p style='color:red'>Waited for"+timeout+"  minutes Script status did not change to success or failure.Please check the issue.</p>");
				break;
			}
		if(objScriptPage.getScriptStatus(scriptName).equalsIgnoreCase("Success"))
		{
			Reporter.log("Script Execution completed.");
			break;
		}
		else if(objScriptPage.getScriptStatus(scriptName).equalsIgnoreCase("Failed"))
		{
			Reporter.log("<p style='color:red'>Script execution Failed. Look in to the logs for more information.</p>");
			objScriptPage.scriptAction(scriptName).click();
			Assert.fail();
		}
		}		
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
		Assert.fail();
	}
		
		
		
	}
	

}
