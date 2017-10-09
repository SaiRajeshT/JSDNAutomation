package com.jamcracker.commonFunctions.marketplace;

import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.CmsAdminMenuBar;
import com.jamcracker.objectRepository.marketplace.DrupalAdminLoginPage;
import com.jamcracker.utilities.TestBase;

public class DrupalAdminLogin extends TestBase {
	
	public void drupalAdminLogin() {
		
		DrupalAdminLoginPage objDALogin = new DrupalAdminLoginPage();
		objDALogin.usernameTextBox.sendKeys("admin");
		objDALogin.passwordTextBox.sendKeys("Root@123");
		objDALogin.loginButton.click();
		CmsAdminMenuBar cmsMenu = new CmsAdminMenuBar();
		try {
			if (cmsMenu.logoutLink.isDisplayed()) {
				Reporter.log("Drupal Admin is successfully logged in");
			}
		} catch (Exception e) {
			Reporter.log("<p style='color:red'>Login is not successful</p>");
		}
						
	}

}
