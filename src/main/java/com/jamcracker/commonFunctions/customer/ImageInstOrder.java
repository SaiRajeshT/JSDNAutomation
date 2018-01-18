package com.jamcracker.commonFunctions.customer;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.entity.service.InstFromImageOrder;
import com.jamcracker.objectRepository.customer.AppstackPage;
import com.jamcracker.objectRepository.customer.CatalogPage;
import com.jamcracker.objectRepository.customer.Imagespage;
import com.jamcracker.objectRepository.customer.StackLaunchPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.SwitchFrame;
import com.jamcracker.utilities.TestBase;

public class ImageInstOrder extends TestBase {
	private String staticIP;
	AppstackPage objAppStackPage = new AppstackPage();

	public void instOrder(InstFromImageOrder instorderinfo) {
		StackLaunchPage objStackLaunchPage = new StackLaunchPage();
		CatalogPage objCatalogPage = new CatalogPage();
		Imagespage objImagesPage = new Imagespage();

		GetStaticIp objstaticIp = new GetStaticIp();
		if (instorderinfo.getStaticIp().equalsIgnoreCase("Y")) {

			staticIP = objstaticIp.getStaticIp(instorderinfo.getVendorName(), instorderinfo.getRegion(), "public");
		}
		try {
			objImagesPage.manageLink.click();
			objImagesPage.imageLink.click();
			objImagesPage.searchTextBox.sendKeys(instorderinfo.getImageName());
			Thread.sleep(3000);
			objImagesPage.goButton.click();
			objImagesPage.getImageActionLink(instorderinfo.getImageName()).click();
			objImagesPage.createInstanceLink.click();

			// explicitWaitFrameToLoad(objCatalogPage.launchstackFrame);
			// Tried all possible way to switch to frame without keeping thread
			// not working

			Thread.sleep(20000);

			SwitchFrame.elementSwitch(objCatalogPage.launchstackFrame);

			// waitTillFrameLoad(objCatalogPage.launchstackFrame);
			// explicitWaitFrameToLoad(objCatalogPage.launchstackFrame);
			/*
			 * while(true) { try{
			 * //objStackLaunchPage.instanceNameTextBox.isDisplayed();
			 * explicitWait(objStackLaunchPage.stackNameTextBox); break;
			 * 
			 * } catch(Exception e) { e.printStackTrace(); } }
			 */

			objStackLaunchPage.stackNameTextBox.clear();
			objStackLaunchPage.stackNameTextBox.sendKeys(instorderinfo.getStackName());
			objStackLaunchPage.descriptionTextBox.sendKeys(instorderinfo.getStackDesc());
			objStackLaunchPage.tagLink.click();
			Map<String, String> tags = instorderinfo.getTags();
			// System.out.println(tags.size());

			int tagsize = tags.size();
			Set<Map.Entry<String, String>> set = tags.entrySet();
			Iterator<Entry<String, String>> itr = set.iterator();

			for (Map.Entry<String, String> entry : set) {
				System.out.print(entry.getKey());
				System.out.println(entry.getValue());
			}

			for (int i = 1; i <= tagsize; i++) {

				if (i == 1) {
					if (objStackLaunchPage.getTagKeyTextBox(i).getAttribute("value").isEmpty()) {
						Map.Entry<String, String> entry = (Map.Entry<String, String>) itr.next();
						objStackLaunchPage.getTagKeyTextBox(i).sendKeys(entry.getKey());
						objStackLaunchPage.valueLink.click();
						objStackLaunchPage.getTagValueTextBox(i).sendKeys(entry.getValue());
						objStackLaunchPage.valueLink.click();
					}
				} else {
					if (objStackLaunchPage.addNewTagLink.isDisplayed()) {
						objStackLaunchPage.addNewTagLink.click();
						Map.Entry<String, String> entry = (Map.Entry<String, String>) itr.next();
						objStackLaunchPage.getTagKeyTextBox(i).sendKeys(entry.getKey());
						objStackLaunchPage.valueLink.click();
						objStackLaunchPage.getTagValueTextBox(i).sendKeys(entry.getValue());
						objStackLaunchPage.valueLink.click();
					}
				}

			}

			// Reporter.log(tagsize +" Tags has been added to stack ");
			objStackLaunchPage.instanceNameTextBox.clear();
			objStackLaunchPage.instanceNameTextBox.sendKeys(instorderinfo.getInstanceName());

			switch (instorderinfo.getVendorName().toLowerCase()) {
			case "aws":
				try {
					HandleDropDown.selectDDLByValue(objStackLaunchPage.vendorDropDown, instorderinfo.getVendorName());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.vendorDropDown)
							.equalsIgnoreCase(instorderinfo.getVendorName())) {
						Reporter.log(instorderinfo.getVendorName() + " Vendor Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the vendor.Please look in to the issue.</p>");
					}

					HandleDropDown.selectDDLByValue(objStackLaunchPage.regionDropDown, instorderinfo.getRegion());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.regionDropDown)
							.equalsIgnoreCase(instorderinfo.getRegion())) {
						Reporter.log(instorderinfo.getRegion() + " Region Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Region.Please look in to the issue.</p>");
					}

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.imageDropDown,
							instorderinfo.getImageName());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.imageDropDown)
							.equalsIgnoreCase(instorderinfo.getImageName())) {
						Reporter.log(instorderinfo.getImageName() + " Image Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Image.Please look in to the issue.</p>");
					}

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.availabilityZoneDropDown,
							instorderinfo.getAvailabiltyZone());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.availabilityZoneDropDown)
							.equalsIgnoreCase(instorderinfo.getAvailabiltyZone())) {
						Reporter.log(instorderinfo.getAvailabiltyZone() + " Availabilityzone Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Availabiltiy Zone.Please look in to the issue.</p>");
					}

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.familyDropDown, instorderinfo.getFamily());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.familyDropDown)
							.equalsIgnoreCase(instorderinfo.getFamily())) {
						Reporter.log("Family is selected as " + instorderinfo.getFamily());
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Family.Please look in to the issue.</p>");
					}

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.familyTypeDropDown,
							instorderinfo.getType());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.familyTypeDropDown)
							.equalsIgnoreCase(instorderinfo.getType())) {
						Reporter.log(instorderinfo.getType() + " Family Type Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Family Type.Please look in to the issue.</p>");
					}

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.flavorDropDown, instorderinfo.getFlavor());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.flavorDropDown)
							.equalsIgnoreCase(instorderinfo.getFlavor())) {
						Reporter.log(instorderinfo.getFlavor() + " Flavor Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Flavor.Please look in to the issue.</p>");
					}

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.enableMonitoringDropDown,
							instorderinfo.getEnableMonitoring());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.enableMonitoringDropDown)
							.equalsIgnoreCase(instorderinfo.getEnableMonitoring())) {
						Reporter.log(" Monitoring Selected as " + instorderinfo.getEnableMonitoring());
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Monitoring.Please look in to the issue.</p>");
					}

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.networkDropDown,
							instorderinfo.getNetwork());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.networkDropDown)
							.equalsIgnoreCase(instorderinfo.getNetwork())) {
						Reporter.log(instorderinfo.getNetwork() + " Network Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Network.Please look in to the issue.</p>");
					}

					objStackLaunchPage.networkNameTextBox.sendKeys(instorderinfo.getNetworkInterfaceName());

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.subnetDropDown,
							instorderinfo.getSubNetName());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.subnetDropDown)
							.equalsIgnoreCase(instorderinfo.getSubNetName())) {
						Reporter.log(instorderinfo.getSubNetName() + " Subnet Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Subnet.Please look in to the issue.</p>");
					}
					if (instorderinfo.getStaticIp().equalsIgnoreCase("Y")) {
						HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.publicIPDropdown, staticIP);
						if (HandleDropDown.getSelectedValue(objStackLaunchPage.publicIPDropdown)
								.equalsIgnoreCase(staticIP)) {
							Reporter.log(staticIP + "  Selected for public IP ");
						} else {
							Reporter.log(
									"<p style='color:red'>Issue while selecting the Public ip .Please look in to the issue.</p>");
						}
					} else {
						if (HandleDropDown.getSelectedValue(objStackLaunchPage.publicIPDropdown)
								.equalsIgnoreCase(instorderinfo.getPublicIp())) {
							Reporter.log(instorderinfo.getPublicIp() + "  Selected for public IP ");
						} else {
							Reporter.log(
									"<p style='color:red'>Issue while selecting the Public ip .Please look in to the issue.</p>");
						}
					}
					break;
				} catch (Exception e) {
					Reporter.log(
							"<p style='color:red'>Issue while selecting configuration for stack while placing order for aws Provider.</p>");
					e.printStackTrace();
					Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e) + "</p>");
					Assert.fail();
				}

			case "windowsazure":
				try {
					HandleDropDown.selectDDLByValue(objStackLaunchPage.vendorDropDown,
							instorderinfo.getVendorName().toLowerCase());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.vendorDropDown)
							.equalsIgnoreCase(instorderinfo.getVendorName())) {
						Reporter.log(instorderinfo.getVendorName() + " Vendor Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the vendor.Please look in to the issue.</p>");
					}

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.regionDropDown, instorderinfo.getRegion());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.regionDropDown)
							.equalsIgnoreCase(instorderinfo.getRegion())) {
						Reporter.log(instorderinfo.getRegion() + " Region Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Region.Please look in to the issue.</p>");
					}

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.imageDropDown,
							instorderinfo.getImageName());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.imageDropDown)
							.equalsIgnoreCase(instorderinfo.getImageName())) {
						Reporter.log(instorderinfo.getImageName() + " Image Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Image.Please look in to the issue.</p>");
					}

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.flavorDropDown, instorderinfo.getFlavor());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.flavorDropDown)
							.equalsIgnoreCase(instorderinfo.getFlavor())) {
						Reporter.log(instorderinfo.getFlavor() + " Flavor Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Flavor.Please look in to the issue.</p>");
					}

					objStackLaunchPage.instUserNameTextBox.sendKeys(instorderinfo.getInstUserName());

					objStackLaunchPage.instPasswordTextBox.sendKeys(instorderinfo.getInstPassword());

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.flavorDropDown, instorderinfo.getFlavor());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.flavorDropDown)
							.equalsIgnoreCase(instorderinfo.getFlavor())) {
						Reporter.log(instorderinfo.getFlavor() + " Flavor Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Flavor.Please look in to the issue.</p>");
					}

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.resourceGroupDropDown,
							instorderinfo.getResourceGroup());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.resourceGroupDropDown)
							.equalsIgnoreCase(instorderinfo.getResourceGroup())) {
						Reporter.log(instorderinfo.getResourceGroup() + " Resource Group Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Resource group.Please look in to the issue.</p>");
					}

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.storageTypeDropDown,
							instorderinfo.getStorageType());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.storageTypeDropDown)
							.equalsIgnoreCase(instorderinfo.getStorageType())) {
						Reporter.log(instorderinfo.getStorageType() + " Storage Type Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Storage Type.Please look in to the issue.</p>");
					}

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.storageAccountDropDown,
							instorderinfo.getStorageAccount());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.storageAccountDropDown)
							.equalsIgnoreCase(instorderinfo.getStorageAccount())) {
						Reporter.log(instorderinfo.getStorageAccount() + " Storage Account Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Storage Account.Please look in to the issue.</p>");
					}

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.availabilitySetDropDown,
							instorderinfo.getAvailabitySet());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.availabilitySetDropDown)
							.equalsIgnoreCase(instorderinfo.getAvailabitySet())) {
						Reporter.log(instorderinfo.getAvailabitySet() + " Availability Set Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Availability Set.Please look in to the issue.</p>");
					}

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.enableMonitoringDropDown,
							instorderinfo.getEnableMonitoring());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.enableMonitoringDropDown)
							.equalsIgnoreCase(instorderinfo.getEnableMonitoring())) {
						Reporter.log(" Monitoring Selected as " + instorderinfo.getEnableMonitoring());
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Monitoring.Please look in to the issue.</p>");
					}

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.networkDropDown,
							instorderinfo.getNetwork());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.networkDropDown)
							.equalsIgnoreCase(instorderinfo.getNetwork())) {
						Reporter.log(instorderinfo.getNetwork() + " Network Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Network.Please look in to the issue.</p>");
					}

					objStackLaunchPage.networkNameTextBox.sendKeys(instorderinfo.getNetworkInterfaceName());

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.subnetDropDown,
							instorderinfo.getSubNetName());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.subnetDropDown)
							.equalsIgnoreCase(instorderinfo.getSubNetName())) {
						Reporter.log(instorderinfo.getSubNetName() + " Subnet Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Subnet.Please look in to the issue.</p>");
					}

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.publicIPDropdown,
							instorderinfo.getPublicIp());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.publicIPDropdown)
							.equalsIgnoreCase(instorderinfo.getPublicIp())) {
						Reporter.log(instorderinfo.getPublicIp() + "  Selected for public IP ");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Public ip .Please look in to the issue.</p>");
					}

					break;
				}

				catch (Exception e1) {
					Reporter.log(
							"<p style='color:red'>Issue while selecting configuration for stack while placing order for Azure provider.</p>");
					e1.printStackTrace();
					Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e1) + "</p>");
					Assert.fail();
				}

			case "privateopenstack":
				try {
					HandleDropDown.selectDDLByValue(objStackLaunchPage.vendorDropDown, instorderinfo.getVendorName());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.vendorDropDown)
							.equalsIgnoreCase(instorderinfo.getVendorName())) {
						Reporter.log(instorderinfo.getVendorName() + " Vendor Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the vendor.Please look in to the issue.</p>");
					}

					HandleDropDown.selectDDLByValue(objStackLaunchPage.regionDropDown, instorderinfo.getRegion());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.regionDropDown)
							.equalsIgnoreCase(instorderinfo.getRegion())) {
						Reporter.log(instorderinfo.getRegion() + " Region Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Region.Please look in to the issue.</p>");
					}

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.imageDropDown,
							instorderinfo.getImageName());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.imageDropDown)
							.equalsIgnoreCase(instorderinfo.getImageName())) {
						Reporter.log(instorderinfo.getImageName() + " Image Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Image.Please look in to the issue.</p>");
					}

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.flavorDropDown, instorderinfo.getFlavor());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.flavorDropDown)
							.equalsIgnoreCase(instorderinfo.getFlavor())) {
						Reporter.log(instorderinfo.getFlavor() + " Flavor Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Flavor.Please look in to the issue.</p>");
					}

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.enableMonitoringDropDown,
							instorderinfo.getEnableMonitoring());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.enableMonitoringDropDown)
							.equalsIgnoreCase(instorderinfo.getEnableMonitoring())) {
						Reporter.log(" Monitoring Selected as " + instorderinfo.getEnableMonitoring());
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Monitoring.Please look in to the issue.</p>");
					}

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.networkDropDown,
							instorderinfo.getNetwork());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.networkDropDown)
							.equalsIgnoreCase(instorderinfo.getNetwork())) {
						Reporter.log(instorderinfo.getNetwork() + " Network Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Network.Please look in to the issue.</p>");
					}

					objStackLaunchPage.networkNameTextBox.sendKeys(instorderinfo.getNetworkInterfaceName());

					HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.subnetDropDown,
							instorderinfo.getSubNetName());
					if (HandleDropDown.getSelectedValue(objStackLaunchPage.subnetDropDown)
							.equalsIgnoreCase(instorderinfo.getSubNetName())) {
						Reporter.log(instorderinfo.getSubNetName() + " Subnet Selected");
					} else {
						Reporter.log(
								"<p style='color:red'>Issue while selecting the Subnet.Please look in to the issue.</p>");
					}

					if (instorderinfo.getStaticIp().equalsIgnoreCase("Y")) {
						HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.publicIPDropdown, staticIP);
						if (HandleDropDown.getSelectedValue(objStackLaunchPage.publicIPDropdown)
								.equalsIgnoreCase(staticIP)) {
							Reporter.log(staticIP + "  Selected for public IP ");
						} else {
							Reporter.log(
									"<p style='color:red'>Issue while selecting the Public ip .Please look in to the issue.</p>");
						}
					} else {
						HandleDropDown.selectDDLByVisibletext(objStackLaunchPage.publicIPDropdown,
								instorderinfo.getPublicIp());
						if (HandleDropDown.getSelectedValue(objStackLaunchPage.publicIPDropdown)
								.equalsIgnoreCase(instorderinfo.getPublicIp())) {
							Reporter.log(instorderinfo.getPublicIp() + "  Selected for public IP ");
						} else {
							Reporter.log(
									"<p style='color:red'>Issue while selecting the Public ip .Please look in to the issue.</p>");
						}
					}
					break;
				}

				catch (Exception e2) {
					Reporter.log(
							"<p style='color:red'>Issue while selecting configuration for stack while placing order for Openstack provider.</p>");
					e2.printStackTrace();
					Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e2) + "</p>");
					Assert.fail();
				}

			}

			try {
				Thread.sleep(1000);
				if (instorderinfo.getSecurityGroups() != null) {
					// for (SecurityGroup secGroup :
					// instorderinfo.getSecurityGroups()) {
					SecurityGroupCreation securityGroupobj = new SecurityGroupCreation();
					objStackLaunchPage.createSecurityGroupLink.click();
					securityGroupobj.createSecurityGroup(instorderinfo.getSecurityGroups());
				}
				// }
			}

			catch (Exception e) {
				Reporter.log("Create security group link is not available");
				e.printStackTrace();

			}

			SwitchFrame.defaultSwitch();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("arguments[0].scrollIntoView(true);",
			// objStackLaunchPage.stackLaunchButton);
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

			try {
				Thread.sleep(5000);
				objCatalogPage.slaAgreeButton.click();

			}

			catch (Exception e) {

			}
			try {
				SwitchFrame.defaultSwitch();

				if (driver.getPageSource().contains(
						"Stack creation is initialized. You will receive an email when the stack is ready.") == true) {
					Reporter.log("stack launched successfully");
					// objCatalogPage.catalogLink.click();
				} else {
					Reporter.log("<p Style ='color:Red'>Stack launch is failure..</p>");

				}

				/*
				 * objAppStackPage.manageLink.click();
				 * objAppStackPage.appStacksLink.click();
				 */

				explicitWait(objAppStackPage.searchTextBox);
				HandleDropDown.selectDDLByValue(objAppStackPage.searchDropDown, "name");
				objAppStackPage.searchTextBox.clear();
				objAppStackPage.searchTextBox.sendKeys(instorderinfo.getStackName());
				Thread.sleep(3000);
				objAppStackPage.searchTextBox.sendKeys(Keys.ENTER);

				boolean test = true;
				long startTime = (System.currentTimeMillis()) / 1000;
				while (test) // Converting in to second and waiting till the
								// time
								// out or the condition satisfied
				{

					if ((System.currentTimeMillis() / 1000) - startTime > timeout) {
						System.out.println("Reached 10 minutes and exiting the loop");
						Reporter.log("<p Style ='color:Red'> Waited for" + timeout
								+ " Seconds. Stack did not go to running please look in to the issue.</p>");
						Assert.fail();
					}

					explicitWait(objAppStackPage.showingText);
					String stackstatus = objAppStackPage.getAppStackStatus(instorderinfo.getStackName());
					if (stackstatus != null) {
						if ((stackstatus.equalsIgnoreCase("Running"))) {
							test = false;
							Reporter.log("Appstack status  Present in Running status");
							break;
						}
					}

					if (stackstatus != null) {
						if (stackstatus.equalsIgnoreCase("Error")) {
							test = false;
							Reporter.log("Appstack status  Present in Error status");

							Assert.fail();
						}
					}
					Thread.sleep(15000);
					explicitWait(objAppStackPage.searchTextBox);
					HandleDropDown.selectDDLByValue(objAppStackPage.searchDropDown, "name");
					objAppStackPage.searchTextBox.clear();
					objAppStackPage.searchTextBox.sendKeys(instorderinfo.getStackName());
					Thread.sleep(3000);
					objAppStackPage.searchTextBox.sendKeys(Keys.ENTER);
				}

			}

			catch (Exception e) {
				e.printStackTrace();
				Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e) + "</p>");
				Assert.fail();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e) + "</p>");
			Assert.fail();
		}
	}

}
