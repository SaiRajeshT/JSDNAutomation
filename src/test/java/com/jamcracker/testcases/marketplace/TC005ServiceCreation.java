package com.jamcracker.testcases.marketplace;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.marketplace.MarketplaceLogin;
import com.jamcracker.commonFunctions.marketplace.ServiceApprove;
import com.jamcracker.commonFunctions.marketplace.ServiceCreation;
import com.jamcracker.entity.service.ServicesInfo;
import com.jamcracker.excel.reader.ReadServiceOfferSheet;
import com.jamcracker.objectRepository.marketplace.MarketplaceHomePage;
import com.jamcracker.objectRepository.marketplace.MyservicesPage;
import com.jamcracker.utilities.SwitchFrame;
import com.jamcracker.utilities.TestBase;
@Listeners(com.jamcracker.listeners.TestListener.class)
public class TC005ServiceCreation extends TestBase{
	
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
//	@DataProvider(name="ServicesData")
//	private String[][] getServiceCreationData()
//	{
//		return getData("Service Creation TestData.xls","ServicesData");
//	} 

	
	@DataProvider(name="ServicesData")
	private ServicesInfo[] getServiceCreationData()
	{
		ReadServiceOfferSheet readServiceOfferSheet = new ReadServiceOfferSheet("./Data/Service Creation TestData.xls");
		return readServiceOfferSheet.getDataFromSheet("Service Creation TestData.xls","ServicesInformation","Offer Details");
	} 
	
  @Test(dataProvider="ServicesData")
  public void servicCreation(ServicesInfo serviceOffer) 
  {
	 try{
	  //Login to marketplace
		String mpAdminEmail =  getData("TestData.xls", "CredentialsSheet", "Email Address", 3);
		String mpAdminPassword =  getData("TestData.xls", "CredentialsSheet", "Password", 3);
		MarketplaceLogin mpLoginObj = new MarketplaceLogin();
		mpLoginObj.login(mpAdminEmail,mpAdminPassword);
		
	//Creating service
		MarketplaceHomePage objMpHomePage = new MarketplaceHomePage();
		objMpHomePage.myCompanyLink.click();
		MyservicesPage objMyServices = new MyservicesPage();
		objMyServices.myServiceLInk.click();
		objMyServices.addServiceButton.click();
		Thread.sleep(3000);
		SwitchFrame.nameIdSwitch("_iframe-divwin");
		objMyServices.newServiceRadioButton.click();
		objMyServices.continueButton.click();
		ServiceCreation objServiceCreate = new ServiceCreation();
		objServiceCreate.serviceInfoConfig(serviceOffer);
	   // objServiceCreate.offerInfoConfig();
		objServiceCreate.activitiesPage();
		objServiceCreate.resourcePage();
		ServiceApprove.serviceApprove(serviceOffer.getServiceName());
	 }
	 
	 catch(Exception e)
	 {
		 e.printStackTrace();
		 Assert.fail();
	 }
		
  }
 
  @AfterMethod
  public void afterTest() {
	 // driver.quit();
  }

}
