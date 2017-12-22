package com.jamcracker.testcases.customeManagement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.commonFunctions.customer.CustomerLogout;
import com.jamcracker.commonFunctions.customer.ResizeInstance;
import com.jamcracker.utilities.TestBase;


@Listeners(com.jamcracker.listeners.TestListener.class)


public class TC010ResizeInstance extends TestBase {
	
@BeforeClass
@Parameters({"browser","storeUrl"})
public void setUp(String browser, String url)
{
	init(browser,url);
}

@DataProvider(name = "resizeInstanceData")
public String[][] getInstanceData() {
	return getData("CustomerData.xls", "Resize sheet");}
@Test(dataProvider="resizeInstanceData")	
public  void resizeInstance(String executable,String email,String password,String instName,String flavor){
	
	CustomerAdminLogin custLogin = new CustomerAdminLogin();

	if (executable.equalsIgnoreCase("y")) {
		custLogin.customerAdminLogin(email, password);
		ResizeInstance.resizeInstance(instName,flavor);
		
		CustomerLogout.logOut();
		
		
	}
	
	
}

@AfterClass
public void close()
{
	closeBrowser();

}

}
