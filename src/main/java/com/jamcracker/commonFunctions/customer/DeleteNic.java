package com.jamcracker.commonFunctions.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Reporter;

import com.jamcracker.constants.NicConstants;
import com.jamcracker.entity.service.NicDetails;
import com.jamcracker.objectRepository.customer.CustomerMenuAndSubmenuObjects;
import com.jamcracker.objectRepository.customer.InstancesPage;
import com.jamcracker.objectRepository.customer.NetworkInterfacePage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.SQLUtil;
import com.jamcracker.utilities.TestBase;

public class DeleteNic extends TestBase {

	InstancesPage objInstancePage = new InstancesPage();
	CustomerMenuAndSubmenuObjects menuObj = new CustomerMenuAndSubmenuObjects();
	NetworkInterfacePage nicPageObj = new NetworkInterfacePage();

	Connection con;

	public void nicDelete(NicDetails nicDataObj) {
		try {

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
			nicPageObj.deleteNicLink.click();
			nicPageObj.nicDeleteConfirm.click();
			if (getDriver().getPageSource()
					.contains(NicConstants.NICDELETEMSG + "'" + nicDataObj.getNicName() + "'.")) {
				Reporter.log("Delete Nic intiated for NIC " + nicDataObj.getNicName());
			} else {
				Reporter.log("<p style='color:red'> Delete action is not intiated.Please check the issue.</p>");
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
						.prepareStatement("select status from jci_port where port_name like '" + nicDataObj.getNicName()
								+ "' and actor_id=(select organization_id from jcp_person where email like '"
								+ nicDataObj.getEmail()
								+ "') and  server_id=(select  id from jcp_server where server_name like '"
								+ nicDataObj.getInstName()
								+ "' order by creation_date desc  limit 1) order by creation_date desc limit 1");
				ResultSet resStatus = getStatusStmt.executeQuery();

				if (resStatus.next()) {
					switch (resStatus.getInt(1)) {
					case NicConstants.NICACTIVE:
						Reporter.log("DB: Nic present in active status");
						test = false;
						break;
					case NicConstants.NICERROR:
						Reporter.log("DB: Nic Present in  error status");
						test = false;
						break;
					case NicConstants.NICTERMINATED:
						Reporter.log("DB: Nic Deleted Successfully");
						test = false;
						break;

					}
				}
			}
			objInstancePage.searchTextBox.clear();
			nicPageObj.searchTextBox.sendKeys(nicDataObj.getNicName());
			Thread.sleep(2000);
			nicPageObj.goButton.click();
			// System.out.println(nicPageObj.rows.size());
			try {
				if (nicPageObj.getStatus(nicDataObj.getNicName()).equalsIgnoreCase("active")) {
					Reporter.log(
							nicDataObj.getNicName() + "Nic is not deleted successfully and displayed in active status");
					Assert.fail();
				}
			} catch (NoSuchElementException e) {

				try {
					if (nicPageObj.getStatus(nicDataObj.getNicName()).equalsIgnoreCase("Error")) {

						Reporter.log(nicDataObj.getNicName() + "Nic is not deleted. and its present in Error status");
						Assert.fail();
					}
				} catch (Exception e1) {
					Reporter.log(nicDataObj.getNicName() + "Nic is  deleted.");

				}
			}
		} catch (Exception e) {
			
			Reporter.log("<p style='color:red'>Nic is not deleted. Please check the issue.</p>");
			Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e) + "</p>");
			e.printStackTrace();
			Assert.fail();

		} finally {
			// SQLUtil.closePreparedStatement(stmt1,stmt);
			try {
				SQLUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
