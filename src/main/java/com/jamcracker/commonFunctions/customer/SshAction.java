package com.jamcracker.commonFunctions.customer;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.objectRepository.customer.InstancesPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;
import com.jamcracker.utilities.TwoWindowsSwitch;

public class SshAction extends TestBase {

	InstancesPage objinstancePage = new InstancesPage();

	public void sshAction(String instName) {

		try {
			objinstancePage.manageLink.click();
			objinstancePage.instancesLink.click();
			explicitWait(objinstancePage.searchTextBox);
			HandleDropDown.selectDDLByValue(objinstancePage.searchDropDown, "name");
			objinstancePage.searchTextBox.clear();
			objinstancePage.searchTextBox.sendKeys(instName);
			Thread.sleep(2000);
			objinstancePage.searchTextBox.sendKeys(Keys.RETURN);
			Thread.sleep(2000);
			objinstancePage.getInstanceActionLink(instName).click();
			objinstancePage.launchSshLink.click();
			Reporter.log("Clicked on launch ssh link. waiting for ssh page to open.");
			Thread.sleep(10000);
			TwoWindowsSwitch.getWindowHandles();
			TwoWindowsSwitch.switchToChild();
			//getDriver().switchTo().alert();
			if(objinstancePage.sshWindow.isDisplayed())
			{
				Reporter.log("Launch ssh Working for"+instName);
			}
//			System.out.println(getDriver().getTitle());
			try{
			if(objinstancePage.cancelButton.isDisplayed()){
				objinstancePage.cancelButton.click();
				Reporter.log("Launch ssh is Not  working");
			} }
			catch(Exception e)
			{
				
			}
			TwoWindowsSwitch.switchToParent();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			Reporter.log("<p style='color:red'>issue while performing launch ssh.<p>");
			Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e)+"</p>");
			Assert.fail();
		}

	}

}
