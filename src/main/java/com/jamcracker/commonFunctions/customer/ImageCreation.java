package com.jamcracker.commonFunctions.customer;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.Reporter;

import com.jamcracker.constants.Constants;
import com.jamcracker.objectRepository.customer.InstancesPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class ImageCreation extends TestBase {
	
	InstancesPage objInstancePage = new InstancesPage();
	
	public void imageCreation(String instName,String imageName,String imageDesc){
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
	
	}
	
	catch (Exception e1)
	{
		
		Reporter.log("<p style='color:red'>Issue while creating image, please look in to the issue.<p>");
		Assert.fail();
	}
	
	}

}
