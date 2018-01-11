package com.jamcracker.commonFunctions.customer;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.entity.service.SecurityGroup;
import com.jamcracker.entity.service.StackOrder;
import com.jamcracker.objectRepository.customer.AppstackPage;
import com.jamcracker.objectRepository.customer.CatalogPage;
import com.jamcracker.objectRepository.customer.StackLaunchPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.MouseActions;
import com.jamcracker.utilities.SwitchFrame;
import com.jamcracker.utilities.TestBase;

public class IaasStackOrder extends TestBase {
	private String staticIP ;
	AppstackPage objAppStackPage = new AppstackPage();
	public void iaasStackOrder(StackOrder stackorderinfo)
	{
		CatalogPage objCatalogPage = new CatalogPage();
		StackLaunchPage objStackLaunchPage = new StackLaunchPage();
		GetStaticIp objstaticIp = new GetStaticIp();
		if(stackorderinfo.getStaticIp().equalsIgnoreCase("Y") ){
		
		 staticIP =objstaticIp.getStaticIp(stackorderinfo.getVendors(), stackorderinfo.getRegion(), "public");
		}
			
	/*	if(stackorderinfo.getStaticIp().equalsIgnoreCase("Y")&& !stackorderinfo.getVendors().toLowerCase().equalsIgnoreCase("privateopenstack")){
			staticIP =objstaticIp.getStaticIp(stackorderinfo.getVendors(), stackorderinfo.getRegion(), "public");
		}*/
			
		objCatalogPage.catalogLink.click();
		explicitWait(objCatalogPage.searchTextBox);
		objCatalogPage.searchTextBox.sendKeys(stackorderinfo.getServiceName());
		objCatalogPage.searchTextBox.sendKeys(Keys.ENTER);
		explicitWait(objCatalogPage.serviceNameText(stackorderinfo.getServiceName()));
		MouseActions.mouseHover(objCatalogPage.serviceNameText(stackorderinfo.getServiceName()));
		explicitWait(objCatalogPage.serviceViewOffersLink(stackorderinfo.getServiceName()));
		//System.out.println(stackorderinfo.getServiceName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		objCatalogPage.serviceViewOffersLink(stackorderinfo.getServiceName()).click();
		explicitWait(objCatalogPage.launchButton);
		objCatalogPage.launchButton.click();
		
		try
		{
			objCatalogPage.continueButton.click();
			
		}
		catch(Exception e)
		{
			System.out.println("continue");
		}
		
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//explicitWait(objStackLaunchPage.stackNameTextBox);
		SwitchFrame.elementSwitch(objCatalogPage.launchstackFrame);
		objStackLaunchPage.stackNameTextBox.clear();
		objStackLaunchPage.stackNameTextBox.sendKeys(stackorderinfo.getStackName());
		objStackLaunchPage.descriptionTextBox.sendKeys(stackorderinfo.getStackDesc());
		objStackLaunchPage.tagLink.click();
		Map<String,String> tags = stackorderinfo.getTags();
		//System.out.println(tags.size());
		
		int tagsize = tags.size();
		Set<Map.Entry<String, String>> set = tags.entrySet();
		Iterator<Entry<String, String>> itr = set.iterator();
	
			
		for(Map.Entry<String, String> entry: set){
			System.out.print(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		for(int i=1;i<=tagsize;i++){
		
			 if(i==1){
				if(objStackLaunchPage.getTagKeyTextBox(i).getAttribute("value").isEmpty()){
					Map.Entry<String , String> entry = (Map.Entry<String, String>) itr.next();
					 objStackLaunchPage.getTagKeyTextBox(i).sendKeys(entry.getKey());
					 objStackLaunchPage.valueLink.click();
					 objStackLaunchPage.getTagValueTextBox(i).sendKeys(entry.getValue()	);
					 objStackLaunchPage.valueLink.click();}}
			 else {
			if( objStackLaunchPage.addNewTagLink.isDisplayed()){
				objStackLaunchPage.addNewTagLink.click();
			Map.Entry<String , String> entry = (Map.Entry<String, String>) itr.next();
			 objStackLaunchPage.getTagKeyTextBox(i).sendKeys(entry.getKey());
			 objStackLaunchPage.valueLink.click();
			 objStackLaunchPage.getTagValueTextBox(i).sendKeys(entry.getValue()	);
			 objStackLaunchPage.valueLink.click();}}
			
			
		}
		
		//Reporter.log(tagsize +" Tags has been added to stack ");
		
		long currentTime = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(currentTime);
		 SimpleDateFormat sdf = new SimpleDateFormat("ddMMMhhmmss");

		 objStackLaunchPage.instanceNameTextBox.clear();
		objStackLaunchPage.instanceNameTextBox.sendKeys(stackorderinfo.getInstanceName());
		
		switch(stackorderinfo.getVendors().toLowerCase())
		{
		case "aws" :  
			try{HandleDropDown.selectDDLByValue(objStackLaunchPage.vendorDropDown, stackorderinfo.getVendors());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.vendorDropDown).equalsIgnoreCase(stackorderinfo.getVendors())){
			Reporter.log(stackorderinfo.getVendors()+" Vendor Selected");
			}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the vendor.Please look in to the issue.</p>");}
			
			HandleDropDown.selectDDLByValue(objStackLaunchPage.regionDropDown, stackorderinfo.getRegion());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.regionDropDown).equalsIgnoreCase(stackorderinfo.getRegion())){
				Reporter.log(stackorderinfo.getRegion()+" Region Selected");
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Region.Please look in to the issue.</p>");}

			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.imageDropDown, stackorderinfo.getImageName());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.imageDropDown).equalsIgnoreCase(stackorderinfo.getImageName())){
				Reporter.log(stackorderinfo.getImageName()+" Image Selected");
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Image.Please look in to the issue.</p>");}

			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.availabilityZoneDropDown, stackorderinfo.getAvailabiltyZone());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.availabilityZoneDropDown).equalsIgnoreCase(stackorderinfo.getAvailabiltyZone())){
				Reporter.log(stackorderinfo.getAvailabiltyZone()+" Availabilityzone Selected");
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Availabiltiy Zone.Please look in to the issue.</p>");}

			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.familyDropDown, stackorderinfo.getFamily());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.familyDropDown).equalsIgnoreCase(stackorderinfo.getFamily())){
				Reporter.log("Family is selected as "+stackorderinfo.getFamily());
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Family.Please look in to the issue.</p>");}

			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.familyTypeDropDown, stackorderinfo.getType());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.familyTypeDropDown).equalsIgnoreCase(stackorderinfo.getType())){
				Reporter.log(stackorderinfo.getType()+" Family Type Selected");
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Family Type.Please look in to the issue.</p>");}

			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.flavorDropDown, stackorderinfo.getFlavor());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.flavorDropDown).equalsIgnoreCase(stackorderinfo.getFlavor())){
				Reporter.log(stackorderinfo.getFlavor()+" Flavor Selected");
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Flavor.Please look in to the issue.</p>");}

			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.enableMonitoringDropDown, stackorderinfo.getEnableMonitoring());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.enableMonitoringDropDown).equalsIgnoreCase(stackorderinfo.getEnableMonitoring())){
				Reporter.log(" Monitoring Selected as " +stackorderinfo.getEnableMonitoring());
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Monitoring.Please look in to the issue.</p>");}

			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.networkDropDown, stackorderinfo.getNetwork());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.networkDropDown).equalsIgnoreCase(stackorderinfo.getNetwork())){
				Reporter.log(stackorderinfo.getNetwork()+" Network Selected");
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Network.Please look in to the issue.</p>");}

			objStackLaunchPage.networkNameTextBox.sendKeys(stackorderinfo.getNetworkInterfaceName());
			
			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.subnetDropDown, stackorderinfo.getSubNetName());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.subnetDropDown).equalsIgnoreCase(stackorderinfo.getSubNetName())){
				Reporter.log(stackorderinfo.getSubNetName()+" Subnet Selected");
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Subnet.Please look in to the issue.</p>");}
				if (stackorderinfo.getStaticIp().equalsIgnoreCase("Y")) {
					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.publicIPDropdown,
							staticIP);
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.publicIPDropdown)
							.equalsIgnoreCase(staticIP)) {
						Reporter.log(staticIP + "  Selected for public IP ");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Public ip .Please look in to the issue.</p>");
					}
				} else {
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.publicIPDropdown)
							.equalsIgnoreCase(stackorderinfo.getPublicIp())) {
						Reporter.log(stackorderinfo.getPublicIp() + "  Selected for public IP ");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Public ip .Please look in to the issue.</p>");
					}
				}
			break;}
		catch (Exception e)
		{
			Reporter.log("<p style='color:red'>Issue while selecting configuration for stack while placing order for aws Provider.</p>");
			e.printStackTrace();
			Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e)+"</p>");
			Assert.fail();
		}
			
			
		case "windowsazure" :  
			try{HandleDropDown.selectDDLByValue(objStackLaunchPage.vendorDropDown, stackorderinfo.getVendors().toLowerCase());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.vendorDropDown).equalsIgnoreCase(stackorderinfo.getVendors())){
			Reporter.log(stackorderinfo.getVendors()+" Vendor Selected");
			}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the vendor.Please look in to the issue.</p>");}
			
			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.regionDropDown, stackorderinfo.getRegion());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.regionDropDown).equalsIgnoreCase(stackorderinfo.getRegion())){
				Reporter.log(stackorderinfo.getRegion()+" Region Selected");
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Region.Please look in to the issue.</p>");}

			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.imageDropDown, stackorderinfo.getImageName());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.imageDropDown).equalsIgnoreCase(stackorderinfo.getImageName())){
				Reporter.log(stackorderinfo.getImageName()+" Image Selected");
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Image.Please look in to the issue.</p>");}

			
			
			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.flavorDropDown, stackorderinfo.getFlavor());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.flavorDropDown).equalsIgnoreCase(stackorderinfo.getFlavor())){
				Reporter.log(stackorderinfo.getFlavor()+" Flavor Selected");
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Flavor.Please look in to the issue.</p>");}

			
			objStackLaunchPage.instUserNameTextBox.sendKeys(stackorderinfo.getInstUserName());
			
			objStackLaunchPage.instPasswordTextBox.sendKeys(stackorderinfo.getInstPassword());

			
			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.flavorDropDown, stackorderinfo.getFlavor());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.flavorDropDown).equalsIgnoreCase(stackorderinfo.getFlavor())){
				Reporter.log(stackorderinfo.getFlavor()+" Flavor Selected");
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Flavor.Please look in to the issue.</p>");}

			
			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.resourceGroupDropDown, stackorderinfo.getResourceGroup());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.resourceGroupDropDown).equalsIgnoreCase(stackorderinfo.getResourceGroup())){
				Reporter.log(stackorderinfo.getResourceGroup()+" Resource Group Selected");
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Resource group.Please look in to the issue.</p>");}

			
			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.storageTypeDropDown, stackorderinfo.getStorageType());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.storageTypeDropDown).equalsIgnoreCase(stackorderinfo.getStorageType())){
				Reporter.log(stackorderinfo.getStorageType()+" Storage Type Selected");
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Storage Type.Please look in to the issue.</p>");}

			
			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.storageAccountDropDown, stackorderinfo.getStorageAccount());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.storageAccountDropDown).equalsIgnoreCase(stackorderinfo.getStorageAccount())){
				Reporter.log(stackorderinfo.getStorageAccount()+" Storage Account Selected");
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Storage Account.Please look in to the issue.</p>");}

			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.availabilitySetDropDown, stackorderinfo.getAvailabitySet());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.availabilitySetDropDown).equalsIgnoreCase(stackorderinfo.getAvailabitySet())){
				Reporter.log(stackorderinfo.getAvailabitySet()+" Availability Set Selected");
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Availability Set.Please look in to the issue.</p>");}

			
			
			
			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.enableMonitoringDropDown, stackorderinfo.getEnableMonitoring());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.enableMonitoringDropDown).equalsIgnoreCase(stackorderinfo.getEnableMonitoring())){
				Reporter.log(" Monitoring Selected as " +stackorderinfo.getEnableMonitoring());
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Monitoring.Please look in to the issue.</p>");}

			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.networkDropDown, stackorderinfo.getNetwork());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.networkDropDown).equalsIgnoreCase(stackorderinfo.getNetwork())){
				Reporter.log(stackorderinfo.getNetwork()+" Network Selected");
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Network.Please look in to the issue.</p>");}

			objStackLaunchPage.networkNameTextBox.sendKeys(stackorderinfo.getNetworkInterfaceName());
			
			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.subnetDropDown, stackorderinfo.getSubNetName());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.subnetDropDown).equalsIgnoreCase(stackorderinfo.getSubNetName())){
				Reporter.log(stackorderinfo.getSubNetName()+" Subnet Selected");
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Subnet.Please look in to the issue.</p>");}

			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.publicIPDropdown,stackorderinfo.getPublicIp());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.publicIPDropdown).equalsIgnoreCase(stackorderinfo.getPublicIp())){
				Reporter.log(stackorderinfo.getPublicIp()+"  Selected for public IP ");
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Public ip .Please look in to the issue.</p>");}
			

			break;}
			
			catch (Exception e1)
			{
				Reporter.log("<p style='color:red'>Issue while selecting configuration for stack while placing order for Azure provider.</p>");
				e1.printStackTrace();
				Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e1)+"</p>");
				Assert.fail();
			}
			
		case "privateopenstack" :  
			try{HandleDropDown.selectDDLByValue(objStackLaunchPage.vendorDropDown, stackorderinfo.getVendors());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.vendorDropDown).equalsIgnoreCase(stackorderinfo.getVendors())){
			Reporter.log(stackorderinfo.getVendors()+" Vendor Selected");
			}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the vendor.Please look in to the issue.</p>");}
			
			HandleDropDown.selectDDLByValue(objStackLaunchPage.regionDropDown, stackorderinfo.getRegion());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.regionDropDown).equalsIgnoreCase(stackorderinfo.getRegion())){
				Reporter.log(stackorderinfo.getRegion()+" Region Selected");
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Region.Please look in to the issue.</p>");}

			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.imageDropDown, stackorderinfo.getImageName());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.imageDropDown).equalsIgnoreCase(stackorderinfo.getImageName())){
				Reporter.log(stackorderinfo.getImageName()+" Image Selected");
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Image.Please look in to the issue.</p>");}

			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.flavorDropDown, stackorderinfo.getFlavor());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.flavorDropDown).equalsIgnoreCase(stackorderinfo.getFlavor())){
				Reporter.log(stackorderinfo.getFlavor()+" Flavor Selected");
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Flavor.Please look in to the issue.</p>");}

			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.enableMonitoringDropDown, stackorderinfo.getEnableMonitoring());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.enableMonitoringDropDown).equalsIgnoreCase(stackorderinfo.getEnableMonitoring())){
				Reporter.log(" Monitoring Selected as " +stackorderinfo.getEnableMonitoring());
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Monitoring.Please look in to the issue.</p>");}

			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.networkDropDown, stackorderinfo.getNetwork());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.networkDropDown).equalsIgnoreCase(stackorderinfo.getNetwork())){
				Reporter.log(stackorderinfo.getNetwork()+" Network Selected");
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Network.Please look in to the issue.</p>");}

			objStackLaunchPage.networkNameTextBox.sendKeys(stackorderinfo.getNetworkInterfaceName());
			
			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.subnetDropDown, stackorderinfo.getSubNetName());
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.subnetDropDown).equalsIgnoreCase(stackorderinfo.getSubNetName())){
				Reporter.log(stackorderinfo.getSubNetName()+" Subnet Selected");
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Subnet.Please look in to the issue.</p>");}
			
			if (stackorderinfo.getStaticIp().equalsIgnoreCase("Y")) {
			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.publicIPDropdown,staticIP);
			if(HandleDropDown.getSelectedValue(objStackLaunchPage.publicIPDropdown).equalsIgnoreCase(staticIP)){
				Reporter.log(staticIP+"  Selected for public IP ");
				}
			else{ Reporter.log("<p style='color:red'>Issue while selecting the Public ip .Please look in to the issue.</p>");}
			}
			else{
				HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.publicIPDropdown,stackorderinfo.getPublicIp());
				if(HandleDropDown.getSelectedValue(objStackLaunchPage.publicIPDropdown).equalsIgnoreCase(stackorderinfo.getPublicIp())){
					Reporter.log(stackorderinfo.getPublicIp()+"  Selected for public IP ");
					}
				else{ Reporter.log("<p style='color:red'>Issue while selecting the Public ip .Please look in to the issue.</p>");}
			}
			break;}
			
			catch (Exception e2)
			{
				Reporter.log("<p style='color:red'>Issue while selecting configuration for stack while placing order for Openstack provider.</p>");
				e2.printStackTrace();
				Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e2)+"</p>");
				Assert.fail();
			}
				

					
		}
		
		try{
			
			if(stackorderinfo.getSecurityGroups()!=null)
			{
			for (SecurityGroup secGroup : stackorderinfo.getSecurityGroups()) {
				SecurityGroupCreation securityGroupobj = new SecurityGroupCreation();
				 objStackLaunchPage.createSecurityGroupLink.click();
				securityGroupobj.createSecurityGroup(secGroup);
			}
			}
		}
		
		catch (Exception e)
		{
			Reporter.log("Create security group link is not available");
			e.printStackTrace();
			
		}
		
		SwitchFrame.defaultSwitch();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView(true);", objStackLaunchPage.stackLaunchButton);
		System.out.println(driver.manage().window().getSize());
		js.executeScript("window.scrollBy(0, -1900);");
		
		SwitchFrame.elementSwitch(objCatalogPage.launchstackFrame);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		objStackLaunchPage.stackLaunchButton.click();
		
	
		
	
		
		try
		{
			Thread.sleep(5000);
			objCatalogPage.slaAgreeButton.click();
			
		}
		
		 catch(Exception e)
		 {
			 
		 }
	try{
		SwitchFrame.defaultSwitch();
	
		if(driver.getPageSource().contains("Stack creation is initialized. You will receive an email when the stack is ready.")==true)
		{
			Reporter.log("stack launched successfully");
			//objCatalogPage.catalogLink.click();
		}
		else
		{
			Reporter.log("<p Style ='color:Red'>Stack launch is failure..</p>");
			
		} 
		
		/*objAppStackPage.manageLink.click();
		objAppStackPage.appStacksLink.click();*/
		
		boolean test = true;
		long startTime = (System.currentTimeMillis())/1000;
		while(test) //Converting in to second and waiting till the time out or the condition satisfied
		{	
			
				if ((System.currentTimeMillis() / 1000) - startTime > timeout) {
					System.out.println("Reached 10 minutes and exiting the loop");
					Reporter.log("<p Style ='color:Red'> Waited for 10 minutes. Stack did not go to running please look in to the issue.</p>");
					Assert.fail();
				}
				
					explicitWait(objAppStackPage.showingText);
				String stackstatus = objAppStackPage.getAppStackStatus(stackorderinfo.getStackName());
				if(stackstatus!=null)
				{
				 if(stackstatus.equalsIgnoreCase("Running")){
				 test= false;
				Reporter.log("Appstack status  Present in Running status");
				break;}}
				
				if(stackstatus!=null)
				{
					if(stackstatus.equalsIgnoreCase("Error")){
					 test= false;
					Reporter.log("Appstack status  Present in Error status");
					
					Assert.fail();}
				}
			  
			
			
		/*	catch(Exception e)
			{	*/
				Thread.sleep(15000);
				explicitWait(objAppStackPage.searchTextBox);
				HandleDropDown.selectDDLByValue(objAppStackPage.searchDropDown, "name");
				objAppStackPage.searchTextBox.clear();
				objAppStackPage.searchTextBox.sendKeys(stackorderinfo.getStackName());
				Thread.sleep(3000);
				objAppStackPage.searchTextBox.sendKeys(Keys.ENTER);
				
				//}
			}
		
		
		
	}
	
	catch(Exception e)
	{
		Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e)+"</p>");
		Assert.fail();
	}
	
	}	
		
		

}
