package com.jamcracker.commonFunctions.customer;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.objectRepository.customer.InstancesPage;
import com.jamcracker.objectRepository.customer.VolSnapshotPage;
import com.jamcracker.utilities.TestBase;

public class DeleteVolumeSnapshot extends TestBase{
	
	public void deleteVolSnapshot(String snapshotName){
	try {
		VolSnapshotPage objVolSnapshot = new VolSnapshotPage();
		InstancesPage objinstancePage = new InstancesPage();
		objinstancePage.manageLink.click();
		objVolSnapshot.volumeSnapshotLink.click();
		explicitWaitToClickable(objVolSnapshot.searchTextBox);
		objVolSnapshot.searchTextBox.click();
		Thread.sleep(2000);
		objVolSnapshot.searchTextBox.sendKeys(snapshotName);
		objVolSnapshot.searchTextBox.sendKeys(Keys.ENTER);
		objVolSnapshot.getDeleteSnapshotLink(snapshotName).click();
		explicitWait(objVolSnapshot.volSnapshotDelconfirmButton);
		objVolSnapshot.volSnapshotDelconfirmButton.click();
		boolean test = true;
		long startTime = (System.currentTimeMillis()) / 1000;
		while (test) {
			if ((System.currentTimeMillis() / 1000) - startTime > timeout) {
				Reporter.log("<p style='color:red'>Waited for" + timeout
						+ " Seconds.Volume Snapshot status present in Deleting status.Please check the issue.</p>");
				Assert.fail();
				break;
			}
			explicitWaitToClickable(objVolSnapshot.searchTextBox);

			objVolSnapshot.searchTextBox.click();
			Thread.sleep(2000);
			objVolSnapshot.searchTextBox.clear();
			objVolSnapshot.searchTextBox.sendKeys(snapshotName);
			objVolSnapshot.searchTextBox.sendKeys(Keys.ENTER);
		if (objVolSnapshot.getDeletingSnapshot(snapshotName)==false)
		{
			Reporter.log("Volume snapshot Deleted succesfully.");
			break;
		}
			
		}
	}

	catch (Exception e) {
		Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e)+"</p>");
		e.printStackTrace();
		Assert.fail();
	}
}

}
