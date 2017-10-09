package com.jamcracker.commonFunctions.marketplace;

import java.util.ArrayList;

import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.MarketplaceHomePage;
import com.jamcracker.objectRepository.marketplace.RegionalSettingsPage;
import com.jamcracker.objectRepository.marketplace.SetUpPage;
import com.jamcracker.utilities.TestBase;
import com.jamcracker.utilities.TwoWindowsSwitch;

public class MyCompanyRegionalSettings extends TestBase
{
	public void regionalSettings(String defaultLanguage,ArrayList<String> timeZones,
			String defaultTimezone,ArrayList<String> dateFormats,String defaultDateFormat)
	{
		
		RegionalSettingsPage regionalSettingsObj = new RegionalSettingsPage();
		MarketplaceHomePage objMpHomePage = new MarketplaceHomePage();
		SetUpPage objSetUpPage = SetUpPage.getInstance();
		objMpHomePage.myCompanyLink.click();
		explicitWait(regionalSettingsObj.regionalSettingsLink);
		regionalSettingsObj.regionalSettingsLink.click();
		objSetUpPage.getLanguage(defaultLanguage).click();
		objSetUpPage.getDefaultLanguage(defaultLanguage).click();
		objSetUpPage.addTimezoneButton.click();
		
		//Verify Language Setup 
		if(objSetUpPage.addDateFormatButton.isDisplayed())
		
			Reporter.log("Regional Settings::Successfully selected language for Marketplace users.",true);
		else
			Reporter.log("<p style='color:red' Default language is not selected please check the issue.</p>");
		//Selecting the Timezones for Marketplace users
		for(String timezone: timeZones)
		{
			try
			{
				objSetUpPage.getTimeZone(timezone).click();
				if(objSetUpPage.getTimeZone(timezone).isSelected())
				{
					Reporter.log(timezone + " Timezone is  selected");
				}
			}
			
			catch(Exception e)
			{
				Reporter.log(timezone + "<p style='color:red' Timezone is not selected please check the issue.</p>");
			}
						
		}
		
		try
		{
			objSetUpPage.getDefaultTimeZone(defaultTimezone).click();
			if(objSetUpPage.getTimeZone(defaultTimezone).isSelected())
			{
				Reporter.log(defaultTimezone + " Default Timezone is  selected.");
			}		
		}
		
		catch (Exception e)
		{
			Reporter.log("<p style='color:red'Default Timezone is not selected please check the issue.</p>");

		}
				
		objSetUpPage.addDateFormatButton.click();
		//Selecting all the available Date Formats
		for(String dateFormat: dateFormats)
		{
			try
			{
				objSetUpPage.getDateFormat(dateFormat).click();
				if(objSetUpPage.getDateFormat(dateFormat).isSelected())
				{
					Reporter.log(dateFormat +" Is selected as Default date Format");
				}
			}
			
			catch(Exception e)
			{
				Reporter.log(dateFormat + "<p style='color:red'  Date Format is not selected please check the issue.</p>");
			}
						
		}
		
		try
		{
			objSetUpPage.getDefaultDateFormat(defaultDateFormat).click();
			if(objSetUpPage.getDefaultDateFormat(defaultDateFormat).isSelected())
			{
				Reporter.log(defaultDateFormat + " Default  is  selected");
			}		
		}
		catch(Exception e)
		{
			Reporter.log("<p style='color:red' Default Date Format is not selected please check the issue</p>");
		}
		
	
		regionalSettingsObj.saveButton.click();
		
		Reporter.log("My company regional settings is completed for Marketplace users");
		TwoWindowsSwitch.switchToParent();

		
		
	}
}
