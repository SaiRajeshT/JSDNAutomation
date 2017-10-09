package com.jamcracker.testcases.customeManagement;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.commonFunctions.customer.ResizeInstance;
import com.jamcracker.utilities.TestBase;


@Listeners(com.jamcracker.listeners.TestListener.class)


public class TC010ResizeInstance extends TestBase {
	
	private String getURL() {
		return getData("TestData.xls", "URLSheet", "URL", 4);
	}
	
@BeforeClass
@Parameters({"browser"})
public void setUp(String browser)
{
	init("chrome",getURL());
}

@DataProvider(name = "resizeInstanceData")
public String[][] getInstanceData() {
	return getData("Iaas Stack Orders.xls", "Resize sheet");}
@Test(dataProvider="resizeInstanceData")	
public  void resizeInstance(String executable,String email,String password,String instName,String flavor){
	
	CustomerAdminLogin custLogin = new CustomerAdminLogin();

	if (executable.equalsIgnoreCase("y")) {
		custLogin.customerAdminLogin(email, password);
		ResizeInstance.resizeInstance(instName,flavor);
		
		//CustomerLogout.logOut();
		
		
	}
	
	
}
	

}
