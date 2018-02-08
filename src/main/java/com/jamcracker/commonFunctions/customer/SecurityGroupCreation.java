package com.jamcracker.commonFunctions.customer;

import java.util.Iterator;
import java.util.ListIterator;

import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.entity.service.SecurityGroup;
import com.jamcracker.entity.service.SecurityGroupRules;
import com.jamcracker.objectRepository.customer.NetworkInterfacePage;
import com.jamcracker.objectRepository.customer.StackLaunchPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class SecurityGroupCreation extends TestBase {
	public  void createSecurityGroup(SecurityGroup secGroup)
	{
		StackLaunchPage  objStackLaunchPage = new StackLaunchPage();
		explicitWait(objStackLaunchPage.SecurityGroupNameTextBox);
		objStackLaunchPage.SecurityGroupNameTextBox.sendKeys(secGroup.getSecurityGroupName());
		int i=1;
		int noOfRules = secGroup.getRules().size();
		while(noOfRules!=1)
		{
			objStackLaunchPage.addNewRuleLink.click();
			noOfRules--;
			
		}
		for(SecurityGroupRules rules:secGroup.getRules()){
			rules.getIpAddress();
			String val = i+"";
			HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.getRuleDD(val),rules.getProtocol());
			objStackLaunchPage.getPortStartRange(val).sendKeys(rules.getPortStart());
			objStackLaunchPage.getPortEndRange(val).sendKeys(rules.getPortEnd());
			objStackLaunchPage.getIpAddress(val).sendKeys(rules.getIpAddress());
			objStackLaunchPage.getSubnetMask(val).sendKeys(rules.getSubnetMask());
			i++;
			
		}
		objStackLaunchPage.doneButton.click();
		if(getDriver().getPageSource().contains(secGroup.getSecurityGroupName())== true)
			Reporter.log( secGroup.getSecurityGroupName() + "Security group created");
		
	}
	
	public void nicCreateSecurityGroup(SecurityGroup secGroup)
	{
		try{
		NetworkInterfacePage  objNicPage = new NetworkInterfacePage();
			try{explicitWait(objNicPage.securityGroupNameTextBox);}
			catch(Exception e)
			{
				objNicPage.createSecurityGroupLink.click();
			}
		objNicPage.securityGroupNameTextBox.sendKeys(secGroup.getSecurityGroupName());
		int i=0;
		int noOfRules = secGroup.getRules().size();
		while(noOfRules!=1)
		{
			explicitWaitToClickable(objNicPage.addNewRuleLink);
			objNicPage.addNewRuleLink.click();
			noOfRules--;
			
		}
		
		 ListIterator<SecurityGroupRules> litr = secGroup.getRules().listIterator();
		
		 while(litr.hasNext())
		 {
			    SecurityGroupRules rules = litr.next();
			    HandleDropDown.selectDDLByVisibletext(objNicPage.ruleDropDown,rules.getProtocol());
				objNicPage.fromPortRangeTextBox.sendKeys(rules.getPortStart());
				objNicPage.toPortRangeTextBox.sendKeys(rules.getPortEnd());
				objNicPage.ipAddressTextBox.sendKeys(rules.getIpAddress());
				objNicPage.subnetMaskTextBox.sendKeys(rules.getSubnetMask());
				if(litr.nextIndex() ==1)
				{
					litr.remove();
					break;
				}
			    
		 }
	
		
		
		for(SecurityGroupRules rules:secGroup.getRules()){
			rules.getIpAddress();
			String val = i+"";
			HandleDropDown.selectDDLByVisibletext(objNicPage.getRuleDD(val),rules.getProtocol());
			objNicPage.getPortStartRange(val).sendKeys(rules.getPortStart());
			objNicPage.getPortEndRange(val).sendKeys(rules.getPortEnd());
			objNicPage.getIpddressTextBox(val).sendKeys(rules.getIpAddress());
			objNicPage.getSubNetMaskTextBox(val).sendKeys(rules.getSubnetMask());
			i++;
			
		}
		objNicPage.createButton.click();
		if(getDriver().getPageSource().contains(secGroup.getSecurityGroupName())== true)
			Reporter.log( secGroup.getSecurityGroupName() + "Security group created");
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}

}
