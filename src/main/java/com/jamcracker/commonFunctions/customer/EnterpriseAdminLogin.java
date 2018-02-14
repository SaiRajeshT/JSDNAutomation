package com.jamcracker.commonFunctions.customer;

import com.jamcracker.objectRepository.customer.StoreHomePage;
import com.jamcracker.utilities.TestBase;


public class EnterpriseAdminLogin extends TestBase {

	
	public void  enterpriseAdminLogin(String username, String password) throws Exception {
		StoreHomePage storeHome = new StoreHomePage();

		storeHome.enterpriseUsernameTextBox.sendKeys(username);
		storeHome.enterprisePasswordTextBox.sendKeys(password);
		storeHome.enterpriseSignInButton.click();
		storeHome.catalogLink.click();				
		
	}

}
