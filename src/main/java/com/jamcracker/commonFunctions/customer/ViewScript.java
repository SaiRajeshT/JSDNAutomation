package com.jamcracker.commonFunctions.customer;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.Reporter;

import com.jamcracker.constants.Constants;
import com.jamcracker.objectRepository.customer.ScriptingPage;
import com.jamcracker.utilities.TestBase;

public class ViewScript extends TestBase {
	public static void viewScript(String scriptName,String script) {
		ScriptingPage objScriptPage = new ScriptingPage();

		try {
			objScriptPage.manageLink.click();

			objScriptPage.scriptingLink.click();
			if (getDriver().getTitle().equals(Constants.MANAGE_SCRIPT_PAGE_TITLE)) {
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
			objScriptPage.getscriptAction(scriptName).click();
			String scriptStatus = objScriptPage.getScriptStatus(scriptName);
			objScriptPage.viewScriptLink.click();
			if(objScriptPage.cancelButton.isDisplayed())
			{
				Reporter.log("Successfully Clicked on View Option for"+scriptStatus+" script and navigated to view Script Page.");
			}
			
			if(objScriptPage.scriptTextBox.getText().contains(script))
			{
				Reporter.log("Script is present");
			}
			else{
				Reporter.log("<p style='color:red'>Issue while viewing saved script. Please look to the issue</p>");
				Assert.fail();
			}
			
		objScriptPage.cancelButton.click();
		if (getDriver().getTitle().equals(Constants.MANAGE_SCRIPT_PAGE_TITLE)) {
			Reporter.log("Successfully Navigated Back to  Manage Script Page");
		}

		else {
			Reporter.log(
					"<p style='color:red'>Issue while Navigating to Manage script Page. Look in to the issue. </p>");
			Assert.fail();
		}
		} 
		catch (Exception e) {
			Reporter.log("<p style = 'color:red'>Issue while viewing saved script. Please look in to the issue.</p>");
			e.printStackTrace();
			Assert.fail();

		}
	}

}
