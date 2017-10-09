package com.jamcracker.testcases.customeManagement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.commonFunctions.customer.OrderMore;
import com.jamcracker.utilities.TestBase;

public class TC004OrderMore extends TestBase {

	@DataProvider(name = "orderMoreData")
	public String[][] getOrderPlaceData() {
		return getData("OrdersData.xls", "OrderMoreSheet");
	}

	@BeforeMethod
	@Parameters({"browser","storeUrl"})
	public void setUp(String browser, String url) {
		init(browser, url);
	}

	@Test(dataProvider = "orderMoreData")
	public void testOrderMore(String email, String password, String serviceName, String offerName, String offerCode,
			String newQuantity) throws Exception {

		CustomerAdminLogin custLogin = new CustomerAdminLogin();
		custLogin.customerAdminLogin(email, password);
		OrderMore orderMore = new OrderMore();
		orderMore.orderMore(offerCode, newQuantity);

	}

	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}

}
