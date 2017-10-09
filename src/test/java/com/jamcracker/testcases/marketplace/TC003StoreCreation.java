package com.jamcracker.testcases.marketplace;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.marketplace.CompanyRequestApprove;
import com.jamcracker.commonFunctions.marketplace.MarketplaceLogin;
import com.jamcracker.commonFunctions.marketplace.StoreCreation;
import com.jamcracker.objectRepository.marketplace.MarketplaceHomePage;
import com.jamcracker.objectRepository.marketplace.MemberManagementPage;
import com.jamcracker.utilities.TestBase;

public class TC003StoreCreation extends TestBase
{
	private String getURL() 
	{
		return getData("TestData.xls", "URLSheet", "URL", 3);
	}


	
	
	@DataProvider(name="storeCreationData")
	private String[][] getStoreCreationData()
	{
		return getData("TestData.xls","Store Creation Sheet");
	}
	
	@BeforeMethod
	@Parameters({"browser"})
	public void setUp(String browser)
	{
		init("chrome", getURL());
	}
	
	
	
	@Test(dataProvider="storeCreationData")
	public void testStoreCreation(String runMode,String companyName,String companyAcronym,String companyURL,String companyDesc,
			String addressLine1,String addressLine2, String addressLine3,String country,String state,
			String zipCode,String city,String firstName,String lastName,String email,String telephone,
			String faxNumber,String timezone)
	{
		
		
		
		if(runMode.equalsIgnoreCase("y"))
		{
			String mpAdminEmail =  getData("TestData.xls", "CredentialsSheet", "Email Address", 3);
			String mpAdminPassword =  getData("TestData.xls", "CredentialsSheet", "Password", 3);
			MarketplaceLogin mpLoginObj = new MarketplaceLogin();
			mpLoginObj.login(mpAdminEmail,mpAdminPassword);
			MarketplaceHomePage objMpHomePage = new MarketplaceHomePage();
			objMpHomePage.AdministrationLink.click();
			MemberManagementPage objMemberMgmtPage = new MemberManagementPage();
			explicitWait(objMemberMgmtPage.memberManagementLink);
			objMemberMgmtPage.memberManagementLink.click();
			explicitWait(objMemberMgmtPage.storeLink);
			objMemberMgmtPage.storeLink.click();
			StoreCreation objStoreCreation = new StoreCreation();
			objStoreCreation.storeCreation(companyName, companyAcronym, companyURL, companyDesc, 
					addressLine1, addressLine2, addressLine3, country, state, 
					city, zipCode, firstName, lastName, email, telephone, faxNumber, timezone);
			
			
			CompanyRequestApprove.companyRequestApprove(companyName);
			
			objMpHomePage.AdministrationLink.click();
			explicitWait(objMemberMgmtPage.memberManagementLink);
			objMemberMgmtPage.memberManagementLink.click();
			explicitWait(objMemberMgmtPage.storeLink);
			objMemberMgmtPage.storeLink.click();
			objMemberMgmtPage.searchTextBox.sendKeys(companyName);
			objMemberMgmtPage.goButton.click();
			explicitWait(objMemberMgmtPage.addStoreButton);
			if(companyName.equalsIgnoreCase(companyAcronym))
			Assert.assertEquals(objMemberMgmtPage.getStoreName(companyName).getText(),"New");
			else
				Assert.assertEquals(objMemberMgmtPage.getcompanyAcronym(companyAcronym).getText(),"New");
			Reporter.log("Company Approved successfully");
			
		}
			
		
		
		
	}
	
	
/*	@AfterMethod
	  public void teardown(ITestResult result)
	  {
		packageName=this.getClass().getPackage().getName();
		packageName=packageName.substring(packageName.lastIndexOf(".")+1,packageName.length());
		  if(ITestResult.FAILURE== result.getStatus())
		  {
			  System.out.println("Capturing screenshot");
			  CaptureScreenshot.screenshot(driver,result.getName(),packageName);
		  }
		 // driver.quit();
	  }  */

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	

}
