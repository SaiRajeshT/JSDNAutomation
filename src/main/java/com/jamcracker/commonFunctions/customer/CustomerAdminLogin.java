package com.jamcracker.commonFunctions.customer;

import com.jamcracker.objectRepository.customer.StoreHomePage;
import com.jamcracker.utilities.TestBase;

public class CustomerAdminLogin extends TestBase {
	
	StoreHomePage storeHome = new StoreHomePage();
	
	public void customerAdminLogin(String username, String password) {
		storeHome.signInLink.click();
		try {
			explicitWait(storeHome.signInSection);
		} catch (Exception e) {
			storeHome.signInLink.click();
			explicitWait(storeHome.signInSection);
		}
		storeHome.usernameTextBox.sendKeys(username);
		storeHome.passwordTextBox.sendKeys(password);
		storeHome.signInButton.click();
	}

}
