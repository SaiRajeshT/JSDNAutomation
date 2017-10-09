package com.jamcracker.commonFunctions.marketplace;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.constants.Constants;
import com.jamcracker.entity.service.Offers;
import com.jamcracker.entity.service.Price;
import com.jamcracker.entity.service.PricingInfo;
import com.jamcracker.entity.service.ServicesInfo;
import com.jamcracker.objectRepository.marketplace.MyservicesPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;
import com.jamcracker.utilities.TwoWindowsSwitch;

public class ServiceCreation extends TestBase {
	MyservicesPage objMyServicesPage = new MyservicesPage();
	/*
	 * //Configuring service information page for service and verifying whether
	 * navigated to next page or not public void serviceInfoConfig(String
	 * serviceName,String servicePublisher,String serviceSummary,String
	 * serviceMoreInfo, String requirements, String faqs,String
	 * serviceType,String subCategory,String slm,String firstAdminEnable)
	 */

	public void offerInfoConfig(Offers offer) {
		try {
			
			try {
				objMyServicesPage.addOfferLink.click();
			} catch (Exception e) {
				Reporter.log("Offer Link is not available");
			}
			// Configuring Offers

			objMyServicesPage.offerNameTextBox.sendKeys(offer.getOfferName());
			objMyServicesPage.offerCodeTextBox.sendKeys(offer.getOfferCode().replaceAll(" ", ""));
			objMyServicesPage.offerDescriptionTextBox.sendKeys(offer.getOfferDescription());

			
			// Selecting Offer catalog checkbox
			if (Constants.Y.equalsIgnoreCase(offer.getAddOffertoCatalog())) {
				if (!(objMyServicesPage.offerCatalogCheckBox.isSelected())) {
					objMyServicesPage.offerCatalogCheckBox.click();
				}
				if (objMyServicesPage.offerCatalogCheckBox.isSelected()) {
					Reporter.log("Add Offer to Catalog Checkbox is selected.");
				} else {
					Reporter.log("<p style='color:red'>Add Offer to Catalog Checkbox is not selected. Please check the issue.</p>");
				}
				

			}

			else {
				if (objMyServicesPage.offerCatalogCheckBox.isSelected()) {
					objMyServicesPage.offerCatalogCheckBox.click();}
					if(!objMyServicesPage.offerCatalogCheckBox.isSelected())
					{
						Reporter.log("Successfully unselected the Add Offer to Catalog Checkbox.");
					}
				
				

			}
			
			
			
			if (Constants.Y.equalsIgnoreCase(offer.getPayasyouGo())) {
				if (!(objMyServicesPage.payAsYouGoCheckBox.isSelected())) {
					objMyServicesPage.payAsYouGoCheckBox.click();
				}
				if (objMyServicesPage.payAsYouGoCheckBox.isSelected()) {
					Reporter.log("Pay as you go checkbox is selected.");
				} else {
					Reporter.log("<p style='color:red'>Pay as you go checkbox is not selected. Please check the issue.</p>");
				}
				

			}

			else {
				if (objMyServicesPage.payAsYouGoCheckBox.isSelected()) {
					objMyServicesPage.payAsYouGoCheckBox.click();
					if(!objMyServicesPage.payAsYouGoCheckBox.isSelected())
					{
						Reporter.log("Successfully unselected the pay per user checkbox");
					}
				}
				

			}
			

			if (Constants.Y.equalsIgnoreCase(offer.getPayperUser())) {
				if (!(objMyServicesPage.payPerUserCheckBox.isSelected())) {
					objMyServicesPage.payPerUserCheckBox.click();

				}
				if (objMyServicesPage.payPerUserCheckBox.isSelected()) {
					Reporter.log("Pay per user  checkbox is selected.");
				} else {
					Reporter.log(
							"<p style='color:red'>Pay per user checkbox is not selected. Please check the issue.</p>");
				}
			}

			else {
				if (objMyServicesPage.payPerUserCheckBox.isSelected()) {
					objMyServicesPage.payPerUserCheckBox.click();
					if(!objMyServicesPage.payAsYouGoCheckBox.isSelected())
					{
						Reporter.log("Successfully unselected the pay per user checkbox");
					}
				}

			}
			

			HandleDropDown.selectDDLByVisibletext(objMyServicesPage.showDataCollectionDropDown,
					offer.getDatacollectionforservice());
			String selectedOption = HandleDropDown.getSelectedValue(objMyServicesPage.showDataCollectionDropDown);
			if(selectedOption.equalsIgnoreCase(offer.getDatacollectionforservice()))
			{
				Reporter.log("Show Data collection For " + offer.getDatacollectionforservice() + "is selected");
			}
			
			else
			{
				Reporter.log("<p style='red:color'>Issue while selecting the Show data collection option.</p>");
			}
			
			if(offer.getSubcriptionType().equalsIgnoreCase("R")){
			objMyServicesPage.regularSubscriptionRadioButton.click();
			if(objMyServicesPage.regularSubscriptionRadioButton.isSelected()){
				Reporter.log("Subscriptin Type selected as Regular.");
			}
			else{ Reporter.log("<p style='red:color'>Subsciption Type not selected as Regular. Please check the issue.</p>");
	
				}
			}
			
			else{
				objMyServicesPage.termSubscriptionRadioButton.click();
				if(objMyServicesPage.termSubscriptionRadioButton.isSelected()){
					Reporter.log("Subscription type is selected as term subscription.");
				}
				else
				{
					Reporter.log("<p style='red:color'>Subscription Type is not selected as term subscription.Please check the issue.</p>");
				}
			}
			objMyServicesPage.saveAndNextButton.click();
			
			explicitWait(objMyServicesPage.unitPriceQtyTextBox);
			
			if(objMyServicesPage.unitPriceQtyTextBox.isDisplayed())
			{
				Reporter.log("Successfully configured offer details page. >> Navigated to Pricing information page");
			}
			else{
				Reporter.log("<p style='red:color'>Issue while configuring offer details page. Please check the issue.</p>");
			}
			
			
			//Configuring pricing information
			
			objMyServicesPage.expandIcon.click();
			PricingInfo pricingInfo = offer.getPricingInfo();
			Map<Integer,Price> prices = pricingInfo.getPrice();
			
			objMyServicesPage.unitPriceTextBox.sendKeys(pricingInfo.getUnitPrice());
			objMyServicesPage.minQtyTextBox.sendKeys(pricingInfo.getMinimumQty());
			objMyServicesPage.unitPriceQtyTextBox.sendKeys(pricingInfo.getUnitPriceQuantity());
			
			try{			
			if(Constants.Y.equalsIgnoreCase(pricingInfo.getStaticQuantity())){
				objMyServicesPage.staticQtyYesRadio.click();
				if(objMyServicesPage.staticQtyYesRadio.isSelected())
				{
					Reporter.log("Static quantity selected as yes for service.");
				}
				else{
					Reporter.log("<p style='red:color'> Issue while selecting Static quantity yes for service. Please check the issue.</p>");
					
				}
			} else{
				objMyServicesPage.staticQtyNoRadio.click();
				if(objMyServicesPage.staticQtyNoRadio.isSelected())
				{
					Reporter.log("Static quantity selected as No for service.");
				}
				else{
					Reporter.log("<p style='red:color'> Issue while selecting Static quantity yes for service. Please check the issue.</p>");
					
				}
				
			}
			}
			catch(Exception e)
			{
				Reporter.log("<p style='color:red'issue while selecting static Radiobutton. please check the issue.</p>");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
			//Selecting Setup Fee Yes or No
			try{			
				if(Constants.Y.equalsIgnoreCase(pricingInfo.getIsSetupFee())){
					objMyServicesPage.SetUpFeeYesRadioButton.click();
					if(objMyServicesPage.SetUpFeeYesRadioButton.isSelected())
					{
						Reporter.log("set up fee  configured  for service.");
						HandleDropDown.selectDDLByVisibletext(objMyServicesPage.setUpFeeDropDown, pricingInfo.getSetUpFeePlan());
						
						String selectedValue = HandleDropDown.getSelectedValue(objMyServicesPage.setUpFeeDropDown);
						if(selectedValue.equalsIgnoreCase(pricingInfo.getSetUpFeePlan()))
						{
							Reporter.log("Set Up Fee plan " + pricingInfo.getSetUpFeePlan()  + " is selected");
						}
						
						else
						{
							Reporter.log("<p style='red:color'>Issue while selecting set up fee plan.</p>");
						}
						
						
						
						
					}
					else{
						Reporter.log("<p style='red:color'> Issue while selecting Static quantity yes for service. Please check the issue.</p>");
						
					}
				} else{
					objMyServicesPage.staticQtyNoRadio.click();
					if(objMyServicesPage.staticQtyNoRadio.isSelected())
					{
						Reporter.log("Static quantity selected as No for service.");
					}
					else{
						Reporter.log("<p style='red:color'> Issue while selecting Static quantity yes for service. Please check the issue.</p>");
						
					}
					
				}
				}
				catch(Exception e)
				{
					Reporter.log("<p style='color:red'issue while selecting static Radiobutton. please check the issue.</p>");
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			
			
			
			HandleDropDown.selectDDLByVisibletext(objMyServicesPage.billingCycleDropDown, pricingInfo.getBillingCycle());
			objMyServicesPage.proRateYesRadioButton.click();
			String selectedValue = HandleDropDown.getSelectedValue(objMyServicesPage.billingCycleDropDown);
			if(selectedValue.equalsIgnoreCase(pricingInfo.getBillingCycle()))
			{
				Reporter.log("Billing cycle " + pricingInfo.getBillingCycle()  + " is selected");
			}
			
			else
			{
				Reporter.log("<p style='red:color'>Issue while selecting the Billing cycle.</p>");
			}
				
			
			for (Entry<Integer, Price> iterable_element : prices.entrySet()) {
				Integer currencyId = (Integer)iterable_element.getKey();
				Price price = (Price)iterable_element.getValue();
				objMyServicesPage.getTaxTextBox(price.getCurrencyCode()).click();
				objMyServicesPage.getCheckAllTaxCheckBox(price.getCurrencyCode()).click();
				objMyServicesPage.getPriceTextbox(currencyId, Constants.ISV_REC_PRICE).sendKeys(price.getVendorSalePrice());
				objMyServicesPage.getPriceTextbox(currencyId, Constants.MP_REC_PRICE).sendKeys(price.getWholeSalePrice());
				objMyServicesPage.getPriceTextbox(currencyId, Constants.MIN_RETAIL_PRICE).sendKeys(price.getMinRetailPrice());
				if(Constants.Y.equalsIgnoreCase(pricingInfo.getIsSetupFee())){
					objMyServicesPage.getPriceTextbox(currencyId, Constants.ISV_SETUP_FEE).sendKeys(price.getVendorSetupFee());
					objMyServicesPage.getPriceTextbox(currencyId, Constants.MP_SETUP_FEE).sendKeys(price.getWholesaleSetupFee());
				}
				
			}
		
			objMyServicesPage.pricingInfoSaveAndNextButton.click();
			if (objMyServicesPage.resellCheckbox.isDisplayed()) {
				Reporter.log("Successfully configured pricing information  page and navigated to Activities page");
			} else {
				Reporter.log(
						"<p style='color:red'>Issue while configuring pricing information page. Please look in to the issue. </p>");
			}
			

				
		}

		catch (NoSuchElementException e) {
			System.out.println("Element not found exception " + e.getMessage());
			e.printStackTrace();

		}

		catch (Exception e) {
			System.out.println("Unknown Exception " + e.getMessage());
			e.printStackTrace();
		}

	}

	public void serviceInfoConfig(ServicesInfo serviceInfo) {
		//Configuring service information page
		try {

			objMyServicesPage.serviceNameTextBox.sendKeys(serviceInfo.getServiceName());
			objMyServicesPage.servicePublisherTextBox.sendKeys(serviceInfo.getServicePublisher());
			objMyServicesPage.serviceSummaryTextBox.sendKeys(serviceInfo.getServiceDescription());
			objMyServicesPage.serviceMoreInfoTextBox.sendKeys(serviceInfo.getMoreInformation());
			objMyServicesPage.requirementsTextBox.sendKeys(serviceInfo.getRequirements());
			objMyServicesPage.faqsTextBox.sendKeys(serviceInfo.getFaqs());
			objMyServicesPage.serviceLogoBrowseButton.sendKeys(System.getProperty("user.dir") + File.separator + "Data"
					+ File.separator + "Logos" + File.separator + "SAAS Service Logo.JPG");
			HandleDropDown.selectDDLByVisibletext(objMyServicesPage.cloudServiceTypeDropDown,
					serviceInfo.getCloudServiceType());

			if (serviceInfo.getSlm().equalsIgnoreCase("Y")) {
				if (!(objMyServicesPage.licenseMgmtcheckBox.isSelected())) {
					objMyServicesPage.licenseMgmtcheckBox.click();
					Reporter.log("License Management checkbox is selected");
				}
			} else {
				while (objMyServicesPage.licenseMgmtcheckBox.isSelected()) {
					objMyServicesPage.licenseMgmtcheckBox.click();
				}
				if (!(objMyServicesPage.licenseMgmtcheckBox.isSelected())) {
					Reporter.log("Successfully Unselected the License management checkbox");

				}

			}

			if (serviceInfo.getFirstAdminEnable().equalsIgnoreCase("Y")) {
				if (!(objMyServicesPage.firstAdminEnableCheckBox.isSelected())) {
					objMyServicesPage.firstAdminEnableCheckBox.click();
					Reporter.log("First admin enable  checkbox is selected");
				}
			} else {
				while (objMyServicesPage.firstAdminEnableCheckBox.isSelected()) {
					objMyServicesPage.firstAdminEnableCheckBox.click();
					if (!(objMyServicesPage.firstAdminEnableCheckBox.isSelected())) {
						Reporter.log("Successfully Unselected the first admin checkbox");
						System.out.println("Else Print2");
					}

				}
			}
			

			objMyServicesPage.addSlaTextBox.click();
			TwoWindowsSwitch.getWindowHandles();
			TwoWindowsSwitch.switchToChild();
			objMyServicesPage.slaBrowseButton.sendKeys(System.getProperty("user.dir") + File.separator + "Data"
					+ File.separator + "SlaAndPolicies" + File.separator + "sla.html");
			objMyServicesPage.saveButton.click();
			TwoWindowsSwitch.switchToParent();
			objMyServicesPage.getSubCategory(serviceInfo.getServiceSubCategory()).click();
			objMyServicesPage.saveAndNextButton.click();
			if (objMyServicesPage.offerCodeTextBox.isDisplayed()) {
				Reporter.log("All the details are saved successfuly in service information page");
			} else {
				Reporter.log(
						"<p style='color:red'> Issue while configuring service information page. Please look in to the issue.</p>");
			}

			// Configuring Offers
			for (Offers offer : serviceInfo.getOffers()) {

				offerInfoConfig(offer);

			}

		}

		catch (NoSuchElementException e) {
			System.out.println("Element not found exception " + e.getMessage());
			e.printStackTrace();

		}

		catch (Exception e) {
			System.out.println("Unknown Exception " + e.getMessage());
			e.printStackTrace();
		}

	}
	
	public void activitiesPage()
	{
		try{
			objMyServicesPage.resellCheckbox.click();
			objMyServicesPage.selectAllCheckbox.click();
			objMyServicesPage.requestQuoteCheckbox.click();
			objMyServicesPage.saveAndNextButton.click();
			try{
				objMyServicesPage.activitiesContinueButton.click();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			if (objMyServicesPage.finishButton.isDisplayed()) {
				Reporter.log("Successfully configured activities page and navigated to resources page");
			} else {
				Reporter.log(
						"<p style='color:red'>Issue while configuring activities page. Please look in to the issue</p>");
			}
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Element not found exception " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
			
		}
		
		catch (Exception e) {
			System.out.println("Unknown Exception " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public void resourcePage()
	{
		objMyServicesPage.finishButton.click();
		
		if(objMyServicesPage.addServiceButton.isDisplayed())
		{
			Reporter.log("Service configuration is completed");
		}
		else{
			Reporter.log("<p style='color:red'>issue while configuring the resource page. Please look in to the issue.</p>");
		}
	}

}
