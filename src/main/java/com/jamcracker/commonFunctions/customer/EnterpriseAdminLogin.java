package com.jamcracker.commonFunctions.customer;

import com.jamcracker.objectRepository.customer.StoreHomePage;

public class EnterpriseAdminLogin {
	
	StoreHomePage storeHome = new StoreHomePage();
	
	public void enterpriseAdminLogin(String username, String password) {
		storeHome.usernameTextBox.clear();
		storeHome.usernameTextBox.sendKeys(username);
		storeHome.passwordTextBox.clear();
		storeHome.passwordTextBox.sendKeys(password);
		storeHome.signInButton.click();
	}

}
