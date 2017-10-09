package com.jamcracker.commonFunctions.marketplace;

import com.jamcracker.objectRepository.marketplace.MpIaaSConsolePage;
import com.jamcracker.utilities.TestBase;

public class PublishStack extends TestBase {
	
	MpIaaSConsolePage mpIaasConsole = new MpIaaSConsolePage();
	
	public void testPublishStack(String stackName) {		
		mpIaasConsole.getPublishLink(stackName).click();
		mpIaasConsole.getServiceNameTextBox.sendKeys(stackName);
		mpIaasConsole.getShortDesc.sendKeys("Short Description");
		mpIaasConsole.getDetailedDesc.sendKeys("Detailed Description");
		mpIaasConsole.getLogoUploadFile.sendKeys(System.getProperty("user.dir") + "/Data/Logos/logoIaaS.jpg");
		mpIaasConsole.getSaveAndFinishButton.click();		
	}

}
