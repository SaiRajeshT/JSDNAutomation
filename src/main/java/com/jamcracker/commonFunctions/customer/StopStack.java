package com.jamcracker.commonFunctions.customer;

import org.openqa.selenium.Keys;

import com.jamcracker.objectRepository.customer.InstancesPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class StopStack extends TestBase {
	
	public void stopStack(String stackName){
		
		try {
			InstancesPage objinstancePage = new InstancesPage();
			objinstancePage.manageLink.click();
			objinstancePage.appstacksLink.click();
			explicitWait(objinstancePage.searchTextBox);
			HandleDropDown.selectDDLByValue(objinstancePage.searchDropDown, "name");
			objinstancePage.searchTextBox.clear();
			objinstancePage.searchTextBox.sendKeys(stackName);
			Thread.sleep(2000);
			objinstancePage.searchTextBox.sendKeys(Keys.RETURN);
			System.out.println("Testing Pradeep");
			
		
		
		
		}
		
		catch(Exception e)
		{
			
		}
		
	}

}
