package com.jamcracker.commonFunctions.marketplace;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.constants.Constants;
import com.jamcracker.entity.service.Price;
import com.jamcracker.entity.service.ServiceSourceData;
import com.jamcracker.objectRepository.marketplace.MarketplaceHomePage;
import com.jamcracker.objectRepository.marketplace.MyservicesPage;
import com.jamcracker.utilities.HandleAlert;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.SwitchFrame;
import com.jamcracker.utilities.TestBase;
import com.jamcracker.utilities.TwoWindowsSwitch;

public class ServiceSourcing extends TestBase {

	public void serviceSource(ServiceSourceData serviceSource) {

		MarketplaceHomePage objMpHome = new MarketplaceHomePage();
		objMpHome.myCompanyLink.click();

		MyservicesPage objMyServ = new MyservicesPage();
		objMyServ.myServiceLInk.click();
		objMyServ.addServiceButton.click();

		SwitchFrame.elementSwitch(objMyServ.addServiceFrame);

		objMyServ.sourceServiceRadioButton.click();
		objMyServ.continueButton.click();

		HandleDropDown.selectDDLByVisibletext(objMyServ.serviceToSourceDropDown, serviceSource.getServiceName());
		HandleDropDown.selectDDLByVisibletext(objMyServ.offerNameDropDown, serviceSource.getOfferName());
		
		if (serviceSource.getServiceType().equalsIgnoreCase("Regular")) {
			
			objMyServ.expandIcon.click();
			Map<Integer, Price> prices = serviceSource.getPrice();

			for (Entry<Integer, Price> iterable_element : prices.entrySet()) {

				Integer currencyId = (Integer) iterable_element.getKey();
				Price price = (Price) iterable_element.getValue();

				try {
					objMyServ.getPriceTextbox(currencyId, Constants.ISV_REC_PRICE).clear();
					objMyServ.getPriceTextbox(currencyId, Constants.ISV_REC_PRICE).sendKeys(price.getVendorSalePrice());
				} catch (Exception e) {
					Reporter.log("For the " + currencyId + " details are already entered or fields are not available");
				}

				try {
					objMyServ.getPriceTextbox(currencyId, Constants.ISV_SETUP_FEE).clear();
					objMyServ.getPriceTextbox(currencyId, Constants.ISV_SETUP_FEE).sendKeys(price.getVendorSetupFee());
				} catch (Exception e) {
					Reporter.log("For the " + currencyId + " details are already entered or fields are not available");
				}

				try {
					objMyServ.getPriceTextbox(currencyId, Constants.MP_REC_PRICE).clear();
					objMyServ.getPriceTextbox(currencyId, Constants.MP_REC_PRICE).sendKeys(price.getWholeSalePrice());
				} catch (Exception e) {
					Reporter.log("For the " + currencyId + " details are already entered or fields are not available");
				}

				try {
					objMyServ.getPriceTextbox(currencyId, Constants.MIN_RETAIL_PRICE).clear();
					objMyServ.getPriceTextbox(currencyId, Constants.MIN_RETAIL_PRICE).sendKeys(price.getMinRetailPrice());
				} catch (Exception e) {
					Reporter.log("For the " + currencyId + " details are already entered or fields are not available");
				}

				try {
					objMyServ.getPriceTextbox(currencyId, Constants.MP_SETUP_FEE).clear();
					objMyServ.getPriceTextbox(currencyId, Constants.MP_SETUP_FEE).sendKeys(price.getWholesaleSetupFee());
				} catch (Exception e) {
					Reporter.log("For the " + currencyId + " details are already entered or fields are not available");
				}

			}
			
		}

		objMyServ.saveButton.click();

		Assert.assertTrue(objMyServ.sourceSuccessMsg.isDisplayed());

		objMyServ.nextButton.click();
		
		try {
			HandleAlert.acceptAlert();
		} catch (Exception e) {
			objMyServ.serviceNameTextBox.clear();
			objMyServ.serviceNameTextBox.sendKeys(serviceSource.getServiceName() + "_srcd");

			objMyServ.addSlaTextBox.click();
			TwoWindowsSwitch.getWindowHandles();
			TwoWindowsSwitch.switchToChild();
			objMyServ.slaBrowseButton.sendKeys(System.getProperty("user.dir") + File.separator + "Data" + File.separator + "SlaAndPolicies" + File.separator + "sla.html");
			objMyServ.saveButton.click();
			TwoWindowsSwitch.switchToParent();
			objMyServ.saveAndNextButton.click();

			objMyServ.nextButton.click();

			objMyServ.requestQuoteCheckbox.click();
			objMyServ.saveAndNextButton.click();
			try {
				objMyServ.activitiesContinueButton.click();
			} catch (Exception e1) {
				Reporter.log("No alert available and hence continuing");
			}

			objMyServ.finishButton.click();
		}
		
		Assert.assertTrue(objMyServ.getServiceStatus(serviceSource.getServiceName()).isDisplayed());
		Reporter.log("Service Sourcing is completed");

	}

}
