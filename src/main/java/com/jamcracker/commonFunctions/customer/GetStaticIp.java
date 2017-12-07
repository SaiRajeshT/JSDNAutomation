package com.jamcracker.commonFunctions.customer;


import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.constants.Constants;
import com.jamcracker.objectRepository.customer.InstancesPage;
import com.jamcracker.objectRepository.customer.StaticIpAddressPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class GetStaticIp extends TestBase {
	
	 StaticIpAddressPage objStaticIp = new StaticIpAddressPage();
	  private String ipAddress;

 public String  getStaticIp(String provider,String region,String network)
 {
	 try {
			InstancesPage objinstancePage = new InstancesPage();
			objinstancePage.manageLink.click();
			objStaticIp.staticPublicIpLink.click();
			objStaticIp.obtainNewIpButton.click();
			explicitWait(objStaticIp.staticIpConfirmButton);
			 provider= objStaticIp.getDropDownValue(provider);
			HandleDropDown.selectDDLByVisibletext(objStaticIp.providerDropdown, provider);
			explicitWait((objStaticIp.regionDropDown));
			objStaticIp.regionDropDown.click();
			HandleDropDown.selectDDLByVisibletext(objStaticIp.regionDropDown,region);
			try{
				objStaticIp.networkDropDown.click();
			HandleDropDown.selectDDLByVisibletext(objStaticIp.networkDropDown, network);}
			catch(NoSuchElementException e){}
			objStaticIp.staticIpConfirmButton.click();
			Thread.sleep(5000);
			explicitWaitToClickable(objStaticIp.searchTextBox);
			objStaticIp.searchTextBox.click();
			objStaticIp.searchTextBox.clear();
			objStaticIp.searchTextBox.sendKeys(provider);
			Thread.sleep(2000);
			objStaticIp.searchTextBox.sendKeys(Keys.ENTER);
			
			ipAddress= objStaticIp.getIp();
			
			if(objStaticIp.getSuccessMsg().contains(Constants.IP_SUCCESS_MESSAGE))
			{
				Reporter.log("IP Obtained successfully. and the Obtained IP is" +ipAddress);
			}
			else{
				Reporter.log("<p style ='color:red'>Issue while obtaining IP address.</p>");
				//Assert.fail();
			}
		
			System.out.println(ipAddress);
			
			
	 
	 
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
		 Assert.fail();
	 }
	return ipAddress;
	 
 }

}
