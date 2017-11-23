package com.jamcracker.commonFunctions.customer;

import java.util.LinkedList;

import org.testng.Reporter;

import com.jamcracker.objectRepository.customer.QuickHelpPage;
import com.jamcracker.utilities.TestBase;
import com.jamcracker.utilities.TwoWindowsSwitch;

public class QuickHelp extends TestBase {

	public static void verifyquickHelp(LinkedList<String> linksList, LinkedList<String>helpText)
	{
		QuickHelpPage objQuickHelp = new QuickHelpPage();
		objQuickHelp.quickHelpLink.click();
		for(String str : linksList)
		{
			if(driver.getPageSource().contains(str))
			{
				Reporter.log(str+ " Is displayed in " +driver.getTitle());
				objQuickHelp.getLink(str).click();
			}
			int count  =0;
			TwoWindowsSwitch.getWindowHandles();
			TwoWindowsSwitch.switchToChild();
			if(driver.getPageSource().contains(helpText.get(count)))
			{
				Reporter.log(helpText.get(count) + " Is Displayed in online help document");
			}
			
			driver.close();
			TwoWindowsSwitch.switchToParent();
		}
		
	}
	
}
