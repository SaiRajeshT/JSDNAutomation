package com.jamcracker.testcases.customeManagement;

import java.util.LinkedList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.commonFunctions.customer.QuickHelp;
import com.jamcracker.objectRepository.customer.InstancesPage;
import com.jamcracker.utilities.TestBase;
@Listeners(com.jamcracker.listeners.TestListener.class)
public class VerifyQuickHelpInstancePage extends TestBase {

	private String getURL() {
		return getData("TestData.xls", "URLSheet", "URL", 4);
	}

	@BeforeClass
	@Parameters({ "browser" })
	public void setUp(String browser) {
		init("Chrome", "https://mntstore.jamcracker.com/");
	}

																	
	@Test
	public void verifyQuickhelp() {
		CustomerAdminLogin custLogin = new CustomerAdminLogin();

		custLogin.customerAdminLogin("testnew5994@gmail.com", "Root123#");
		InstancesPage objinstancePage = new InstancesPage();
		objinstancePage.manageLink.click();
		objinstancePage.instancesLink.click();
		explicitWait(objinstancePage.searchTextBox);
		LinkedList<String> l1  = new LinkedList<String>();
		l1.add("Search instances");
		l1.add("Manage instances");
		l1.add("Launch vendor console");
		
		LinkedList<String> l2  = new LinkedList<String>();
		l2.add("Search for Specific Instances");
		l2.add("Managing Instances");
		l2.add("Launching Vendor Console");
		QuickHelp.verifyquickHelp(l1, l2);
		
		
	}

}
