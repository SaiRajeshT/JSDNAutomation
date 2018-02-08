package com.jamcracker.commonFunctions.marketplace;

import java.util.ArrayList;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.SetUpPage;
import com.jamcracker.utilities.CaptureScreenshot;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class SetUpBillingOptions extends TestBase
{
	//private static SetUpPage  objSetUpPage =  SetUpPage.getInstance();
	
	private static SetUpBillingOptions instance;

	private SetUpBillingOptions() 
	{
		
	}

	public static SetUpBillingOptions getInstance() 
	{
		if(instance == null){
			instance  = new SetUpBillingOptions();
		}
		return new SetUpBillingOptions();
	}


	
	public void testSetUpBillingOptions(String storeCurrency,ArrayList<String> paymentMethods,String creditCardPaymentGateway,String payPalPaymentGateway,
			String daysBetweenRetries,String numberOfPaymentAttempts,String defultPaymentMethod,String paymentDueAlert,
			String numberOfAlerts,String intervalBwnAlert,String screenShotName)

	{
		 SetUpPage  objSetUpPage =  SetUpPage.getInstance();
	

		try
		{
			HandleDropDown.selectDDLByVisibletext(objSetUpPage.currenciesDropdown, storeCurrency);
			Reporter.log(storeCurrency +" Is selected as Store Currency.");
			//need to check the selected value in the dropdown
		}
		catch(Exception e)
		{
			Reporter.log(" <p style='color:red'>Store Currency is not selected. Please check the issue.</p>");
			//Assert.fail();

		}
		
		
		
		for(String paymentMethod : paymentMethods)
		{
			System.out.println("paymentMethod: "+paymentMethod.toLowerCase());
		
			try
			{
				switch(paymentMethod.toLowerCase())
				{
				 case "credit card": 
					System.out.println("inside credit card switch");
					Thread.sleep(1000);
					objSetUpPage.creditCardCheckBox.click();
					HandleDropDown.selectDDLByVisibletext(objSetUpPage.creditPaymentGateWayDropDown, creditCardPaymentGateway);
					if(creditCardPaymentGateway.equalsIgnoreCase("Braintree")){
					HandleDropDown.selectDDLByVisibletext(objSetUpPage.brainTreeDaysBtwnRetriesDropDown, daysBetweenRetries);
					HandleDropDown.selectDDLByVisibletext(objSetUpPage.brainTreeNumberOfPaymentAttemptsDropDown, numberOfPaymentAttempts);}
					Reporter.log(paymentMethod + " Payment method is selected");

					break;
				
				case "paypal" :
					System.out.println("inside paypal  switch Block");
					objSetUpPage.payPalCheckBox.click();
					HandleDropDown.selectDDLByVisibletext(objSetUpPage.paypalPaymentGateWayDropDown,payPalPaymentGateway);
					HandleDropDown.selectDDLByVisibletext(objSetUpPage.payPalDaysBtwnRetriesDropDown, daysBetweenRetries);
					HandleDropDown.selectDDLByVisibletext(objSetUpPage.payPalNumberOfPaymentAttemptsDropDown, numberOfPaymentAttempts);
					Reporter.log(paymentMethod + " Payment method is selected");

					break;
				default:
					objSetUpPage.preApprovedCheckbox.click();
					Reporter.log(paymentMethod + " Payment method is selected");
					break;
					
						
				}			
			}
		
			catch(Exception e)
			{
				e.printStackTrace();
				Reporter.log("<p style='color:red'>"+paymentMethod + "Payment method is not selected. Please check the issue.</p>");
				CaptureScreenshot.screenshot(getDriver(),screenShotName,testClassName,packageName);
				Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e)+"</p>");
			}
		
		}
		
		HandleDropDown.selectDDLByVisibletext(objSetUpPage.defaultPaymentMethodDropDown,defultPaymentMethod);
		Reporter.log("Default Payment method is selected as " + defultPaymentMethod);
		HandleDropDown.selectDDLByVisibletext(objSetUpPage.paymentDueAlertDropDown,paymentDueAlert);
		HandleDropDown.selectDDLByVisibletext(objSetUpPage.numberofAlertsDropDown,numberOfAlerts);
		HandleDropDown.selectDDLByVisibletext(objSetUpPage.intervalBetweenAlertsDropDown,intervalBwnAlert);
		if(!objSetUpPage.payNowCheckBox.isSelected()){
		objSetUpPage.payNowCheckBox.click();}//Need to take value from excel and check
		//objSetUpPage.itemizedInvoiceCheckbox.click();
		//Need to check from excel whether do we need to configure or not
		objSetUpPage.saveAndNextButton.click();
		try{
			objSetUpPage.deleteCompaniesCheckbox.isDisplayed();
			Reporter.log("Billing Page Configuration is completed successfully");
		}
		catch(Exception e)
		{
			Reporter.log("Issue in Billing page configuration");
			
		}
		
		
		
	}
	
}
