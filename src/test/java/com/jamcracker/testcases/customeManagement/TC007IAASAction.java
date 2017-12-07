package com.jamcracker.testcases.customeManagement;

import org.junit.After;
import org.testng.annotations.AfterClass;
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

	@BeforeClass
	@Parameters({ "browser","storeUrl" })
	public void setUp(String browser, String url) {
		init(browser, url);
	}

	@DataProvider(name = "StartInstanceData")
	public String[][] getInstanceData() {
		return getData("Iaas Stack Orders.xls", "Instances sheet"); }// passing file name and sheet name
																	
	@Test(dataProvider = "StartInstanceData")
	public void iaasAction(String executable, String action, String email, String Password, String instName,String imageName) {
		StartInstance objStartInstance = new StartInstance();
		StopInstance objStopInstance = new StopInstance();
		TerminateServer objTerminateInstance = new TerminateServer();
		SshAction objssh = new SshAction();

		CustomerAdminLogin custLogin = new CustomerAdminLogin();
		CustomerMenuAndSubmenuObjects objMenuPage = new CustomerMenuAndSubmenuObjects();

		if (executable.equalsIgnoreCase("y")) {
			try{
				driver.navigate().refresh();
				objMenuPage.profileIcon.click();
				objMenuPage.signOutLink.click();
			}
			catch(Exception e)
			{
				
			}
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
		
			objMenuPage.profileIcon.click();
			objMenuPage.signOutLink.click();	
		}
		
		
		
	}
	@AfterClass
	public void close()
	{
		closeBrowser();

	}

}
