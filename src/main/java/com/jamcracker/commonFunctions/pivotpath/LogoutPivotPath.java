package com.jamcracker.commonFunctions.pivotpath;

import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.PivotpathPages;

public class LogoutPivotPath {

 public static 	void logout(){
	 PivotpathPages objPivotpath = new PivotpathPages();
	  objPivotpath.logOutLink.click();
	  if(objPivotpath.loginButton.isDisplayed())
	  {
		  Reporter.log("Log out successfull");
		  System.out.println("Log out successfull");
	  }
	  else{
		  Reporter.log("<p style='color:red'>Issue while log out.Please look in to the issue.</p>");
	  }
 }
 			

}
