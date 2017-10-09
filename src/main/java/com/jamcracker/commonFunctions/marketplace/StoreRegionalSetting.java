package com.jamcracker.commonFunctions.marketplace;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.SetUpPage;

public class StoreRegionalSetting 
{
	
	public static void  testStoreRegionalSetting(ArrayList<String> languages, String defaultLanguage,ArrayList<String> timezones,String defaultTimezone,ArrayList<String>dateFormats,String defaultDateFormat)
	{
		
		SetUpPage objSetUpPage = SetUpPage.getInstance();
		
		//Selecting Languages and Verifying whether selected or not
		for(String language:languages)
		{
			objSetUpPage.getLanguage(language).click();
			if(SetUpPage.getInstance().getLanguage(language).isSelected())
				Reporter.log(language +" Language is selected for store");
			else
				Reporter.log(language+"<p style='color:red'> Language is Not selected for store.Please check the issue.</p>");
		
		}
		
		//Selecting the default language and verify whether default language is selected or not
		try{
			objSetUpPage.getDefaultLanguage(defaultLanguage).click();
			if (SetUpPage.getInstance().getDefaultLanguage(defaultLanguage).isSelected()) {
				Reporter.log(defaultLanguage + " Default Language is selected for store");
			} 
		}catch(NoSuchElementException ne){
			Reporter.log(defaultLanguage + " <p style='color:red'> Default Language is Not selected for store.Please check the issue.</p>");
			ne.printStackTrace();
			Assert.fail();
		}

		
		//Navigating from language page to timezone page and verifying whether its navigated or not	
		
		try {
			objSetUpPage.addTimezoneButton.click();
			if(objSetUpPage.addDateFormatButton.isDisplayed())
			{
				Reporter.log("Regional Settings::Navigated from language selection page to timezone selection page");
			}
		} catch (Exception e) {
			Reporter.log("<p style='color:red'> StyleIssue while navigating from language selection section to timezone section.</p>");
		}
		
		
		//Selecting Timezone and verifying all the timezones are selected or not
		
		for(String timezone:timezones)
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
				Reporter.log(timezone + "<p style='color:Red'> Timezone is not selected please check the issue </p>");
			}
		
		}
		
		//Selecting the default Timezone
		
		try {
				objSetUpPage.getDefaultTimeZone(defaultTimezone).click();

			if(objSetUpPage.getDefaultTimeZone(defaultTimezone).isSelected())
			{
				Reporter.log("Default Timezone selected ");
			}
		} catch (Exception e) {
			Reporter.log("<p style='color:red'> Default Timezone is not selected Please check the  issue.</p>");
			e.printStackTrace();
			Assert.fail();
		}
		
		
		objSetUpPage.addDateFormatButton.click();

		if(objSetUpPage.saveAndContinueButton.isDisplayed())
		{
			Reporter.log("Regional Settings::Successfully selected Timezone for Store",true);
		}
		
		
		for(String dateFormat:dateFormats)
		{
			try
			{
				objSetUpPage.getDateFormat(dateFormat).click();
				if(objSetUpPage.getDateFormat(dateFormat).isSelected())
				{
					Reporter.log(dateFormat + " dateformat is  selected");
				}
			}
			
			catch(Exception e)
			{
				Reporter.log(dateFormat + "<p style='color:Red'>Date Format is not selected please check the issue</p>");
			}
		
		}
		
		try {
			   objSetUpPage.getDefaultDateFormat(defaultDateFormat).click();
			   Reporter.log("Default Date Format is selected");
		} catch (Exception e) 
		{
			Reporter.log(defaultDateFormat + "<p style='color:Red'> Default DateFormat is not selected please check the issue </p>");
			Assert.fail();

		}
		
		objSetUpPage.saveAndContinueButton.click();
		
		try{
			
			if(objSetUpPage.privacyPolicyEditIcon.isDisplayed())
			{
				Reporter.log("Regional settings page configuration is completed");
			}
			}
			catch(Exception e)
			{
				Reporter.log("<p style='color:Red'> Please check the regional settings configuration issue</p>");
			}
		
		
		
	}
	
}
