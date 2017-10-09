package com.jamcracker.commonFunctions.marketplace;

import java.io.File;
import java.util.ArrayList;

import org.testng.ITestResult;
import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.MarketplaceHomePage;
import com.jamcracker.objectRepository.marketplace.SetUpPage;
import com.jamcracker.objectRepository.superAdmin.SuperAdminMarktplacesPage;
import com.jamcracker.utilities.CaptureScreenshot;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;
import com.jamcracker.utilities.ThreeWindowsSwitch;
import com.jamcracker.utilities.TwoWindowsSwitch;

public class MarketplaceBranding extends TestBase
{ 
	ITestResult result;
	String testClassName;
	public void marketplaceBranding(String companyName,String theme,String defaultLanguage,
			ArrayList<String> timeZones,String defaultTimezone,ArrayList<String> dateFormats,
			String defaultDateFormat,String emailSignature,
			ArrayList<String> currencies,String defaultCurrency,String billingType,
			String domDate,String cutOffDays,ArrayList<String> paymentMethods,String paymentDue,String paymentDueAlert,String numberOfAlerts,String intervalBwnAlert,String screenShotName)
	{
		SuperAdminMarktplacesPage superAdminMktPlacePageobj = new SuperAdminMarktplacesPage();
		superAdminMktPlacePageobj.getMarketplaceProxy(companyName).click();
		TwoWindowsSwitch.getWindowHandles();
		TwoWindowsSwitch.switchToChild();
	/*	//Declared variables for taking screenshot
		testClassName = result.getInstanceName().trim();
		testClassName = testClassName.substring(testClassName.lastIndexOf(".")+1 ,testClassName.length());
		packageName=result.getClass().getPackage().getName();
		packageName=packageName.substring(packageName.lastIndexOf(".")+1,packageName.length());*/
		
		MarketplaceHomePage objMpHomePage = new MarketplaceHomePage();
		explicitWait(objMpHomePage.AdministrationLink);

		objMpHomePage.AdministrationLink.click();
		SetUpPage objSetUpPage = SetUpPage.getInstance();
		objSetUpPage.setUpLink.click();
		objSetUpPage.uploadLogoLink.click();
		//ThreeWindowsSwitch objWindow = new ThreeWindowsSwitch();
		ThreeWindowsSwitch.getWindowHandles();
		ThreeWindowsSwitch.switchTograndChild();
		objSetUpPage.browseButton.sendKeys(System.getProperty("user.dir")+File.separator+"Data"+File.separator+"Logos"+File.separator+"CompanyLogo.JPG");
		objSetUpPage.submitButton.click();
		ThreeWindowsSwitch.switchToChild();
		//HandleDropDown dropdownObj = new HandleDropDown();
		HandleDropDown.selectDDLByVisibletext(objSetUpPage.themeDropdown,theme);
		objSetUpPage.saveAndNextButton.click();
		
		try
		{
			
		//Verifying Branding Setup 
		if(objSetUpPage.addTimezoneButton.isDisplayed())
		{
			Reporter.log("Branding::Successfully uploaded logo and selected Theme for Marektplace");
		}
		}
		catch (Exception e)
		{
			Reporter.log("<p style='color:red'>Branding::Branding set up is failed.<p>");
			
		}
		
		objSetUpPage.regionalSettingsLink.click();
		objSetUpPage.getLanguage(defaultLanguage).click();
		objSetUpPage.getDefaultLanguage(defaultLanguage).click();
		objSetUpPage.addTimezoneButton.click();
		//Verify Language Setup 
		if(objSetUpPage.addDateFormatButton.isDisplayed())
		{
			Reporter.log("Regional Settings::Successfully selected language for Marketplace",true);
		}

		//Selecting the Timezones for the marketplace
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
				Reporter.log(timezone + " Timezone is not selected please check the issue");
				//Manually Taking screenshot
				CaptureScreenshot.screenshot(driver,screenShotName,testClassName,packageName);
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
			Reporter.log("Default Timezone is not selected please check the issue.");

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
					Reporter.log(dateFormat +"Is selected as Default date Format");
				}
			}
			
			catch(Exception e)
			{
				Reporter.log(dateFormat + "  Date Format is not selected please check the issue.");
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
			Reporter.log("Default Date Format is not selected please check the issue");
		}
		
		objSetUpPage.saveAndContinueButton.click();
		
		//Verifying successfully naviagted from Regional settings page to On demand network policy page
		
		try{
			
		if(objSetUpPage.copyRightNoticeField.isDisplayed())
		{
			Reporter.log("Regional settings page configuration is completed");
		}
		}
		catch(Exception e)
		{
			
		}
		
		objSetUpPage.onDemandNetworkPolicyLink.click();
		
		objSetUpPage.saveAndNextButton.click();
		
		//Verifying successfully navigated from on demand network policy page to Identity management page
		try{
			
			if(objSetUpPage.identityMgtNoRadioButton.isDisplayed())
			{
				Reporter.log("Successfully Navigated from on demand network policy page to Identity management page. ");
			}
			
			}
			catch(Exception e)
			{
				
			}
		
		objSetUpPage.saveAndFinishButton.click();
		
	try{
			
			if(objSetUpPage.memberAddServiceTextBox.isDisplayed())
			{
				Reporter.log("Successfully Navigated from  Identity management page to Customer Email Notifications  page. ");
			}
			
			}
			catch(Exception e)
			{
				
			}
	objSetUpPage.emailSignatureTextBox.clear();
	objSetUpPage.emailSignatureTextBox.sendKeys(emailSignature);
	
	
	objSetUpPage.saveAndNextButton.click();
	//objSetUpPage.bilingOptionsLink.click();
	

		try{
			
			if(objSetUpPage.currenciesDropdown.isDisplayed())
			{
				Reporter.log("Successfully Navigated from  Email notification page to Billing option page. </p>");
			}
			
			}
			catch(Exception e)
			{
				Reporter.log("<p style='color:red'>Customer Email notification page configurations are not done please check the issue.</p>");
			}
		
	
		//Performing Billing selection for marketplace
		
		
			for(String currency:currencies)
			{
				try
				{
				HandleDropDown.selectDDLByVisibletext(objSetUpPage.currenciesDropdown, currency);		
				Reporter.log(currency + " is  selected.");
				}
				catch (Exception e)
				{
					Reporter.log("<p style='color:red'>"+currency+" is not selected. Please check the issue</p>");
				}

			}
			
			if ( currencies.size() == HandleDropDown.selectedOptionsCount(objSetUpPage.currenciesDropdown))
				Reporter.log("All currencies are selected");
			
			try
			{
				HandleDropDown.selectDDLByVisibletext(objSetUpPage.defaultCurrencyDropdown, defaultCurrency);
				Reporter.log(defaultCurrency +" Is selected as Default Currency.");
			}
			catch(Exception e)
			{
				Reporter.log(" <p style='color:red'>Default Currency is not selected. Please check the issue.</p>");

			}
			
			if(billingType.equalsIgnoreCase("Monthly"))
			{
			  objSetUpPage.getmonthlyRadioButton(billingType).click();
			  Reporter.log(billingType+" Is selected as bill type of Marketplace");
			}
			else
			{
				 objSetUpPage.getsameDayRadioButton(billingType).click();
				 Reporter.log(billingType+" Is selected as bill type of Marketplace");
			}
			
			HandleDropDown.selectDDLByVisibletext(objSetUpPage.monthlyDomDateDropDown, domDate);
			Reporter.log(domDate+" Is selected as Billing Generation Date of Marketplace.");
			

			HandleDropDown.selectDDLByVisibletext(objSetUpPage.cutOffPeriodDropdown, cutOffDays);
			Reporter.log(cutOffDays+" day/s selected as cut off days of Marketplace.");
			objSetUpPage.itemizedInvoiceCheckbox.click();
			
			try {
				objSetUpPage.paymentDueTextBox.sendKeys(paymentDue);
			} catch (Exception e1)
			{
			}
			if(objSetUpPage.paymentDueTextBox.isSelected())
			{
		      Reporter.log("Payment due from invoice day is updated."  );
			}
			else
			{
				Reporter.log("Payment due from invoice day is not updated. Please check the issue."  );
			}
			
			for(String paymentMethod : paymentMethods)
			{
				System.out.println("paymentMethod: "+paymentMethod);
			
				try
				{
					switch(paymentMethod.toLowerCase())
					{
					case "creditcard": 
						System.out.println("inside credit card switch");
						objSetUpPage.creditCardCheckBox.click();
						try{objSetUpPage.brainTreeCheckbox.click();
						objSetUpPage.brainTreeAutomaticCheckBox.click();}
						catch(Exception e)
						{//Manually screenshot
							Reporter.log("<p style='color:red'>Brain Tree Payment method  is not available in the system.Please deploy it </p>");
}
						try{objSetUpPage.tmPaymentChcekBox.click();
						     if(!objSetUpPage.customerSelfServiceCheckBox.isSelected())
						    		 objSetUpPage.customerSelfServiceCheckBox.click();}
						catch(Exception e){ //Manually screenshot
							Reporter.log("<p style='color:red'>Tm Payment Gateway is not present in the system.Please deploy it </p>");
						}
						break;
					
					case "paypal" :
						System.out.println("inside credit card switch");
						objSetUpPage.payPalCheckBox.click();
						objSetUpPage.payPalExpressCheckBox.click();
						objSetUpPage.paypalAutomaticCheckBox.click();
						break;
					default:
						objSetUpPage.preApprovedCheckbox.click();
							
					}			
					Reporter.log(paymentMethod + "Payment method is selected");
				}
			
				catch(Exception e)
				{
					Reporter.log(paymentMethod + "<p style='color:red'>Payment method is not selected. Please check the issue.</p>");
					CaptureScreenshot.screenshot(driver,screenShotName,testClassName,packageName);
				}
			
			}
			
			HandleDropDown.selectDDLByVisibletext(objSetUpPage.paymentDueAlertDropDown, paymentDueAlert);
			
			HandleDropDown.selectDDLByVisibletext(objSetUpPage.numberofAlertsDropDown,numberOfAlerts);
			HandleDropDown.selectDDLByVisibletext(objSetUpPage.intervalBetweenAlertsDropDown,intervalBwnAlert);
			objSetUpPage.saveAndNextButton.click();
			//objSetUpPage.taxSetUpLink.click();
			if(objSetUpPage.addNewTaxButton.isDisplayed()){
			Reporter.log("Successfully Navigated from Billing page to Tax set up page.");
			Reporter.log("Billing Page Configuration is completed successfully");}
			else
				Reporter.log("<p style='color:red'>Tax page is not loaded. please check the issue.</p>");
			objSetUpPage.nextButton.click();
			
			if(objSetUpPage.noOfRecordsPerPage.isDisplayed())
				Reporter.log("Successfully Navigated from Tax set up page to Preference page.");
			else
				Reporter.log("<p style='color:red'>Preference page is not loaded. please check the issue</p>");
			objSetUpPage.saveAndNextButton.click();
			if(objSetUpPage.addContentButton.isDisplayed())
				Reporter.log("Successfully Navigated from preference page to contents page");
			else
				Reporter.log("<p style='color:red'>content page is not loaded. please check the issue</p>");
			objSetUpPage.nextButton.click();
			if(objSetUpPage.finishButton.isDisplayed())
				Reporter.log("Successfully Navigated from Contents page to Page customization .");
			else
				Reporter.log("<p style='color:red'> Page customization  is not loaded. please check the issue</p>");
			objSetUpPage.finishButton.click();
			ThreeWindowsSwitch.getWindowHandles();
			ThreeWindowsSwitch.switchTograndChild();
			String emsg="You have finished the set up tasks for On Demand Service Delivery Network.";
			if(emsg.equalsIgnoreCase(objSetUpPage.finishMktplaceSetuPMessage.getText()))
			Reporter.log("Marketplace set up is completed");
			else
			Reporter.log("<p style='color:red' Issue is present in the last step of Marketplace setup. Please check the issue</p>");
			objSetUpPage.closeButton.click();
			Reporter.log("Clicked on close button Successfully");
			ThreeWindowsSwitch.switchToChild();
			objMpHomePage.myCompanyLink.click();
			//ThreeWindowsSwitch.switchToParent();
			
			
			
			
			

			
			
			
			
			
		
			
			

		
		
		
		
		
		
		
		
	}
		
		
		

		
	
	

}
