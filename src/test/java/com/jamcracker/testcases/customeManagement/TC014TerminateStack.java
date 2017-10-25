package com.jamcracker.testcases.customeManagement;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.commonFunctions.customer.TerminateStack;
import com.jamcracker.utilities.TestBase;

public class TC014TerminateStack extends TestBase{
	

	private String getURL() {
		return getData("TestData.xls", "URLSheet", "URL", 4);
	}

	@BeforeClass
	@Parameters({ "browser" })
	public void setUp(String browser) {
		init("chrome", getURL());
	}

	@DataProvider(name = "TerminateStack")
	public String[][] getTerminateStackData() {
		return getData("Iaas Stack Orders.xls", "Terminate Stack");
	}
	@Test(dataProvider = "TerminateStack")
	public void staticIp(String executable,String email, String password, String stackName,String action)
	{
		
		CustomerAdminLogin custLogin = new CustomerAdminLogin();
		TerminateStack objTerminateStack = new TerminateStack();

		if (executable.equalsIgnoreCase("y")) {
			custLogin.customerAdminLogin(email, password);
			objTerminateStack.terminateStack(stackName, action);
		
	}
	
	}

}
