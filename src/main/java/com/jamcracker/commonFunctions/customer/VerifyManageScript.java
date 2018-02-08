package com.jamcracker.commonFunctions.customer;

import org.junit.Assert;
import org.testng.Reporter;

import com.jamcracker.constants.Constants;
import com.jamcracker.objectRepository.customer.ScriptingPage;
import com.jamcracker.utilities.TestBase;

public  class  VerifyManageScript extends TestBase {
	
	
    public static void verifyScriptPage()
    {
    	try{
    		ScriptingPage objScriptPage = new ScriptingPage();
    		objScriptPage.manageLink.click();
    		objScriptPage.scriptingLink.click();
    	if(getDriver().getTitle().equals(Constants.MANAGE_SCRIPT_PAGE_TITLE))
    	{
    		Reporter.log("Successfully Navigated to Manage Script Page");
    	}
    	
    	else{
    		Reporter.log("<p style='color:red'>Issue while Navigating to Manage script Page. Look in to the issue. </p>");
    		Assert.fail();
    	}
    	
    	}
    	
    	catch(Exception e)
    	{
    		Reporter.log("<p style='color:red'>Issue while Navigating to Manage script Page. Look in to the issue. </p>");
    		Assert.fail();
    		e.printStackTrace();
    	}
    }
}
