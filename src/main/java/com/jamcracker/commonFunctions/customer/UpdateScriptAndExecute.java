package com.jamcracker.commonFunctions.customer;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.Reporter;

import com.jamcracker.constants.Constants;
import com.jamcracker.objectRepository.customer.ScriptingPage;
import com.jamcracker.utilities.TestBase;

public class UpdateScriptAndExecute extends TestBase {
	public static void getScriptUpdateAndExecute(String scriptName,String script) {
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
			objScriptPage.executeButton.click();
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
				objScriptPage.getscriptAction(scriptName).click();
				objScriptPage.viewLogLink.click();
				Assert.fail();
			}
			}		
			
		} 
		catch (Exception e) {
			Reporter.log("<p style = 'color:red'>Issue while updating"+status+" Script" + scriptName+". Please look to the issue</p>");
			e.printStackTrace();
			Assert.fail();

		}
	}

}
