package com.jamcracker.commonFunctions.customer;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.objectRepository.customer.InstancesPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class DetachAndTerminateVolume extends TestBase {

	public void deleteVolume(String instName, String volumeName) {

		try {
			InstancesPage objinstancePage = new InstancesPage();
			objinstancePage.manageLink.click();
			objinstancePage.instancesLink.click();
			explicitWait(objinstancePage.searchTextBox);
			HandleDropDown.selectDDLByValue(objinstancePage.searchDropDown, "name");
			objinstancePage.searchTextBox.clear();
			objinstancePage.searchTextBox.sendKeys(instName);
			Thread.sleep(3000);
			objinstancePage.searchTextBox.sendKeys(Keys.ENTER);
			explicitWait(objinstancePage.showingText);
			objinstancePage.getInstanceActionLink(instName).click();
			objinstancePage.viewDetaisLink.click();
			objinstancePage.volumeTab.click();
			explicitWait(objinstancePage.showingText);
			objinstancePage.getVolumeActionLink(volumeName).click();
			objinstancePage.detachTerminateVolumeLink.click();
			explicitWait(objinstancePage.volumeDetachConfirmButton);
			objinstancePage.volumeDetachConfirmButton.click();

			boolean test = true;
			long startTime = (System.currentTimeMillis()) / 1000;
			while (test) {
				if ((System.currentTimeMillis() / 1000) - startTime > timeout) {
					Reporter.log("<p style='color:red'>Waited for" + timeout
							+ " Seconds.Volume status did not go to Active.Please check the issue.</p>");
					Assert.fail();
					break;
				}

				objinstancePage.searchTextBox.clear();
				objinstancePage.searchTextBox.sendKeys(volumeName);
				Thread.sleep(3000);
				objinstancePage.searchTextBox.sendKeys(Keys.ENTER);
				try {
					explicitWait(objinstancePage.showingText);
				} catch (Exception e) {
				}
				if (objinstancePage.getDetachVolumeStatus(volumeName)) {
					continue;

				} else {
					objinstancePage.attachExistingVolumeLink.click();
					explicitWait(objinstancePage.existingVolumeSearchBox);
					objinstancePage.existingVolumeSearchBox.clear();
					objinstancePage.existingVolumeSearchBox.sendKeys(volumeName);
					Thread.sleep(3000);
					objinstancePage.existingVolumeSearchBox.sendKeys(Keys.ENTER);
					if (objinstancePage.getExistingVolumeStatus(volumeName) == false) {
						//objinstancePage.existingVolumeSearchBox.sendKeys(volumeName);
						objinstancePage.closePouUp.click();
						Reporter.log("Detach volume is successfull.");
					}
					else{
						Reporter.log("<p style='color:red'> Detach and Terminate Volume is failed. please look in to the issue.</p>");
						Assert.fail();
						
					}
					break;
				}

			}
		}

		catch (Exception e) {
			e.printStackTrace();
			Reporter.log("<p style='color:red'> Detach and Terminate Volume is failed. please look in to the issue.</p>");
			Assert.fail();
		}

	}

}
