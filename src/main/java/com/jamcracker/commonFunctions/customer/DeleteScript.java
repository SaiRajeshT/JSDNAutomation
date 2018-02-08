package com.jamcracker.commonFunctions.customer;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.Reporter;

import com.jamcracker.constants.Constants;
import com.jamcracker.objectRepository.customer.ScriptingPage;
import com.jamcracker.utilities.TestBase;

public class DeleteScript extends TestBase {

	public static void deleteScript(String scriptName) {
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
		objScriptPage.deleteLink.click();
		
		if(!objScriptPage.getscriptAction(scriptName).isDisplayed())
			{
			Reporter.log("Script Template deleted successfully.");
			}
		
		}

		catch (Exception e) {
			Reporter.log("<p style='color:red'>Issue while deleting the script. Please look in to the issue.</p>");
			e.printStackTrace();
			Assert.fail();
		}

	}

}
