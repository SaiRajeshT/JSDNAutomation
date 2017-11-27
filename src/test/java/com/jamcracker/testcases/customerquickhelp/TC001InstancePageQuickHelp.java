package com.jamcracker.testcases.customerquickhelp;

import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.commonFunctions.customer.QuickHelp;
import com.jamcracker.objectRepository.customer.InstancesPage;
import com.jamcracker.utilities.ExcelcolumnReader;
import com.jamcracker.utilities.TestBase;
@Listeners(com.jamcracker.listeners.TestListener.class)
public class TC001InstancePageQuickHelp extends TestBase {

	
	
	private String getURL() {
		return getData("TestData.xls", "URLSheet", "URL", 4);
	}

	@BeforeClass
	@Parameters({ "browser" })
	public void setUp(String browser) {
		init("Chrome", getURL());
	}
	
	private ArrayList<String>  getQuickhelpLinks()
	{
		ArrayList<String> linksList;
		linksList = ExcelcolumnReader.extractExcelContentByColumnIndex("Quick help Links.xls", "Links", 1);
	    return linksList;
	}

	private ArrayList<String> getonlineText()
	{
		ArrayList<String> textList;
		textList = ExcelcolumnReader.extractExcelContentByColumnIndex("Quick help Links.xls", "Links", 2);
		return textList;
		  
	}
																	
	@Test
	public void verifyQuickhelp() {
		CustomerAdminLogin custLogin = new CustomerAdminLogin();

		custLogin.customerAdminLogin("testnew5994@gmail.com", "Root123#");
		InstancesPage objinstancePage = new InstancesPage();
		objinstancePage.manageLink.click();
		objinstancePage.instancesLink.click();
		explicitWait(objinstancePage.searchTextBox);
	    //QuickHelp.verifyquickHelp(l1, l2);
		QuickHelp.verifyquickHelp(getQuickhelpLinks(),getonlineText());
		
		
	}

}
