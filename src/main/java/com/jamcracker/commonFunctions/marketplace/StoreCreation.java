package com.jamcracker.commonFunctions.marketplace;

import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.CompanyRequestsPage;
import com.jamcracker.objectRepository.marketplace.MarketplaceHomePage;
import com.jamcracker.objectRepository.marketplace.MemberManagementPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public  class StoreCreation extends TestBase
{
	MarketplaceHomePage objMpHomePage = new MarketplaceHomePage();

	public  void storeCreation(String companyName, String companyAcronym, String companyURL, 
			String companyDesc,String addressLine1,String addressLine2,
			String addressLine3,String country,String state,String city,String zipCode,String firstName,String lastName,
			String emailAddress,String telephone,String faxNumber,String timezone)
	{
		
		try{
			
		MemberManagementPage objMemberMgmt = new MemberManagementPage();
		objMemberMgmt.addStoreButton.click();
		explicitWait(objMemberMgmt.companyNameTextBox);
		objMemberMgmt.companyNameTextBox.sendKeys(companyName);
		objMemberMgmt.companyAcronymTextBox.sendKeys(companyAcronym);
		objMemberMgmt.companyURLTextBox.sendKeys(companyURL);
		objMemberMgmt.companyDescTextBox.sendKeys(companyDesc);
		objMemberMgmt.addressLine1TextBox.sendKeys(addressLine1);
		objMemberMgmt.addressLineT2extBox.sendKeys(addressLine2);
		objMemberMgmt.addressLine3TextBox.sendKeys(addressLine3);
		HandleDropDown.selectDDLByVisibletext(objMemberMgmt.countryDropdown, country);
		HandleDropDown.selectDDLByVisibletext(objMemberMgmt.stateDropdown, state);
		objMemberMgmt.cityTextBox.sendKeys(city);
		objMemberMgmt.zipCodeTextBox.sendKeys(zipCode);
		objMemberMgmt.firstNameTextBox.sendKeys(firstName);
		objMemberMgmt.lastNameTextBox.sendKeys(lastName);
		objMemberMgmt.emailAddressTextBox.sendKeys(emailAddress);
		objMemberMgmt.telephoneTextBox.sendKeys(telephone);
		objMemberMgmt.faxTextBox.sendKeys(faxNumber);
		HandleDropDown.selectDDLByVisibletext(objMemberMgmt.timeZoneDropDown, timezone);
		objMemberMgmt.saveButton.click();
		objMpHomePage.AdministrationLink.click();
		CompanyRequestsPage objCompanyReqPage = new CompanyRequestsPage();
		objCompanyReqPage.companyRequestLink.click();
		Assert.assertTrue(objCompanyReqPage.companySelectCheckbox(emailAddress).isDisplayed(),"Companny is not Registered");
		Reporter.log("Company Registered successfully");
		
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
		
		
		
	}
	
			

}
