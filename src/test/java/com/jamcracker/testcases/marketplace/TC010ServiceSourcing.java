package com.jamcracker.testcases.marketplace;

import java.io.File;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.marketplace.MarketplaceLogin;
import com.jamcracker.commonFunctions.marketplace.ServiceSourcing;
import com.jamcracker.entity.service.ServiceSourceData;
import com.jamcracker.excel.reader.ReadServiceOfferSheet;
import com.jamcracker.utilities.TestBase;

public class TC010ServiceSourcing extends TestBase {
	
	@BeforeMethod
	@Parameters({ "browser", "targetMpUrl" })
	public void setUp(String browser, String url) {
		init(browser, url);
	}
	
	@DataProvider(name="serviceSourceData")
	public ServiceSourceData[] getServiceSourceData() {
		ReadServiceOfferSheet reader = new ReadServiceOfferSheet(System.getProperty("user.dir") + File.separator + "Data" + File.separator + "ServiceSourcing.xls");
		return reader.getServiceSourceData("ServiceSourcing.xls", "SourceServiceSheet");
	}
	
	@Test(dataProvider = "serviceSourceData")
	public void testServiceSourcing(ServiceSourceData serviceSource) {
		
		MarketplaceLogin mpLogin = new MarketplaceLogin();
		mpLogin.login(serviceSource.getEmail(),serviceSource.getPassword());
		
		ServiceSourcing serSource = new ServiceSourcing();
		serSource.serviceSource(serviceSource);
		
	}
	
	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}

}
