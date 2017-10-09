package com.jamcracker.testcases.customeManagement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.commonFunctions.customer.OrderNew;
import com.jamcracker.utilities.TestBase;

public class TC003OrderNew extends TestBase {

	@DataProvider(name = "orderNewData")
	public String[][] getOrderPlaceData() {
		return getData("OrdersData.xls", "OrderNewSheet");
	}

	@BeforeMethod
	@Parameters({"browser","storeUrl"})
	public void setUp(String browser, String url) {
		init(browser, url);
	}

	@Test(dataProvider = "orderNewData")
	public void testOrderNew(String email, String password, String serviceName, String offerName, String offerCode,
			String quantity, String paymentMethod) throws Exception {

		CustomerAdminLogin custLogin = new CustomerAdminLogin();
		custLogin.customerAdminLogin(email, password);
		OrderNew orderNew = new OrderNew();
		orderNew.orderNew(serviceName, offerName, offerCode, quantity, paymentMethod);

	}

	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}

}
