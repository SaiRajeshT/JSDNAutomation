package com.jamcracker.testcases.customeManagement;

import java.io.File;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.CustomerCreation;
import com.jamcracker.entity.service.CustomerCreationData;
import com.jamcracker.excel.reader.CustomerCreationReader;
import com.jamcracker.utilities.TestBase;

public class TC001CustomerRegistration extends TestBase {

	@DataProvider(name = "customerRegistrationData")
	public CustomerCreationData[] getStackCreationData() {
		CustomerCreationReader reader = new CustomerCreationReader(System.getProperty("user.dir") + File.separator + "Data" + File.separator + "CustomerCreationData.xls");
		return reader.getCustomerCreationData("CustomerCreationData.xls", "CustomerRegistrationSheet");
	}

	@BeforeMethod
	@Parameters({"browser","storeUrl"})
	public void setUp(String browser, String url) {
		init(browser, url);
	}

	@Test(dataProvider = "customerRegistrationData")
	public void testCustomerRegistration(CustomerCreationData ccData) throws Exception {
		CustomerCreation customer = new CustomerCreation();
		customer.customerCreation(ccData);
	}

	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}

}
