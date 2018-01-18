package com.jamcracker.commonFunctions.pivotpath;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.PivotpathPages;
import com.jamcracker.utilities.TestBase;

public class DisableCaptcha extends TestBase{
	
	public static void captchaDisable(String acronym)
	{
		try{
		PivotpathPages objPivotpath = new PivotpathPages();
		explicitWait(objPivotpath.administrationLink);
		objPivotpath.administrationLink.click();
		objPivotpath.memberOrgLink.click();
		objPivotpath.searchTextBox.sendKeys(acronym);
		objPivotpath.searchButton.click();
		objPivotpath.getProxyLink(acronym).click();
		objPivotpath.organizationAdminLink.click();
		explicitWait(objPivotpath.securityPolicyLink);
		objPivotpath.securityPolicyLink.click();
		if(objPivotpath.captchCheckbox.isSelected())
		{
			objPivotpath.captchCheckbox.click();
			Reporter.log("captcha Disabled for "+ acronym);

		}
		
		else{
			Reporter.log("Captcha is already Disabled for "+acronym);
		}
		
		
		objPivotpath.SaveButton.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("<p style='color:red'>issue while disabling the captcha for "+ acronym+ ".<p>");
			Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e)+"</p>");
			//Assert.fail();
		}
		
		
		
		
		
	}

}
