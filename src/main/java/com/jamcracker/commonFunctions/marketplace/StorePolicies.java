package com.jamcracker.commonFunctions.marketplace;

import java.io.File;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.SetUpPage;

public class StorePolicies 
{
	//static SetUpPage objSetUpPage = SetUpPage.getInstance(); Execution is failed by saying session closed or kiled

	public static void testPrivacyPolicyUpload()
	{
		SetUpPage objSetUpPage = SetUpPage.getInstance();
		//objSetUpPage.storePolicyLink.click();
		objSetUpPage.privacyPolicyEditIcon.click();
		objSetUpPage.FileRadionButton.click();
		objSetUpPage.upLoadFile.sendKeys(System.getProperty("user.dir")+File.separator+"Data"+File.separator+"SlaAndPolicies"+File.separator+"PrivacyPolicy.html");
		objSetUpPage.saveButton.click();
		
		try{
			if(objSetUpPage.privacyPolicyStatus.getText().equalsIgnoreCase("Activated"))
		
			Reporter.log("Privacy Policy uploaded successfully.");
		
			}
		catch(Exception e)
		{
			Reporter.log("<p style='color:Red'> Privacy policy not uploaded. Please check the issue.</p>");
			Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e)+"</p>");
			Assert.fail();
		}
		
	}
	
	
	public static void testSecurityStatementUpload()
	{
		SetUpPage objSetUpPage = SetUpPage.getInstance();

		objSetUpPage.securityEditIcon.click();
		objSetUpPage.FileRadionButton.click();
		objSetUpPage.upLoadFile.sendKeys(System.getProperty("user.dir")+File.separator+"Data"+File.separator+"SlaAndPolicies"+File.separator+"SecurityStatement.html");
		objSetUpPage.saveButton.click();
		
		try{
			if(objSetUpPage.securityStatus.getText().equalsIgnoreCase("Activated"))
		
			Reporter.log("Security Statememnt uploaded successfully.");
		
			}
		catch(Exception e)
		{
			Reporter.log("<p style='color:Red'> Security Statememnt is not uploaded. Please check the issue.</p>");
			Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e)+"</p>");
			Assert.fail();
		}
		
		objSetUpPage.saveAndNextButton.click();
//Need to check whether next page is loaded or not
		
	}
	

	
		
}
