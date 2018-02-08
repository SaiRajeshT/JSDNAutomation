package com.jamcracker.testcases.customeManagement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.commonFunctions.customer.ImageInstOrder;
import com.jamcracker.entity.service.InstFromImageOrder;
import com.jamcracker.excel.reader.ExcelInstFromImageReader;
import com.jamcracker.utilities.TestBase;

@Listeners(com.jamcracker.listeners.TestListener.class)

public class TC019LaunchInstFromImage extends TestBase {

	@BeforeMethod
	@Parameters({ "browser", "storeUrl" })
	public void setUp(String browser, String url) {
		init(browser, url);
	}

	@DataProvider(name = "instFromImageData")
	private InstFromImageOrder[] getInstOrderData() {
		ExcelInstFromImageReader readInstOrderData = new ExcelInstFromImageReader("./Data/CustomerData.xls");
		return readInstOrderData.getExcelData("LaunchInst From Image");
	}

	@Test(dataProvider = "instFromImageData")
	public void imageInstOrder(InstFromImageOrder instorderinfo) {
		if (instorderinfo.getExecutable().equalsIgnoreCase("y")) {
			CustomerAdminLogin custLogin = new CustomerAdminLogin();
			custLogin.customerAdminLogin(instorderinfo.getEmail(), instorderinfo.getPassword());
			ImageInstOrder instOrderObj = new ImageInstOrder();
			if (instorderinfo.getExecutable().equalsIgnoreCase("y"))
				instOrderObj.instOrder(instorderinfo);
		}

	}

	@AfterMethod
	public void aftermethod() {
		getDriver().quit();
	}

}
