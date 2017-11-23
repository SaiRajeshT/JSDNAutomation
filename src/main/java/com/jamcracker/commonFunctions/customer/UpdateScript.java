package com.jamcracker.commonFunctions.customer;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.Reporter;

import com.jamcracker.constants.Constants;
import com.jamcracker.objectRepository.customer.ScriptingPage;
import com.jamcracker.utilities.TestBase;

public class UpdateScript extends TestBase {
	public static void getScriptUpdate(String scriptName,String script) {
		ScriptingPage objScriptPage = new ScriptingPage();
		String status = null ;
		try {
			objScriptPage.manageLink.click();

			objScriptPage.scriptingLink.click();
			if (driver.getTitle().equals(Constants.MANAGE_SCRIPT_PAGE_TITLE)) {
				Reporter.log("Successfully Navigated to Manage Script Page");
			}

			else {
				Reporter.log(
						"<p style='color:red'>Issue while Navigating to Manage script Page. Look in to the issue. </p>");
				Assert.fail();
			}
			
			objScriptPage.scriptSearchTextBox.sendKeys(scriptName);
			Thread.sleep(2000);
			objScriptPage.scriptSearchTextBox.sendKeys(Keys.ENTER);
			 status = objScriptPage.getScriptStatus(scriptName);
			objScriptPage.getscriptAction(scriptName).click();
			objScriptPage.EditScript.click();
			if(objScriptPage.scriptSaveButton.isDisplayed())
			{
				Reporter.log("Successfully Clicked on Edit Option for saved script and navigated to Update Script Page.");
			}
			
			objScriptPage.addscriptAreaTextBox.sendKeys(script);
			objScriptPage.scriptSaveButton.click();
			objScriptPage.scriptSearchTextBox.sendKeys(scriptName);
			Thread.sleep(2000);
			objScriptPage.scriptSearchTextBox.sendKeys(Keys.ENTER);
			objScriptPage.getscriptAction(scriptName).click();
			objScriptPage.viewScriptLink.click();
			if(objScriptPage.addscriptAreaTextBox.getText().contains(script))
			{
				Reporter.log("Script" + scriptName+" Updated successfully");
			}
			else{
				Reporter.log("<p style='color:red'>Issue while updating"+status+" Script" + scriptName+". Please look to the issue</p>");
				Assert.fail();
			}
			
		} 
		catch (Exception e) {
			Reporter.log("<p style = 'color:red'>Issue while updating"+status+" Script" + scriptName+". Please look to the issue</p>");
			e.printStackTrace();
			Assert.fail();

		}
	}

}
