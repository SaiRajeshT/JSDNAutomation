package com.jamcracker.commonFunctions.marketplace;

import com.jamcracker.objectRepository.marketplace.ManageIaaSServicesPage;
import com.jamcracker.objectRepository.marketplace.SLAUploadPage;
import com.jamcracker.utilities.TestBase;
import com.jamcracker.utilities.TwoWindowsSwitch;

public class ApproveStackService extends TestBase {
	
	ManageIaaSServicesPage mpIaaSService = new ManageIaaSServicesPage();
	
	public void testApproveStackService(String stackName) {
		
		mpIaaSService.getServiceManagementLink.click();
		mpIaaSService.getSearchServicesTextBox.sendKeys(stackName);
		mpIaaSService.getGoButton.click();
		explicitWait(mpIaaSService.getReviewLink(stackName));
		mpIaaSService.getReviewLink(stackName).click();
		explicitWait(mpIaaSService.getEditButton);
		mpIaaSService.getEditButton.click();
		explicitWait(mpIaaSService.getSLAAddButton);
		mpIaaSService.getSLAAddButton.click();
		TwoWindowsSwitch.getWindowHandles();
		TwoWindowsSwitch.switchToChild();
		SLAUploadPage slaPage = new SLAUploadPage();
		explicitWait(slaPage.getSLALocationFile);
		slaPage.testSLAUpload();
		TwoWindowsSwitch.switchToParent();
		if (mpIaaSService.getStackCheckBox.isSelected()) {
			mpIaaSService.getSaveReviewButton.click();
		} else {
			mpIaaSService.getStackCheckBox.click();
			mpIaaSService.getSaveReviewButton.click();
		}
		explicitWait(mpIaaSService.getEditButton);
		mpIaaSService.getEditButton.click();
		mpIaaSService.getOffersLink.click();
		mpIaaSService.getEditOfferIcon.click();
		explicitWait(mpIaaSService.getPricingInformtionTab);
		mpIaaSService.getPricingInformtionTab.click();
		mpIaaSService.getUnitPriceDecsTextBox.clear();
		mpIaaSService.getUnitPriceDecsTextBox.sendKeys("unit");
		mpIaaSService.getSaveExitButton.click();
		explicitWait(mpIaaSService.getNextButton);
		mpIaaSService.getNextButton.click();
		explicitWait(mpIaaSService.getResellCheckBox);
		mpIaaSService.getResellCheckBox.click();
		mpIaaSService.getRequestQuoteTextBox.click();
		mpIaaSService.getSaveNextButton.click();
		explicitWait(mpIaaSService.getFinishButton);
		mpIaaSService.getFinishButton.click();
		explicitWait(mpIaaSService.getApproveButton);
		mpIaaSService.getApproveButton.click();
		explicitWait(mpIaaSService.getSearchServicesTextBox);
		mpIaaSService.getSearchServicesTextBox.sendKeys(stackName);
		mpIaaSService.getGoButton.click();
		
	}

}
