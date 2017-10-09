package com.jamcracker.commonFunctions.marketplace;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;

import com.jamcracker.objectRepository.marketplace.DesignerConsolePage;
import com.jamcracker.objectRepository.marketplace.ManageIaaSServicesPage;
import com.jamcracker.objectRepository.marketplace.MarketplaceHomePage;
import com.jamcracker.objectRepository.marketplace.MpIaaSConsolePage;
import com.jamcracker.utilities.SwitchFrame;
import com.jamcracker.utilities.TestBase;

public class AppStackCreation extends TestBase {
	
	public void appStackCreation(String username, String password, String runMode, String sName, String sDescription, String iName, String sgName, String sType, String chefType, String[][] tagsData, String[][] vendorsData) throws Exception {
		
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");			
		} else {
			//Marketplace Administrator Login
			MarketplaceLogin mpLogin = new MarketplaceLogin();
			mpLogin.login(username,password);
			Reporter.log("Marketplace Admin Log in is successfull");
			
			//Navigating to IaaS Console > Create Stack Template
			MarketplaceHomePage mpHome = new MarketplaceHomePage();
			mpHome.waitForMpHomePage();
			mpHome.IaaSConsoleLink.click();
			MpIaaSConsolePage mpIaaSConsole = new MpIaaSConsolePage();
			mpIaaSConsole.waitForMpIaaSConsolePage();
			explicitWait(mpIaaSConsole.getCreateStackTemplateButton);
			mpIaaSConsole.getCreateStackTemplateButton.click();
			
			//Designer Console Page for creating stack template
			DesignerConsolePage dConsole = new DesignerConsolePage();
			dConsole.waitForDesignerConsolePage();
			
			//Switching to Designer Canvas Frame
			SwitchFrame.elementSwitch(dConsole.dcFrame);
			
			//Dropping the Required Components into Canvas
			ComponentSelection cselection = new ComponentSelection();
			if (sType.equalsIgnoreCase("onlyLinux")) {
				cselection.onlyLinux();
			} else if (sType.equalsIgnoreCase("linuxWithShell")) {
				cselection.linuxWithShell();
			} else if (sType.equalsIgnoreCase("linuxWithChef")) {
				cselection.linuxWithChef();
			} else if (sType.equalsIgnoreCase("linuxWithChefAndShell")) {
				cselection.linuxWithChefAndShell();
			} else if (sType.equalsIgnoreCase("onlyWindows")) {
				cselection.onlyWindows();
			}
			
			
			dConsole.getStackTempNameTextBox.clear();
			dConsole.getStackTempNameTextBox.sendKeys(sName);
			dConsole.getDescriptionTextBox.clear();
			dConsole.getDescriptionTextBox.sendKeys(sDescription);
			
			//Creating Tags
			TagsCreation tags =  new TagsCreation();
			tags.createTags(tagsData);
			
			//Resource Details
			dConsole.getInstanceNameTextBox.clear();
			dConsole.getInstanceNameTextBox.sendKeys(iName);
			
			//Stack supporting vendors selection
			StackVendorSelection vendors = new StackVendorSelection();
			vendors.selectVendors(vendorsData);
			
			//Security Group creation
			SecurityGroupCreation sgCreation = new SecurityGroupCreation();
			dConsole.getSecurityGroupLink.click();
			explicitWait(dConsole.getSecurityGroupNameTextBox);
			dConsole.getSecurityGroupNameTextBox.sendKeys(sgName);
			sgCreation.createSecurityGroup();
			
			
			//Providing Script related data
			ScriptConfiguration scriptConf = new ScriptConfiguration();
			if (sType.equalsIgnoreCase("linuxWithShell")) {
				scriptConf.shellScriptConfiguration();
			} else if (sType.equalsIgnoreCase("linuxWithChef")) {
				scriptConf.chefScriptConfiguration(chefType);
			} else if (sType.equalsIgnoreCase("linuxWithChefAndShell")) {
				scriptConf.shellScriptConfiguration();
				scriptConf.chefScriptConfiguration(chefType);
			}
						
			//Saving the Template
			try {
				dConsole.getSaveTemplateButton.click();
			} catch (Exception e) {
				dConsole.getSaveTemplateButton.click();
			}
			SwitchFrame.defaultSwitch();
			Assert.assertEquals(mpIaaSConsole.getStackName(sName).getAttribute("title"), sName);
			
			//Publishing Stack
			PublishStack publish = new PublishStack();
			publish.testPublishStack(sName);
			
			//Approving the Stack Service
			mpHome.AdministrationLink.click();
			ManageIaaSServicesPage mIaaSService = new ManageIaaSServicesPage();
			ApproveStackService approve = new ApproveStackService();
			approve.testApproveStackService(sName);
			Assert.assertEquals(mIaaSService.getServiceStatus(sName).getText(), "Approved");
		}
	}
	
}
