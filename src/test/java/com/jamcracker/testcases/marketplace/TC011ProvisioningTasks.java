package com.jamcracker.testcases.marketplace;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.marketplace.CompleteProvisioningTasks;
import com.jamcracker.commonFunctions.marketplace.MarketplaceLogin;
import com.jamcracker.utilities.TestBase;

public class TC011ProvisioningTasks extends TestBase 
{

	@DataProvider(name = "ProvisioningTasksData")
	private String[][] getProvisioningTasksData()
	{
		return getData("TestData.xls","ProvisioningTasksSheet");		
	}
	
	
	@BeforeMethod
	@Parameters({"browser", "mpUrl"})
	public void setUp(String browser, String url)
	{
		init(browser, url);
	}
	
	
	
	@Test(dataProvider = "ProvisioningTasksData")
	public void ProvisioningTasks(String runMode, String taskType, String offerCode, String offerName, String organization, String buttonType) throws Exception
	{
		if(runMode.equalsIgnoreCase("y"))
		{
			
			String mpAdminEmail =  getData("TestData.xls", "CredentialsSheet", "Email Address", 3);
			String mpAdminPassword =  getData("TestData.xls", "CredentialsSheet", "Password", 3);
			MarketplaceLogin mpLoginObj = new MarketplaceLogin();
			mpLoginObj.login(mpAdminEmail,mpAdminPassword);
			CompleteProvisioningTasks  obj = new CompleteProvisioningTasks();
			obj.provisioningTasks(runMode, taskType, offerCode, offerName, organization, buttonType);
			
	}


 }
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}

