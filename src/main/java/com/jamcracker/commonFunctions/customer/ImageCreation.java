package com.jamcracker.commonFunctions.customer;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.Reporter;
import com.jamcracker.constants.Constants;
import com.jamcracker.objectRepository.customer.CustomerMenuAndSubmenuObjects;
import com.jamcracker.objectRepository.customer.InstancesPage;
import com.jamcracker.objectRepository.customer.VolSnapshotPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class ImageCreation extends TestBase {
	
	InstancesPage objInstancePage = new InstancesPage();
	CustomerMenuAndSubmenuObjects menuObj = new CustomerMenuAndSubmenuObjects();

	
	public void imageCreation(String instName,String imageName,String imageDesc){
	try{
		
		//InstancesPage objinstancePage = new InstancesPage();
		objInstancePage.manageLink.click();
		objInstancePage.instancesLink.click();
		explicitWait(objInstancePage.searchTextBox);
		HandleDropDown.selectDDLByValue(objInstancePage.searchDropDown, "name");
		objInstancePage.searchTextBox.clear();
		objInstancePage.searchTextBox.sendKeys(instName);
		Thread.sleep(3000);
		objInstancePage.searchTextBox.sendKeys(Keys.ENTER);
		explicitWait(objInstancePage.showingText);
		objInstancePage.getInstanceActionLink(instName).click();
		objInstancePage.createImageLink.click();
		explicitWait(objInstancePage.imageCancelButton);
		if(objInstancePage.imageCancelButton.isDisplayed()){
			Reporter.log("Create Image pop up is displayed");
		}
		
		objInstancePage.imageNameTextBox.sendKeys(imageName);
		objInstancePage.imageDescription.sendKeys(imageName);
		objInstancePage.createImageButton.click();
		
		if(Constants.IMAGE_CREATION_MESSAGE.equalsIgnoreCase("Image creation is successfully initiated.")){
			Reporter.log("Image Creation intiated");
				}
		else{
			Reporter.log("<p style='color:red'> Image Creation is not intiated please look in to the issue.</p>");
		}
		
		boolean test = true;
		long startTime = (System.currentTimeMillis()) / 1000;
		while (test) {
			if ((System.currentTimeMillis() / 1000) - startTime > timeout) {
				Reporter.log("<p style='color:red'>Waited for"+timeout+" Seconds.Image status did not go to Active.Please check the issue.<p>");
				Assert.fail();
				break;
			}
			
			objInstancePage.searchTextBox.clear();
			objInstancePage.searchTextBox.sendKeys(imageName);
			Thread.sleep(3000);
			objInstancePage.searchTextBox.sendKeys(Keys.ENTER);
			explicitWait(objInstancePage.showingText);
			
			if(objInstancePage.getImageStatus(imageName).equalsIgnoreCase("Active")){
			
				test = false;
				Reporter.log("Image Created successfully and image status changed to active");
			}
			
			Thread.sleep(5000);
			
		}
	
	}
	
	catch (Exception e1)
	{
		
		Reporter.log("<p style='color:red'>Issue while creating image, please look in to the issue.<p>");
		Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e1)+"</p>");
		Assert.fail();
	}
	
	}
	
	public void imageCreationwithVolume(String instName,String imageName,String imageDesc,String volumeName,String volumeSnapshotName){
		try{
			
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
			objinstancePage.createImageLink.click();
			explicitWait(objinstancePage.imageCancelButton);
			if(objinstancePage.imageCancelButton.isDisplayed()){
				Reporter.log("Create Image pop up is displayed");
			}
			
			objinstancePage.imageNameTextBox.sendKeys(imageName);
			objinstancePage.imageDescription.sendKeys(imageName);
			objinstancePage.getVolumeCheckBox(volumeName).click();
			objinstancePage.getVolumeSnapshotTextBox(volumeName).sendKeys(volumeSnapshotName);
			objinstancePage.createImageButton.click();
			
			if(Constants.IMAGE_CREATION_MESSAGE.equalsIgnoreCase("Image creation is successfully initiated.")){
				Reporter.log("Image Creation intiated");
					}
			else{
				Reporter.log("<p style='color:red'> Image Creation is not intiated please look in to the issue.</p>");
			}
			
			boolean test = true;
			long startTime = (System.currentTimeMillis()) / 1000;
			while (test) {
				if ((System.currentTimeMillis() / 1000) - startTime > timeout) {
					Reporter.log("<p style='color:red'>Waited for"+timeout+" Seconds.Image status did not go to Active.Please check the issue.<p>");
					Assert.fail();
					break;
				}
				
				objinstancePage.searchTextBox.clear();
				objinstancePage.searchTextBox.sendKeys(imageName);
				Thread.sleep(3000);
				objinstancePage.searchTextBox.sendKeys(Keys.ENTER);
				explicitWait(objinstancePage.showingText);
				
				if(objinstancePage.getImageStatus(imageName).equalsIgnoreCase("Active")){
				
					test = false;
					Reporter.log("Image Created successfully and image status changed to active");
				}
				
				Thread.sleep(5000);
				
			}
			menuObj.manageLink.click();
			menuObj.volSnapLink.click();
			VolSnapshotPage objVolSnapshot = new VolSnapshotPage();
			
			
			boolean test1 = true;
			long startTime1 = (System.currentTimeMillis()) / 1000;
			while (test1) {
				if ((System.currentTimeMillis() / 1000) - startTime1 > timeout) {
					Reporter.log("<p style='color:red'>Waited for" + timeout
							+ " Seconds.Volume Snapshot status did not go to Active.Please check the issue.</p>");
					Assert.fail();
					break;
				}
				explicitWait(objVolSnapshot.searchTextBox);
				objVolSnapshot.searchTextBox.clear();
				objVolSnapshot.searchTextBox.sendKeys(volumeSnapshotName);
				objVolSnapshot.searchTextBox.sendKeys(Keys.ENTER);
				// explicitWait(objinstancePage.showingText);
				if (objVolSnapshot.getactiveSnapshotStatus(volumeSnapshotName) != null) {
					if (objVolSnapshot.getactiveSnapshotStatus(volumeSnapshotName).getText().equalsIgnoreCase("Active")) {
						Reporter.log("Volume snapshot created successfully.");
						break;
					} else if (objVolSnapshot.getErrorSnapshotStatus(volumeSnapshotName) != null) {

						if (objVolSnapshot.getErrorSnapshotStatus(volumeSnapshotName).getText().equalsIgnoreCase("Error")) {
							Reporter.log(
									"<p style = 'color:red'> Volume snapshot status present in Error status. Please look in to the issue.</p>");
							break;
						}
					}

				}
			}
		}
		
		catch (Exception e1)
		{  	
			e1.printStackTrace();
			Reporter.log("<p style='color:red'>Issue while creating image, please look in to the issue.<p>");
			Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e1)+"</p>");
			Assert.fail();
		}
		
		}

}
