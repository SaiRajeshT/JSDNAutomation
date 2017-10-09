package com.jamcracker.testcases.customeManagement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.commonFunctions.customer.IaasStackOrder;
import com.jamcracker.entity.service.StackOrder;
import com.jamcracker.excel.reader.ExcelStackOrderReader;
import com.jamcracker.utilities.TestBase;

@Listeners(com.jamcracker.listeners.TestListener.class)

public class TC006PlaceStackOrder extends TestBase
{
	private String getURL() 
	{
		return getData("TestData.xls", "URLSheet", "URL", 4);
	}


	
	@BeforeMethod
	@Parameters({"browser"})
	public void setUp(String browser)
	{
		init("chrome", getURL());
	}

@DataProvider(name="StackOrdersData")
private StackOrder[] getStackOrderData()
{
	ExcelStackOrderReader readStackOrderData = new ExcelStackOrderReader("./Data/Iaas Stack Orders.xls");
	return readStackOrderData.getExcelData("Stack Orders");
}

	@Test(dataProvider="StackOrdersData")
	public void stackOrder(StackOrder stackorderinfo)
	{
		if(stackorderinfo.getExecutable().equalsIgnoreCase("y")){
		CustomerAdminLogin custLogin = new CustomerAdminLogin();
		custLogin.customerAdminLogin(stackorderinfo.getEmail(), stackorderinfo.getPassword());
		IaasStackOrder stackOrder = new IaasStackOrder();
		if(stackorderinfo.getExecutable().equalsIgnoreCase("y"))
		stackOrder.iaasStackOrder( stackorderinfo);}
		
		
		
	}
	

	@AfterMethod
	public void aftermethod()
	{
		//driver.quit();
	}
	
}
