package com.jamcracker.testcases.customeManagement;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.commonFunctions.customer.StartStack;
import com.jamcracker.commonFunctions.customer.StopStack;
import com.jamcracker.commonFunctions.customer.TerminateStack;
import com.jamcracker.objectRepository.customer.CustomerMenuAndSubmenuObjects;
import com.jamcracker.utilities.TestBase;

@Listeners(com.jamcracker.listeners.TestListener.class)

public class TC014StackAction extends TestBase {

	@BeforeClass
	@Parameters({ "browser","storeUrl" })
	public void setUp(String browser, String url) {
		init(browser, url);
	}

	@DataProvider(name = "StacksData")
	public String[][] getTerminateStackData() {
		return getData("Iaas Stack Orders.xls", "Stack Actions");
	}

	@Test(dataProvider = "StacksData")
	public void stackAction(String executable,String email, String password, String stackName,String action)
	{
		
		CustomerAdminLogin custLogin = new CustomerAdminLogin();
		TerminateStack objTerminateStack = new TerminateStack();
		StopStack objStopStack = new StopStack();
		StartStack objStartStack = new StartStack();

		if (executable.equalsIgnoreCase("y")) {
			custLogin.customerAdminLogin(email, password);
			
			switch (action.toLowerCase()) {
			case "start":
				objStartStack.startStack(stackName);
				break;
			case "stop":
				objStopStack.stopStack(stackName);
				break;
				
			case "terminate":
				objTerminateStack.terminateStack(stackName, action);
				break;
			}
			CustomerMenuAndSubmenuObjects objMenuPage = new CustomerMenuAndSubmenuObjects();
			objMenuPage.profileIcon.click();
			objMenuPage.signOutLink.click();
	}
	}
}
