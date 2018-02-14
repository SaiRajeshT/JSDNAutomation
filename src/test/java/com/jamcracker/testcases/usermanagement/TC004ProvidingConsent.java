package com.jamcracker.testcases.usermanagement;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.commonFunctions.customer.ProvideConsent;
import com.jamcracker.utilities.TestBase;

public class TC004ProvidingConsent extends TestBase{
	
	
	@BeforeClass
	@Parameters({ "browser","storeUrl" })
	public void setUp(String browser) {
		init("chrome", "url");
	}
	
	@DataProvider(name="ProvidingConsentData")
	public String[][] getUserData(){
		return getData("CustomerData.xls", "ProvidingConsentSheet");
	}

	@Test(dataProvider = "ProvidingConsentData")
	public void testProvidingConsent(String executable, String custEmail, String password,
			String offerName, String userEmail, String userPassword, String newPassword) throws Exception 
	{
		
	
	if(executable.equalsIgnoreCase("y"))
	{  
		CustomerAdminLogin loginObj = new CustomerAdminLogin();
		loginObj.customerAdminLogin(custEmail, password);
		ProvideConsent objProvideConsent = new ProvideConsent();
		objProvideConsent.provideConsent(custEmail, password, offerName, userEmail, userPassword, newPassword);
    }
	}
}
