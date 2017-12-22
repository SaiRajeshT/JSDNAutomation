package com.jamcracker.commonFunctions.pivotpath;

import com.jamcracker.objectRepository.marketplace.PivotpathPages;

public class LoginToPivotpath {

 public static 	void login(String acronym,String userName,String password){
	PivotpathPages objPivotpath = new PivotpathPages();
 	objPivotpath.organizationTextBox.sendKeys(acronym);
 	objPivotpath.userNameTextBox.sendKeys(userName);
 	objPivotpath.passwordTextBox.sendKeys(password);
 	objPivotpath.loginButton.click();}
 			

}
