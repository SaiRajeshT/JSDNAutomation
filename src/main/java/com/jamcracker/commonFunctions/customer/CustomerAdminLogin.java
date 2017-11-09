package com.jamcracker.commonFunctions.customer;

import com.jamcracker.objectRepository.customer.StoreHomePage;
import com.jamcracker.utilities.TestBase;

public class CustomerAdminLogin extends TestBase {
	
	StoreHomePage storeHome = new StoreHomePage();
	
	public void customerAdminLogin(String username, String password) {
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
