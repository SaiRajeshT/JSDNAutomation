package com.jamcracker.commonFunctions.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Reporter;

import com.jamcracker.constants.NicConstants;
import com.jamcracker.entity.service.NicDetails;
import com.jamcracker.entity.service.SecurityGroup;
import com.jamcracker.objectRepository.customer.CustomerMenuAndSubmenuObjects;
import com.jamcracker.objectRepository.customer.InstancesPage;
import com.jamcracker.objectRepository.customer.NetworkInterfacePage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.SQLUtil;
import com.jamcracker.utilities.TestBase;

public class NicCreation extends TestBase {
	
	InstancesPage objInstancePage = new InstancesPage();
	CustomerMenuAndSubmenuObjects menuObj = new CustomerMenuAndSubmenuObjects();
	NetworkInterfacePage nicPageObj = new NetworkInterfacePage();

	Connection con;
	public void nicCreation(NicDetails nicDataObj){
	try{
		
		 con = SQLUtil.getConnection();
		PreparedStatement stmt=	con.prepareStatement("select count(port_name) from jci_port where port_name like '"+nicDataObj.getNicName()+"' and "
				+ "actor_id=(select organization_id from jcp_person where email like '"+nicDataObj.getEmail()+"') and "
				+ "server_id=(select  id from jcp_server where server_name like '"+nicDataObj.getInstName()+"' order by creation_date desc  limit 1)");
		ResultSet res = stmt.executeQuery();
		int count =	0;
		if(res.next()){
			count =	res.getInt(1);
		}
			
		objInstancePage.manageLink.click();
		objInstancePage.instancesLink.click();
		explicitWait(objInstancePage.searchTextBox);
		HandleDropDown.selectDDLByValue(objInstancePage.searchDropDown, "name");
		objInstancePage.searchTextBox.clear();
		objInstancePage.searchTextBox.sendKeys(nicDataObj.getInstName());
		Thread.sleep(3000);
		objInstancePage.searchTextBox.sendKeys(Keys.ENTER);
		explicitWait(objInstancePage.showingText);
		objInstancePage.getInstanceActionLink(nicDataObj.getInstName()).click();
		objInstancePage.viewDetaisLink.click();
		objInstancePage.networkInterfaceLink.click();
		explicitWait(objInstancePage.addNetworkInterfaceButton);
		objInstancePage.addNetworkInterfaceButton.click();
		nicPageObj.nicNameTextBox.sendKeys(nicDataObj.getNicName());
		explicitWaitToClickable(nicPageObj.subNetDropDown);
		HandleDropDown.selectDDLByVisibletext(nicPageObj.subNetDropDown, nicDataObj.getSubNet());
		HandleDropDown.selectDDLByVisibletext(nicPageObj.publicIpDropdown, nicDataObj.getPublicIp());
		nicPageObj.securityGroupLink.click();
	
		try{
			
			if(nicDataObj.getSecurityGroups()!=null)
			{
			for (SecurityGroup secGroup : nicDataObj.getSecurityGroups()) {
				SecurityGroupCreation securityGroupobj = new SecurityGroupCreation();
				explicitWaitToClickable(nicPageObj.createSecurityGroupLink);
				nicPageObj.createSecurityGroupLink.click();
				securityGroupobj.nicCreateSecurityGroup(secGroup);
			}
			}
		}
		
		catch (Exception e)
		{
			Reporter.log("Create security group link is not available");
			e.printStackTrace();
			
		}
		
		explicitWait(nicPageObj.addButton);
		nicPageObj.addButton.click();
		
		PreparedStatement stmt1=	con.prepareStatement("select count(port_name) from jci_port where port_name like '"+nicDataObj.getNicName()+"' and "
				+ "actor_id=(select organization_id from jcp_person where email like '"+nicDataObj.getEmail()+"') and "
				+ "server_id=(select  id from jcp_server where server_name like '"+nicDataObj.getInstName()+"' order by creation_date desc  limit 1)");
		ResultSet res1 = stmt1.executeQuery();
		int count1 = 0;
		if(res1.next()){
			count1 =	res1.getInt(1);
		}
			if(count1 > count)
			{
				boolean test = true;
				long startTime = (System.currentTimeMillis()) / 1000;
				while (test) {
					if ((System.currentTimeMillis() / 1000) - startTime > timeout) {
						Reporter.log("<p style='color:red'>Waited for"+timeout+" Seconds.Nic status did not go to Active/Error.Please check the issue.<p>");
						Assert.fail();
						break;		}
			      PreparedStatement getStatusStmt = con.prepareStatement("select status from jci_port where port_name like '"+nicDataObj.getNicName()+"' and actor_id=(select organization_id from jcp_person where email like '"+nicDataObj.getEmail()+"') and  server_id=(select  id from jcp_server where server_name like '"+nicDataObj.getInstName()+"' order by creation_date desc  limit 1) order by creation_date desc limit 1");
			      		ResultSet resStatus = getStatusStmt.executeQuery();
			      		
			      		if(resStatus.next())
			      		{
			      			switch(resStatus.getInt(1))
			      			{
			      			case NicConstants.NICACTIVE : 
			      				Reporter.log("DB: Nic Created successfully and present in active status");
			      				test = false;
			      				break;
			      			case NicConstants.NICERROR :
			      				Reporter.log("Nic Created and went to error status");
			      				test = false;
			      				break;
			      			case NicConstants.NICTERMINATED:
			      				Reporter.log("Nic Deleted Successfully");
			      				test = false;
			      				break;
			      			 
			      			}
			      		}
			
				}
			
				nicPageObj.searchTextBox.sendKeys(nicDataObj.getNicName());
				Thread.sleep(2000);
				nicPageObj.goButton.click();
				//System.out.println(nicPageObj.rows.size());
				if(nicPageObj.getStatus(nicDataObj.getNicName()).equalsIgnoreCase("active"))
						{
							Reporter.log(nicDataObj.getNicName()+"Nic Created successfully and displayed in active status");
						}
				else if(nicPageObj.getStatus(nicDataObj.getNicName()).equalsIgnoreCase("Error"))
				{
					
						Reporter.log(nicDataObj.getNicName()+"Nic Went to Error status");
				}
				
				
				
			}
			
			else{
				Reporter.log("No nics are created");
			}
			
			
	}
		catch(Exception e)
		{ 
			Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e)+"</p>");
			e.printStackTrace();
			Assert.fail();
			
		}
	finally {
					 //SQLUtil.closePreparedStatement(stmt1,stmt);
					 try {
						SQLUtil.closeConnection(con);
					} catch (Exception e) {
						e.printStackTrace();
					}
			 
		 }
	
	
	}
}
