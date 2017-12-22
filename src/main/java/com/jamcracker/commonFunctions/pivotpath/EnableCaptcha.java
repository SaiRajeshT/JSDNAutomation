package com.jamcracker.commonFunctions.pivotpath;

import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.PivotpathPages;
import com.jamcracker.utilities.TestBase;

public class EnableCaptcha extends TestBase{
	
	public static void captchaEnable(String acronym)
	{
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
		if(!objPivotpath.captchCheckbox.isSelected())
		{
			objPivotpath.captchCheckbox.click();
			Reporter.log("captcha Enabled for " + acronym);

		}
		
		else{
			Reporter.log("Captcha is already Enabled for "+acronym);
		}
		
		
		objPivotpath.SaveButton.click();
		
		
		
		
		
	}

}
