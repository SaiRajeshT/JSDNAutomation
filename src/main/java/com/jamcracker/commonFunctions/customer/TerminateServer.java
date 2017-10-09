package com.jamcracker.commonFunctions.customer;


import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Reporter;

import com.jamcracker.objectRepository.customer.InstancesPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public  class TerminateServer extends TestBase {

	public  void terminateServer(String instName)
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
		objinstancePage.searchTextBox.sendKeys(Keys.RETURN);
		
		try
		{
			Thread.sleep(3000);
			objinstancePage.getInstanceActionLink(instName).click();
			
			
		}
		catch(NoSuchElementException e)
		{
			
			//objinstancePage.getMonitorInstanceActionLink(instName).click();
		}
		
		objinstancePage.terminateLink.click();
		try{
			objinstancePage.terminateInstanceOnlyButton.click();
			
						
		}
		catch(NoSuchElementException e)
		{
			objinstancePage.terminateAppstackOnlyButton.click();

			
		}
		Thread.sleep(5000);
		
		 objinstancePage.instanceconfirmButton.click();

		
		 
		if (driver.getPageSource().contains("Terminating the Instance. This may take a few minutes for the VM to terminate.") == true)
		{
			Reporter.log("Instance Termination intiated successfully");
		}
		explicitWait(objinstancePage.searchTextBox);
		HandleDropDown.selectDDLByValue(objinstancePage.searchDropDown, "name");
		objinstancePage.searchTextBox.clear();
		objinstancePage.searchTextBox.sendKeys(instName);
		Thread.sleep(2000);
		objinstancePage.searchTextBox.sendKeys(Keys.ENTER);
		
		boolean test = true;
		long startTime = (System.currentTimeMillis())/1000;
		while(test) //Converting in to second and waiting till the time out or the condition satisfied
		{	
			if((System.currentTimeMillis()/1000)-startTime > timeout){
				break;
			}
			try{
				
					explicitWait(objinstancePage.showingText);
				 if(objinstancePage.getTermiantedInstance(instName).isDisplayed() == true){
				 test= false;
				Reporter.log("Instance  Present in Terminated status");}
				
				}
			
			catch(Exception e)
			{	
				Thread.sleep(15000);
				explicitWait(objinstancePage.searchTextBox);
				HandleDropDown.selectDDLByValue(objinstancePage.searchDropDown, "name");
				objinstancePage.searchTextBox.clear();
				objinstancePage.searchTextBox.sendKeys(instName);
				Thread.sleep(3000);
				objinstancePage.searchTextBox.sendKeys(Keys.ENTER);
				
				}
			}
		
		}
		catch(Exception emsg)
		{
			emsg.printStackTrace();
			Assert.fail();
		}
		}
	
}
