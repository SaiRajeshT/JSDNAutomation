package com.jamcracker.commonFunctions.marketplace;

import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.CmsAdminMenuBar;
import com.jamcracker.objectRepository.marketplace.CmsDomainCreationPage;
import com.jamcracker.objectRepository.marketplace.CmsDomainSettingsPage;
import com.jamcracker.objectRepository.marketplace.CmsDomainThemePage;
import com.jamcracker.objectRepository.marketplace.CmsDomainsListPage;
import com.jamcracker.objectRepository.marketplace.CmsEditDomainPage;
import com.jamcracker.objectRepository.marketplace.CmsStructuresPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class CMSStoreConfiguration extends TestBase {
	
	public void storeCMSConfiguration(String domain, String name, String storeType, String siteName, String emailAddress, String defaultLanguage) {
		
		CmsAdminMenuBar objCmsMenu = new CmsAdminMenuBar();
		explicitWait(objCmsMenu.structureLink);
		objCmsMenu.structureLink.click();
		CmsStructuresPage objCmsStructures = new CmsStructuresPage();
		try {
			if (objCmsStructures.structureHeading.getText().equalsIgnoreCase("Structure")) {
				Reporter.log("Navigated to Structures Page");
			} else {
				Reporter.log("<p style='color:red'>Page is not navigated to Structures Page</p>");
				Assert.fail();
			}
		} catch (Exception e) {
			Reporter.log("<p style='color:red'>Page is not navigated to Structures Page</p>");
			Assert.fail();
		}
		objCmsStructures.domainsLink.click();
		CmsDomainsListPage objCmsDomains = new CmsDomainsListPage();
		try {
			if (objCmsDomains.domainsHeading.getText().equalsIgnoreCase("Domains")) {
				Reporter.log("Navigated to Domains Listing Page");
			} else {
				Reporter.log("<p style='color:red'>Page is not navigated to Domains Listing Page</p>");
				Assert.fail();
			}
		} catch (Exception e) {
			Reporter.log("<p style='color:red'>Page is not navigated to Domains Listing Page</p>");
			Assert.fail();
		}
		objCmsDomains.createDomainLink.click();
		CmsDomainCreationPage objDomainCreation = new CmsDomainCreationPage();
		try {
			if (objDomainCreation.domainTextBox.isDisplayed()) {
				Reporter.log("Navigated to Domain Creation Page");
			} else {
				Reporter.log("<p style='color:red'>Page is not navigated to Domains Creation Page</p>");
				Assert.fail();
			}
		} catch (Exception e) {
			Reporter.log("<p style='color:red'>Page is not navigated to Domains Creation Page</p>");
			Assert.fail();
		}
		objDomainCreation.domainTextBox.sendKeys(domain);
		objDomainCreation.sitenameTextBox.sendKeys(name);
		objDomainCreation.httpsRadioButton.click();
		switch (storeType.toLowerCase()) {
		case "reseller":
			Reporter.log("Store Type is Reseller");
			break;
		
		case "enterprise-non ad":
			objDomainCreation.restrictPreLoginCheckBox.click();
			Reporter.log("Store Type is " + storeType + "and hence Restrict Pre-Login option is selected");
			break;
			
		case "enterprise-ad":
			objDomainCreation.restrictPreLoginCheckBox.click();
			objDomainCreation.adConfiguredCheckBox.click();
			Reporter.log("Store Type is " + storeType + "and hence Restrict Pre-Login and AD Configured options are selected");
			break;
			
		default:
			break;
		}
		objDomainCreation.saveDomainRecordButton.click();
		explicitWait(objDomainCreation.domainStatusMessage);
		try {
			if (objDomainCreation.domainStatusMessage.getText().contains("Domain record updated.")) {
				Reporter.log("Domain is created successfully");
			} else {
				Reporter.log("<p style='color:red'>Domain is not created</p>");
				Assert.fail();
			}
		} catch (Exception e) {
			Reporter.log("<p style='color:red'>Domain is not created</p>");
			Assert.fail();
		}
		objCmsMenu.structureLink.click();
		objCmsStructures.domainsLink.click();
		try {
			if (objCmsDomains.domainsHeading.getText().equalsIgnoreCase("Domains")) {
				Reporter.log("Navigated to Domains Listing Page");
			} else {
				Reporter.log("<p style='color:red'>Page is not navigated to Domains Listing Page</p>");
				Assert.fail();
			}
		} catch (Exception e) {
			Reporter.log("<p style='color:red'>Page is not navigated to Domains Listing Page</p>");
			Assert.fail();
		}
		explicitWait(objCmsDomains.getEditDomainLink(name));
		objCmsDomains.getEditDomainLink(name).click();
		CmsEditDomainPage objEditDomain = new CmsEditDomainPage();
		try {
			if (objEditDomain.getEditPageTitle(domain).isDisplayed()) {
				Reporter.log("Navigated to " + name + "Domain, Edit Page");
			} else {
				Reporter.log("<p style='color:red'>Page is not navigated to " + name + "Domain, Edit Page</p>");
				Assert.fail();
			}
		} catch (Exception e) {
			Reporter.log("<p style='color:red'>Page is not navigated to " + name + "Domain, Edit Page</p>");
			Assert.fail();
		}		
		CmsDomainSettingsPage objDomainSettings = new CmsDomainSettingsPage();
		objDomainSettings.domainSettingsLink.click();
		try {
			if (objDomainSettings.getSettingsPageTitle(domain).isDisplayed()) {
				Reporter.log("Navigated to " + name + "Domain, Settings Page");
			} else {
				Reporter.log("<p style='color:red'>Page is not navigated to " + name + "Domain, Settings Page</p>");
				Assert.fail();
			}
		} catch (Exception e) {
			Reporter.log("<p style='color:red'>Page is not navigated to " + name + "Domain, Settings Page</p>");
			Assert.fail();
		}
		objDomainSettings.siteNameTextBox.clear();
		objDomainSettings.siteNameTextBox.sendKeys(siteName);
		objDomainSettings.emailAddressTextBox.clear();
		objDomainSettings.emailAddressTextBox.sendKeys(emailAddress);
		objDomainSettings.siteFrontPageTextBox.clear();
		objDomainSettings.siteFrontPageTextBox.sendKeys("home");
		HandleDropDown.selectDDLByVisibletext(objDomainSettings.defaultLangDropDown, defaultLanguage);
		objDomainSettings.saveDomainSettingsButton.click();
		try {
			if (objDomainSettings.domainSettingsStatusMessage.getText().contains("Domain options saved successfully.")) {
				Reporter.log("Domain Settings saved successfully");
			} else {
				Reporter.log("<p style='color:red'>Domain Settings are not saved</p>");
				Assert.fail();
			}
		} catch (Exception e) {
			Reporter.log("<p style='color:red'>Domain Settings are not saved</p>");
			Assert.fail();
		}
		CmsDomainThemePage objDomainTheme = new CmsDomainThemePage();
		objDomainTheme.themeLink.click();
		try {
			if (objDomainTheme.getThemePageTitle(domain).isDisplayed()) {
				Reporter.log("Navigated to " + name + "Domain, Theme Page");
			} else {
				Reporter.log("<p style='color:red'>Page is not navigated to " + name + "Domain, Theme Page</p>");
				Assert.fail();
			}
		} catch (Exception e) {
			Reporter.log("<p style='color:red'>Page is not navigated to " + name + "Domain, Theme Page</p>");
			Assert.fail();
		}
		explicitWait(objDomainTheme.configureLink);
		objDomainTheme.configureLink.click();		
		objDomainTheme.uploadLogo.sendKeys(System.getProperty("user.dir") + "/Data/Logos/CompanyLogo.JPG");
		objDomainTheme.saveConfigurationButton.click();
		try {
			if (objDomainTheme.successMsg.getText().contains("The configuration options have been saved.")) {
				Reporter.log("Logo has been uploaded successfully for "+name+" domain");
			} else {
				Reporter.log("Logo not uploaded successfully for "+name+" domain");
				Assert.fail();
			}
		} catch (Exception e) {
			Reporter.log("Logo not uploaded successfully for "+name+" domain");
			Assert.fail();
		}
		Reporter.log("CMS configuration for the store "+domain+" is successful");
	}

}
