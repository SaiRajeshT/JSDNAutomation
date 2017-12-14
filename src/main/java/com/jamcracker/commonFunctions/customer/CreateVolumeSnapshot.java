package com.jamcracker.commonFunctions.customer;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.objectRepository.customer.InstancesPage;
import com.jamcracker.objectRepository.customer.VolSnapshotPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class CreateVolumeSnapshot extends TestBase {

	public void createVolumeSnapshot(String instName, String volumeName, String snapshotName, String snapshotDesc) {

		try {
			VolSnapshotPage objVolSnapshot = new VolSnapshotPage();
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
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 1300);");
			objinstancePage.createVolumeSnapshotLink.click();
			explicitWait(objinstancePage.volSnapshotNameTextBox);
			objinstancePage.volSnapshotNameTextBox.sendKeys(snapshotName);
			objinstancePage.volSnapShotDescriptionTextBox.sendKeys(snapshotDesc);
			objinstancePage.volSnapshotDoneButton.click();
			objVolSnapshot.volumeSnapshotPageLink.click();
			boolean test = true;
			long startTime = (System.currentTimeMillis()) / 1000;
			while (test) {
				if ((System.currentTimeMillis() / 1000) - startTime > timeout) {
					Reporter.log("<p style='color:red'>Waited for" + timeout
							+ " Seconds.Volume Snapshot status did not go to Active.Please check the issue.</p>");
					Assert.fail();
					break;
				}
				explicitWait(objVolSnapshot.searchTextBox);
				objVolSnapshot.searchTextBox.clear();
				objVolSnapshot.searchTextBox.sendKeys(snapshotName);
				objVolSnapshot.searchTextBox.sendKeys(Keys.ENTER);
				// explicitWait(objinstancePage.showingText);
				if (objVolSnapshot.getactiveSnapshotStatus(snapshotName) != null) {
					if (objVolSnapshot.getactiveSnapshotStatus(snapshotName).getText().equalsIgnoreCase("Active")) {
						Reporter.log("Volume snapshot created successfully.");
						break;
					} else if (objVolSnapshot.getErrorSnapshotStatus(snapshotName) != null) {

						if (objVolSnapshot.getErrorSnapshotStatus(snapshotName).getText().equalsIgnoreCase("Error")) {
							Reporter.log(
									"<p style = 'color:red'> Volume snapshot status present in Error status. Please look in to the issue.</p>");
							break;
						}
					}

				}
			}

		}

		catch (Exception e) {
			Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e)+"</p>");
			e.printStackTrace();

		}
	}
}
