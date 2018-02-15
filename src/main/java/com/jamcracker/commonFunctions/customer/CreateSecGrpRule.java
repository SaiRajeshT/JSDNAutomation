package com.jamcracker.commonFunctions.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Reporter;

import com.jamcracker.constants.NicConstants;
import com.jamcracker.entity.service.NicDetails;
import com.jamcracker.entity.service.SecurityGroup;
import com.jamcracker.entity.service.SecurityGroupRules;
import com.jamcracker.objectRepository.customer.CustomerMenuAndSubmenuObjects;
import com.jamcracker.objectRepository.customer.InstancesPage;
import com.jamcracker.objectRepository.customer.NetworkInterfacePage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.SQLUtil;
import com.jamcracker.utilities.TestBase;

public class CreateSecGrpRule extends TestBase {

	InstancesPage objInstancePage = new InstancesPage();
	CustomerMenuAndSubmenuObjects menuObj = new CustomerMenuAndSubmenuObjects();
	NetworkInterfacePage nicPageObj = new NetworkInterfacePage();

	Connection con;
	PreparedStatement stmt;
	PreparedStatement stmt1;

	public void createRule(NicDetails nicDataObj) {
		try {

			con = SQLUtil.getConnection();
			Reporter.log("Delete Security group Scenario :");
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
			nicPageObj.searchTextBox.sendKeys(nicDataObj.getNicName());
			Thread.sleep(2000);
			nicPageObj.goButton.click();
			nicPageObj.getNicAction(nicDataObj.getNicName()).click();
			nicPageObj.editNic.click();
			explicitWaitToClickable(nicPageObj.nicNameTextBox);

			explicitWaitToClickable(nicPageObj.securityGroupLink);
			Thread.sleep(2000);
			nicPageObj.securityGroupLink.click();

			try {

				if (nicDataObj.getSecurityGroups() != null) {
					for (SecurityGroup secGroup : nicDataObj.getSecurityGroups()) {
						JavascriptExecutor js = (JavascriptExecutor) getDriver();
						// js.executeScript("arguments[0].scrollIntoView(true);",nicPageObj.secGroup(secGroup.getSecurityGroupName()));
						js.executeScript("window.scrollBy(0,200)");
						nicPageObj.editSecGroup(secGroup.getSecurityGroupName()).click();
						int noOfRules = secGroup.getRules().size();
						while(noOfRules>0)
						{
							explicitWaitToClickable(nicPageObj.addNewRuleLink);
							nicPageObj.addNewRuleLink.click();
							noOfRules--;
						}
						
					int i=0;
					List<SecurityGroupRules> rules = secGroup.getRules();
					for(int j=0;j<rules.size();j++){
						String val = i+"";
						i++;
						if(nicPageObj.getRuleDD(val).isEnabled()){
						HandleDropDown.selectDDLByVisibletext(nicPageObj.getRuleDD(val),rules.get(j).getProtocol());
						nicPageObj.getPortStartRange(val).sendKeys(rules.get(j).getPortStart());
						nicPageObj.getPortEndRange(val).sendKeys(rules.get(j).getPortEnd());
						nicPageObj.getIpddressTextBox(val).sendKeys(rules.get(j).getIpAddress());
						nicPageObj.getSubNetMaskTextBox(val).sendKeys(rules.get(j).getSubnetMask());
						 continue;}
						j--;
					}
					 
					}
				}
			}

			catch (Exception e) {
				Reporter.log(" security group  is not available");
				e.printStackTrace();

			}

			explicitWait(nicPageObj.saveSecButton);
			nicPageObj.saveSecButton.click();

			if (getDriver().getPageSource().contains(NicConstants.NICUPDATEMSG)) {
				Reporter.log("Nic Updation intiated");
			}

			else {
				Reporter.log("Security group not deleted. Please check the issue.");
			}

			boolean test = true;
			long startTime = (System.currentTimeMillis()) / 1000;
			while (test) {
				if ((System.currentTimeMillis() / 1000) - startTime > timeout) {
					Reporter.log("<p style='color:red'>Waited for" + timeout
							+ " Seconds.Nic status did not go to Active/Error.Please check the issue.<p>");
					Assert.fail();
					break;
				}
				PreparedStatement getStatusStmt = con.prepareStatement(
						"select status from jci_port where port_name like '" + nicDataObj.getUpdateNicName()
								+ "' and actor_id=(select organization_id from jcp_person where email like '"
								+ nicDataObj.getEmail()
								+ "') and  server_id=(select  id from jcp_server where server_name like '"
								+ nicDataObj.getInstName()
								+ "' order by creation_date desc  limit 1) order by creation_date desc limit 1");
				ResultSet resStatus = getStatusStmt.executeQuery();

				if (resStatus.next()) {
					switch (resStatus.getInt(1)) {
					case NicConstants.NICACTIVE:
						Reporter.log("DB: Nic updated successfully and present in active status");
						test = false;
						break;
					case NicConstants.NICERROR:
						Reporter.log("Nic Created and went to error status");
						test = false;
						break;
					case NicConstants.NICTERMINATED:
						Reporter.log("Nic Deleted Successfully");
						test = false;
						break;

					}
				}

				nicPageObj.searchTextBox.clear();
				nicPageObj.searchTextBox.sendKeys(nicDataObj.getUpdateNicName());
				Thread.sleep(4000);
				nicPageObj.goButton.click();
				// System.out.println(nicPageObj.rows.size());
				if (nicPageObj.getStatus(nicDataObj.getUpdateNicName()).equalsIgnoreCase("active")) {
					Reporter.log(
							nicDataObj.getUpdateNicName() + "Nic updated successfully and displayed in active status");
				} else if (nicPageObj.getStatus(nicDataObj.getUpdateNicName()).equalsIgnoreCase("Error")) {

					Reporter.log(nicDataObj.getUpdateNicName() + "Nic Went to Error status");
				}

			}

		} catch (Exception e) {
			Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e) + "</p>");
			e.printStackTrace();
			Assert.fail();

		} finally {
			try {
				SQLUtil.closePreparedStatement(stmt);
				SQLUtil.closePreparedStatement(stmt1);
				SQLUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
