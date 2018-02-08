package com.jamcracker.commonFunctions.customer;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.Reporter;

import com.jamcracker.objectRepository.customer.InstancesPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class StartInstance extends TestBase {

	public void startInstance(String instName) {
		try {
			InstancesPage objinstancePage = new InstancesPage();
			objinstancePage.manageLink.click();
			objinstancePage.instancesLink.click();
			explicitWait(objinstancePage.searchTextBox);
			HandleDropDown.selectDDLByValue(objinstancePage.searchDropDown, "name");
			objinstancePage.searchTextBox.clear();
			objinstancePage.searchTextBox.sendKeys(instName);
			Thread.sleep(2000);
			objinstancePage.searchTextBox.sendKeys(Keys.RETURN);

			try {
				Thread.sleep(3000);
				objinstancePage.getInstanceActionLink(instName).click();

			} catch (Exception e) {

			}

			objinstancePage.startLink.click();
			Reporter.log("Clicked on start link for instance.");
			if (getDriver().getPageSource().contains(
					"Starting the Instance. This may take a few minutes to have the VM up and running.") == true) {
				Reporter.log("Instance started successfully.");
			}
			explicitWait(objinstancePage.searchTextBox);
			HandleDropDown.selectDDLByValue(objinstancePage.searchDropDown, "name");
			objinstancePage.searchTextBox.clear();
			objinstancePage.searchTextBox.sendKeys(instName);
			Thread.sleep(3000);
			objinstancePage.searchTextBox.sendKeys(Keys.ENTER);

			// boolean test =
			// objinstancePage.getRunningInstance(instName).isDisplayed();
			boolean test = true;
			long startTime = (System.currentTimeMillis()) / 1000;
			while (test) {
				if ((System.currentTimeMillis() / 1000) - startTime > timeout) {
					Reporter.log("<p style='color:red'>Waited for"+timeout+" Seconds.Instance status did not go to Running.Please check the issue.</p>");
					Assert.fail();
					break;
				}
				try {

					explicitWait(objinstancePage.showingText);
					if (objinstancePage.getRunningInstance(instName).isDisplayed() == true) {
						test = false;
						Reporter.log("Instance is Present in running status.");
					}
				}

				catch (Exception e) {
					Thread.sleep(15000);
					explicitWait(objinstancePage.searchTextBox);
					HandleDropDown.selectDDLByValue(objinstancePage.searchDropDown, "name");
					objinstancePage.searchTextBox.clear();
					objinstancePage.searchTextBox.sendKeys(instName);
					Thread.sleep(3000);
					objinstancePage.searchTextBox.sendKeys(Keys.ENTER);
				}
			}
		} catch (Exception emsg) {
			emsg.printStackTrace();
			Reporter.log("<p style='color:red'>Issue while starting the server. Please look in to the issue.</p>");
			Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(emsg)+"</p>");
			Assert.fail();
		}
	}

}
