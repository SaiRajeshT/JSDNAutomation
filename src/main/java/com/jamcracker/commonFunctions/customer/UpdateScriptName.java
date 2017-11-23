package com.jamcracker.commonFunctions.customer;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.Reporter;

import com.jamcracker.constants.Constants;
import com.jamcracker.objectRepository.customer.ScriptingPage;
import com.jamcracker.utilities.TestBase;

public class UpdateScriptName extends TestBase {

	public static void getScriptNameUpdate(String scriptName) {
		ScriptingPage objScriptPage = new ScriptingPage();
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
			objScriptPage.EditScript.click();
			explicitWait(objScriptPage.SaveButton);
			objScriptPage.scriptNameTextBox.sendKeys(scriptName);
			objScriptPage.scriptSaveButton.click();
			objScriptPage.scriptSearchTextBox.sendKeys(scriptName);
			Thread.sleep(2000);
			objScriptPage.scriptSearchTextBox.sendKeys(Keys.ENTER);
			if (objScriptPage.getScriptStatus(scriptName).equalsIgnoreCase("Saved")) {
				Reporter.log("Script"+ scriptName+" Updated successfully and its present in Saved Status.");
			} else {
				Reporter.log("<p style='color:red'>Issue while Updating  Script Name. Please look in to the issue.</p>");
				Assert.fail();
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			Reporter.log("<p style='color:red'>Issue while Updating  Script Name.Please look in to the issue.</p>");
			Assert.fail();
		}

	}

}
