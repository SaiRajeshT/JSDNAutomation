package com.jamcracker.commonFunctions.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.Reporter;

import com.jamcracker.constants.NicConstants;
import com.jamcracker.entity.service.NicDetails;
import com.jamcracker.objectRepository.customer.CustomerMenuAndSubmenuObjects;
import com.jamcracker.objectRepository.customer.InstancesPage;
import com.jamcracker.objectRepository.customer.NetworkInterfacePage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.SQLUtil;
import com.jamcracker.utilities.TestBase;

public class UpdateNicName extends TestBase {

	InstancesPage objInstancePage = new InstancesPage();
	CustomerMenuAndSubmenuObjects menuObj = new CustomerMenuAndSubmenuObjects();
	NetworkInterfacePage nicPageObj = new NetworkInterfacePage();

	Connection con;
	PreparedStatement getStatusStmt;
	public void nicUpdate(NicDetails nicDataObj) {
		try {
			Reporter.log("Nic update Scenario" );
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
			nicPageObj.nicNameTextBox.clear();
			nicPageObj.nicNameTextBox.sendKeys(nicDataObj.getUpdateNicName());
			HandleDropDown.selectDDLByVisibletext(nicPageObj.publicIpDropdown, nicDataObj.getPublicIp());
			//explicitWaitToClickable(nicPageObj.saveNicButton); its not waiting even after keeping this
			//Thread.sleep(5000);
			explicitWaitToClickable(nicPageObj.publicIpDropdown);
			nicPageObj.saveNicButton.click();

			if (getDriver().getPageSource()
					.contains(NicConstants.NICUPDATEMSG + "'" + nicDataObj.getUpdateNicName() + "'.")) {
				Reporter.log("Nic Updatation intiated for  " + nicDataObj.getNicName());
			} else {
				Reporter.log("<p style='color:red'> Update action is not intiated for nic '" + nicDataObj.getNicName()
						+ "'.Please check the issue.</p>");
			}
			con = SQLUtil.getConnection();
			boolean test = true;
			long startTime = (System.currentTimeMillis()) / 1000;
			while (test) {
				if ((System.currentTimeMillis() / 1000) - startTime > timeout) {
					Reporter.log("<p style='color:red'>Waited for" + timeout + " Seconds. Nic "
							+ nicDataObj.getNicName() + "  is not getting Deleted.Please check the issue.<p>");
					Assert.fail();
					break;
				}
				PreparedStatement getStatusStmt = con
						.prepareStatement("select status from jci_port where port_name like '" + nicDataObj.getUpdateNicName()
								+ "' and actor_id=(select organization_id from jcp_person where email like '"
								+ nicDataObj.getEmail()
								+ "') and  server_id=(select  id from jcp_server where server_name like '"
								+ nicDataObj.getInstName()
								+ "' order by creation_date desc  limit 1) order by creation_date desc limit 1");
				ResultSet resStatus = getStatusStmt.executeQuery();

				if (resStatus.next()) {
					switch (resStatus.getInt(1)) {
					case NicConstants.NICACTIVE:
						Reporter.log("DB: Nic updated and present in active status");
						test = false;
						break;
					case NicConstants.NICERROR:
						Reporter.log(
								"<p style = 'color:red'>DB: Nic updated but went to  error status. Please check the issue</p>");
						test = false;
						break;
					case NicConstants.NICTERMINATED:
						Reporter.log(
								"<p style = 'color:red'>DB: Nic updated but it got Deleted. Please check the issue.</p> ");
						test = false;
						break;

					}
				}
			}
			objInstancePage.searchTextBox.clear();
			nicPageObj.searchTextBox.sendKeys(nicDataObj.getUpdateNicName());
			Thread.sleep(2000);
			nicPageObj.goButton.click();
			if (nicPageObj.getStatus(nicDataObj.getUpdateNicName()).equalsIgnoreCase("active")) {
				Reporter.log("'"+nicDataObj.getUpdateNicName()+ "' Nic is  updated  successfully and status changed to active status");
			}
			else if (nicPageObj.getStatus(nicDataObj.getUpdateNicName()).equalsIgnoreCase("Error")) {

				Reporter.log("'"+nicDataObj.getUpdateNicName()
						+ "Nic Updation is failed and Nic Status changed to Error.Please Look in to the issue.</p>");
				Assert.fail();
			}

		} catch (Exception e) {

			Reporter.log("<p style='color:red'>Nic is not Updated. Please check the issue.</p>");
			Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e) + "</p>");
			e.printStackTrace();
			Assert.fail();

		} finally {
			try {
				 SQLUtil.closePreparedStatement(getStatusStmt);
				SQLUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
