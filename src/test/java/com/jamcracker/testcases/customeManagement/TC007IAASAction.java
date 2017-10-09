package com.jamcracker.testcases.customeManagement;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.commonFunctions.customer.SshAction;
import com.jamcracker.commonFunctions.customer.StartInstance;
import com.jamcracker.commonFunctions.customer.StopInstance;
import com.jamcracker.commonFunctions.customer.TerminateServer;
import com.jamcracker.objectRepository.customer.CustomerMenuAndSubmenuObjects;
import com.jamcracker.utilities.TestBase;
@Listeners(com.jamcracker.listeners.TestListener.class)
public class TC007IAASAction extends TestBase {

	private String getURL() {
		return getData("TestData.xls", "URLSheet", "URL", 4);
	}

	@BeforeClass
	@Parameters({ "browser" })
	public void setUp(String browser) {
		init("chrome", getURL());
	}

	@DataProvider(name = "StartInstanceData")
	public String[][] getInstanceData() {
		return getData("Iaas Stack Orders.xls", "Instances sheet"); }// passing file name and sheet name
																	
	@Test(dataProvider = "StartInstanceData")
	public void iaasAction(String executable, String action, String email, String Password, String instName) {
		StartInstance objStartInstance = new StartInstance();
		StopInstance objStopInstance = new StopInstance();
		TerminateServer objTerminateInstance = new TerminateServer();
		SshAction objssh = new SshAction();

		CustomerAdminLogin custLogin = new CustomerAdminLogin();

		if (executable.equalsIgnoreCase("y")) {
			custLogin.customerAdminLogin(email, Password);

			switch (action.toLowerCase()) {
			case "start server":
				objStartInstance.startInstance(instName);
				break;
			case "stop server":
				objStopInstance.stopInstance(instName);
				break;
				
			case "terminate server":
				objTerminateInstance.terminateServer(instName);
				break;
				
			case"ssh":
				objssh.sshAction(instName);
				
				
			}
		
			CustomerMenuAndSubmenuObjects objMenuPage = new CustomerMenuAndSubmenuObjects();
			objMenuPage.profileIcon.click();
			objMenuPage.signOutLink.click();	
		}
		
		
		
	}

}
