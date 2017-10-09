package com.jamcracker.commonFunctions.customer;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.objectRepository.customer.InstancesPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class AttachVolume extends TestBase {
	public void attachVolume(String instName,String volumeName,String volumeType,String size, String sizeType)
	{
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
			objinstancePage.attachNewVolumeLink.click();
			explicitWait(objinstancePage.volumeDoneButton);
			objinstancePage.volumeNameTextBox.sendKeys(volumeName);
			HandleDropDown.selectDDLByVisibletext(objinstancePage.volumeTypeDropDown, volumeType);
			objinstancePage.volumeSizeTextBox.sendKeys(size+"");
			HandleDropDown.selectDDLByVisibletext(objinstancePage.sizeDropDown, sizeType);
			objinstancePage.volumeDoneButton.click();
			
			objinstancePage.searchTextBox.clear();
			objinstancePage.searchTextBox.sendKeys(instName);
			Thread.sleep(3000);
			objinstancePage.searchTextBox.sendKeys(Keys.ENTER);
			explicitWait(objinstancePage.showingText);
			
			objinstancePage.getInstanceActionLink(instName).click();
			objinstancePage.viewDetaisLink.click();
			objinstancePage.volumeTab.click();			
			boolean test = true;
			long startTime = (System.currentTimeMillis()) / 1000;
			while (test) {
				if ((System.currentTimeMillis() / 1000) - startTime > timeout) {
					Reporter.log("<p style='color:red'>Waited for"+timeout+" Seconds.Volume status did not go to Active.Please check the issue.</p>");
					Assert.fail();
					break;
				}
				
				objinstancePage.searchTextBox.clear();
				objinstancePage.searchTextBox.sendKeys(volumeName);
				Thread.sleep(3000);
				objinstancePage.searchTextBox.sendKeys(Keys.ENTER);
				try{
					explicitWait(objinstancePage.showingText);
				}
				catch(Exception e){}
				
				try{
					
					if(objinstancePage.getVolumeStatus(volumeName).equalsIgnoreCase("Available"))
					{
						Reporter.log("Volume created successfully and present in available status");
						test=false;
					}
					
					if(objinstancePage.getVolumeStatus(volumeName).equalsIgnoreCase("Error"))
					{
						Reporter.log("<p style='color:red'>Volume Went to error status. Please check the issue.</p>");
						test=false;
					}
					
				}
				
				catch(Exception e)
				{
					
				}
			
		 }
		}
	
		
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("<p style='color:red'> Attaching Volume is failed please look in to the issue.</p>");
			Assert.fail();
		}
	
}
}
