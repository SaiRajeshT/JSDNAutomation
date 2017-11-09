package com.jamcracker.commonFunctions.customer;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.objectRepository.customer.AppstackPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class TerminateStack extends TestBase {
	
	public void terminateStack(String stackName,String action){
		
		try {
			AppstackPage objstackPage = new AppstackPage();
			objstackPage.manageLink.click();
			objstackPage.appStacksLink.click();;
			explicitWait(objstackPage.searchTextBox);
			HandleDropDown.selectDDLByValue(objstackPage.searchDropDown, "name");
			objstackPage.searchTextBox.clear();
			objstackPage.searchTextBox.sendKeys(stackName);
			Thread.sleep(2000);
			objstackPage.searchTextBox.sendKeys(Keys.RETURN);
			try {
				Thread.sleep(3000);
				objstackPage.getStackActionLink(stackName).click();

			} catch (Exception e) {
				
				Reporter.log("<p style='color:red'>Action link is not clickable. Please look in to the issue.</p>");
				Assert.fail();
			}

			objstackPage.terminateLink.click();
			explicitWait(objstackPage.confirmButton);
			objstackPage.confirmButton.click();
			if (driver.getPageSource().contains(
					"The stack termination process is initiated") == true) {
				Reporter.log("Stack Termination intiated.");
			}
			explicitWait(objstackPage.searchTextBox);
			HandleDropDown.selectDDLByValue(objstackPage.searchDropDown, "name");
			objstackPage.searchTextBox.clear();
			objstackPage.searchTextBox.sendKeys(stackName);
			Thread.sleep(3000);
			objstackPage.searchTextBox.sendKeys(Keys.ENTER);

			// boolean test =
			// objstackPage.getRunningStack(stackName).isDisplayed();
			boolean test = true;
			long startTime = (System.currentTimeMillis()) / 1000;
			while (test) {
				if ((System.currentTimeMillis() / 1000) - startTime > timeout) {
					Reporter.log("<p style='color:red'>Waited for"+timeout+" Seconds.Stack is not terminated.Please check the issue.<p>");
					Assert.fail();
					break;
				}
				try {

					explicitWait(objstackPage.showingText);
					if (objstackPage.getRunningstack(stackName).isDisplayed() == true) {
						test = false;
						Reporter.log("Stack is Present in Terminated status.");
					}
				}

				catch (Exception e) {
					Thread.sleep(15000);
					explicitWait(objstackPage.searchTextBox);
					HandleDropDown.selectDDLByValue(objstackPage.searchDropDown, "name");
					objstackPage.searchTextBox.clear();
					objstackPage.searchTextBox.sendKeys(stackName);
					Thread.sleep(3000);
					objstackPage.searchTextBox.sendKeys(Keys.ENTER);
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
