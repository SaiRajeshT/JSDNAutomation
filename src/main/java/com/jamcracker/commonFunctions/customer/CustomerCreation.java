package com.jamcracker.commonFunctions.customer;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.entity.service.CustomerCreationData;
import com.jamcracker.objectRepository.customer.CustomerRegistrationPage;
import com.jamcracker.objectRepository.customer.StoreHomePage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class CustomerCreation extends TestBase {
	
	public void customerCreation(CustomerCreationData ccData) throws Exception {
		
		StoreHomePage storeHome = new StoreHomePage();
		CustomerRegistrationPage custRegister = new CustomerRegistrationPage();
		try {
			storeHome.signUpLink.click();
			manualWait(custRegister.registrationPageSection, 10);
		} catch (Exception e) {
			storeHome.signUpLink.click();
		}		
		explicitWait(custRegister.registrationPageSection);
		custRegister.firstNameTextBox.clear();
		custRegister.firstNameTextBox.sendKeys(ccData.getFirstName());
		custRegister.lastNameTextBox.clear();
		custRegister.lastNameTextBox.sendKeys(ccData.getLastName());
		custRegister.emailTextBox.clear();
		custRegister.emailTextBox.sendKeys(ccData.getEmail());
		custRegister.contactPhoneTextBox.clear();
		custRegister.contactPhoneTextBox.sendKeys(ccData.getContactPhone());
		custRegister.companyNameTextBox.clear();
		custRegister.companyNameTextBox.sendKeys(ccData.getCompanyName());
		custRegister.mailingAddress1TextBox.clear();
		custRegister.mailingAddress1TextBox.sendKeys(ccData.getMailingAddress1());
		custRegister.mailingPhoneTextBox.clear();
		custRegister.mailingPhoneTextBox.sendKeys(ccData.getMailingPhone());
		HandleDropDown.selectDDLByVisibletext(custRegister.mailingcountryDropDown, ccData.getMailingCountry());
		explicitWait(custRegister.mailingStateDropDown);
		HandleDropDown.selectDDLByVisibletext(custRegister.mailingStateDropDown, ccData.getMailingState());
		if (ccData.getMailingState().equalsIgnoreCase("Other")) {
			explicitWait(custRegister.mailingOtherStateTextBox);
			custRegister.mailingOtherStateTextBox.clear();
			custRegister.mailingOtherStateTextBox.sendKeys(ccData.getMailingOtherState());
		}
		custRegister.mailingCityTextBox.clear();
		custRegister.mailingCityTextBox.sendKeys(ccData.getMailingCity());
		custRegister.mailingZipTextBox.clear();
		custRegister.mailingZipTextBox.sendKeys(ccData.getMailingZip());
		if (ccData.getBillEqualMailAddress().equalsIgnoreCase("YES")) {
			custRegister.billingCheckBox.click();			
		} else {
			custRegister.billingAddress1TextBox.clear();
			custRegister.billingAddress1TextBox.sendKeys(ccData.getBillingAddress1());
			custRegister.billingPhoneTextBox.clear();
			custRegister.billingPhoneTextBox.sendKeys(ccData.getBillingPhone());
			HandleDropDown.selectDDLByVisibletext(custRegister.billingCountryDropDown, ccData.getBillingCountry());
			explicitWait(custRegister.billingStateDropDown);
			HandleDropDown.selectDDLByVisibletext(custRegister.billingStateDropDown, ccData.getBillingState());
			if (ccData.getBillingState().equalsIgnoreCase("Other")) {
				explicitWait(custRegister.billingOtherStateTextBox);
				custRegister.billingOtherStateTextBox.clear();
				custRegister.billingOtherStateTextBox.sendKeys(ccData.getBillingOtherState());
			}
			custRegister.billingCityTextBox.clear();
			custRegister.billingCityTextBox.sendKeys(ccData.getBillingCity());
			custRegister.billingZipTextBox.clear();
			custRegister.billingZipTextBox.sendKeys(ccData.getBillingZip());
		}
		HandleDropDown.selectDDLByVisibletext(custRegister.timeZoneDropDown, ccData.getTimeZone());
		Thread.sleep(10000);
		try {
			custRegister.i_agreeCheckBox.click();
			/*if (custRegister.i_agreeCheckBox.isSelected() == true) {
				custRegister.registerButton.click();
			} else if (custRegister.i_agreeCheckBox.isSelected() == false) {
				custRegister.i_agreeCheckBox.click();
				custRegister.registerButton.click();
			}*/
		} catch (Exception e) {
			custRegister.i_agreeCheckBox.click();
		}
		try {
			Actions act = new Actions(driver);
			act.moveToElement(custRegister.registerButton).click().perform();
		} catch (Exception e) {
			custRegister.registerButton.click();
		}
		String actualTitle = driver.getTitle();
		String expectedTitle = "Registration Success";
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Customer with Name" + ccData.getCompanyName()+ " and Email Id "+ccData.getEmail()+" Registration is Successful ", true);
	}

}
