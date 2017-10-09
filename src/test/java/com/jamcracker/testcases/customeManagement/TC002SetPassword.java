package com.jamcracker.testcases.customeManagement;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.SetPassword;
import com.jamcracker.utilities.ExcelcolumnReader;
import com.jamcracker.utilities.TestBase;

public class TC002SetPassword extends TestBase {

	@DataProvider(name = "setPasswordData")
	public String[] getSetPasswordData() {
		ArrayList<String> emailist = ExcelcolumnReader.extractExcelContentByColumnIndex("CustomerCreationData.xls",
				"CustomerRegistrationSheet", 3);
		String[] emailistData = emailist.toArray(new String[emailist.size()]);
		return emailistData;
	}

	@BeforeMethod
	@Parameters({"browser","storeUrl"})
	public void setUp(String browser, String url) {
		init(browser, url);
	}

	@Test(dataProvider = "setPasswordData")
	public void testSetpassword(String email) {

		String password = getData("CustomerCreationData.xls", "SetPasswordSheet", "New Password", 2);
		String secQues = getData("CustomerCreationData.xls", "SetPasswordSheet", "Security Question", 2);
		String secAns = getData("CustomerCreationData.xls", "SetPasswordSheet", "Security Answer", 2);
		SetPassword setPassword = new SetPassword();
		setPassword.setPassword(email, password, secQues, secAns);

	}

	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}

}
