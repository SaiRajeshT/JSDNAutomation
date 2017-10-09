package com.jamcracker.commonFunctions.customer;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.Reporter;

import com.jamcracker.objectRepository.customer.InstancesPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class ResizeInstance extends TestBase
{
	public static void resizeInstance(String instName,String flavor)
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
		objinstancePage.resizeLink.click();
		explicitWait(objinstancePage.resizeCancelButton);
		HandleDropDown.selectDDLByVisibletext(objinstancePage.resizeDropDown, flavor);
		objinstancePage.resizeButton.click();
		objinstancePage.resizeConfirmButton.click();
		HandleDropDown.selectDDLByValue(objinstancePage.searchDropDown, "name");
		objinstancePage.searchTextBox.clear();
		objinstancePage.searchTextBox.sendKeys(instName);
		Thread.sleep(2000);
		objinstancePage.searchTextBox.sendKeys(Keys.ENTER);
		boolean test = true;
		long startTime = (System.currentTimeMillis()) / 1000;
		while (test) {
			if ((System.currentTimeMillis() / 1000) - startTime > timeout) {
				Reporter.log("<p style='color:red'>Waited for"+timeout+" Seconds.Instance status did not go to Running.Please check the issue.<p>");
				Assert.fail();
				break;
			}
			try {

				explicitWait(objinstancePage.showingText);
				if (objinstancePage.getRunningInstance(instName).isDisplayed() == true) {
					test = false;
					
					try{
						objinstancePage.getInstanceActionLink(instName).click();
						objinstancePage.viewDetaisLink.click();
						//explicitWait(objinstancePage.downLoadPrivateKeyButton);
						if(objinstancePage.getSize(flavor).isDisplayed())
							Reporter.log("Instance Resize is completed.");
					}
					catch(Exception e)
					{
						e.printStackTrace();
						Reporter.log("<p style='color:red'>Instance Resize is not completed. Please look in to the issue</p>.");
					}
					
				}
			}

			catch (Exception e) {
				Thread.sleep(15000);
				explicitWait(objinstancePage.searchTextBox);
				HandleDropDown.selectDDLByValue(objinstancePage.searchDropDown, "name");
				objinstancePage.searchTextBox.clear();
				objinstancePage.searchTextBox.sendKeys(instName);
				Thread.sleep(2000);
				objinstancePage.searchTextBox.sendKeys(Keys.ENTER);
			}
		
	}
		}
		catch (Exception e1)
		{
			Assert.fail();
			e1.printStackTrace();
		}
	}	
}
