package com.jamcracker.testcases.marketplace;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.marketplace.CMSStoreConfiguration;
import com.jamcracker.commonFunctions.marketplace.DrupalAdminLogin;
import com.jamcracker.utilities.TestBase;

public class TC009CmsStoreConfiguration extends TestBase {

	@DataProvider(name = "cmsStoreData")
	public String[][] getCmsStoreData() {
		return getData("CMSStoreConfigData.xls", "CmsStoresSheet");
	}

	@BeforeMethod
	@Parameters({ "browser", "sourceStoreUrl" })
	public void setUp(String browser, String url) {
		init(browser, url);
	}

	@Test(dataProvider = "cmsStoreData")
	public void testCMSStoreConfiguration(String domain, String name, String storeType, String siteName,
			String emailAddress, String defaultLanguage) {
		DrupalAdminLogin daLogin = new DrupalAdminLogin();
		daLogin.drupalAdminLogin();
		CMSStoreConfiguration cmsStore = new CMSStoreConfiguration();
		cmsStore.storeCMSConfiguration(domain, name, storeType, siteName, emailAddress, defaultLanguage);
	}

	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}

}
