package com.jamcracker.commonFunctions.customer;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.Reporter;

import com.jamcracker.objectRepository.customer.InstancesPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class StopInstance extends TestBase {

	public void stopInstance(String instName) {
		try {
			InstancesPage objinstancePage = new InstancesPage();
			objinstancePage.manageLink.click();
			objinstancePage.instancesLink.click();
			explicitWait(objinstancePage.searchTextBox);
			HandleDropDown.selectDDLByValue(objinstancePage.searchDropDown, "name");
			objinstancePage.searchTextBox.clear();
			objinstancePage.searchTextBox.sendKeys(instName);
			Thread.sleep(3000);
			objinstancePage.searchTextBox.sendKeys(Keys.RETURN);

			try {
				Thread.sleep(3000);
				objinstancePage.getInstanceActionLink(instName).click();

			} catch (Exception e) {

				objinstancePage.getMonitorInstanceActionLink(instName).click();
			}

			objinstancePage.stopLink.click();
			if (driver.getPageSource()
					.contains("Stopping the Instance. This may take a few minutes for the VM to shut down") == true) {
				Reporter.log("Instance stoped successfully");
			}
			explicitWait(objinstancePage.searchTextBox);
			HandleDropDown.selectDDLByValue(objinstancePage.searchDropDown, "name");
			objinstancePage.searchTextBox.clear();
			objinstancePage.searchTextBox.sendKeys(instName);
			Thread.sleep(3000);
			objinstancePage.searchTextBox.sendKeys(Keys.ENTER);
			boolean test = true;
			long startTime = (System.currentTimeMillis()) / 1000;
			while (test) {
				if ((System.currentTimeMillis() / 1000) - startTime > timeout) {
					Reporter.log("<p style='color:red'Waited for"+timeout+"  minutes instance status did not change to stopped.Please check the issue.<p>");
					break;
				}
				try {

					explicitWait(objinstancePage.showingText);
					if (objinstancePage.getStoppedInstance(instName).isDisplayed() == true) {
						test = false;
						Reporter.log("Instance is Present in Stopped status");
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
			Assert.fail();
		}
	}

}
