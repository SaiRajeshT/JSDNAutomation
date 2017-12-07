package com.jamcracker.testcases.customeManagement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.commonFunctions.customer.CustomerLogout;
import com.jamcracker.commonFunctions.customer.GetStaticIp;
import com.jamcracker.utilities.TestBase;

@Listeners(com.jamcracker.listeners.TestListener.class)

public class TC013StaticIpAddress extends TestBase{
	
	@BeforeClass
	@Parameters({ "browser","storeUrl" })
	public void setUp(String browser, String url) {
		init(browser, url);
	}

	@DataProvider(name = "StaticIp")
	public String[][] getInstanceData() {
		return getData("Iaas Stack Orders.xls", "Static Public Ip address");
	}
	@Test(dataProvider = "StaticIp")
	public void staticIp(String executable,String email, String password, String provider, String region, String network)
	{
		
		CustomerAdminLogin custLogin = new CustomerAdminLogin();
		GetStaticIp objStaticIp = new GetStaticIp();

		if (executable.equalsIgnoreCase("y")) {
			custLogin.customerAdminLogin(email, password);
			objStaticIp.getStaticIp(provider,region,network);
			CustomerLogout.logOut();

	}
	
	}

	@AfterClass
	public void close()
	{
		closeBrowser();

	}
}
