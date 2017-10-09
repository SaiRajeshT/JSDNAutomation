package com.jamcracker.commonFunctions.customer;

import org.testng.Reporter;

import com.jamcracker.entity.service.SecurityGroup;
import com.jamcracker.entity.service.SecurityGroupRules;
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
		if(driver.getPageSource().contains(secGroup.getSecurityGroupName())== true)
			Reporter.log( secGroup.getSecurityGroupName() + "Security group created");
		
	}

}
