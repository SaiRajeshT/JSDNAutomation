package com.jamcracker.commonFunctions.customer;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.jamcracker.constants.Constants;
import com.jamcracker.objectRepository.customer.ScriptingPage;
import com.jamcracker.utilities.TestBase;

public class ViewScriptLog extends TestBase {
	public static void getScriptLog(String scriptName,String script) {
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
			
			objScriptPage.getscriptAction(scriptName).click();
			objScriptPage.viewLogLink.click();
			explicitWait(objScriptPage.viewLogPopUp);
			if(objScriptPage.viewLogPopUp.getText().equalsIgnoreCase("View Log"))
			{
				Reporter.log("Successfully Clicked on View Log for" +objScriptPage.getScriptStatus(scriptName)+"  script and navigated to view Log Page.");
			}
			 Reporter.log(objScriptPage.logStatus.getText());
			List<WebElement> textList = objScriptPage.getLog();
			for(WebElement element : textList)
			{
				Reporter.log(element.getText());
			}
			
			//If we need to compare the script log then we have to write it here
			
			
			objScriptPage.cancelButton.click();
			if (driver.getTitle().equals(Constants.MANAGE_SCRIPT_PAGE_TITLE)) {
				Reporter.log("Successfully Navigated back to Manage Script Page");
			}

			else {
				Reporter.log(
						"<p style='color:red'>Issue while Navigating to Manage script Page. Look in to the issue. </p>");
				Assert.fail();
			}
			
		} 
		catch (Exception e) {
			Reporter.log("<p style = 'color:red'>Issue while viewing logs for "+objScriptPage.getScriptStatus(scriptName)+" script. Please look in to the issue.</p>");
			e.printStackTrace();
			Assert.fail();

		}
	}

}
