package com.jamcracker.testcases.customeManagement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.EnterpriseAdminLogin;
import com.jamcracker.commonFunctions.customer.OrderNew;
import com.jamcracker.utilities.TestBase;

public class TC020EnterpriseOrderNew extends TestBase {
	
	@DataProvider(name = "entOrderNewData")
	public String[][] getOrderPlaceData() {
		return getData("CustomerData.xls", "OrderNewSheet");
	}
	@BeforeMethod
	@Parameters({"browser","storeUrl"})
	public void setUp(String browser, String url) {
		init(browser, url);
	}

	@Test(dataProvider = "entOrderNewData")
	public void EntOrderNew(String executable,String email, String password, String serviceName, String offerName, String offerCode,
			String quantity, String paymentMethod,String dummyBudget, String existingMicrosoftCloudCustomer, String microsoftPrimaryDomain)throws Exception{
	
		if(executable.equalsIgnoreCase("Y"))
		{
			EnterpriseAdminLogin entLogin = new EnterpriseAdminLogin();
			entLogin.enterpriseAdminLogin(email,password);
			OrderNew objOrderNew = new OrderNew();
			objOrderNew.orderNew(serviceName, offerName, offerCode, quantity, paymentMethod, dummyBudget, existingMicrosoftCloudCustomer, microsoftPrimaryDomain);
			
		}
	}
			
		@AfterMethod
		public void tearDown() {
			closeBrowser();
		
	}
}
