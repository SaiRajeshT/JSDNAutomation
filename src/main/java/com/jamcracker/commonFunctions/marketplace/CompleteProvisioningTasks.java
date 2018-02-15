package com.jamcracker.commonFunctions.marketplace;

import org.testng.Assert;

import com.jamcracker.objectRepository.marketplace.MarketplaceHomePage;
import com.jamcracker.objectRepository.marketplace.ProvisioningTasksPage;
import com.jamcracker.utilities.TestBase;

public class CompleteProvisioningTasks extends TestBase {
	
	MarketplaceHomePage objMpHomePage = new MarketplaceHomePage();
	
	public void provisioningTasks(String runMode, String taskType, String offerCode, String offerName,
			String organization, String buttonType)
	{
		
		try{
			
		
			MarketplaceHomePage objMpHomePage = new MarketplaceHomePage();
			objMpHomePage.AdministrationLink.click();
			ProvisioningTasksPage objProvisioningTasksPage = new ProvisioningTasksPage();
			explicitWait(objProvisioningTasksPage.ProvisioningTasksLink);
			objProvisioningTasksPage.ProvisioningTasksLink.click();
			explicitWait(objProvisioningTasksPage.ShowTasksDropdown);
			objProvisioningTasksPage.ShowTasksDropdown.click();
			objProvisioningTasksPage.selectTaskType(taskType).click();
		
			objProvisioningTasksPage.searchTextBox.sendKeys(organization);
			objProvisioningTasksPage.selectDropDown.click();
			objProvisioningTasksPage.selectOrganizationName.click();
			objProvisioningTasksPage.goButton.click();
		
			objProvisioningTasksPage.checkbox(offerCode).click();
			objProvisioningTasksPage.buttonType(buttonType).click();
			Thread.sleep(3000);
			
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
	
	}
}
