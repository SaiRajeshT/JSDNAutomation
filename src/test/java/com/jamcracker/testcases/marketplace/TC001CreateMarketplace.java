package com.jamcracker.testcases.marketplace;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.marketplace.ActivateMarketplace;
import com.jamcracker.commonFunctions.marketplace.MarketplaceBranding;
import com.jamcracker.commonFunctions.marketplace.MarketplaceCreation;
import com.jamcracker.commonFunctions.marketplace.MyCompanyRegionalSettings;
import com.jamcracker.commonFunctions.superAdmin.SuperAdminLogin;
import com.jamcracker.utilities.ExcelcolumnReader;
import com.jamcracker.utilities.TestBase;

@Listeners(com.jamcracker.listeners.TestListener.class)
public class TC001CreateMarketplace extends TestBase
{
	private String getURL() 
	{
		return getData("TestData.xls", "URLSheet", "URL", 2);
	}


	
	@DataProvider(name="MarketplaceCreationData")
	private String[][] getStackCreationData() {
		return getData("TestData.xls", "MpCreationDataSheet");
	}	
		
	@BeforeMethod
	@Parameters({"browser"})
	public void setUp(String browser)
	{
		init("chrome", getURL());
	}
	
	@Test(dataProvider="MarketplaceCreationData")
	
	 public void testCreateMarketplace(String runMode, String marketplaceURL ,String companyAcronym, String companyName, 
			 String mpAdminEmail, String mpAdminPassword,String marketplaceFullName,String marketplaceShortName, String MarketplaceAcronym)
	{
		//Login To SuperAdmin
		SuperAdminLogin superAdminLogin = new SuperAdminLogin();
		String superAdminEmail =  getData("TestData.xls", "CredentialsSheet", "Email Address", 2);
		String superAdminPassword =  getData("TestData.xls", "CredentialsSheet", "Password", 2);
		superAdminLogin.superAdminLogin(superAdminEmail, superAdminPassword);
		if (runMode.equalsIgnoreCase("y"))
		{			
			
			MarketplaceCreation objMarketplace = new MarketplaceCreation();
			
			objMarketplace.createMarketplace(marketplaceURL, companyAcronym, companyName, mpAdminEmail, mpAdminPassword, marketplaceFullName, marketplaceShortName, MarketplaceAcronym);
			
		}
		//in getData last parameter refers to row number.Ex: in below line 2 means row number 2 in excel sheet.
		String theme = getData("TestData.xls", "BrandingSheet", "Theme to be configured", 2);
		String defaultLanguage= getData("TestData.xls", "BrandingSheet", "Default Language", 2);
		
		//in extractExcelContentByColumnIndex Method last parameter refers to column number.Ex: in below line 4 means column number 4 in excel sheet.
		ArrayList<String> timeZonecColumn = ExcelcolumnReader.extractExcelContentByColumnIndex("TestData.xls","BrandingSheet",4);
		
		String defaultTimezone = getData("TestData.xls", "BrandingSheet", "Default Time Zone", 2);
		ArrayList<String> dateFormats = ExcelcolumnReader.extractExcelContentByColumnIndex("TestData.xls","BrandingSheet",6);
		String defaultDateFormat = getData("TestData.xls", "BrandingSheet", "Default Date Format", 2);
		String emailSignature    =getData("TestData.xls", "BrandingSheet", "Email Signature", 2);
		ArrayList<String> currencies = ExcelcolumnReader.extractExcelContentByColumnIndex("TestData.xls","BrandingSheet",9);
		String defaultCurrency	=  getData("TestData.xls", "BrandingSheet", "Default Currency", 2);
		String billingType		=  getData("TestData.xls", "BrandingSheet", "Billing Type", 2);
		String domDate			=  getData("TestData.xls", "BrandingSheet", "DOM Date", 2);
		String cutOffDays			=  getData("TestData.xls", "BrandingSheet", "CutOff Days", 2);
		String paymentDue		=  getData("TestData.xls", "BrandingSheet", "PaymentDue", 2);
		String paymentDueAlert		=  getData("TestData.xls", "BrandingSheet", "PaymentDueAlert", 2);
		String numberOfAlert		=  getData("TestData.xls", "BrandingSheet", "NumberofAlert", 2);
		String intervalBwnAlert		=  getData("TestData.xls", "BrandingSheet", "Interval b/w alerts", 2);
		ArrayList<String> paymentMethods = ExcelcolumnReader.extractExcelContentByColumnIndex("TestData.xls","BrandingSheet",15);

		//String[] paymentMethodsArray = paymentMethods.toArray(new String[paymentMethods.size()]);
		

		
		MarketplaceBranding objBranding = new MarketplaceBranding();
		objBranding.marketplaceBranding(companyName,theme,defaultLanguage,timeZonecColumn,
				defaultTimezone,dateFormats,defaultDateFormat,emailSignature,currencies,
				defaultCurrency,billingType,domDate,cutOffDays,paymentMethods,paymentDue,paymentDueAlert,
				numberOfAlert,intervalBwnAlert,"marketplaceBranding");
				
		MyCompanyRegionalSettings objRegionalSettings = new MyCompanyRegionalSettings();
objRegionalSettings.regionalSettings(defaultLanguage, timeZonecColumn, defaultTimezone, dateFormats, defaultDateFormat);
ActivateMarketplace actMarketplace = new ActivateMarketplace();
actMarketplace.activateMarketplace(companyName); 
			
		
	
	}
	
	@AfterMethod
	public void teardown()
	{
		//driver.quit();
	}
	
}
