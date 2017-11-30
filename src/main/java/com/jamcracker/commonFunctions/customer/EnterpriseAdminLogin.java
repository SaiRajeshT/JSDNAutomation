package com.jamcracker.commonFunctions.customer;

import com.jamcracker.objectRepository.customer.StoreHomePage;
import com.jamcracker.utilities.TestBase;


public class EnterpriseAdminLogin extends TestBase {

	
	public static void  enterpriseAdminLogin(String username, String password) {
		StoreHomePage storeHome = new StoreHomePage();

		storeHome.signInLink.click();
		try {
			explicitWait(storeHome.usernameTextBox);
		} catch (Exception e) {
			storeHome.signInLink.click();
			explicitWait(storeHome.usernameTextBox);
		}
		storeHome.usernameTextBox.sendKeys(username);
		storeHome.passwordTextBox.sendKeys(password);
		storeHome.signInButton.click();
	}

}
