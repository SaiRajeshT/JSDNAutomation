package com.jamcracker.testcases.customeManagement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.commonFunctions.customer.OrderNew;
import com.jamcracker.utilities.TestBase;

public class TCMSCSPOrderNew extends TestBase {

	@DataProvider(name = "testOrderNewData")
	public String[][] getOrderPlaceData() {
		return getData("CustomerData.xls", "OrderNewSheet");
	}

	@BeforeMethod
	@Parameters({"browser","storeUrl"})
	public void setUp(String browser, String url) {
		init("chrome", url);
	}

	@Test(dataProvider = "testOrderNewData")
	public void testOrderNew(String executable,String email, String password, String serviceName, String offerName, String offerCode,
			String quantity,String paymentMethod,String budgetCode,String ExistingMicrosoftCloudCustomer,String MicrosoftPrimaryDomain) throws Exception {
		if(executable.equalsIgnoreCase("Y"))
		{
		CustomerAdminLogin custLogin = new CustomerAdminLogin();
		custLogin.customerAdminLogin(email, password);
		OrderNew objOrderNew = new OrderNew();
		objOrderNew.orderNew(serviceName, offerName, offerCode, quantity, paymentMethod,budgetCode,ExistingMicrosoftCloudCustomer,MicrosoftPrimaryDomain);
		}
	}

	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}

}
