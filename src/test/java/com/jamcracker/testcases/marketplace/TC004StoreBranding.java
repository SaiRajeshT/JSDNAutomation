package com.jamcracker.testcases.marketplace;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.marketplace.IdentityManagement;
import com.jamcracker.commonFunctions.marketplace.MarketplaceLogin;
import com.jamcracker.commonFunctions.marketplace.SetUpBillingOptions;
import com.jamcracker.commonFunctions.marketplace.StoreAvailableServiceSelection;
import com.jamcracker.commonFunctions.marketplace.StoreBranding;
import com.jamcracker.commonFunctions.marketplace.StoreEmailNotificationSetUp;
import com.jamcracker.commonFunctions.marketplace.StoreInvoiceSettings;
import com.jamcracker.commonFunctions.marketplace.StorePolicies;
import com.jamcracker.commonFunctions.marketplace.StorePreferences;
import com.jamcracker.commonFunctions.marketplace.StoreRegionalSetting;
import com.jamcracker.commonFunctions.marketplace.StoreRequestApprove;
import com.jamcracker.commonFunctions.marketplace.StoreReview;
import com.jamcracker.commonFunctions.marketplace.StoreSearchPreference;
import com.jamcracker.commonFunctions.marketplace.StoreTypeSelection;
import com.jamcracker.objectRepository.marketplace.MarketplaceHomePage;
import com.jamcracker.objectRepository.marketplace.SetUpPage;
import com.jamcracker.objectRepository.marketplace.StoreRequestsPage;
import com.jamcracker.utilities.ExcelcolumnReader;
import com.jamcracker.utilities.TestBase;

public class TC004StoreBranding extends TestBase 
{
	private String getURL() 
	{
		return getData("TestData.xls", "URLSheet", "URL", 3);
	}


	
	@BeforeMethod
	@Parameters({"browser"})
	public void setUp(String browser)
	{
		init("chrome", getURL());
	}
	
	
  @Test
  public void storeBranding() 
  
  {
	  	String mpAdminEmail =  getData("TestData.xls", "CredentialsSheet", "Email Address", 3);
		String mpAdminPassword =  getData("TestData.xls", "CredentialsSheet", "Password", 3);
		MarketplaceLogin mpLoginObj = new MarketplaceLogin();
		mpLoginObj.login(mpAdminEmail,mpAdminPassword);
		MarketplaceHomePage objMpHomePage = new MarketplaceHomePage();
		objMpHomePage.AdministrationLink.click();
		StoreRequestsPage objStoreReqPage = new StoreRequestsPage();
		objStoreReqPage.storeRequestLink.click();
		String storeAdminEmail= getData("TestData.xls", "Store Creation Sheet", "Email Address", 2);
		System.out.println(storeAdminEmail);
		String companyName= getData("TestData.xls", "Store Creation Sheet", "Company Name", 2);
		String companyAcronym= getData("TestData.xls", "Store Creation Sheet", "Company Acronym", 2);

		//Clicking on Review store
		StoreReview objStoreReview = new StoreReview();
		objStoreReview.testStoreReview(storeAdminEmail);
		
		//Performing Store Branding
		StoreBranding storeBrandObj = new StoreBranding();
		String theme = getData("TestData.xls", "Store Branding","Theme to be configured", 2);
		storeBrandObj.storeBranding(theme);
		
		
		//Performing Regional Settings for Store
		ArrayList<String> languages = ExcelcolumnReader.extractExcelContentByColumnIndex("TestData.xls", "Store Branding", 3);
		String defaultLanguage		= getData("TestData.xls", "Store Branding","Default Language", 2);
		ArrayList<String> timezones = ExcelcolumnReader.extractExcelContentByColumnIndex("TestData.xls", "Store Branding", 5);
		String defaultTimezone = getData("TestData.xls", "Store Branding","Default Time Zone", 2);
		ArrayList<String> dateFormats = ExcelcolumnReader.extractExcelContentByColumnIndex("TestData.xls", "Store Branding", 7);
		String defaultDateFormat = getData("TestData.xls", "Store Branding","Default Date Format", 2);
		
		StoreRegionalSetting.testStoreRegionalSetting(languages, defaultLanguage,timezones,defaultTimezone,dateFormats,defaultDateFormat);
		StorePolicies.testPrivacyPolicyUpload();
		StorePolicies.testSecurityStatementUpload();
		
		SetUpPage objSetUpPage =  SetUpPage.getInstance();
		
		
		//Selecting Store Type as Enteprise/Reseller
		//objSetUpPage.storeTypeLink.click();
		String storeType = getData("TestData.xls", "Store Branding","Store Type", 2);
		String budget =  getData("TestData.xls", "Store Branding","Enable Budget", 2);
		StoreTypeSelection.testStoreSelect(storeType,budget);
		
		
		//Identity Management configuration
		String identiyMgmt = getData("TestData.xls", "Store Branding","Identity Management", 2);
		IdentityManagement.testIdentityManagement(identiyMgmt);
		
		//Selecting and unselecting the service 
		String selectservice = getData("TestData.xls", "Store Branding","Select All the Services", 2);
		StoreAvailableServiceSelection.selectSerivces(selectservice);
		
		//Setting up Email Id's 
		String emailId =  getData("TestData.xls", "Store Branding","Store Order Emails", 2);
		String emailSignature = getData("TestData.xls", "Store Branding","Email Signature", 2);
		String supportEmailSignature = getData("TestData.xls", "Store Branding","Help Desk Email Signature", 2);
		String contentRequestEmail = getData("TestData.xls", "Store Branding","Content only Service Email id", 2);
		String supportFromAddress = getData("TestData.xls", "Store Branding","From Address for Customer Support mail", 2);
		String storeRegisterEmail = getData("TestData.xls", "Store Branding","New Store Registrant Email", 2);
		String notificationFromAddress = getData("TestData.xls", "Store Branding","From Address for Notification mails", 2);


		
		
		StoreEmailNotificationSetUp.getInstance().emailPageSetup(emailSignature,storeRegisterEmail,emailId,notificationFromAddress
				,supportEmailSignature,contentRequestEmail,supportFromAddress);
		
		//Configuring Billing options page store
		String storeCurrency = getData("TestData.xls", "Store Branding","Store Currency", 2);
		ArrayList<String> paymentMethods= ExcelcolumnReader.extractExcelContentByColumnIndex("TestData.xls", "Store Branding",17);
		String defultPaymentMethod =  getData("TestData.xls", "Store Branding","Default Payment Method", 2);
		String paymentDueAlert	 =   getData("TestData.xls", "Store Branding","PaymentDueAlert", 2);
		String numberOfAlerts	 =   getData("TestData.xls", "Store Branding","NumberofAlert", 2);
		String intervalBwnAlert  =   getData("TestData.xls", "Store Branding","Interval b/w alerts", 2);
		String creditCardPaymentGateway	 =   getData("TestData.xls", "Store Branding","Credit card Payment Gateway", 2);
		String payPalPaymentGateway  =   getData("TestData.xls", "Store Branding","PayPal Payment Gateway", 2);
		String daysBetweenRetries  =  getData("TestData.xls", "Store Branding","Days Between Retries", 2);
		String numberOfPaymentAttempts  =  getData("TestData.xls", "Store Branding","Number of Payment Attempts", 2);

	
		
		SetUpBillingOptions.getInstance().testSetUpBillingOptions(storeCurrency, paymentMethods,  creditCardPaymentGateway, 
				payPalPaymentGateway,daysBetweenRetries,numberOfPaymentAttempts,defultPaymentMethod,
				paymentDueAlert,numberOfAlerts, intervalBwnAlert,"testSetUpBillingOptions");
		//objSetUpPage.preferencesLink.click();
		
		//Reading the data from excel sheet to configure prefernece page and calling StorePrefrence method
		String deleteCompany = getData("TestData.xls", "Store Branding","Delete Company", 2).trim();
		String suspendCompany = getData("TestData.xls", "Store Branding","Suspend Company", 2).trim();
		String proxyCustomer = getData("TestData.xls", "Store Branding","Proxy Customer", 2).trim();
		String enableSelfOrder = getData("TestData.xls", "Store Branding","Enable Self order", 2).trim();
		String showPublisherInfo = getData("TestData.xls", "Store Branding","Show publisher Info", 2).trim();
		String manageCommercialContent = getData("TestData.xls", "Store Branding","Manage commercial Content", 2).trim();
		String showAnalyticStatistics = getData("TestData.xls", "Store Branding","Show analytic Statistics", 2).trim();
		String overrideServiceDependency= getData("TestData.xls", "Store Branding","Override service Dependency", 2).trim();
		String itemLevelSAD = getData("TestData.xls", "Store Branding","Service Activation Date for Item level", 2).trim();
		String accessHelpDesk = getData("TestData.xls", "Store Branding","HelpDesk for Customer", 2).trim();
		
		StorePreferences.getInstance().storePreferences(deleteCompany,suspendCompany,proxyCustomer,enableSelfOrder,
				showPublisherInfo,manageCommercialContent,showAnalyticStatistics,overrideServiceDependency,
				itemLevelSAD,accessHelpDesk);
		
		//Configuring Invoice page set up by calling Invoice Method
		StoreInvoiceSettings.getInstance().invoicePageSetup();
		
		//Configuring Final search preference and submitting store for approval
		StoreSearchPreference.getInstance().storeSearchPreference();
		objSetUpPage.proxyBackToMktPlaceLink.click();
		//Need to verify whether proxied back or not
		//Approving store 
		StoreRequestApprove.testStoreRequestApprove(storeAdminEmail,companyName,companyAcronym);

	  
  }
  
  
  
  @AfterMethod
  public void afterMethod() {
	//  driver.quit();
  }

}
